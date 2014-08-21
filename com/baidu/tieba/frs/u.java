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
class u implements bm {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bm
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.n nVar) {
        cv cvVar;
        cv cvVar2;
        cv cvVar3;
        cv cvVar4;
        cv cvVar5;
        g gVar;
        g gVar2;
        g gVar3;
        String str;
        boolean z;
        dt dtVar;
        cvVar = this.a.B;
        if (i != cvVar.v().f() || view2 == null || view == null) {
            cvVar2 = this.a.B;
            if (i != cvVar2.v().e()) {
                cvVar3 = this.a.B;
                if (i != cvVar3.v().g()) {
                    cvVar4 = this.a.B;
                    if (i != cvVar4.v().h()) {
                        cvVar5 = this.a.B;
                        if (i == cvVar5.v().i()) {
                            com.baidu.tbadk.core.f.b(this.a.getParent(), "my_service_ck");
                            gVar = this.a.N;
                            if (gVar != null) {
                                gVar2 = this.a.N;
                                if (gVar2.i() != null) {
                                    gVar3 = this.a.N;
                                    ForumData i3 = gVar3.i();
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new com.baidu.tbadk.core.atomData.bb(this.a, com.baidu.adp.lib.e.c.a(i3.getId(), 0L), i3.getName(), i3.getImage_url(), 0)));
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
                        this.a.J();
                        return;
                    } else {
                        LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                        return;
                    }
                }
                FrsActivity frsActivity = this.a;
                com.baidu.tbadk.core.atomData.bc bcVar = new com.baidu.tbadk.core.atomData.bc(this.a);
                str = this.a.q;
                frsActivity.sendMessage(new CustomMessage(2004001, bcVar.a(nVar, str, null, 18003, true, false, false)));
                return;
            } else if (nVar != null) {
                this.a.j = nVar;
                z = this.a.i;
                if (!z) {
                    this.a.i = true;
                    int isLike = nVar.g() == null ? 0 : nVar.g().getIsLike();
                    dtVar = this.a.aA;
                    dtVar.a(nVar.f(), nVar.i(), isLike, "frs");
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
        this.a.a(i2, nVar, rect.bottom);
    }
}
