package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ ab auk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.auk = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        ag agVar;
        boolean z3;
        TextView textView2;
        textView = this.auk.atZ;
        textView.setEnabled(false);
        z = this.auk.atO;
        TiebaStatic.eventStat(this.auk.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.auk.atQ = true;
        z2 = this.auk.atP;
        if (z2) {
            Drawable drawable = ba.getDrawable(u.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.auk.atX;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        agVar = this.auk.auh;
        z3 = this.auk.atP;
        agVar.bi(z3);
    }
}
