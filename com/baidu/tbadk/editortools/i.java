package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aDz = d.f.selector_more_tool_btn;
        this.aCM = new MoreDeskView(context);
        this.aDD = true;
        this.aDC = 6;
        this.aDE = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aDz = d.f.new_pbeditor_more_button;
        this.aCM = new MoreDeskView(context, !z);
        this.aDD = true;
        this.aDC = 6;
        this.aDE = new int[]{1};
    }
}
