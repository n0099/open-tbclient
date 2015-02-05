package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ ai alW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.alW = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        boolean z;
        boolean z2;
        an anVar;
        boolean z3;
        TextView textView2;
        textView = this.alW.alM;
        textView.setEnabled(false);
        z = this.alW.alB;
        TiebaStatic.eventStat(this.alW.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.alW.alD = true;
        z2 = this.alW.alC;
        if (z2) {
            Drawable drawable = com.baidu.tbadk.core.util.bc.getDrawable(v.btn_dailog_choose_d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.alW.alK;
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        anVar = this.alW.alT;
        z3 = this.alW.alC;
        anVar.bd(z3);
    }
}
