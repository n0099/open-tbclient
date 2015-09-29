package com.baidu.tbadk.editortools.locationtool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends v {
    public c(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_location), 7, i);
        this.apr = i.e.btn_pb_add_pin;
        this.apw = new int[]{18};
    }
}
