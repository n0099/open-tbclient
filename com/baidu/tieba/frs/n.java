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
import com.baidu.tieba.frs.f.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bo boVar;
        com.baidu.tieba.frs.f.ao aoVar;
        bo boVar2;
        a aVar;
        com.baidu.tieba.frs.f.ad adVar;
        a aVar2;
        if (view != this.bNU.bMN.Zu()) {
            if (view == this.bNU.bMN.Zp()) {
                ax axVar = this.bNU.bMN;
                boVar = this.bNU.bMP;
                axVar.a(boVar);
                aoVar = this.bNU.bNa;
                boVar2 = this.bNU.bMP;
                aoVar.a(boVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bNU.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bNU.bMN.ZB();
                FrsActivityStatic.bOa = false;
                aVar = this.bNU.bNn;
                if (aVar != null) {
                    aVar2 = this.bNU.bNn;
                    aVar2.adD();
                }
                this.bNU.bMN.ZS();
                adVar = this.bNU.bNb;
                adVar.abm();
            } else if (view == this.bNU.bMN.Zr()) {
                long j = 0;
                if (this.bNU.bMO != null && this.bNU.bMO.getUserData() != null && !StringUtils.isNull(this.bNU.bMO.getUserData().getUserId())) {
                    str = this.bNU.bMO.getUserData().getUserId();
                } else {
                    str = "";
                }
                if (this.bNU.bMO != null) {
                    j = this.bNU.bMO.bgg();
                }
                this.bNU.bMN.Zs().setVisibility(4);
                ImageView imageView = (ImageView) view;
                if (this.bNU.YL()) {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
                } else {
                    com.baidu.tbadk.core.util.aq.b(imageView, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
                }
                if (this.bNU.bMN.ZR()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11946").Z(SapiAccountManager.SESSION_UID, str).g("tid", j));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bNU.getApplicationContext(), String.valueOf(this.bNU.bMO.bgg()))));
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11944"));
                    com.baidu.adp.lib.util.k.showToast(this.bNU.getActivity(), w.l.frs_no_drifting_bottle_tip);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bNU.getApplicationContext())));
                }
                this.bNU.bMN.dK(false);
                b.uo().putLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), this.bNU.bMO.bgg());
            }
        } else {
            this.bNU.closeActivity();
        }
        if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hv()) {
            TiebaStatic.log("c10853");
            if (this.bNU.bMN.ZD()) {
                this.bNU.bMN.ZE();
                return;
            }
            String activityUrl = this.bNU.bMO.aJp().getYuleData().tl().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.P(this.bNU.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
