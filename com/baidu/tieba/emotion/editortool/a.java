package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_express), 5, i);
        this.aQh = e.f.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.aPu = emotionTabHost;
        this.aQl = true;
        this.aQk = 6;
        this.aQm = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(e.j.editor_express), 5, i);
        this.aQh = e.f.pbeditor_face_button;
        this.aPu = new EmotionTabHost(context);
        this.aQl = true;
        this.aQk = 6;
        this.aQm = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void bS(boolean z) {
        ((EmotionTabHost) this.aPu).setShowUserCollect(z);
    }
}
