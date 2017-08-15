package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.l.more_function);
        this.aCO = d.g.selector_editor_btn_more;
        this.aCd = new m(context);
        this.aCS = true;
        this.aCR = 6;
        this.aCT = new int[]{1};
    }
}
