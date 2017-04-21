package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends x {
    public u(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(w.l.more_function);
        this.azJ = w.g.selector_editor_btn_more;
        this.ayZ = new q(context);
        this.azN = true;
        this.azM = 6;
        this.azO = new int[]{1};
    }
}
