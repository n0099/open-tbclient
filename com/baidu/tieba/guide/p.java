package com.baidu.tieba.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.b.aa;
import com.baidu.tieba.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Button button;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        boolean z;
        NewUserGuideActivity newUserGuideActivity3;
        boolean z2;
        NewUserGuideActivity newUserGuideActivity4;
        NewUserGuideActivity newUserGuideActivity5;
        View view2;
        if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
            button = this.a.p;
            if (view == button) {
                newUserGuideActivity = this.a.n;
                if (newUserGuideActivity.f()) {
                    com.baidu.tieba.r.c().e(true);
                }
                o oVar = this.a;
                newUserGuideActivity2 = this.a.n;
                aa aaVar = new aa(newUserGuideActivity2);
                z = this.a.q;
                oVar.sendMessage(new com.baidu.adp.framework.message.a(2015001, aaVar.a(1, z)));
                newUserGuideActivity3 = this.a.n;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.a.s;
        if (z2) {
            this.a.s = false;
            newUserGuideActivity4 = this.a.n;
            com.baidu.tbadk.core.g.a(newUserGuideActivity4, "newUserInterestSelect");
            newUserGuideActivity5 = this.a.n;
            w wVar = new w(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new q(this));
            view2 = this.a.b;
            view2.setVisibility(0);
            wVar.a();
            this.a.s = true;
        }
    }
}
