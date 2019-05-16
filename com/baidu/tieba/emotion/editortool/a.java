package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.crt = R.drawable.pbeditor_face_button;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.cqE = emotionTabHost;
        this.crx = true;
        this.crw = 6;
        this.cry = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.crt = R.drawable.pbeditor_face_button;
        this.cqE = new EmotionTabHost(context);
        this.crx = true;
        this.crw = 6;
        this.cry = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void fg(boolean z) {
        ((EmotionTabHost) this.cqE).setShowUserCollect(z);
    }
}
