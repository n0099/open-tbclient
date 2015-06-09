package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class e implements an {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v52, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        String str;
        bfVar = this.aLY.aLj;
        if (i != bfVar.Lx().KU()) {
            bfVar2 = this.aLY.aLj;
            if (i != bfVar2.Lx().Kh()) {
                bfVar3 = this.aLY.aLj;
                if (i != bfVar3.Lx().KW()) {
                    bfVar4 = this.aLY.aLj;
                    if (i != bfVar4.Lx().KV()) {
                        bfVar5 = this.aLY.aLj;
                        if (i == bfVar5.Lx().KX() && this.aLY.checkUpIsLogin()) {
                            com.baidu.tbadk.core.k.B(this.aLY.getParent(), "my_service_ck");
                            wVar2 = this.aLY.aLm;
                            if (wVar2 != null) {
                                wVar3 = this.aLY.aLm;
                                if (wVar3.aas() != null) {
                                    wVar4 = this.aLY.aLm;
                                    ForumData aas = wVar4.aas();
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aLY.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(aas.getId(), 0L), aas.getName(), aas.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.aLY.checkUpIsLogin()) {
                        com.baidu.tbadk.core.k.A(this.aLY.getParent(), "forum_fortune_click");
                        this.aLY.KC();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                return;
            }
            FrsActivity frsActivity = this.aLY;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aLY.getPageContext().getPageActivity());
            str = this.aLY.aLc;
            frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (this.aLY.checkUpIsLogin() && wVar != null && wVar.rp() != null && wVar.rp().get(0) != null && !StringUtils.isNull(wVar.rp().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bi.tO().b(this.aLY.getPageContext(), new String[]{wVar.rp().get(0).getUrl()});
            if (wVar.rp().get(0).qq() == 1) {
                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (wVar.rp().get(0).qq() == 2) {
                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
