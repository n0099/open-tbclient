package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_at), 9, i);
        this.aCG = d.f.btn_pb_add_add;
        this.aCH = false;
        this.aCL = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(d.j.editor_at), 9, i);
        this.aCG = i2;
        this.aCK = z;
        this.aCH = false;
        this.aCL = new int[]{16};
    }
}
