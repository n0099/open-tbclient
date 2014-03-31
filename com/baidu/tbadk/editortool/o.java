package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.a = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        int i;
        String str;
        g gVar;
        textView = this.a.j;
        if (textView != null) {
            gVar = this.a.a;
            gVar.setNewViewVisible(false);
        }
        TbadkApplication.j().g(TbadkApplication.j().at());
        TbadkApplication.j().f(false);
        i = this.a.l;
        switch (i) {
            case 1:
                str = "faceshop_from_write_shop";
                break;
            case 2:
                str = "faceshop_from_pchat_shop";
                break;
            case 3:
                str = "faceshop_from_gchat_shop";
                break;
            default:
                str = "";
                break;
        }
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.j(this.a.getContext(), str)));
    }
}
