package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.j.editor_at), 9, i);
        this.cjk = d.f.btn_pb_add_add;
        this.cjl = false;
        this.cjp = new int[]{16};
    }
}
