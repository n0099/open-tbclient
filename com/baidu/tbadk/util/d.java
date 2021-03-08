package com.baidu.tbadk.util;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.io.FileUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class d {
    private static JSONObject fNR = null;
    private static ArrayList<Long> fNS = new ArrayList<>();
    private static final Hashtable<String, ArrayList<a<Integer, Integer>>> fNT = new Hashtable<>();
    private static boolean fNU = true;

    public static void DP(final String str) {
        rx.d.bY("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.tbadk.util.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str2) {
                String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("old_sniff_url", "");
                if (TextUtils.isEmpty(str) || str.equals(string)) {
                    d.ls(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (b.bFa().f(new File(file, "sniff.json"), str) > 0) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("old_sniff_url", "");
                }
                d.ls(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ls(final boolean z) {
        rx.d.bY("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.tbadk.util.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (d.fNR == null || z) {
                    d.bFe();
                }
                d.bFd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bFd() {
        JSONArray optJSONArray;
        JSONObject jSONObject = fNR;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int length = optJSONArray.length();
            int size = fNS.size();
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i < size) {
                    arrayList.add(fNS.get(i));
                } else {
                    arrayList.add(0L);
                }
            }
            fNS = arrayList;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    a(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), fNU);
                } else {
                    return;
                }
            }
            if (fNU) {
                fNU = false;
            }
        }
    }

    private static void a(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        if (i >= 0 && !TextUtils.isEmpty(str) && i2 >= 0 && jSONArray != null && jSONArray.length() != 0) {
            long time = new Date().getTime();
            String str2 = "AD_SNIFF_RESULT_KEY_" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "TS";
            long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong(str2, 0L);
            long millis = TimeUnit.MINUTES.toMillis(i2);
            boolean z2 = j == 0;
            boolean z3 = j > 0 && time - j > millis;
            if (z || z2 || z3) {
                com.baidu.tbadk.core.sharedPref.b.brR().putLong(str2, time);
                b(i, jSONArray);
            }
        }
    }

    private static void b(int i, JSONArray jSONArray) {
        if (i >= fNS.size()) {
            Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
            return;
        }
        PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
        rF(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < jSONArray.length()) {
                String optString = jSONArray.optString(i3);
                int i4 = i3 + 1;
                a<Integer, Integer> aVar = new a<>(Integer.valueOf(i), Integer.valueOf(i4));
                ArrayList<a<Integer, Integer>> arrayList = fNT.get(optString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(aVar);
                fNT.put(optString, arrayList);
                a(packageManager, optString, i, i4);
                i2 = i3 + 1;
            } else {
                rG(i);
                com.baidu.tbadk.core.sharedPref.b.brR().putString("AD_SNIFF_RESULT_KEY", bFg());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bFe() {
        File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
        if (file.exists()) {
            File file2 = new File(file, "sniff.json");
            if (file2.exists()) {
                String readFileData = FileUtils.readFileData(file2);
                if (!TextUtils.isEmpty(readFileData)) {
                    synchronized (d.class) {
                        try {
                            fNR = new JSONObject(readFileData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void a(PackageManager packageManager, String str, int i, int i2) {
        try {
            packageManager.getApplicationInfo(str, 0);
            be(i, i2);
        } catch (PackageManager.NameNotFoundException e) {
            bf(i, i2);
        }
    }

    private static void rF(int i) {
        bf(i, 0);
    }

    private static void rG(int i) {
        be(i, 0);
    }

    private static void be(int i, int i2) {
        ArrayList<Long> arrayList = fNS;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
        }
    }

    private static void bf(int i, int i2) {
        ArrayList<Long> arrayList = fNS;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & ((1 << i2) ^ (-1))));
        }
    }

    public static void L(Intent intent) {
        if (!TextUtils.isEmpty(intent.getDataString())) {
            String str = "";
            if (intent.getDataString().length() > 8) {
                str = intent.getDataString().substring(8);
            }
            String action = intent.getAction();
            ArrayList<a<Integer, Integer>> arrayList = fNT.get(str);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<a<Integer, Integer>> it = arrayList.iterator();
                while (it.hasNext()) {
                    a<Integer, Integer> next = it.next();
                    if (next != null) {
                        int intValue = next.fNW.intValue();
                        int intValue2 = next.fNX.intValue();
                        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                            be(intValue, intValue2);
                        } else {
                            bf(intValue, intValue2);
                        }
                    }
                }
            }
        }
    }

    public static String bFf() {
        if (fNS.size() > 0) {
            return bFg();
        }
        return bFh();
    }

    private static String bFg() {
        ArrayList<Long> arrayList = fNS;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(it.next()));
        }
        return TextUtils.join(",", arrayList2);
    }

    private static String bFh() {
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("AD_SNIFF_RESULT_KEY", "");
        if (!TextUtils.isEmpty(string)) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str : string.split(",")) {
                arrayList.add(Long.valueOf(str));
            }
            fNS = arrayList;
        } else {
            ls(false);
        }
        return string;
    }

    /* loaded from: classes.dex */
    public static class a<X, Y> {
        public final X fNW;
        public final Y fNX;

        public a(X x, Y y) {
            this.fNW = x;
            this.fNX = y;
        }
    }
}
