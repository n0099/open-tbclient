package com.baidu.tbadk.util;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.io.FileUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes2.dex */
public class c {
    private static JSONObject eUI = null;
    private static ArrayList<Long> eUJ = new ArrayList<>();
    private static final Hashtable<String, ArrayList<a<Integer, Integer>>> eUK = new Hashtable<>();
    private static boolean eUL = true;

    public static void CE(final String str) {
        rx.d.bW("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.tbadk.util.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str2) {
                String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("old_sniff_url", "");
                if (TextUtils.isEmpty(str) || str.equals(string)) {
                    c.jG(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (b.buY().f(new File(file, "sniff.json"), str) > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("old_sniff_url", "");
                }
                c.jG(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jG(final boolean z) {
        rx.d.bW("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.tbadk.util.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (c.eUI == null || z) {
                    c.bvc();
                }
                c.bvb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bvb() {
        JSONArray optJSONArray;
        JSONObject jSONObject = eUI;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int length = optJSONArray.length();
            int size = eUJ.size();
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i < size) {
                    arrayList.add(eUJ.get(i));
                } else {
                    arrayList.add(0L);
                }
            }
            eUJ = arrayList;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    a(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), eUL);
                } else {
                    return;
                }
            }
            if (eUL) {
                eUL = false;
            }
        }
    }

    private static void a(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        if (i >= 0 && !TextUtils.isEmpty(str) && i2 >= 0 && jSONArray != null && jSONArray.length() != 0) {
            long time = new Date().getTime();
            String str2 = "AD_SNIFF_RESULT_KEY_" + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "TS";
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(str2, 0L);
            long millis = TimeUnit.MINUTES.toMillis(i2);
            boolean z2 = j == 0;
            boolean z3 = j > 0 && time - j > millis;
            if (z || z2 || z3) {
                com.baidu.tbadk.core.sharedPref.b.bik().putLong(str2, time);
                b(i, jSONArray);
            }
        }
    }

    private static void b(int i, JSONArray jSONArray) {
        if (i >= eUJ.size()) {
            Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
            return;
        }
        PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
        qJ(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < jSONArray.length()) {
                String optString = jSONArray.optString(i3);
                int i4 = i3 + 1;
                a<Integer, Integer> aVar = new a<>(Integer.valueOf(i), Integer.valueOf(i4));
                ArrayList<a<Integer, Integer>> arrayList = eUK.get(optString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(aVar);
                eUK.put(optString, arrayList);
                a(packageManager, optString, i, i4);
                i2 = i3 + 1;
            } else {
                qK(i);
                com.baidu.tbadk.core.sharedPref.b.bik().putString("AD_SNIFF_RESULT_KEY", bve());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bvc() {
        File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
        if (file.exists()) {
            File file2 = new File(file, "sniff.json");
            if (file2.exists()) {
                String readFileData = FileUtils.readFileData(file2);
                if (!TextUtils.isEmpty(readFileData)) {
                    synchronized (c.class) {
                        try {
                            eUI = new JSONObject(readFileData);
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
            bh(i, i2);
        } catch (PackageManager.NameNotFoundException e) {
            bi(i, i2);
        }
    }

    private static void qJ(int i) {
        bi(i, 0);
    }

    private static void qK(int i) {
        bh(i, 0);
    }

    private static void bh(int i, int i2) {
        ArrayList<Long> arrayList = eUJ;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
        }
    }

    private static void bi(int i, int i2) {
        ArrayList<Long> arrayList = eUJ;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & ((1 << i2) ^ (-1))));
        }
    }

    public static void K(Intent intent) {
        if (!TextUtils.isEmpty(intent.getDataString())) {
            String substring = intent.getDataString().substring(8);
            String action = intent.getAction();
            ArrayList<a<Integer, Integer>> arrayList = eUK.get(substring);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<a<Integer, Integer>> it = arrayList.iterator();
                while (it.hasNext()) {
                    a<Integer, Integer> next = it.next();
                    if (next != null) {
                        int intValue = next.eUN.intValue();
                        int intValue2 = next.eUO.intValue();
                        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                            bh(intValue, intValue2);
                        } else {
                            bi(intValue, intValue2);
                        }
                    }
                }
            }
        }
    }

    public static String bvd() {
        if (eUJ.size() > 0) {
            return bve();
        }
        return bvf();
    }

    private static String bve() {
        ArrayList<Long> arrayList = eUJ;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(it.next()));
        }
        return TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList2);
    }

    private static String bvf() {
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("AD_SNIFF_RESULT_KEY", "");
        if (!TextUtils.isEmpty(string)) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str : string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                arrayList.add(Long.valueOf(str));
            }
            eUJ = arrayList;
        } else {
            jG(false);
        }
        return string;
    }

    /* loaded from: classes2.dex */
    public static class a<X, Y> {
        public final X eUN;
        public final Y eUO;

        public a(X x, Y y) {
            this.eUN = x;
            this.eUO = y;
        }
    }
}
