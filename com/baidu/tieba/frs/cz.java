package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class cz implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(TabMenuPopView tabMenuPopView) {
        this.bWs = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: IU */
    public TextView ez() {
        Context context;
        Context context2;
        context = this.bWs.mContext;
        TextView textView = new TextView(context);
        context2 = this.bWs.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(context2, r.e.fontsize28));
        com.baidu.tbadk.core.util.at.k(textView, r.f.bg_tab_meun);
        com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bWs);
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
            com.baidu.tbadk.core.util.at.k(textView, r.f.bg_tab_meun);
            com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_f, 1);
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
