package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.avP = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.avP.avq;
        if (!z) {
            z2 = this.avP.avp;
            if (z2) {
                Drawable drawable = ay.getDrawable(p.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.avP.avx;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.avP.avo = false;
                this.avP.avp = false;
                return;
            }
            Drawable drawable2 = ay.getDrawable(p.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.avP.avx;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.avP.avo = true;
            this.avP.avp = true;
        }
    }
}
