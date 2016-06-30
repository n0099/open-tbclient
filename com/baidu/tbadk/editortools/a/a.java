package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(u.j.editor_at), 9, i);
        this.arb = u.f.btn_pb_add_add;
        this.arc = false;
        this.arg = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(u.j.editor_at), 9, i);
        this.arb = i2;
        this.arf = z;
        this.arc = false;
        this.arg = new int[]{16};
    }
}
