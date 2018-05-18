package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aDA = d.f.selector_more_tool_btn;
        this.aCN = new MoreDeskView(context);
        this.aDE = true;
        this.aDD = 6;
        this.aDF = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aDA = d.f.new_pbeditor_more_button;
        this.aCN = new MoreDeskView(context, !z);
        this.aDE = true;
        this.aDD = 6;
        this.aDF = new int[]{1};
    }
}
