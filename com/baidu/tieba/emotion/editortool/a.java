package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aMS = d.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aMf = emotionTabHost;
        this.aMW = true;
        this.aMV = 6;
        this.aMX = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.aMS = d.f.pbeditor_face_button;
        this.aMf = new EmotionTabHost(context);
        this.aMW = true;
        this.aMV = 6;
        this.aMX = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void bF(boolean z) {
        ((EmotionTabHost) this.aMf).setShowUserCollect(z);
    }
}
