package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class t implements bk {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.m mVar) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        g gVar;
        g gVar2;
        g gVar3;
        String str;
        boolean z;
        Cdo cdo;
        ctVar = this.a.v;
        if (i != ctVar.u().f() || view2 == null || view == null) {
            ctVar2 = this.a.v;
            if (i == ctVar2.u().e()) {
                this.a.i = mVar;
                z = this.a.h;
                if (!z) {
                    this.a.h = true;
                    int isLike = mVar.o() == null ? 0 : mVar.o().getIsLike();
                    cdo = this.a.aw;
                    cdo.a(mVar.n(), mVar.q(), isLike, "frs");
                    return;
                }
                return;
            }
            ctVar3 = this.a.v;
            if (i != ctVar3.u().g()) {
                ctVar4 = this.a.v;
                if (i != ctVar4.u().h()) {
                    ctVar5 = this.a.v;
                    if (i == ctVar5.u().i()) {
                        com.baidu.tbadk.core.f.b(this.a.getParent(), "my_service_ck");
                        gVar = this.a.H;
                        if (gVar != null) {
                            gVar2 = this.a.H;
                            if (gVar2.g() != null) {
                                gVar3 = this.a.H;
                                ForumData g = gVar3.g();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new com.baidu.tbadk.core.atomData.av(this.a, com.baidu.adp.lib.f.b.a(g.getId(), 0L), g.getName(), g.getImage_url(), 0)));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.f.a(this.a.getParent(), "forum_fortune_click");
                if (TbadkApplication.isLogin()) {
                    this.a.K();
                    return;
                } else {
                    LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                    return;
                }
            }
            FrsActivity frsActivity = this.a;
            com.baidu.tbadk.core.atomData.aw awVar = new com.baidu.tbadk.core.atomData.aw(this.a);
            str = this.a.m;
            frsActivity.sendMessage(new CustomMessage(2004001, awVar.a(mVar, str, null, 18003, true, false, false)));
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.a.a(i2, mVar, rect.bottom);
    }
}
