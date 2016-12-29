package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        bq bqVar;
        com.baidu.tieba.frs.h.ak akVar;
        bq bqVar2;
        com.baidu.tieba.frs.h.a aVar;
        com.baidu.tieba.frs.h.ab abVar;
        com.baidu.tieba.frs.h.a aVar2;
        if (view != this.bzl.byg.Xg()) {
            if (view == this.bzl.byg.Xb()) {
                ax axVar = this.bzl.byg;
                bqVar = this.bzl.byi;
                axVar.a(bqVar);
                akVar = this.bzl.byt;
                bqVar2 = this.bzl.byi;
                akVar.a(bqVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bzl.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bzl.byg.Xp();
                FrsActivityStatic.bzr = false;
                aVar = this.bzl.byG;
                if (aVar != null) {
                    aVar2 = this.bzl.byG;
                    aVar2.abw();
                }
                this.bzl.byg.XL();
                abVar = this.bzl.byu;
                abVar.Zn();
            } else if (view == this.bzl.byg.Xd()) {
                long j = 0;
                if (this.bzl.byh != null && this.bzl.byh.getUserData() != null && !StringUtils.isNull(this.bzl.byh.getUserData().getUserId())) {
                    str = this.bzl.byh.getUserData().getUserId();
                } else {
                    str = "";
                }
                if (this.bzl.byh != null) {
                    j = this.bzl.byh.beF();
                }
                this.bzl.byg.Xe().setVisibility(4);
                ImageView imageView = (ImageView) view;
                if (this.bzl.Wv()) {
                    com.baidu.tbadk.core.util.ar.b(imageView, r.f.btn_bottle_selector, r.f.btn_bottle_selector);
                } else {
                    com.baidu.tbadk.core.util.ar.b(imageView, r.f.d_btn_bottle_selector, r.f.d_btn_bottle_selector);
                }
                if (this.bzl.byg.XK()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11946").ab(SapiAccountManager.SESSION_UID, str).g("tid", j));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bzl.getApplicationContext(), String.valueOf(this.bzl.byh.beF()))));
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11944"));
                    com.baidu.adp.lib.util.k.showToast(this.bzl.getActivity(), r.j.frs_no_drifting_bottle_tip);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.bzl.getApplicationContext())));
                }
                this.bzl.byg.dE(false);
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), this.bzl.byh.beF());
            }
        } else {
            this.bzl.closeActivity();
        }
        if (view.getId() == r.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10853");
            if (this.bzl.byg.Xr()) {
                this.bzl.byg.Xs();
                return;
            }
            String activityUrl = this.bzl.byh.aIk().getYuleData().sU().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                f.v(this.bzl.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
