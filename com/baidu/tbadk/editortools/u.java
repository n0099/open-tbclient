package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends x {
    public u(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(w.l.more_function);
        this.azr = w.g.selector_editor_btn_more;
        this.ayH = new q(context);
        this.azv = true;
        this.azu = 6;
        this.azw = new int[]{1};
    }
}
