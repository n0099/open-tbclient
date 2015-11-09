package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements View.OnClickListener {
    final /* synthetic */ dy aZb;
    private final /* synthetic */ MediaData aZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dy dyVar, MediaData mediaData) {
        this.aZb = dyVar;
        this.aZc = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        TiebaStatic.log("c10067");
        context = this.aZb.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.aZc.getVideoUrl());
    }
}
