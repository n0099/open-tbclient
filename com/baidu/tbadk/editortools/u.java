package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class u extends x {
    public u(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.m9getInst().getString(r.l.more_function);
        this.atW = r.g.selector_editor_btn_more;
        this.atm = new q(context);
        this.aua = true;
        this.atZ = 6;
        this.aub = new int[]{1};
    }
}
