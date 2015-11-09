package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class em implements com.baidu.adp.lib.e.c<TextView> {
    final /* synthetic */ TabMenuPopView aZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(TabMenuPopView tabMenuPopView) {
        this.aZV = tabMenuPopView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Fm */
    public TextView ha() {
        Context context;
        Context context2;
        context = this.aZV.mContext;
        TextView textView = new TextView(context);
        context2 = this.aZV.mContext;
        textView.setTextSize(0, com.baidu.adp.lib.util.k.d(context2, i.d.fontsize28));
        com.baidu.tbadk.core.util.an.i((View) textView, i.e.bg_tab_meun);
        com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_f, 1);
        textView.setGravity(17);
        textView.setOnClickListener(this.aZV);
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public void l(TextView textView) {
        if (textView != null) {
            textView.setText("");
            textView.setTag(null);
            textView.setSelected(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public TextView m(TextView textView) {
        if (textView != null) {
            com.baidu.tbadk.core.util.an.i((View) textView, i.e.bg_tab_meun);
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_f, 1);
        }
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
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
