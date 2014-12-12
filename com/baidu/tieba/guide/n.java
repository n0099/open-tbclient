package com.baidu.tieba.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m aNK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aNK = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        boolean z;
        NewUserGuideActivity newUserGuideActivity3;
        boolean z2;
        NewUserGuideActivity newUserGuideActivity4;
        NewUserGuideActivity newUserGuideActivity5;
        View view2;
        if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
            button = this.aNK.mNext;
            if (view == button) {
                newUserGuideActivity = this.aNK.aNp;
                if (newUserGuideActivity.IO()) {
                    TbadkApplication.getInst().setLikeBarChanged(true);
                }
                m mVar = this.aNK;
                newUserGuideActivity2 = this.aNK.aNp;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2.getPageContext().getPageActivity());
                z = this.aNK.aMV;
                mVar.sendMessage(new CustomMessage(2015001, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.aNK.aNp;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.aNK.aNJ;
        if (z2) {
            this.aNK.aNJ = false;
            newUserGuideActivity4 = this.aNK.aNp;
            com.baidu.tbadk.core.i.B(newUserGuideActivity4.getPageContext().getPageActivity(), "newUserInterestSelect");
            newUserGuideActivity5 = this.aNK.aNp;
            t tVar = new t(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new o(this));
            view2 = this.aNK.aNw;
            view2.setVisibility(0);
            tVar.show();
            this.aNK.aNJ = true;
        }
    }
}
