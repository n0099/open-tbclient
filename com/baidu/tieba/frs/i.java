package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
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
class i implements az {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v58, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.az
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.x xVar) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str;
        boolean z;
        com.baidu.tieba.tbadkCore.ao aoVar;
        bpVar = this.aDT.aCV;
        if (i != bpVar.Hf().Fx() || view2 == null || view == null) {
            bpVar2 = this.aDT.aCV;
            if (i != bpVar2.Hf().Gm()) {
                bpVar3 = this.aDT.aCV;
                if (i != bpVar3.Hf().Fw()) {
                    bpVar4 = this.aDT.aCV;
                    if (i != bpVar4.Hf().Fy()) {
                        bpVar5 = this.aDT.aCV;
                        if (i != bpVar5.Hf().Gn()) {
                            bpVar6 = this.aDT.aCV;
                            if (i == bpVar6.Hf().Go()) {
                                com.baidu.tbadk.core.i.B(this.aDT.getParent(), "my_service_ck");
                                eVar = this.aDT.aDf;
                                if (eVar != null) {
                                    eVar2 = this.aDT.aDf;
                                    if (eVar2.aeI() != null) {
                                        eVar3 = this.aDT.aDf;
                                        ForumData aeI = eVar3.aeI();
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aDT.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(aeI.getId(), 0L), aeI.getName(), aeI.getImage_url(), 0)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.i.A(this.aDT.getParent(), "forum_fortune_click");
                        if (TbadkCoreApplication.isLogin()) {
                            this.aDT.FX();
                            return;
                        } else {
                            this.aDT.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDT.getPageContext().getPageActivity(), (String) null, true, 18004)));
                            return;
                        }
                    }
                    FrsActivity frsActivity = this.aDT;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDT.getPageContext().getPageActivity());
                    str = this.aDT.aCN;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str, null, 18003, true, false, false)));
                    return;
                } else if (xVar != null) {
                    this.aDT.aCI = xVar;
                    z = this.aDT.aBD;
                    if (!z) {
                        this.aDT.aBD = true;
                        int isLike = xVar.getPraise() == null ? 0 : xVar.getPraise().getIsLike();
                        aoVar = this.aDT.aBR;
                        aoVar.a(xVar.getFirst_post_id(), xVar.getTid(), isLike, "frs");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (xVar != null && xVar.nt() != null && xVar.nt().get(0) != null && !StringUtils.isNull(xVar.nt().get(0).getUrl())) {
                com.baidu.tbadk.core.util.bm.pO().b(this.aDT.getPageContext(), new String[]{xVar.nt().get(0).getUrl()});
                if (xVar.nt().get(0).mj() == 1) {
                    TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                    return;
                } else if (xVar.nt().get(0).mj() == 2) {
                    TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aDT.a(i2, xVar, rect.bottom);
    }
}
