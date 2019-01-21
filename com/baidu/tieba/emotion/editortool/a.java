package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_express), 5, i);
        this.aZJ = e.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aYW = emotionTabHost;
        this.aZN = true;
        this.aZM = 6;
        this.aZO = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_express), 5, i);
        this.aZJ = e.f.pbeditor_face_button;
        this.aYW = new EmotionTabHost(context);
        this.aZN = true;
        this.aZM = 6;
        this.aZO = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void cw(boolean z) {
        ((EmotionTabHost) this.aYW).setShowUserCollect(z);
    }
}
