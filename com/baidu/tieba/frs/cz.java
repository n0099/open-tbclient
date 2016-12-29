package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class cz implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(TabMenuPopView tabMenuPopView) {
        this.bCC = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Ip */
    public TextView ez() {
        Context context;
        Context context2;
        context = this.bCC.mContext;
        TextView textView = new TextView(context);
        context2 = this.bCC.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(context2, r.e.fontsize28));
        com.baidu.tbadk.core.util.ar.k(textView, r.f.bg_tab_meun);
        com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bCC);
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public void o(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public TextView p(TextView textView) {
        if (textView != null) {
            com.baidu.tbadk.core.util.ar.k(textView, r.f.bg_tab_meun);
            com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_f, 1);
        }
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public TextView q(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
        return textView;
    }
}
