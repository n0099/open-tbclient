package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        Context context;
        Drawable drawable;
        TextView textView;
        Context context2;
        Context context3;
        Drawable drawable2;
        TextView textView2;
        Context context4;
        z = this.a.f;
        if (!z) {
            z2 = this.a.e;
            if (z2) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    context4 = this.a.a;
                    drawable2 = context4.getResources().getDrawable(u.btn_dailog_choose_n_1);
                } else {
                    context3 = this.a.a;
                    drawable2 = context3.getResources().getDrawable(u.btn_dailog_choose_n);
                }
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                textView2 = this.a.m;
                textView2.setCompoundDrawables(drawable2, null, null, null);
                this.a.d = false;
                this.a.e = false;
                return;
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                context2 = this.a.a;
                drawable = context2.getResources().getDrawable(u.btn_dailog_choose_s_1);
            } else {
                context = this.a.a;
                drawable = context.getResources().getDrawable(u.btn_dailog_choose_s);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView = this.a.m;
            textView.setCompoundDrawables(drawable, null, null, null);
            this.a.d = true;
            this.a.e = true;
        }
    }
}
