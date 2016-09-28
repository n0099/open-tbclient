package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.m9getInst().getString(r.j.editor_hot_tipc), 26, i);
        this.auA = r.f.btn_pb_add_topic_n;
        this.auB = false;
        this.auF = new int[]{43};
    }
}
