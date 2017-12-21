package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCJ = d.f.selector_more_tool_btn;
        this.aBW = new m(context);
        this.aCN = true;
        this.aCM = 6;
        this.aCO = new int[]{1};
    }

    public o(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCJ = d.f.new_pbeditor_more_button;
        this.aBW = new m(context, !z);
        this.aCN = true;
        this.aCM = 6;
        this.aCO = new int[]{1};
    }
}
