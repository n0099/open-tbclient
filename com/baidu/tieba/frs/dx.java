package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements View.OnClickListener {
    final /* synthetic */ dw aYE;
    private final /* synthetic */ MediaData aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dw dwVar, MediaData mediaData) {
        this.aYE = dwVar;
        this.aYF = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        TiebaStatic.log("c10067");
        context = this.aYE.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.aYF.getVideoUrl());
    }
}
