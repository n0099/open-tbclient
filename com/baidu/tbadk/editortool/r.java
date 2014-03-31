package com.baidu.tbadk.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final String b;

    private r(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
        this.a = emotionTabHorizonScrollView;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, byte b) {
        this(emotionTabHorizonScrollView, str);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        String str;
        i = this.a.l;
        switch (i) {
            case 1:
                str = "faceshop_from_write_promotion";
                break;
            case 2:
                str = "faceshop_from_pchat_promotion";
                break;
            case 3:
                str = "faceshop_from_gchat_promotion";
                break;
            default:
                str = "";
                break;
        }
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(this.a.getContext(), this.b, false, str)));
    }
}
