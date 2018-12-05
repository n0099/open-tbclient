package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aYV = e.f.selector_more_tool_btn;
        this.aYi = new MoreDeskView(context);
        this.aYZ = true;
        this.aYY = 6;
        this.aZa = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(e.j.more_function);
        this.aYV = e.f.new_pbeditor_more_button;
        this.aYi = new MoreDeskView(context, !z);
        this.aYZ = true;
        this.aYY = 6;
        this.aZa = new int[]{1};
    }
}
