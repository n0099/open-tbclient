package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m10getInst().getString(u.j.more_function);
        this.arQ = u.f.selector_editor_btn_more;
        this.aqX = new t(context);
        this.arU = true;
        this.arT = 6;
        this.arV = new int[]{1};
    }
}
