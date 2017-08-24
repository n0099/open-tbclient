package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends r {
    public o(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(d.l.more_function);
        this.aCP = d.g.selector_editor_btn_more;
        this.aCe = new m(context);
        this.aCT = true;
        this.aCS = 6;
        this.aCU = new int[]{1};
    }
}
