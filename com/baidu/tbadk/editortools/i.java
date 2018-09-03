package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(f.j.more_function);
        this.aMP = f.C0146f.selector_more_tool_btn;
        this.aMc = new MoreDeskView(context);
        this.aMT = true;
        this.aMS = 6;
        this.aMU = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(f.j.more_function);
        this.aMP = f.C0146f.new_pbeditor_more_button;
        this.aMc = new MoreDeskView(context, !z);
        this.aMT = true;
        this.aMS = 6;
        this.aMU = new int[]{1};
    }
}
