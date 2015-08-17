package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.editortools.v {
    public m(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.C0057i.editor_express), 5, i);
        this.apf = i.e.pbeditor_face_button;
        j jVar = new j(context);
        jVar.setShowBigEmotion(z);
        this.aox = jVar;
        this.apj = true;
        this.api = 6;
        this.apk = new int[]{1};
    }

    public m(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.C0057i.editor_express), 5, i);
        this.apf = i.e.pbeditor_face_button;
        this.aox = new j(context);
        this.apj = true;
        this.api = 6;
        this.apk = new int[]{1};
    }
}
