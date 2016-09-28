package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_at), 9, i);
        this.auA = r.f.btn_pb_add_add;
        this.auB = false;
        this.auF = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(r.j.editor_at), 9, i);
        this.auA = i2;
        this.auE = z;
        this.auB = false;
        this.auF = new int[]{16};
    }
}
