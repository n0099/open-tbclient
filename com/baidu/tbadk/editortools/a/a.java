package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(w.l.editor_at), 9, i);
        this.azt = w.g.btn_pb_add_add;
        this.azu = false;
        this.azy = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(w.l.editor_at), 9, i);
        this.azt = i2;
        this.azx = z;
        this.azu = false;
        this.azy = new int[]{16};
    }
}
