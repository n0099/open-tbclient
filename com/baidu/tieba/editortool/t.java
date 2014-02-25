package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.a = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdUtilHelper.a(this.a.getContext(), (int) R.string.emotion_cant_show);
    }
}
