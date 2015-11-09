package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.w {
    public r(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_express), 5, i);
        this.launcherIcon = i.e.pbeditor_face_button;
        this.toolView = new o(context);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolLaunchAction = new int[]{1, 34, 35};
    }
}
