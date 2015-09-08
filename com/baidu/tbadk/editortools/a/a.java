package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends v {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_at), 9, i);
        this.aqQ = i.e.btn_pb_add_add;
        this.aqR = false;
        this.aqV = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(i.h.editor_at), 9, i);
        this.aqQ = i2;
        this.aqU = z;
        this.aqR = false;
        this.aqV = new int[]{16};
    }
}
