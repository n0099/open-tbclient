package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements n {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.frs.n
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bl blVar) {
        String str;
        if (i != this.bVb.bUa.aaR().abH()) {
            if (i != this.bVb.bUa.aaR().abI()) {
                if (i != this.bVb.bUa.aaR().abK()) {
                    if (i != this.bVb.bUa.aaR().abb()) {
                        if (i == this.bVb.bUa.aaR().abJ() && this.bVb.bTF != null && this.bVb.bTF.getUserData() != null && this.bVb.bTF.getUserData().isBawu()) {
                            String bgE = this.bVb.bTF.bgE();
                            if (!com.baidu.tbadk.core.util.au.isEmpty(bgE) && this.bVb.bTF.aIz() != null) {
                                a.a(this.bVb.getPageContext(), this.bVb.bTF.aIz().getId(), this.bVb.bTF.aIz().getName(), new ad(this, bgE));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.bVb.bTR = blVar;
                    com.baidu.tieba.frs.e.p.a(this.bVb, this.bVb.bTR);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10179").Z("fid", this.bVb.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.e.p.y(this.bVb);
                if (i == this.bVb.bUa.aaR().abK()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).Z("fid", this.bVb.getForumId()));
            } else if (bh.aN(this.bVb.getPageContext().getPageActivity())) {
                TiebaStatic.log("my_service_ck");
                if (this.bVb.bTF != null && this.bVb.bTF.aIz() != null) {
                    ForumData aIz = this.bVb.bTF.aIz();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bVb.getPageContext().getPageActivity(), b.c(aIz.getId(), 0L), aIz.getName(), aIz.getImage_url(), 0)));
                }
            }
        } else if (bh.aN(this.bVb.getActivity())) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.e.p.a(this.bVb.getPageContext(), this.bVb.bTF);
        }
    }
}
