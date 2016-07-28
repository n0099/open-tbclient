package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w aIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.aIY = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.aIY.aIz;
        if (!z) {
            z2 = this.aIY.aIy;
            if (z2) {
                Drawable drawable = av.getDrawable(u.f.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.aIY.aIG;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.aIY.aIx = false;
                this.aIY.aIy = false;
                return;
            }
            Drawable drawable2 = av.getDrawable(u.f.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.aIY.aIG;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.aIY.aIx = true;
            this.aIY.aIy = true;
        }
    }
}
