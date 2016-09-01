package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends aa {
    public x(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(t.j.more_function);
        this.auX = t.f.selector_editor_btn_more;
        this.aue = new t(context);
        this.avb = true;
        this.ava = 6;
        this.avc = new int[]{1};
    }
}
