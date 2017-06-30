package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements n {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.frs.n
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bm bmVar) {
        String str;
        if (i != this.cdl.ccj.aeI().afy()) {
            if (i != this.cdl.ccj.aeI().afz()) {
                if (i != this.cdl.ccj.aeI().afB()) {
                    if (i != this.cdl.ccj.aeI().aeS()) {
                        if (i == this.cdl.ccj.aeI().afA() && this.cdl.cbN != null && this.cdl.cbN.getUserData() != null && this.cdl.cbN.getUserData().isBawu()) {
                            String bkS = this.cdl.cbN.bkS();
                            if (!com.baidu.tbadk.core.util.aw.isEmpty(bkS) && this.cdl.cbN.aMt() != null) {
                                a.a(this.cdl.getPageContext(), this.cdl.cbN.aMt().getId(), this.cdl.cbN.aMt().getName(), new ad(this, bkS));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.cdl.cca = bmVar;
                    com.baidu.tieba.frs.e.p.a(this.cdl, this.cdl.cca);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10179").Z("fid", this.cdl.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.e.p.y(this.cdl);
                if (i == this.cdl.ccj.aeI().afB()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).Z("fid", this.cdl.getForumId()));
            } else if (bl.aN(this.cdl.getPageContext().getPageActivity())) {
                TiebaStatic.log("my_service_ck");
                if (this.cdl.cbN != null && this.cdl.cbN.aMt() != null) {
                    ForumData aMt = this.cdl.cbN.aMt();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.cdl.getPageContext().getPageActivity(), b.c(aMt.getId(), 0L), aMt.getName(), aMt.getImage_url(), 0)));
                }
            }
        } else if (bl.aN(this.cdl.getActivity())) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.e.p.a(this.cdl.getPageContext(), this.cdl.cbN);
        }
    }
}
