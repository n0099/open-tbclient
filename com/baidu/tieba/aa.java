package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w aIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.aIh = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aIh.aHI;
        if (!z) {
            z2 = this.aIh.aHH;
            if (z2) {
                Drawable drawable = av.getDrawable(u.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aIh.aHP;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aIh.aHG = false;
                this.aIh.aHH = false;
                return;
            }
            Drawable drawable2 = av.getDrawable(u.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aIh.aHP;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aIh.aHG = true;
            this.aIh.aHH = true;
        }
    }
}
