package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class e implements an {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v41, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        String str;
        bfVar = this.aJQ.aJa;
        if (i != bfVar.Kr().JP()) {
            bfVar2 = this.aJQ.aJa;
            if (i != bfVar2.Kr().Jd()) {
                bfVar3 = this.aJQ.aJa;
                if (i != bfVar3.Kr().JQ()) {
                    bfVar4 = this.aJQ.aJa;
                    if (i == bfVar4.Kr().JR()) {
                        com.baidu.tbadk.core.k.B(this.aJQ.getParent(), "my_service_ck");
                        wVar2 = this.aJQ.aJd;
                        if (wVar2 != null) {
                            wVar3 = this.aJQ.aJd;
                            if (wVar3.Za() != null) {
                                wVar4 = this.aJQ.aJd;
                                ForumData Za = wVar4.Za();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aJQ.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(Za.getId(), 0L), Za.getName(), Za.getImage_url(), 0)));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.k.A(this.aJQ.getParent(), "forum_fortune_click");
                if (!TbadkCoreApplication.isLogin()) {
                    this.aJQ.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aJQ.getPageContext().getPageActivity(), (String) null, true, 18004)));
                    return;
                } else {
                    this.aJQ.Jx();
                    return;
                }
            }
            FrsActivity frsActivity = this.aJQ;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aJQ.getPageContext().getPageActivity());
            str = this.aJQ.aIS;
            frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (wVar != null && wVar.qJ() != null && wVar.qJ().get(0) != null && !StringUtils.isNull(wVar.qJ().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bk.tl().b(this.aJQ.getPageContext(), new String[]{wVar.qJ().get(0).getUrl()});
            if (wVar.qJ().get(0).pK() == 1) {
                TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (wVar.qJ().get(0).pK() == 2) {
                TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
