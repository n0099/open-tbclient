package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ ab auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.auc = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        ag agVar;
        boolean z3;
        TextView textView2;
        textView = this.auc.atR;
        textView.setEnabled(false);
        z = this.auc.atG;
        TiebaStatic.eventStat(this.auc.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.auc.atI = true;
        z2 = this.auc.atH;
        if (z2) {
            Drawable drawable = ba.getDrawable(u.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.auc.atP;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        agVar = this.auc.atZ;
        z3 = this.auc.atH;
        agVar.bi(z3);
    }
}
