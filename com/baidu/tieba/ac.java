package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ y aSa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.aSa = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aSa.aRB;
        if (!z) {
            z2 = this.aSa.aRA;
            if (z2) {
                Drawable drawable = aq.getDrawable(w.g.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aSa.aRI;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aSa.aRz = false;
                this.aSa.aRA = false;
                return;
            }
            Drawable drawable2 = aq.getDrawable(w.g.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aSa.aRI;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aSa.aRz = true;
            this.aSa.aRA = true;
        }
    }
}
