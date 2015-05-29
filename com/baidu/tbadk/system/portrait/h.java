package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {
    private aa aaG;
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    private h(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
        this.aaG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(ChangeSystemPhotoActivity changeSystemPhotoActivity, h hVar) {
        this(changeSystemPhotoActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        com.baidu.adp.widget.a.a aVar;
        this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
        try {
            aa aaVar = this.aaG;
            aVar = this.arP.arM;
            aaVar.d("pic", aVar.mV());
            str = this.aaG.sz();
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.aaG.sX().tT().qa()) {
                return str;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.arP.arL = null;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        String str2;
        if (this.aaG != null) {
            if (this.aaG.sX().tT().qa()) {
                new q(this.arP.getPageContext()).dn(this.arP.getResources().getString(t.reset_success));
                Intent intent = new Intent();
                str2 = this.arP.arN;
                intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, str2);
                this.arP.setResult(-1, intent);
                this.arP.finish();
                return;
            }
            new q(this.arP.getPageContext()).dp(this.arP.getResources().getString(t.bubble_setdefualt_error));
        }
    }
}
