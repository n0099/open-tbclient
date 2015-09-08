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
        this.aqU = true;
        this.aqT = 6;
        MultiImgToolView multiImgToolView = (MultiImgToolView) c.h(context, 1);
        multiImgToolView.setDefaultTip(context.getString(i.h.baobao_remind));
        multiImgToolView.setDeleteAction(23);
        multiImgToolView.setTargetToolId(13);
        this.aqi = multiImgToolView;
        this.aqV = new int[]{12, 13, 9};
    }
}
