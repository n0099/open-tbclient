package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends v {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m411getInst().getString(i.h.editor_at), 9, i);
        this.aps = i.e.btn_pb_add_add;
        this.apt = false;
        this.apx = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(i.h.editor_at), 9, i);
        this.aps = i2;
        this.apw = z;
        this.apt = false;
        this.apx = new int[]{16};
    }
}
