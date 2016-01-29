package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aVd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aVd = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.aVd.getContext(), this.aVd.getContext().getResources().getString(t.j.emotion_cant_show)).us();
    }
}
