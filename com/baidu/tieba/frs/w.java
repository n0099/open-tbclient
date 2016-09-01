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
class w implements ba {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ba
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bg bgVar) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        String str;
        bmVar = this.bQp.bPo;
        if (i != bmVar.abJ().acZ()) {
            bmVar2 = this.bQp.bPo;
            if (i != bmVar2.abJ().ada()) {
                bmVar3 = this.bQp.bPo;
                if (i != bmVar3.abJ().adc()) {
                    bmVar4 = this.bQp.bPo;
                    if (i == bmVar4.abJ().ach()) {
                        this.bQp.bPe = bgVar;
                        this.bQp.aaN();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10179").ab("fid", this.bQp.getForumId()));
                        return;
                    }
                    bmVar5 = this.bQp.bPo;
                    if (i != bmVar5.abJ().add()) {
                        bmVar6 = this.bQp.bPo;
                        if (i == bmVar6.abJ().adb() && this.bQp.bPq != null && this.bQp.bPq.getUserData() != null && this.bQp.bPq.getUserData().isBawu()) {
                            String bhx = this.bQp.bPq.bhx();
                            if (!com.baidu.tbadk.core.util.ba.isEmpty(bhx) && this.bQp.bPq.aLP() != null) {
                                a.a(this.bQp.getPageContext(), this.bQp.bPq.aLP().getId(), this.bQp.bPq.aLP().getName(), new x(this, bhx));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c10417");
                    this.bQp.bPq.bhZ();
                    bmVar7 = this.bQp.bPo;
                    bmVar7.abB();
                    b.tS().putLong("frs_storecard_closetime", System.currentTimeMillis());
                    return;
                }
                this.bQp.aaM();
                bmVar8 = this.bQp.bPo;
                if (i == bmVar8.abJ().adc()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", this.bQp.getForumId()));
            } else if (this.bQp.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bQp.bPq != null && this.bQp.bPq.aLP() != null) {
                    ForumData aLP = this.bQp.bPq.aLP();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bQp.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aLP.getId(), 0L), aLP.getName(), aLP.getImage_url(), 0)));
                }
            }
        } else if (this.bQp.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            this.bQp.aaJ();
        }
    }
}
