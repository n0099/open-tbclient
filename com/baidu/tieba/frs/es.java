package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import tbclient.VideoInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class es implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bgh;
    final /* synthetic */ ep biW;
    private final /* synthetic */ VideoInfo biX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(ep epVar, com.baidu.tbadk.core.data.z zVar, VideoInfo videoInfo) {
        this.biW = epVar;
        this.bgh = zVar;
        this.biX = videoInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10644");
        avVar.aa("tid", this.bgh.getTid());
        avVar.aa(ImageViewerConfig.FORUM_ID, this.bgh.getId());
        TiebaStatic.log(avVar);
        context = this.biW.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.biX.video_url, this.biX.video_width.intValue(), this.biX.video_height.intValue(), this.biX.thumbnail_url);
    }
}
