package com.baidu.tieba.frs;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class cq implements com.baidu.adp.lib.e.c<TextView> {
    final /* synthetic */ TabMenuPopView cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(TabMenuPopView tabMenuPopView) {
        this.cfw = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: IM */
    public TextView fK() {
        Context context;
        Context context2;
        context = this.cfw.mContext;
        TextView textView = new TextView(context);
        context2 = this.cfw.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.g(context2, w.f.fontsize28));
        com.baidu.tbadk.core.util.as.j(textView, w.g.bg_tab_meun);
        com.baidu.tbadk.core.util.as.c(textView, w.e.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.cfw);
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public void o(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public TextView p(TextView textView) {
        if (textView != null) {
            com.baidu.tbadk.core.util.as.j(textView, w.g.bg_tab_meun);
            com.baidu.tbadk.core.util.as.c(textView, w.e.cp_cont_f, 1);
        }
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
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
