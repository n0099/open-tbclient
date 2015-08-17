package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aqa = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aqa.getContext(), this.aqa.getContext().getResources().getString(i.C0057i.emotion_cant_show)).sX();
    }
}
