package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_express), 5, i);
        this.aLW = d.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aLj = emotionTabHost;
        this.aMa = true;
        this.aLZ = 6;
        this.aMb = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_express), 5, i);
        this.aLW = d.f.pbeditor_face_button;
        this.aLj = new EmotionTabHost(context);
        this.aMa = true;
        this.aLZ = 6;
        this.aMb = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void bE(boolean z) {
        ((EmotionTabHost) this.aLj).setShowUserCollect(z);
    }
}
