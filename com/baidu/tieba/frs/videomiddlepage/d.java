package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes4.dex */
public class d {
    private h fSW;
    private com.baidu.tieba.frs.aggregation.g fSX;
    private ValueAnimator fSY;
    private com.baidu.tieba.play.c fzp;
    private View rootView;

    public void a(h hVar) {
        this.fSW = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g btl() {
        if (this.fSX == null) {
            this.fSX = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.fSX, this.fSW.btr());
        return this.fSX;
    }

    private void a(com.baidu.tieba.frs.aggregation.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo != null) {
            g.b bVar = new g.b();
            if (videoSerializeVideoThreadInfo.getAuthor() != null) {
                bVar.userId = videoSerializeVideoThreadInfo.getAuthor().userId;
                bVar.userName = videoSerializeVideoThreadInfo.getAuthor().userName;
                bVar.userNickname = videoSerializeVideoThreadInfo.getAuthor().userNickname;
                bVar.isBigV = videoSerializeVideoThreadInfo.getAuthor().isBigV;
                bVar.isGod = videoSerializeVideoThreadInfo.getAuthor().isGod;
                bVar.portrait = videoSerializeVideoThreadInfo.getAuthor().portrait;
                bVar.hasFocus = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            }
            gVar.fzP = bVar;
            g.c cVar = new g.c();
            if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
                cVar.thumbnailWidth = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
                cVar.thumbnailHeight = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
                cVar.videoMd5 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
                cVar.videoUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
                cVar.videoDuration = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
                cVar.videoWidth = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
                cVar.videoHeight = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
                cVar.videoSize = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
                cVar.thumbnailUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
                cVar.originVideoUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
                gVar.playCount = videoSerializeVideoThreadInfo.playCount;
            }
            gVar.fzQ = cVar;
            gVar.forumId = videoSerializeVideoThreadInfo.forumId;
            gVar.threadId = videoSerializeVideoThreadInfo.threadId;
            gVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            gVar.createTime = videoSerializeVideoThreadInfo.createTime;
            gVar.postNum = videoSerializeVideoThreadInfo.postNum;
            gVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            gVar.fzM = videoSerializeVideoThreadInfo.disAgreeNum;
            if (gVar.agn() != null) {
                gVar.agn().threadId = videoSerializeVideoThreadInfo.threadId;
                gVar.agn().agreeType = videoSerializeVideoThreadInfo.agreeType;
                gVar.agn().hasAgree = videoSerializeVideoThreadInfo.hasAgree;
                gVar.agn().diffAgreeNum = videoSerializeVideoThreadInfo.diffAgreeNum;
            }
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void boh() {
        if (this.fzp != null) {
            this.fzp.destroy();
            this.fzp = null;
        }
    }

    public void onDestroy() {
        if (this.fSY != null) {
            this.fSY.cancel();
            this.fSY = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        boh();
    }
}
