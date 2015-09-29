package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aqk = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aqk.getContext(), this.aqk.getContext().getResources().getString(i.h.emotion_cant_show)).sZ();
    }
}
