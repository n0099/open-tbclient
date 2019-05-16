package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.crt = R.drawable.selector_more_tool_btn;
        this.cqE = new MoreDeskView(context);
        this.crx = true;
        this.crw = 6;
        this.cry = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.crt = R.drawable.new_pbeditor_more_button;
        this.cqE = new MoreDeskView(context, !z);
        this.crx = true;
        this.crw = 6;
        this.cry = new int[]{1};
    }
}
