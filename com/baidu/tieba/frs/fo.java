package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class fo implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(TabMenuPopView tabMenuPopView) {
        this.bmM = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: HF */
    public TextView hk() {
        Context context;
        Context context2;
        context = this.bmM.mContext;
        TextView textView = new TextView(context);
        context2 = this.bmM.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.c(context2, t.e.fontsize28));
        com.baidu.tbadk.core.util.ar.k(textView, t.f.bg_tab_meun);
        com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bmM);
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
            com.baidu.tbadk.core.util.ar.k(textView, t.f.bg_tab_meun);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_f, 1);
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
