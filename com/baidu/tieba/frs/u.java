package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class u implements bj {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bj
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.o oVar) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        String str;
        boolean z;
        dm dmVar;
        csVar = this.a.w;
        if (i != csVar.v().f() || view2 == null || view == null) {
            csVar2 = this.a.w;
            if (i == csVar2.v().e()) {
                this.a.j = oVar;
                z = this.a.i;
                if (!z) {
                    this.a.i = true;
                    dmVar = this.a.av;
                    dmVar.a(oVar.i(), oVar.l(), oVar.j().getIsLike(), "frs");
                    return;
                }
                return;
            }
            csVar3 = this.a.w;
            if (i == csVar3.v().g()) {
                FrsActivity frsActivity = this.a;
                com.baidu.tbadk.core.atomData.as asVar = new com.baidu.tbadk.core.atomData.as(this.a);
                str = this.a.n;
                frsActivity.sendMessage(new CustomMessage(2006001, asVar.a(oVar, str, null, 18003, true, false, false)));
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.a.a(i2, oVar, rect.bottom);
    }
}
