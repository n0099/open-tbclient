package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ y aTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.aTM = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aTM.aTn;
        if (!z) {
            z2 = this.aTM.aTm;
            if (z2) {
                Drawable drawable = aq.getDrawable(w.g.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aTM.aTu;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aTM.aTl = false;
                this.aTM.aTm = false;
                return;
            }
            Drawable drawable2 = aq.getDrawable(w.g.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aTM.aTu;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aTM.aTl = true;
            this.aTM.aTm = true;
        }
    }
}
