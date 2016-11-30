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
class n implements ao {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ao
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bk bkVar) {
        String str;
        if (i != this.bTa.bRW.ade().aeA()) {
            if (i != this.bTa.bRW.ade().aeB()) {
                if (i != this.bTa.bRW.ade().aeD()) {
                    if (i != this.bTa.bRW.ade().adz()) {
                        if (i != this.bTa.bRW.ade().aeE()) {
                            if (i == this.bTa.bRW.ade().aeC() && this.bTa.bRX != null && this.bTa.bRX.getUserData() != null && this.bTa.bRX.getUserData().isBawu()) {
                                String bkB = this.bTa.bRX.bkB();
                                if (!com.baidu.tbadk.core.util.ax.isEmpty(bkB) && this.bTa.bRX.aOk() != null) {
                                    a.a(this.bTa.getPageContext(), this.bTa.bRX.aOk().getId(), this.bTa.bRX.aOk().getName(), new o(this, bkB));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c10417");
                        this.bTa.bRX.bli();
                        this.bTa.bRW.acX();
                        b.um().putLong("frs_storecard_closetime", System.currentTimeMillis());
                        return;
                    }
                    this.bTa.bRM = bkVar;
                    com.baidu.tieba.frs.utils.u.b(this.bTa, this.bTa.bRM);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10179").ab("fid", this.bTa.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.utils.u.E(this.bTa);
                if (i == this.bTa.bRW.ade().aeD()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.av(str).ab("fid", this.bTa.getForumId()));
            } else if (this.bTa.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bTa.bRX != null && this.bTa.bRX.aOk() != null) {
                    ForumData aOk = this.bTa.bRX.aOk();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bTa.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aOk.getId(), 0L), aOk.getName(), aOk.getImage_url(), 0)));
                }
            }
        } else if (this.bTa.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.utils.u.b(this.bTa, this.bTa.bRX);
        }
    }
}
