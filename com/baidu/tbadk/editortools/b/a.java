package com.baidu.tbadk.editortools.b;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends y {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(n.i.editor_gift_tab), 22, i);
        this.launcherIcon = n.e.btn_pb_add_gift;
        this.toolLaunchAction = new int[]{36};
    }
}
