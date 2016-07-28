package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class u implements ba {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ba
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.be beVar) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bqVar = this.bEL.bDK;
        if (i != bqVar.WN().Yn()) {
            bqVar2 = this.bEL.bDK;
            if (i != bqVar2.WN().Yo()) {
                bqVar3 = this.bEL.bDK;
                if (i != bqVar3.WN().Yq()) {
                    bqVar4 = this.bEL.bDK;
                    if (i == bqVar4.WN().Xk()) {
                        this.bEL.bDA = beVar;
                        this.bEL.VQ();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10179").ab("fid", this.bEL.getForumId()));
                        return;
                    }
                    bqVar5 = this.bEL.bDK;
                    if (i != bqVar5.WN().Yr()) {
                        bqVar6 = this.bEL.bDK;
                        if (i == bqVar6.WN().Yp() && this.bEL.bDM != null && this.bEL.bDM.getUserData() != null && this.bEL.bDM.getUserData().isBawu()) {
                            String bdT = this.bEL.bDM.bdT();
                            if (!com.baidu.tbadk.core.util.ba.isEmpty(bdT)) {
                                com.baidu.tbadk.browser.f.u(this.bEL.getPageContext().getPageActivity(), bdT);
                                if (this.bEL.bDM.aGX() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10502").ab("fid", this.bEL.bDM.aGX().getId()).ab("uid", this.bEL.bDM.getUserData().getUserId()));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c10417");
                    this.bEL.bDM.bet();
                    bqVar7 = this.bEL.bDK;
                    bqVar7.WF();
                    b.sN().putLong("frs_storecard_closetime", System.currentTimeMillis());
                    return;
                }
                this.bEL.VP();
                bqVar8 = this.bEL.bDK;
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay(i == bqVar8.WN().Yq() ? "c10177" : "c10244").ab("fid", this.bEL.getForumId()));
            } else if (this.bEL.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bEL.bDM != null && this.bEL.bDM.aGX() != null) {
                    ForumData aGX = this.bEL.bDM.aGX();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bEL.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aGX.getId(), 0L), aGX.getName(), aGX.getImage_url(), 0)));
                }
            }
        } else if (this.bEL.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            this.bEL.VO();
        }
    }
}
