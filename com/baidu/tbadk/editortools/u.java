package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class u extends x {
    public u(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(r.j.more_function);
        this.auR = r.f.selector_editor_btn_more;
        this.auh = new q(context);
        this.auV = true;
        this.auU = 6;
        this.auW = new int[]{1};
    }
}
