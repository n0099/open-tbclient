package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.cjl = d.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.cix = emotionTabHost;
        this.cjp = true;
        this.cjo = 6;
        this.cjq = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_express), 5, i);
        this.cjl = d.f.pbeditor_face_button;
        this.cix = new EmotionTabHost(context);
        this.cjp = true;
        this.cjo = 6;
        this.cjq = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void eK(boolean z) {
        ((EmotionTabHost) this.cix).setShowUserCollect(z);
    }
}
