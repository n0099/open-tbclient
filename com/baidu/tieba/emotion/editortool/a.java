package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_express), 5, i);
        this.aDz = d.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aCM = emotionTabHost;
        this.aDD = true;
        this.aDC = 6;
        this.aDE = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_express), 5, i);
        this.aDz = d.f.pbeditor_face_button;
        this.aCM = new EmotionTabHost(context);
        this.aDD = true;
        this.aDC = 6;
        this.aDE = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void bA(boolean z) {
        ((EmotionTabHost) this.aCM).setShowUserCollect(z);
    }
}
