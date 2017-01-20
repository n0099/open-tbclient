package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.l.editor_at), 9, i);
        this.atW = r.g.btn_pb_add_add;
        this.atX = false;
        this.aub = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(r.l.editor_at), 9, i);
        this.atW = i2;
        this.aua = z;
        this.atX = false;
        this.aub = new int[]{16};
    }
}
