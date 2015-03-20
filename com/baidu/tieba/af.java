package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ab auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar) {
        this.auc = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        TextView textView2;
        z = this.auc.atI;
        if (!z) {
            z2 = this.auc.atH;
            if (z2) {
                Drawable drawable = ba.getDrawable(u.btn_dailog_choose_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView2 = this.auc.atP;
                textView2.setCompoundDrawables(drawable, null, null, null);
                this.auc.atG = false;
                this.auc.atH = false;
                return;
            }
            Drawable drawable2 = ba.getDrawable(u.btn_dailog_choose_s);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView = this.auc.atP;
            textView.setCompoundDrawables(drawable2, null, null, null);
            this.auc.atG = true;
            this.auc.atH = true;
        }
    }
}
