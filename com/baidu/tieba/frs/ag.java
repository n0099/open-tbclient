package com.baidu.tieba.frs;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        button = this.a.j;
        if (view == button) {
            this.a.finish();
            return;
        }
        button2 = this.a.k;
        if (view == button2) {
            MainTabActivity.a(this.a, "goto_recommend");
            this.a.finish();
            return;
        }
        button3 = this.a.x;
        if (view == button3) {
            this.a.a(0);
            return;
        }
        button4 = this.a.y;
        if (view == button4) {
            this.a.c(1);
            return;
        }
        button5 = this.a.z;
        if (view == button5) {
            this.a.a(1);
        }
    }
}
