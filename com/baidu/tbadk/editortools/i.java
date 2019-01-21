package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aZJ = e.f.selector_more_tool_btn;
        this.aYW = new MoreDeskView(context);
        this.aZN = true;
        this.aZM = 6;
        this.aZO = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aZJ = e.f.new_pbeditor_more_button;
        this.aYW = new MoreDeskView(context, !z);
        this.aZN = true;
        this.aZM = 6;
        this.aZO = new int[]{1};
    }
}
