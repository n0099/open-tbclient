package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class fe implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bjQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(TabMenuPopView tabMenuPopView) {
        this.bjQ = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Gg */
    public TextView hc() {
        Context context;
        Context context2;
        context = this.bjQ.mContext;
        TextView textView = new TextView(context);
        context2 = this.bjQ.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.d(context2, n.e.fontsize28));
        com.baidu.tbadk.core.util.as.i((View) textView, n.f.bg_tab_meun);
        com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bjQ);
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
            com.baidu.tbadk.core.util.as.i((View) textView, n.f.bg_tab_meun);
            com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_f, 1);
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
