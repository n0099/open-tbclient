package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ ai alZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.alZ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.alZ.alG;
        if (!z) {
            z2 = this.alZ.alF;
            if (z2) {
                Drawable drawable = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.alZ.alN;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.alZ.alE = false;
                this.alZ.alF = false;
                return;
            }
            Drawable drawable2 = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.alZ.alN;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.alZ.alE = true;
            this.alZ.alF = true;
        }
    }
}
