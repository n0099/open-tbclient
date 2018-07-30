package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bdw;
    private y mNetWork;
    private String mUrl;
    private String wf;

    /* loaded from: classes.dex */
    public interface a {
        void e(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.wf = str;
        this.mUrl = str2;
        this.bdw = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wf) || ap.isEmpty(this.mUrl) || !l.dR(this.wf)) {
            return null;
        }
        String bm = s.bm(this.mUrl);
        String str = this.wf + bm + "/";
        if (hR(str)) {
            return bm;
        }
        this.mNetWork = new y();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.wf + bm + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && av(str2, str)) {
            hQ(str2);
            return bm;
        }
        hQ(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bdw != null) {
            if (!ap.isEmpty(str)) {
                this.bdw.e(true, str);
            } else {
                this.bdw.e(false, null);
            }
        }
    }

    private boolean av(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.W(str, str2);
    }

    private void hQ(String str) {
        if (!ap.isEmpty(str)) {
            l.r(new File(str));
        }
    }

    private boolean hR(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
