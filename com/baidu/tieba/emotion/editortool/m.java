package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView brx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.brx = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.brx.getContext(), this.brx.getContext().getResources().getString(u.j.emotion_cant_show)).sb();
    }
}
