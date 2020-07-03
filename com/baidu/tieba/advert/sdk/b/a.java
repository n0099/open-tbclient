package com.baidu.tieba.advert.sdk.b;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.s;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes10.dex */
public class a extends BdAsyncTask<Void, Void, Boolean> {
    private final String TAG = a.class.getSimpleName();
    private AdInfo adInfo;
    public static final String fbV = Environment.getExternalStorageDirectory() + "/tieba/.advideo";
    public static final String FILE_SEP = File.separator;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean doInBackground(Void... voidArr) {
        FileNotFoundException e;
        boolean z;
        String str = fbV + FILE_SEP + "advideo.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            new File(fbV).mkdirs();
            if (!file.createNewFile()) {
                a(false, null);
                return false;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        e eVar = new e();
        eVar.kT().setUrl(this.adInfo.adVideoUrl);
        boolean a = new com.baidu.adp.lib.network.http.c(eVar).a(str, null, 3, 3000, -1, -1, true, true);
        try {
        } catch (FileNotFoundException e3) {
            e = e3;
            z = a;
        }
        if (TextUtils.isEmpty(this.adInfo.videoMd5)) {
            a(a, file);
            return Boolean.valueOf(a);
        }
        String md5 = s.toMd5(new FileInputStream(str));
        z = TextUtils.isEmpty(md5) ? false : a;
        try {
            if (!md5.equalsIgnoreCase(this.adInfo.videoMd5)) {
                z = false;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            e.printStackTrace();
            a(z, file);
            return Boolean.valueOf(z);
        }
        a(z, file);
        return Boolean.valueOf(z);
    }

    public void b(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    private void a(boolean z, File file) {
        if (z && file != null) {
            File file2 = new File(fbV + FILE_SEP + (s.toMd5(this.adInfo.adVideoUrl) + ".mp4"));
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                this.adInfo.videoLocalPath = file2.getAbsolutePath();
            } else {
                this.adInfo.videoLocalPath = "";
            }
        } else {
            this.adInfo.videoLocalPath = "";
        }
        com.baidu.tieba.advert.sdk.c.a.c(this.adInfo);
    }
}
