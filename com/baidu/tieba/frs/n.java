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
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bQa = frsActivity;
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
        if (view != this.bQa.bOU.aaT()) {
            if (view == this.bQa.bOU.aaO()) {
                az azVar = this.bQa.bOU;
                bqVar = this.bQa.bOW;
                azVar.a(bqVar);
                aoVar = this.bQa.bPh;
                bqVar2 = this.bQa.bOW;
                aoVar.a(bqVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bQa.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bQa.bOU.aba();
                FrsActivityStatic.bQg = false;
                aVar = this.bQa.bPt;
                if (aVar != null) {
                    aVar2 = this.bQa.bPt;
                    aVar2.aez();
                }
                this.bQa.bOU.abr();
                adVar = this.bQa.bPi;
                adVar.acK();
            } else if (view == this.bQa.bOU.aaQ()) {
                long j = 0;
                if (this.bQa.bOV != null && this.bQa.bOV.getUserData() != null && !StringUtils.isNull(this.bQa.bOV.getUserData().getUserId())) {
                    str = this.bQa.bOV.getUserData().getUserId();
                } else {
                    str = "";
                }
                if (this.bQa.bOV != null) {
                    j = this.bQa.bOV.bhU();
                }
                this.bQa.bOU.aaR().setVisibility(4);
                ImageView imageView = (ImageView) view;
                if (this.bQa.aai()) {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                } else {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                }
                if (this.bQa.bOU.abq()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11946").aa(SapiAccountManager.SESSION_UID, str).g("tid", j));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bQa.getApplicationContext(), String.valueOf(this.bQa.bOV.bhU()))));
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11944"));
                    com.baidu.adp.lib.util.k.showToast(this.bQa.getActivity(), w.l.frs_no_drifting_bottle_tip);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bQa.getApplicationContext())));
                }
                this.bQa.bOU.dW(false);
                b.uL().putLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), this.bQa.bOV.bhU());
            }
        } else {
            this.bQa.closeActivity();
        }
        if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hB()) {
            TiebaStatic.log("c10853");
            if (this.bQa.bOU.abc()) {
                this.bQa.bOU.abd();
                return;
            }
            String activityUrl = this.bQa.bOV.aKx().getYuleData().tJ().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.T(this.bQa.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
