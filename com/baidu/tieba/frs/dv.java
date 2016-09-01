package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class dv implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(TabMenuPopView tabMenuPopView) {
        this.bUj = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: IR */
    public TextView ez() {
        Context context;
        Context context2;
        context = this.bUj.mContext;
        TextView textView = new TextView(context);
        context2 = this.bUj.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(context2, t.e.fontsize28));
        com.baidu.tbadk.core.util.av.k(textView, t.f.bg_tab_meun);
        com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bUj);
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public void o(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public TextView p(TextView textView) {
        if (textView != null) {
            com.baidu.tbadk.core.util.av.k(textView, t.f.bg_tab_meun);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_f, 1);
        }
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: f */
    public TextView q(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
        return textView;
    }
}
