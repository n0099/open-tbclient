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
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.aLX = frsActivity;
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
        bfVar = this.aLX.aLi;
        if (i != bfVar.Lw().KT()) {
            bfVar2 = this.aLX.aLi;
            if (i != bfVar2.Lw().Kg()) {
                bfVar3 = this.aLX.aLi;
                if (i != bfVar3.Lw().KV()) {
                    bfVar4 = this.aLX.aLi;
                    if (i != bfVar4.Lw().KU()) {
                        bfVar5 = this.aLX.aLi;
                        if (i == bfVar5.Lw().KW() && this.aLX.checkUpIsLogin()) {
                            com.baidu.tbadk.core.k.B(this.aLX.getParent(), "my_service_ck");
                            wVar2 = this.aLX.aLl;
                            if (wVar2 != null) {
                                wVar3 = this.aLX.aLl;
                                if (wVar3.aar() != null) {
                                    wVar4 = this.aLX.aLl;
                                    ForumData aar = wVar4.aar();
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aLX.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(aar.getId(), 0L), aar.getName(), aar.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.aLX.checkUpIsLogin()) {
                        com.baidu.tbadk.core.k.A(this.aLX.getParent(), "forum_fortune_click");
                        this.aLX.KB();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                return;
            }
            FrsActivity frsActivity = this.aLX;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aLX.getPageContext().getPageActivity());
            str = this.aLX.aLb;
            frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (this.aLX.checkUpIsLogin() && wVar != null && wVar.rp() != null && wVar.rp().get(0) != null && !StringUtils.isNull(wVar.rp().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bi.tO().b(this.aLX.getPageContext(), new String[]{wVar.rp().get(0).getUrl()});
            if (wVar.rp().get(0).qq() == 1) {
                TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (wVar.rp().get(0).qq() == 2) {
                TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
