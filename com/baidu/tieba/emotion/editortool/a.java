package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.csH = R.drawable.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.crT = emotionTabHost;
        this.csL = true;
        this.csK = 6;
        this.csM = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.csH = R.drawable.pbeditor_face_button;
        this.crT = new EmotionTabHost(context);
        this.csL = true;
        this.csK = 6;
        this.csM = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void fk(boolean z) {
        ((EmotionTabHost) this.crT).setShowUserCollect(z);
    }
}
