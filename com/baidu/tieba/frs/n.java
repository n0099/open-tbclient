package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class n implements be {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.frs.be
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.q qVar) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        b bVar;
        b bVar2;
        b bVar3;
        String str;
        boolean z;
        df dfVar;
        buVar = this.aBk.aAv;
        if (i != buVar.GH().EM() || view2 == null || view == null) {
            buVar2 = this.aBk.aAv;
            if (i != buVar2.GH().EL()) {
                buVar3 = this.aBk.aAv;
                if (i != buVar3.GH().EN()) {
                    buVar4 = this.aBk.aAv;
                    if (i != buVar4.GH().FO()) {
                        buVar5 = this.aBk.aAv;
                        if (i == buVar5.GH().FP()) {
                            com.baidu.tbadk.core.i.m(this.aBk.getParent(), "my_service_ck");
                            bVar = this.aBk.azE;
                            if (bVar != null) {
                                bVar2 = this.aBk.azE;
                                if (bVar2.zJ() != null) {
                                    bVar3 = this.aBk.azE;
                                    ForumData zJ = bVar3.zJ();
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aBk, com.baidu.adp.lib.g.c.a(zJ.getId(), 0L), zJ.getName(), zJ.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.i.l(this.aBk.getParent(), "forum_fortune_click");
                    if (TbadkApplication.isLogin()) {
                        this.aBk.Fy();
                        return;
                    } else {
                        LoginActivity.a((Activity) this.aBk, (String) null, true, 18004);
                        return;
                    }
                }
                FrsActivity frsActivity = this.aBk;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aBk);
                str = this.aBk.aAn;
                frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(qVar, str, null, 18003, true, false, false)));
                return;
            } else if (qVar != null) {
                this.aBk.aAi = qVar;
                z = this.aBk.ayt;
                if (!z) {
                    this.aBk.ayt = true;
                    int isLike = qVar.getPraise() == null ? 0 : qVar.getPraise().getIsLike();
                    dfVar = this.aBk.ayI;
                    dfVar.a(qVar.getFirst_post_id(), qVar.getTid(), isLike, "frs");
                    return;
                }
                return;
            } else {
                return;
            }
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aBk.a(i2, qVar, rect.bottom);
    }
}
