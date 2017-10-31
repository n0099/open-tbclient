package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aBQ = d.f.selector_more_tool_btn;
        this.aBf = new m(context);
        this.aBU = true;
        this.aBT = 6;
        this.aBV = new int[]{1};
    }
}
