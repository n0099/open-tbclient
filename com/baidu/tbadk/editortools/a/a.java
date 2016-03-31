package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(t.j.editor_at), 9, i);
        this.launcherIcon = t.f.btn_pb_add_add;
        this.isLauncherCanSelect = false;
        this.toolLaunchAction = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(t.j.editor_at), 9, i);
        this.launcherIcon = i2;
        this.toolNeedAction = z;
        this.isLauncherCanSelect = false;
        this.toolLaunchAction = new int[]{16};
    }
}
