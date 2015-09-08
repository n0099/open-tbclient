package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements View.OnClickListener {
    final /* synthetic */ dd aYP;
    private final /* synthetic */ MediaData aYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar, MediaData mediaData) {
        this.aYP = ddVar;
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
