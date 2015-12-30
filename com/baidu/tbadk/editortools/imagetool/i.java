package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends y {
    public i(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(n.j.editor_image), 10, i);
        this.launcherIcon = n.f.btn_pb_add_pic;
        this.isLauncherCanSelect = false;
        this.toolLaunchAction = new int[]{14};
    }
}
