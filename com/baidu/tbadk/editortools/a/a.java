package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_at), 9, i);
        this.aCc = d.g.btn_pb_add_add;
        this.aCd = false;
        this.aCh = new int[]{16};
    }

    public a(Context context, int i, int i2, boolean z) {
        super(context, context.getString(d.l.editor_at), 9, i);
        this.aCc = i2;
        this.aCg = z;
        this.aCd = false;
        this.aCh = new int[]{16};
    }
}
