package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.csO = R.drawable.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.csa = emotionTabHost;
        this.csS = true;
        this.csR = 6;
        this.csT = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.csO = R.drawable.pbeditor_face_button;
        this.csa = new EmotionTabHost(context);
        this.csS = true;
        this.csR = 6;
        this.csT = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void fk(boolean z) {
        ((EmotionTabHost) this.csa).setShowUserCollect(z);
    }
}
