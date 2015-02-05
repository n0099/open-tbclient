package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ ai alW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.alW = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.alW.alD;
        if (!z) {
            z2 = this.alW.alC;
            if (z2) {
                Drawable drawable = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.alW.alK;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.alW.alB = false;
                this.alW.alC = false;
                return;
            }
            Drawable drawable2 = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.alW.alK;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.alW.alB = true;
            this.alW.alC = true;
        }
    }
}
