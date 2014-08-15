package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        ag agVar;
        boolean z3;
        Context context;
        Drawable drawable;
        TextView textView;
        Context context2;
        z = this.a.d;
        TiebaStatic.eventStat(this.a.getContext(), "upgrade_channel", z ? "withOtherApp" : "withoutOtherApp", 1, new Object[0]);
        this.a.f = true;
        z2 = this.a.e;
        if (z2) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                context2 = this.a.a;
                drawable = context2.getResources().getDrawable(t.btn_dailog_choose_d_1);
            } else {
                context = this.a.a;
                drawable = context.getResources().getDrawable(t.btn_dailog_choose_d);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView = this.a.m;
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        agVar = this.a.v;
        z3 = this.a.e;
        agVar.a(z3);
    }
}
