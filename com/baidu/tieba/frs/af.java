package com.baidu.tieba.frs;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        button = this.a.k;
        if (view != button) {
            button2 = this.a.x;
            if (view != button2) {
                button3 = this.a.y;
                if (view != button3) {
                    button4 = this.a.z;
                    if (view != button4) {
                        return;
                    }
                    this.a.c(1);
                    return;
                }
                this.a.e(1);
                return;
            }
            this.a.c(0);
            return;
        }
        this.a.finish();
    }
}
