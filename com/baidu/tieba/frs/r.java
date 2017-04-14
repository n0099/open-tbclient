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
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.frs.at
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bi biVar) {
        String str;
        if (i != this.bNJ.bMD.aae().abr()) {
            if (i != this.bNJ.bMD.aae().abs()) {
                if (i != this.bNJ.bMD.aae().abu()) {
                    if (i != this.bNJ.bMD.aae().aaw()) {
                        if (i == this.bNJ.bMD.aae().abt() && this.bNJ.bME != null && this.bNJ.bME.getUserData() != null && this.bNJ.bME.getUserData().isBawu()) {
                            String bgF = this.bNJ.bME.bgF();
                            if (!com.baidu.tbadk.core.util.au.isEmpty(bgF) && this.bNJ.bME.aJw() != null) {
                                a.a(this.bNJ.getPageContext(), this.bNJ.bME.aJw().getId(), this.bNJ.bME.aJw().getName(), new s(this, bgF));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.bNJ.bMt = biVar;
                    com.baidu.tieba.frs.f.t.b(this.bNJ, this.bNJ.bMt);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10179").aa("fid", this.bNJ.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.f.t.E(this.bNJ);
                if (i == this.bNJ.bMD.aae().abu()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", this.bNJ.getForumId()));
            } else if (this.bNJ.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bNJ.bME != null && this.bNJ.bME.aJw() != null) {
                    ForumData aJw = this.bNJ.bME.aJw();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bNJ.getPageContext().getPageActivity(), b.c(aJw.getId(), 0L), aJw.getName(), aJw.getImage_url(), 0)));
                }
            }
        } else if (this.bNJ.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.f.t.b(this.bNJ, this.bNJ.bME);
        }
    }
}
