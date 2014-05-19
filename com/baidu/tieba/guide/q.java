package com.baidu.tieba.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.al;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            button = this.a.q;
            if (view == button) {
                newUserGuideActivity = this.a.o;
                if (newUserGuideActivity.e()) {
                    ad.c().e(true);
                }
                p pVar = this.a;
                newUserGuideActivity2 = this.a.o;
                al alVar = new al(newUserGuideActivity2);
                z = this.a.r;
                pVar.a(new CustomMessage(2017001, alVar.a(1, z)));
                newUserGuideActivity3 = this.a.o;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.a.t;
        if (z2) {
            this.a.t = false;
            newUserGuideActivity4 = this.a.o;
            com.baidu.tbadk.core.g.a(newUserGuideActivity4, "newUserInterestSelect");
            newUserGuideActivity5 = this.a.o;
            x xVar = new x(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new r(this));
            view2 = this.a.c;
            view2.setVisibility(0);
            xVar.a();
            this.a.t = true;
        }
    }
}
