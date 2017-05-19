package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ y aUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.aUy = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aUy.aTZ;
        if (!z) {
            z2 = this.aUy.aTY;
            if (z2) {
                Drawable drawable = aq.getDrawable(w.g.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aUy.aUg;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aUy.aTX = false;
                this.aUy.aTY = false;
                return;
            }
            Drawable drawable2 = aq.getDrawable(w.g.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aUy.aUg;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aUy.aTX = true;
            this.aUy.aTY = true;
        }
    }
}
