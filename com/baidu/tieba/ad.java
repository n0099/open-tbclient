package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ac adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.adt = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        ah ahVar;
        boolean z3;
        TextView textView;
        z = this.adt.acX;
        TiebaStatic.eventStat(this.adt.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.adt.acZ = true;
        z2 = this.adt.acY;
        if (z2) {
            Drawable drawable = com.baidu.tbadk.core.util.aw.getDrawable(u.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView = this.adt.adh;
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        ahVar = this.adt.adq;
        z3 = this.adt.acY;
        ahVar.aL(z3);
    }
}
