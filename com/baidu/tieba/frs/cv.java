package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class cv implements com.baidu.adp.lib.e.c<TextView> {
    final /* synthetic */ TabMenuPopView bJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(TabMenuPopView tabMenuPopView) {
        this.bJS = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Ig */
    public TextView ex() {
        Context context;
        Context context2;
        context = this.bJS.mContext;
        TextView textView = new TextView(context);
        context2 = this.bJS.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.e(context2, r.f.fontsize28));
        com.baidu.tbadk.core.util.ap.j((View) textView, r.g.bg_tab_meun);
        com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bJS);
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
            com.baidu.tbadk.core.util.ap.j((View) textView, r.g.bg_tab_meun);
            com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_f, 1);
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
