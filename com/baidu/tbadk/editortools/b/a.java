package com.baidu.tbadk.editortools.b;

import android.content.Context;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.editortools.imagetool.c;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends v {
    public a(Context context) {
        super(context, (String) null, 14);
        this.apj = true;
        this.api = 6;
        MultiImgToolView multiImgToolView = (MultiImgToolView) c.h(context, 1);
        multiImgToolView.setDefaultTip(context.getString(i.C0057i.baobao_remind));
        multiImgToolView.setDeleteAction(23);
        multiImgToolView.setTargetToolId(13);
        this.aox = multiImgToolView;
        this.apk = new int[]{12, 13, 9};
    }
}
