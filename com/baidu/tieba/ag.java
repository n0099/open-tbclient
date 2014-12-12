package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ af alf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.alf = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        ak akVar;
        boolean z3;
        TextView textView2;
        textView = this.alf.akV;
        textView.setEnabled(false);
        z = this.alf.akK;
        TiebaStatic.eventStat(this.alf.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.alf.akM = true;
        z2 = this.alf.akL;
        if (z2) {
            Drawable drawable = com.baidu.tbadk.core.util.ax.getDrawable(v.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.alf.akT;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        akVar = this.alf.alc;
        z3 = this.alf.akL;
        akVar.bb(z3);
    }
}
