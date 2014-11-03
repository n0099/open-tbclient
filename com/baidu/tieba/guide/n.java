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
    final /* synthetic */ m aLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aLS = mVar;
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
            button = this.aLS.aLP;
            if (view == button) {
                newUserGuideActivity = this.aLS.aLw;
                if (newUserGuideActivity.Ix()) {
                    aj.wm().aR(true);
                }
                m mVar = this.aLS;
                newUserGuideActivity2 = this.aLS.aLw;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2);
                z = this.aLS.aLb;
                mVar.sendMessage(new CustomMessage(2015001, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.aLS.aLw;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.aLS.aLR;
        if (z2) {
            this.aLS.aLR = false;
            newUserGuideActivity4 = this.aLS.aLw;
            com.baidu.tbadk.core.j.l(newUserGuideActivity4, "newUserInterestSelect");
            newUserGuideActivity5 = this.aLS.aLw;
            t tVar = new t(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new o(this));
            view2 = this.aLS.aLD;
            view2.setVisibility(0);
            tVar.show();
            this.aLS.aLR = true;
        }
    }
}
