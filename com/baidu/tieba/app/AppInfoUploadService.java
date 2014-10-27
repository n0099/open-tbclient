package com.baidu.tieba.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.lib.network.willdelete.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AppInfoUploadService extends Service {
    private static final String UID = "uid";
    private String mCH;
    private String mCuid;
    private String mMd5 = null;
    private c mTask;
    private String mUid;

    public static void startService(String str) {
        Intent intent = new Intent(TbadkApplication.m251getInst().getApp(), AppInfoUploadService.class);
        intent.putExtra("uid", str);
        TbadkApplication.m251getInst().getApp().startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0089 -> B:20:0x008c). Please submit an issue!!! */
    public boolean Upload(String str) {
        if (str != null && str.length() > 0) {
            try {
                ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
                arrayList.add(new BasicNameValuePair("ch", this.mCH));
                arrayList.add(new BasicNameValuePair("cuid", this.mCuid));
                arrayList.add(new BasicNameValuePair("uid", this.mUid));
                arrayList.add(new BasicNameValuePair("x", str));
                f b = com.baidu.adp.lib.network.willdelete.e.dY().b(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.APP_UPLOAD, false, arrayList, null, 3, -1, null, null, null, null);
                if (b != null && b.kU == 200) {
                    try {
                        if (new JSONObject(new String(b.data, "utf-8")).optInt("error_code", -1) == 0) {
                            return true;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return false;
    }

    public String genPostData() {
        a yg = e.yf().yg();
        ArrayList<b> arrayList = yg.aiL;
        ArrayList<b> arrayList2 = yg.aiM;
        StringBuilder sb = new StringBuilder();
        int addList = addList(arrayList2, sb, 100, 0);
        if (addList < 100) {
            addList(arrayList, sb, 100 - addList, 1);
        }
        return sb.toString();
    }

    private int addList(ArrayList<b> arrayList, StringBuilder sb, int i, int i2) {
        int i3 = 0;
        while (i3 < arrayList.size() && i3 < i) {
            b bVar = arrayList.get(i3);
            sb.append(String.format("%s,%s,%s,%d;", bVar.aiN, bVar.mPackageName, Integer.valueOf(bVar.aiP), Integer.valueOf(i2)));
            i3++;
        }
        return i3;
    }

    private String radomGen5() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int nextInt = random.nextInt(51);
            if (nextInt < 26) {
                sb.append((char) (nextInt + 97));
            } else {
                sb.append((char) ((nextInt - 26) + 65));
            }
        }
        return sb.toString();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            this.mUid = intent.getStringExtra("uid");
        }
        this.mCuid = TbadkApplication.m251getInst().getCuid();
        this.mCH = TbConfig.getFrom();
        this.mTask = new c(this, null);
        this.mTask.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEncrypt(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int length = this.mUid.length();
            byte[] bytes = this.mUid.getBytes("UTF-8");
            byte[] bytes2 = str.getBytes("UTF-8");
            byte[] bArr = new byte[bytes2.length];
            for (int i = 0; i < bytes2.length; i++) {
                bArr[i] = (byte) (bytes[i % length] ^ bytes2[i]);
            }
            String k = l.k(bArr);
            String radomGen5 = radomGen5();
            String radomGen52 = radomGen5();
            sb.append(radomGen5);
            sb.append(k);
            sb.append(radomGen52);
        } catch (Exception e) {
            BdLog.e(e);
        }
        return sb.toString();
    }
}
