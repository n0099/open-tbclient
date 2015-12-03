package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends y {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(n.i.editor_at), 9, i);
        this.launcherIcon = n.e.btn_pb_add_add;
        this.isLauncherCanSelect = false;
        this.toolLaunchAction = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(n.i.editor_at), 9, i);
        this.launcherIcon = i2;
        this.toolNeedAction = z;
        this.isLauncherCanSelect = false;
        this.toolLaunchAction = new int[]{16};
    }
}
