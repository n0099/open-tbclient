package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class r implements as {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.as
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bg bgVar) {
        String str;
        if (i != this.bzl.byg.Xu().YU()) {
            if (i != this.bzl.byg.Xu().YV()) {
                if (i != this.bzl.byg.Xu().YX()) {
                    if (i != this.bzl.byg.Xu().XS()) {
                        if (i != this.bzl.byg.Xu().YY()) {
                            if (i == this.bzl.byg.Xu().YW() && this.bzl.byh != null && this.bzl.byh.getUserData() != null && this.bzl.byh.getUserData().isBawu()) {
                                String ber = this.bzl.byh.ber();
                                if (!com.baidu.tbadk.core.util.av.isEmpty(ber) && this.bzl.byh.aIk() != null) {
                                    com.baidu.tieba.c.a.a(this.bzl.getPageContext(), this.bzl.byh.aIk().getId(), this.bzl.byh.aIk().getName(), new s(this, ber));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c10417");
                        this.bzl.byh.beX();
                        this.bzl.byg.Xn();
                        com.baidu.tbadk.core.sharedPref.b.tW().putLong("frs_storecard_closetime", System.currentTimeMillis());
                        return;
                    }
                    this.bzl.bxX = bgVar;
                    com.baidu.tieba.frs.utils.t.b(this.bzl, this.bzl.bxX);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10179").ab("fid", this.bzl.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.utils.t.D(this.bzl);
                if (i == this.bzl.byg.Xu().YX()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.at(str).ab("fid", this.bzl.getForumId()));
            } else if (this.bzl.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bzl.byh != null && this.bzl.byh.aIk() != null) {
                    ForumData aIk = this.bzl.byh.aIk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bzl.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aIk.getId(), 0L), aIk.getName(), aIk.getImage_url(), 0)));
                }
            }
        } else if (this.bzl.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.utils.t.b(this.bzl, this.bzl.byh);
        }
    }
}
