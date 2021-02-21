package com.baidu.tieba.ala.b;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public File gMj = null;
    public String mLoadingFile;
    public String mMd5;
    public String mType;
    public String mUrl;
    public String mVersion;

    public boolean isLoaded() {
        return acc() != null && acc().exists();
    }

    public void bSZ() {
        File file = new File(ace());
        if (file != null) {
            com.baidu.tieba.ala.b.b.a.deleteDir(file);
        }
        this.gMj = null;
        ace();
        acc();
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File acc() {
        if (this.gMj == null && !TextUtils.isEmpty(this.mVersion)) {
            this.gMj = new File(ace(), getName());
        }
        return this.gMj;
    }

    public String getFilePath() {
        return acc().getAbsolutePath();
    }

    public String ace() {
        return TextUtils.equals(this.mType, "so") ? c.bSX().getAbsolutePath() : c.bSY().getAbsolutePath();
    }

    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            this.mLoadingFile = getFilePath();
            if (!this.mLoadingFile.endsWith(".zip")) {
                this.mLoadingFile += ".zip";
            }
        }
        return this.mLoadingFile;
    }

    public boolean onResLoaded(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File file2 = new File(getFilePath() + ".tmp");
            if (file2.exists()) {
                com.baidu.tieba.ala.b.b.a.deleteDir(file2);
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.baidu.tieba.ala.b.b.a.unzipFile(file, file2.getAbsolutePath());
            file2.renameTo(acc());
            if (isLoaded() && bTa()) {
                z = true;
            }
            if (!z) {
                com.baidu.tieba.ala.b.b.a.deleteDir(acc());
            }
            com.baidu.tieba.ala.b.b.a.deleteFile(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.tieba.ala.b.b.a.deleteDir(acc());
        }
        return z;
    }

    public boolean bTa() {
        JSONArray optJSONArray;
        try {
            File file = new File(acc(), "files.json");
            if (file == null || !file.exists()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(com.baidu.fsg.face.base.b.c.g)) == null || optJSONArray.length() <= 0) {
                return false;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(a.Gc(optJSONArray.getString(i)));
            }
            return U(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean U(ArrayList<a> arrayList) {
        File file;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        try {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                String str = next.mPath;
                if (TextUtils.isEmpty(str)) {
                    file = new File(getFilePath(), next.mName);
                } else {
                    file = new File(getFilePath() + str, next.mName);
                }
                if (file == null || !file.exists()) {
                    return false;
                }
                if (!TextUtils.equals(com.baidu.tieba.ala.b.b.b.getFileMD5(file.getAbsolutePath()), next.mMd5)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static d eo(String str, String str2) {
        d dVar = new d();
        dVar.mVersion = str;
        String str3 = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
        if (TextUtils.equals(str2, "source")) {
            str3 = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
        }
        String str4 = str3 + str + ".zip";
        dVar.mUrl = str4;
        dVar.mMd5 = com.baidu.tieba.ala.b.b.b.ep(str4, EncryptUtils.ENCRYPT_MD5);
        dVar.mType = str2;
        return dVar;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String mMd5;
        public String mName;
        public String mPath;

        public static a Gc(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    a aVar = new a();
                    aVar.mName = jSONObject.optString("name");
                    aVar.mPath = jSONObject.optString("path");
                    aVar.mMd5 = jSONObject.optString("md5");
                    return aVar;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
