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
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
        buVar = this.aBu.aAF;
        if (i != buVar.GJ().EO() || view2 == null || view == null) {
            buVar2 = this.aBu.aAF;
            if (i != buVar2.GJ().EN()) {
                buVar3 = this.aBu.aAF;
                if (i != buVar3.GJ().EP()) {
                    buVar4 = this.aBu.aAF;
                    if (i != buVar4.GJ().FQ()) {
                        buVar5 = this.aBu.aAF;
                        if (i == buVar5.GJ().FR()) {
                            com.baidu.tbadk.core.j.m(this.aBu.getParent(), "my_service_ck");
                            bVar = this.aBu.azN;
                            if (bVar != null) {
                                bVar2 = this.aBu.azN;
                                if (bVar2.zL() != null) {
                                    bVar3 = this.aBu.azN;
                                    ForumData zL = bVar3.zL();
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aBu, com.baidu.adp.lib.g.c.a(zL.getId(), 0L), zL.getName(), zL.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.j.l(this.aBu.getParent(), "forum_fortune_click");
                    if (TbadkApplication.isLogin()) {
                        this.aBu.FA();
                        return;
                    } else {
                        LoginActivity.a((Activity) this.aBu, (String) null, true, 18004);
                        return;
                    }
                }
                FrsActivity frsActivity = this.aBu;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aBu);
                str = this.aBu.aAx;
                frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(qVar, str, null, 18003, true, false, false)));
                return;
            } else if (qVar != null) {
                this.aBu.aAs = qVar;
                z = this.aBu.ayC;
                if (!z) {
                    this.aBu.ayC = true;
                    int isLike = qVar.getPraise() == null ? 0 : qVar.getPraise().getIsLike();
                    dfVar = this.aBu.ayR;
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
        this.aBu.a(i2, qVar, rect.bottom);
    }
}
