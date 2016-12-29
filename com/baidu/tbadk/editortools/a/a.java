package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_at), 9, i);
        this.auR = r.f.btn_pb_add_add;
        this.auS = false;
        this.auW = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(r.j.editor_at), 9, i);
        this.auR = i2;
        this.auV = z;
        this.auS = false;
        this.auW = new int[]{16};
    }
}
