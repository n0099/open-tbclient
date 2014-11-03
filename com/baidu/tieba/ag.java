package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ac adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.adt = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.adt.acZ;
        if (!z) {
            z2 = this.adt.acY;
            if (z2) {
                Drawable drawable = com.baidu.tbadk.core.util.aw.getDrawable(u.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.adt.adh;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.adt.acX = false;
                this.adt.acY = false;
                return;
            }
            Drawable drawable2 = com.baidu.tbadk.core.util.aw.getDrawable(u.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.adt.adh;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.adt.acX = true;
            this.adt.acY = true;
        }
    }
}
