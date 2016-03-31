package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m411getInst().getString(t.j.more_function);
        this.launcherIcon = t.f.selector_editor_btn_more;
        this.toolView = new t(context);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolLaunchAction = new int[]{1};
    }
}
