package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class t implements bk {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.n nVar) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        String str;
        boolean z;
        dn dnVar;
        ctVar = this.a.w;
        if (i != ctVar.v().f() || view2 == null || view == null) {
            ctVar2 = this.a.w;
            if (i == ctVar2.v().e()) {
                this.a.j = nVar;
                z = this.a.i;
                if (!z) {
                    this.a.i = true;
                    int isLike = nVar.o() == null ? 0 : nVar.o().getIsLike();
                    dnVar = this.a.as;
                    dnVar.a(nVar.n(), nVar.q(), isLike, "frs");
                    return;
                }
                return;
            }
            ctVar3 = this.a.w;
            if (i == ctVar3.v().g()) {
                FrsActivity frsActivity = this.a;
                com.baidu.tbadk.core.atomData.ar arVar = new com.baidu.tbadk.core.atomData.ar(this.a);
                str = this.a.n;
                frsActivity.sendMessage(new CustomMessage(2006001, arVar.a(nVar, str, null, 18003, true, false, false)));
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.a.a(i2, nVar, rect.bottom);
    }
}
