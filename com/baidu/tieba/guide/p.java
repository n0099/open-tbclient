package com.baidu.tieba.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        boolean z;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        NewUserGuideActivity newUserGuideActivity5;
        if (view.getTag() != null && (view.getTag() instanceof InterestFrsData.Tag)) {
            newUserGuideActivity4 = this.a.n;
            ai.a(newUserGuideActivity4, "newUserInterestSelect");
            newUserGuideActivity5 = this.a.n;
            new u(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag()).a();
            return;
        }
        button = this.a.p;
        if (view == button) {
            newUserGuideActivity = this.a.n;
            if (newUserGuideActivity.e()) {
                TiebaApplication.g().h(true);
            }
            newUserGuideActivity2 = this.a.n;
            z = this.a.q;
            MainTabActivity.a(newUserGuideActivity2, 1, z);
            newUserGuideActivity3 = this.a.n;
            newUserGuideActivity3.finish();
        }
    }
}
