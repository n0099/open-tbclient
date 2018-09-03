package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(f.j.editor_express), 5, i);
        this.aMP = f.C0146f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aMc = emotionTabHost;
        this.aMT = true;
        this.aMS = 6;
        this.aMU = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(f.j.editor_express), 5, i);
        this.aMP = f.C0146f.pbeditor_face_button;
        this.aMc = new EmotionTabHost(context);
        this.aMT = true;
        this.aMS = 6;
        this.aMU = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void bG(boolean z) {
        ((EmotionTabHost) this.aMc).setShowUserCollect(z);
    }
}
