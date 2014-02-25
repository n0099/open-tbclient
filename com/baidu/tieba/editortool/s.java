package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.faceshop.FaceShopActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.a = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        int i;
        String str;
        TextView textView2;
        textView = this.a.j;
        if (textView != null) {
            textView2 = this.a.j;
            textView2.setVisibility(8);
        }
        TiebaApplication.g().q(TiebaApplication.g().bi());
        TiebaApplication.g().A(false);
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
        FaceShopActivity.a(this.a.getContext(), str);
    }
}
