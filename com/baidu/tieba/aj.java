package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ ai alZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.alZ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        an anVar;
        boolean z3;
        TextView textView2;
        textView = this.alZ.alP;
        textView.setEnabled(false);
        z = this.alZ.alE;
        TiebaStatic.eventStat(this.alZ.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.alZ.alG = true;
        z2 = this.alZ.alF;
        if (z2) {
            Drawable drawable = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.alZ.alN;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        anVar = this.alZ.alW;
        z3 = this.alZ.alF;
        anVar.bd(z3);
    }
}
