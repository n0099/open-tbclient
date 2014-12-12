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
class i implements ba {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v58, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.ba
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str;
        boolean z;
        com.baidu.tieba.tbadkCore.ao aoVar;
        bqVar = this.aCV.aBX;
        if (i != bqVar.GO().Ff() || view2 == null || view == null) {
            bqVar2 = this.aCV.aBX;
            if (i != bqVar2.GO().FV()) {
                bqVar3 = this.aCV.aBX;
                if (i != bqVar3.GO().Fe()) {
                    bqVar4 = this.aCV.aBX;
                    if (i != bqVar4.GO().Fg()) {
                        bqVar5 = this.aCV.aBX;
                        if (i != bqVar5.GO().FW()) {
                            bqVar6 = this.aCV.aBX;
                            if (i == bqVar6.GO().FX()) {
                                com.baidu.tbadk.core.i.C(this.aCV.getParent(), "my_service_ck");
                                eVar = this.aCV.aCh;
                                if (eVar != null) {
                                    eVar2 = this.aCV.aCh;
                                    if (eVar2.aej() != null) {
                                        eVar3 = this.aCV.aCh;
                                        ForumData aej = eVar3.aej();
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aCV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(aej.getId(), 0L), aej.getName(), aej.getImage_url(), 0)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.i.B(this.aCV.getParent(), "forum_fortune_click");
                        if (TbadkCoreApplication.isLogin()) {
                            this.aCV.FF();
                            return;
                        } else {
                            this.aCV.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aCV.getPageContext().getPageActivity(), (String) null, true, 18004)));
                            return;
                        }
                    }
                    FrsActivity frsActivity = this.aCV;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aCV.getPageContext().getPageActivity());
                    str = this.aCV.aBP;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
                    return;
                } else if (wVar != null) {
                    this.aCV.aBK = wVar;
                    z = this.aCV.aAE;
                    if (!z) {
                        this.aCV.aAE = true;
                        int isLike = wVar.getPraise() == null ? 0 : wVar.getPraise().getIsLike();
                        aoVar = this.aCV.aAT;
                        aoVar.a(wVar.getFirst_post_id(), wVar.getTid(), isLike, "frs");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (wVar != null && wVar.ny() != null && wVar.ny().get(0) != null && !StringUtils.isNull(wVar.ny().get(0).getUrl())) {
                com.baidu.tbadk.core.util.bh.pK().b(this.aCV.getPageContext(), new String[]{wVar.ny().get(0).getUrl()});
                if (wVar.ny().get(0).mq() == 1) {
                    TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                    return;
                } else if (wVar.ny().get(0).mq() == 2) {
                    TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
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
        this.aCV.a(i2, wVar, rect.bottom);
    }
}
