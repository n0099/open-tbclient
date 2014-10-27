package com.baidu.tieba.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m aLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aLE = mVar;
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
            button = this.aLE.aLB;
            if (view == button) {
                newUserGuideActivity = this.aLE.aLi;
                if (newUserGuideActivity.It()) {
                    aj.wk().aR(true);
                }
                m mVar = this.aLE;
                newUserGuideActivity2 = this.aLE.aLi;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2);
                z = this.aLE.aKN;
                mVar.sendMessage(new CustomMessage(2015001, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.aLE.aLi;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.aLE.aLD;
        if (z2) {
            this.aLE.aLD = false;
            newUserGuideActivity4 = this.aLE.aLi;
            com.baidu.tbadk.core.i.l(newUserGuideActivity4, "newUserInterestSelect");
            newUserGuideActivity5 = this.aLE.aLi;
            t tVar = new t(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new o(this));
            view2 = this.aLE.aLp;
            view2.setVisibility(0);
            tVar.show();
            this.aLE.aLD = true;
        }
    }
}
