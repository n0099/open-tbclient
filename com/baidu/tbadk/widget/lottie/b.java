package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private aa cml;
    private a fUM;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void onLoaded(boolean z, String str);
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.join("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.fUM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (au.isEmpty(this.mPath) || au.isEmpty(this.mUrl) || !checkInternalTempDir(this.mPath)) {
            return null;
        }
        String md5 = s.toMd5(this.mUrl);
        String str = this.mPath + md5 + "/";
        if (isExists(str)) {
            return md5;
        }
        this.cml = new aa();
        this.cml.setUrl(this.mUrl);
        String str2 = this.mPath + md5 + ".zip";
        if (this.cml.downloadFile(str2, null, 0, 3, 0, true) && unZip(str2, str)) {
            clearTemp(str2);
            return md5;
        }
        clearTemp(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.fUM != null) {
            if (!au.isEmpty(str)) {
                this.fUM.onLoaded(true, str);
            } else {
                this.fUM.onLoaded(false, null);
            }
        }
    }

    private boolean unZip(String str, String str2) {
        if (au.isEmpty(str) || au.isEmpty(str2)) {
            return false;
        }
        return r.unZipFiles(str, str2);
    }

    private void clearTemp(String str) {
        if (!au.isEmpty(str)) {
            o.deleteFileOrDir(new File(str));
        }
    }

    private boolean isExists(String str) {
        return !au.isEmpty(str) && new File(str).exists();
    }
}
