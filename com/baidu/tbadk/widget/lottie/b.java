package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bgU;
    private x mNetWork;
    private String mUrl;
    private String yz;

    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z, String str);
    }

    public static boolean io(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.j("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public b(String str, String str2, a aVar) {
        this.yz = str;
        this.mUrl = str2;
        this.bgU = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ao.isEmpty(this.yz) || ao.isEmpty(this.mUrl) || !io(this.yz)) {
            return null;
        }
        String bD = s.bD(this.mUrl);
        String str = this.yz + bD + "/";
        if (iq(str)) {
            return bD;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.yz + bD + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && aC(str2, str)) {
            ip(str2);
            return bD;
        }
        ip(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bgU != null) {
            if (!ao.isEmpty(str)) {
                this.bgU.d(true, str);
            } else {
                this.bgU.d(false, null);
            }
        }
    }

    private boolean aC(String str, String str2) {
        if (ao.isEmpty(str) || ao.isEmpty(str2)) {
            return false;
        }
        return r.ad(str, str2);
    }

    private void ip(String str) {
        if (!ao.isEmpty(str)) {
            l.x(new File(str));
        }
    }

    private boolean iq(String str) {
        return !ao.isEmpty(str) && new File(str).exists();
    }
}
