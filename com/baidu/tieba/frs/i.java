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
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aDW = frsActivity;
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
        bpVar = this.aDW.aCY;
        if (i != bpVar.Hl().FD() || view2 == null || view == null) {
            bpVar2 = this.aDW.aCY;
            if (i != bpVar2.Hl().Gs()) {
                bpVar3 = this.aDW.aCY;
                if (i != bpVar3.Hl().FC()) {
                    bpVar4 = this.aDW.aCY;
                    if (i != bpVar4.Hl().FE()) {
                        bpVar5 = this.aDW.aCY;
                        if (i != bpVar5.Hl().Gt()) {
                            bpVar6 = this.aDW.aCY;
                            if (i == bpVar6.Hl().Gu()) {
                                com.baidu.tbadk.core.i.B(this.aDW.getParent(), "my_service_ck");
                                eVar = this.aDW.aDi;
                                if (eVar != null) {
                                    eVar2 = this.aDW.aDi;
                                    if (eVar2.aeN() != null) {
                                        eVar3 = this.aDW.aDi;
                                        ForumData aeN = eVar3.aeN();
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aDW.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(aeN.getId(), 0L), aeN.getName(), aeN.getImage_url(), 0)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.i.A(this.aDW.getParent(), "forum_fortune_click");
                        if (TbadkCoreApplication.isLogin()) {
                            this.aDW.Gd();
                            return;
                        } else {
                            this.aDW.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDW.getPageContext().getPageActivity(), (String) null, true, 18004)));
                            return;
                        }
                    }
                    FrsActivity frsActivity = this.aDW;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDW.getPageContext().getPageActivity());
                    str = this.aDW.aCQ;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str, null, 18003, true, false, false)));
                    return;
                } else if (xVar != null) {
                    this.aDW.aCL = xVar;
                    z = this.aDW.aBG;
                    if (!z) {
                        this.aDW.aBG = true;
                        int isLike = xVar.getPraise() == null ? 0 : xVar.getPraise().getIsLike();
                        aoVar = this.aDW.aBU;
                        aoVar.a(xVar.getFirst_post_id(), xVar.getTid(), isLike, "frs");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (xVar != null && xVar.nA() != null && xVar.nA().get(0) != null && !StringUtils.isNull(xVar.nA().get(0).getUrl())) {
                com.baidu.tbadk.core.util.bm.pV().b(this.aDW.getPageContext(), new String[]{xVar.nA().get(0).getUrl()});
                if (xVar.nA().get(0).mq() == 1) {
                    TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                    return;
                } else if (xVar.nA().get(0).mq() == 2) {
                    TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
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
        this.aDW.a(i2, xVar, rect.bottom);
    }
}
