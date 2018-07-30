package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aMS = d.f.selector_more_tool_btn;
        this.aMf = new MoreDeskView(context);
        this.aMW = true;
        this.aMV = 6;
        this.aMX = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.aMS = d.f.new_pbeditor_more_button;
        this.aMf = new MoreDeskView(context, !z);
        this.aMW = true;
        this.aMV = 6;
        this.aMX = new int[]{1};
    }
}
