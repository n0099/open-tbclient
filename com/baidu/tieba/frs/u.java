package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
final class u implements bf {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bf
    public final void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.o oVar) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        String str;
        cm cmVar4;
        boolean z;
        dc unused;
        cmVar = this.a.r;
        cmVar.t();
        if (i != ay.g()) {
            cmVar2 = this.a.r;
            cmVar2.t();
            if (i == ay.f()) {
                this.a.f = oVar;
                z = this.a.e;
                if (!z) {
                    this.a.e = true;
                    unused = this.a.aq;
                    dc.a(oVar.j(), oVar.m(), oVar.k().getIsLike(), "frs");
                    return;
                }
                return;
            }
            cmVar3 = this.a.r;
            cmVar3.t();
            if (i != ay.h()) {
                cmVar4 = this.a.r;
                cmVar4.t();
                if (i != ay.i()) {
                    return;
                }
            }
            FrsActivity frsActivity = this.a;
            com.baidu.tbadk.core.b.af afVar = new com.baidu.tbadk.core.b.af(this.a);
            str = this.a.i;
            frsActivity.sendMessage(new com.baidu.adp.framework.message.a(2004001, afVar.a(oVar, str, null, 18003, true, false, false)));
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.a.a(i2, oVar, rect.bottom);
    }
}
