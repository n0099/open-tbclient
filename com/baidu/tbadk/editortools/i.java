package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aUI = e.f.selector_more_tool_btn;
        this.aTV = new MoreDeskView(context);
        this.aUM = true;
        this.aUL = 6;
        this.aUN = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aUI = e.f.new_pbeditor_more_button;
        this.aTV = new MoreDeskView(context, !z);
        this.aUM = true;
        this.aUL = 6;
        this.aUN = new int[]{1};
    }
}
