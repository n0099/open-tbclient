package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final String b;

    private w(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
        this.a = emotionTabHorizonScrollView;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, byte b) {
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
        FacePackageDetailActivity.a(this.a.getContext(), this.b, false, str);
    }
}
