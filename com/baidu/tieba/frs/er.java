package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import tbclient.VideoInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class er implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bci;
    final /* synthetic */ ep bfc;
    private final /* synthetic */ VideoInfo bfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(ep epVar, com.baidu.tbadk.core.data.z zVar, VideoInfo videoInfo) {
        this.bfc = epVar;
        this.bci = zVar;
        this.bfd = videoInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10644");
        avVar.ab("tid", this.bci.getTid());
        avVar.ab(ImageViewerConfig.FORUM_ID, this.bci.getId());
        TiebaStatic.log(avVar);
        context = this.bfc.mContext;
        XiaoyingUtil.startPlayXiaoyingVideo(context, this.bfd.video_url, this.bfd.video_width.intValue(), this.bfd.video_height.intValue(), this.bfd.thumbnail_url);
    }
}
