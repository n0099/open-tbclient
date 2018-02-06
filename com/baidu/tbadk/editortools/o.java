package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.btj = d.f.selector_more_tool_btn;
        this.bsw = new m(context);
        this.bto = true;
        this.btm = 6;
        this.btp = new int[]{1};
    }

    public o(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.btj = d.f.new_pbeditor_more_button;
        this.bsw = new m(context, !z);
        this.bto = true;
        this.btm = 6;
        this.btp = new int[]{1};
    }
}
