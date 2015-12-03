package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class fe implements com.baidu.adp.lib.f.c<TextView> {
    final /* synthetic */ TabMenuPopView bfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(TabMenuPopView tabMenuPopView) {
        this.bfY = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Gr */
    public TextView hc() {
        Context context;
        Context context2;
        context = this.bfY.mContext;
        TextView textView = new TextView(context);
        context2 = this.bfY.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.d(context2, n.d.fontsize28));
        com.baidu.tbadk.core.util.as.i((View) textView, n.e.bg_tab_meun);
        com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.bfY);
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
            com.baidu.tbadk.core.util.as.i((View) textView, n.e.bg_tab_meun);
            com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_f, 1);
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
