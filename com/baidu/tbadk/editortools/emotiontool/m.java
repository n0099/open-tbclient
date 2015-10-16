package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends v {
    public m(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_express), 5, i);
        this.aps = i.e.pbeditor_face_button;
        j jVar = new j(context);
        jVar.setShowBigEmotion(z);
        this.aoJ = jVar;
        this.apw = true;
        this.apv = 6;
        this.apx = new int[]{1};
    }

    public m(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_express), 5, i);
        this.aps = i.e.pbeditor_face_button;
        this.aoJ = new j(context);
        this.apw = true;
        this.apv = 6;
        this.apx = new int[]{1};
    }
}
