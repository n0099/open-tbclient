package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView YB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.YB = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.YB.getContext(), this.YB.getContext().getResources().getString(com.baidu.tieba.z.emotion_cant_show)).ob();
    }
}
