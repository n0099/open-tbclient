package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCG = d.f.selector_more_tool_btn;
        this.aBT = new m(context);
        this.aCK = true;
        this.aCJ = 6;
        this.aCL = new int[]{1};
    }

    public o(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aCG = d.f.new_pbeditor_more_button;
        this.aBT = new m(context, !z);
        this.aCK = true;
        this.aCJ = 6;
        this.aCL = new int[]{1};
    }
}
