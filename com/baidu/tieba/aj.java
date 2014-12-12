package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ af alf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.alf = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.alf.akM;
        if (!z) {
            z2 = this.alf.akL;
            if (z2) {
                Drawable drawable = com.baidu.tbadk.core.util.ax.getDrawable(v.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.alf.akT;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.alf.akK = false;
                this.alf.akL = false;
                return;
            }
            Drawable drawable2 = com.baidu.tbadk.core.util.ax.getDrawable(v.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.alf.akT;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.alf.akK = true;
            this.alf.akL = true;
        }
    }
}
