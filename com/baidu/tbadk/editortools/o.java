package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.l.more_function);
        this.aBh = d.g.selector_more_tool_btn;
        this.aAv = new m(context);
        this.aBl = true;
        this.aBk = 6;
        this.aBm = new int[]{1};
    }
}
