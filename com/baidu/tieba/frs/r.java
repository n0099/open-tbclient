package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class r implements ar {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bj bjVar) {
        String str;
        if (i != this.bNU.bMN.ZG().aaT()) {
            if (i != this.bNU.bMN.ZG().aaU()) {
                if (i != this.bNU.bMN.ZG().aaW()) {
                    if (i != this.bNU.bMN.ZG().ZY()) {
                        if (i != this.bNU.bMN.ZG().aaX()) {
                            if (i == this.bNU.bMN.ZG().aaV() && this.bNU.bMO != null && this.bNU.bMO.getUserData() != null && this.bNU.bMO.getUserData().isBawu()) {
                                String bfS = this.bNU.bMO.bfS();
                                if (!com.baidu.tbadk.core.util.au.isEmpty(bfS) && this.bNU.bMO.aJp() != null) {
                                    a.a(this.bNU.getPageContext(), this.bNU.bMO.aJp().getId(), this.bNU.bMO.aJp().getName(), new s(this, bfS));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c10417");
                        this.bNU.bMO.bgz();
                        this.bNU.bMN.ZA();
                        b.uo().putLong("frs_storecard_closetime", System.currentTimeMillis());
                        return;
                    }
                    this.bNU.bMD = bjVar;
                    com.baidu.tieba.frs.utils.t.b(this.bNU, this.bNU.bMD);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10179").Z("fid", this.bNU.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.utils.t.E(this.bNU);
                if (i == this.bNU.bMN.ZG().aaW()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).Z("fid", this.bNU.getForumId()));
            } else if (this.bNU.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bNU.bMO != null && this.bNU.bMO.aJp() != null) {
                    ForumData aJp = this.bNU.bMO.aJp();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bNU.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aJp.getId(), 0L), aJp.getName(), aJp.getImage_url(), 0)));
                }
            }
        } else if (this.bNU.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.utils.t.b(this.bNU, this.bNU.bMO);
        }
    }
}
