package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m11getInst().getString(t.j.more_function);
        this.aql = t.f.selector_editor_btn_more;
        this.aps = new t(context);
        this.aqp = true;
        this.aqo = 6;
        this.aqq = new int[]{1};
    }
}
