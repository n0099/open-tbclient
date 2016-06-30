package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class ea implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(TabMenuPopView tabMenuPopView) {
        this.bHM = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Hu */
    public TextView dF() {
        Context context;
        Context context2;
        context = this.bHM.mContext;
        TextView textView = new TextView(context);
        context2 = this.bHM.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.c(context2, u.e.fontsize28));
        com.baidu.tbadk.core.util.av.k(textView, u.f.bg_tab_meun);
        com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bHM);
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public void l(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public TextView m(TextView textView) {
        if (textView != null) {
            com.baidu.tbadk.core.util.av.k(textView, u.f.bg_tab_meun);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_f, 1);
        }
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: f */
    public TextView n(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
        return textView;
    }
}
