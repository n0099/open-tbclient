package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class r implements at {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.at
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bi biVar) {
        String str;
        if (i != this.bQa.bOU.abf().acs()) {
            if (i != this.bQa.bOU.abf().act()) {
                if (i != this.bQa.bOU.abf().acv()) {
                    if (i != this.bQa.bOU.abf().abx()) {
                        if (i == this.bQa.bOU.abf().acu() && this.bQa.bOV != null && this.bQa.bOV.getUserData() != null && this.bQa.bOV.getUserData().isBawu()) {
                            String bhH = this.bQa.bOV.bhH();
                            if (!com.baidu.tbadk.core.util.au.isEmpty(bhH) && this.bQa.bOV.aKx() != null) {
                                a.a(this.bQa.getPageContext(), this.bQa.bOV.aKx().getId(), this.bQa.bOV.aKx().getName(), new s(this, bhH));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.bQa.bOK = biVar;
                    com.baidu.tieba.frs.f.t.b(this.bQa, this.bQa.bOK);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10179").aa("fid", this.bQa.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.f.t.E(this.bQa);
                if (i == this.bQa.bOU.abf().acv()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", this.bQa.getForumId()));
            } else if (this.bQa.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bQa.bOV != null && this.bQa.bOV.aKx() != null) {
                    ForumData aKx = this.bQa.bOV.aKx();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bQa.getPageContext().getPageActivity(), b.c(aKx.getId(), 0L), aKx.getName(), aKx.getImage_url(), 0)));
                }
            }
        } else if (this.bQa.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.f.t.b(this.bQa, this.bQa.bOV);
        }
    }
}
