package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.cji = d.f.selector_more_tool_btn;
        this.ciu = new MoreDeskView(context);
        this.cjm = true;
        this.cjl = 6;
        this.cjn = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.cji = d.f.new_pbeditor_more_button;
        this.ciu = new MoreDeskView(context, !z);
        this.cjm = true;
        this.cjl = 6;
        this.cjn = new int[]{1};
    }
}
