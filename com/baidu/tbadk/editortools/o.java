package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.bsZ = d.f.selector_more_tool_btn;
        this.bsm = new m(context);
        this.btd = true;
        this.btc = 6;
        this.bte = new int[]{1};
    }

    public o(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.j.more_function);
        this.bsZ = d.f.new_pbeditor_more_button;
        this.bsm = new m(context, !z);
        this.btd = true;
        this.btc = 6;
        this.bte = new int[]{1};
    }
}
