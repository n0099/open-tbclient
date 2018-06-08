package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aLW = d.f.selector_more_tool_btn;
        this.aLj = new MoreDeskView(context);
        this.aMa = true;
        this.aLZ = 6;
        this.aMb = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.k.more_function);
        this.aLW = d.f.new_pbeditor_more_button;
        this.aLj = new MoreDeskView(context, !z);
        this.aMa = true;
        this.aLZ = 6;
        this.aMb = new int[]{1};
    }
}
