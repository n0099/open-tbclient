package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(d.k.editor_hot_tipc), 26, i);
        this.aDA = d.f.btn_pb_add_topic_n;
        this.aDB = false;
        this.aDF = new int[]{43};
    }
}
