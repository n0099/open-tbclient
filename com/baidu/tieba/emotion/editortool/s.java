package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.editortools.y {
    public s(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(n.j.editor_express), 5, i);
        this.launcherIcon = n.f.pbeditor_face_button;
        this.toolView = new p(context);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolLaunchAction = new int[]{1, 34, 35};
    }
}
