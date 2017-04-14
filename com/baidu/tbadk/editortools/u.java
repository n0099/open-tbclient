package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends x {
    public u(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(w.l.more_function);
        this.azH = w.g.selector_editor_btn_more;
        this.ayX = new q(context);
        this.azL = true;
        this.azK = 6;
        this.azM = new int[]{1};
    }
}
