package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements View.OnClickListener {
    final /* synthetic */ dw aYP;
    private final /* synthetic */ MediaData aYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dw dwVar, MediaData mediaData) {
        this.aYP = dwVar;
        this.aYQ = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        TiebaStatic.log("c10067");
        context = this.aYP.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.aYQ.getVideoUrl());
    }
}
