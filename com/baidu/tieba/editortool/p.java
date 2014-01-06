package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, l lVar) {
        this(emotionTabHorizonScrollView, str);
    }

    private p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
        this.a = emotionTabHorizonScrollView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
