package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements n {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tieba.frs.n
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bk bkVar) {
        String str;
        if (i != this.bPn.bOn.ZO().aaE()) {
            if (i != this.bPn.bOn.ZO().aaF()) {
                if (i != this.bPn.bOn.ZO().aaH()) {
                    if (i != this.bPn.bOn.ZO().ZZ()) {
                        if (i == this.bPn.bOn.ZO().aaG() && this.bPn.bNT != null && this.bPn.bNT.getUserData() != null && this.bPn.bNT.getUserData().isBawu()) {
                            String bfj = this.bPn.bNT.bfj();
                            if (!com.baidu.tbadk.core.util.au.isEmpty(bfj) && this.bPn.bNT.aHE() != null) {
                                a.a(this.bPn.getPageContext(), this.bPn.bNT.aHE().getId(), this.bPn.bNT.aHE().getName(), new ac(this, bfj));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.bPn.bOe = bkVar;
                    com.baidu.tieba.frs.d.p.a(this.bPn, this.bPn.bOe);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10179").aa("fid", this.bPn.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.d.p.y(this.bPn);
                if (i == this.bPn.bOn.ZO().aaH()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", this.bPn.getForumId()));
            } else if (bg.aN(this.bPn.getPageContext().getPageActivity())) {
                TiebaStatic.log("my_service_ck");
                if (this.bPn.bNT != null && this.bPn.bNT.aHE() != null) {
                    ForumData aHE = this.bPn.bNT.aHE();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bPn.getPageContext().getPageActivity(), b.c(aHE.getId(), 0L), aHE.getName(), aHE.getImage_url(), 0)));
                }
            }
        } else if (bg.aN(this.bPn.getActivity())) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.d.p.a(this.bPn.getPageContext(), this.bPn.bNT);
        }
    }
}
