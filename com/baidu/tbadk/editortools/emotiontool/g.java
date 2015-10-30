package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aql = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aql.getContext(), this.aql.getContext().getResources().getString(i.h.emotion_cant_show)).sW();
    }
}
