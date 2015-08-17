package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements View.OnClickListener {
    final /* synthetic */ cx aYy;
    private final /* synthetic */ MediaData aYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar, MediaData mediaData) {
        this.aYy = cxVar;
        this.aYz = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        TiebaStatic.log("c10067");
        context = this.aYy.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.aYz.getVideoUrl());
    }
}
