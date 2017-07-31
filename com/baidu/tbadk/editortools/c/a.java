package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.l.editor_hot_tipc), 26, i);
        this.aCN = d.g.btn_pb_add_topic_n;
        this.aCO = false;
        this.aCS = new int[]{43};
    }
}
