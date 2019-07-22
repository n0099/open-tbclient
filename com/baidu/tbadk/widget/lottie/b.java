package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a cKz;
    private x mNetWork;
    private String mUrl;
    private String wX;

    /* loaded from: classes.dex */
    public interface a {
        void h(boolean z, String str);
    }

    public static boolean rx(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.i("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public b(String str, String str2, a aVar) {
        this.wX = str;
        this.mUrl = str2;
        this.cKz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (aq.isEmpty(this.wX) || aq.isEmpty(this.mUrl) || !rx(this.wX)) {
            return null;
        }
        String bn = s.bn(this.mUrl);
        String str = this.wX + bn + "/";
        if (rz(str)) {
            return bn;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.wX + bn + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && ch(str2, str)) {
            ry(str2);
            return bn;
        }
        ry(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.cKz != null) {
            if (!aq.isEmpty(str)) {
                this.cKz.h(true, str);
            } else {
                this.cKz.h(false, null);
            }
        }
    }

    private boolean ch(String str, String str2) {
        if (aq.isEmpty(str) || aq.isEmpty(str2)) {
            return false;
        }
        return r.bK(str, str2);
    }

    private void ry(String str) {
        if (!aq.isEmpty(str)) {
            m.A(new File(str));
        }
    }

    private boolean rz(String str) {
        return !aq.isEmpty(str) && new File(str).exists();
    }
}
