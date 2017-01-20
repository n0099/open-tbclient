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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bo boVar;
        com.baidu.tieba.frs.f.am amVar;
        bo boVar2;
        a aVar;
        com.baidu.tieba.frs.f.ad adVar;
        a aVar2;
        if (view != this.bGL.bFF.Yv()) {
            if (view == this.bGL.bFF.Yq()) {
                ax axVar = this.bGL.bFF;
                boVar = this.bGL.bFH;
                axVar.a(boVar);
                amVar = this.bGL.bFS;
                boVar2 = this.bGL.bFH;
                amVar.a(boVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bGL.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bGL.bFF.YC();
                FrsActivityStatic.bGR = false;
                aVar = this.bGL.bGf;
                if (aVar != null) {
                    aVar2 = this.bGL.bGf;
                    aVar2.acD();
                }
                this.bGL.bFF.YT();
                adVar = this.bGL.bFT;
                adVar.aap();
            } else if (view == this.bGL.bFF.Ys()) {
                long j = 0;
                if (this.bGL.bFG != null && this.bGL.bFG.getUserData() != null && !StringUtils.isNull(this.bGL.bFG.getUserData().getUserId())) {
                    str = this.bGL.bFG.getUserData().getUserId();
                } else {
                    str = "";
                }
                if (this.bGL.bFG != null) {
                    j = this.bGL.bFG.bgt();
                }
                this.bGL.bFF.Yt().setVisibility(4);
                ImageView imageView = (ImageView) view;
                if (this.bGL.XM()) {
                    com.baidu.tbadk.core.util.ap.b(imageView, r.g.btn_bottle_selector, r.g.btn_bottle_selector);
                } else {
                    com.baidu.tbadk.core.util.ap.b(imageView, r.g.d_btn_bottle_selector, r.g.d_btn_bottle_selector);
                }
                if (this.bGL.bFF.YS()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11946").ab(SapiAccountManager.SESSION_UID, str).g("tid", j));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bGL.getApplicationContext(), String.valueOf(this.bGL.bFG.bgt()))));
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11944"));
                    com.baidu.adp.lib.util.k.showToast(this.bGL.getActivity(), r.l.frs_no_drifting_bottle_tip);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bGL.getApplicationContext())));
                }
                this.bGL.bFF.dK(false);
                b.tQ().putLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), this.bGL.bFG.bgt());
            }
        } else {
            this.bGL.closeActivity();
        }
        if (view.getId() == r.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.gB()) {
            TiebaStatic.log("c10853");
            if (this.bGL.bFF.YE()) {
                this.bGL.bFF.YF();
                return;
            }
            String activityUrl = this.bGL.bFG.aJY().getYuleData().sO().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bGL.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
