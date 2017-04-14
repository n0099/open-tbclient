package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.g.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bq bqVar;
        com.baidu.tieba.frs.g.ao aoVar;
        bq bqVar2;
        a aVar;
        com.baidu.tieba.frs.g.ad adVar;
        a aVar2;
        if (view != this.bNJ.bMD.ZS()) {
            if (view == this.bNJ.bMD.ZN()) {
                az azVar = this.bNJ.bMD;
                bqVar = this.bNJ.bMF;
                azVar.a(bqVar);
                aoVar = this.bNJ.bMQ;
                bqVar2 = this.bNJ.bMF;
                aoVar.a(bqVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bNJ.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bNJ.bMD.ZZ();
                FrsActivityStatic.bNP = false;
                aVar = this.bNJ.bNc;
                if (aVar != null) {
                    aVar2 = this.bNJ.bNc;
                    aVar2.ady();
                }
                this.bNJ.bMD.aaq();
                adVar = this.bNJ.bMR;
                adVar.abJ();
            } else if (view == this.bNJ.bMD.ZP()) {
                long j = 0;
                if (this.bNJ.bME != null && this.bNJ.bME.getUserData() != null && !StringUtils.isNull(this.bNJ.bME.getUserData().getUserId())) {
                    str = this.bNJ.bME.getUserData().getUserId();
                } else {
                    str = "";
                }
                if (this.bNJ.bME != null) {
                    j = this.bNJ.bME.bgT();
                }
                this.bNJ.bMD.ZQ().setVisibility(4);
                ImageView imageView = (ImageView) view;
                if (this.bNJ.Zh()) {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                } else {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                }
                if (this.bNJ.bMD.aap()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11946").aa(SapiAccountManager.SESSION_UID, str).g("tid", j));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bNJ.getApplicationContext(), String.valueOf(this.bNJ.bME.bgT()))));
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11944"));
                    com.baidu.adp.lib.util.k.showToast(this.bNJ.getActivity(), w.l.frs_no_drifting_bottle_tip);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bNJ.getApplicationContext())));
                }
                this.bNJ.bMD.dM(false);
                b.uL().putLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), this.bNJ.bME.bgT());
            }
        } else {
            this.bNJ.closeActivity();
        }
        if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hA()) {
            TiebaStatic.log("c10853");
            if (this.bNJ.bMD.aab()) {
                this.bNJ.bMD.aac();
                return;
            }
            String activityUrl = this.bNJ.bME.aJw().getYuleData().tJ().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.T(this.bNJ.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
