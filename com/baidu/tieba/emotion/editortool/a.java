package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.cji = d.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.ciu = emotionTabHost;
        this.cjm = true;
        this.cjl = 6;
        this.cjn = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.cji = d.f.pbeditor_face_button;
        this.ciu = new EmotionTabHost(context);
        this.cjm = true;
        this.cjl = 6;
        this.cjn = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void eK(boolean z) {
        ((EmotionTabHost) this.ciu).setShowUserCollect(z);
    }
}
