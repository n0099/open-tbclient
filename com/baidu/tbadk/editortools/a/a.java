package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m11getInst().getString(t.j.editor_at), 9, i);
        this.aql = t.f.btn_pb_add_add;
        this.aqm = false;
        this.aqq = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(t.j.editor_at), 9, i);
        this.aql = i2;
        this.aqp = z;
        this.aqm = false;
        this.aqq = new int[]{16};
    }
}
