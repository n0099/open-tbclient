package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.play.c fer;
    private h fxq;
    private com.baidu.tieba.frs.aggregation.g fxr;
    private ValueAnimator fxs;
    private View rootView;

    public void a(h hVar) {
        this.fxq = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g bjP() {
        if (this.fxr == null) {
            this.fxr = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.fxr, this.fxq.bjV());
        return this.fxr;
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
            gVar.feR = bVar;
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
            gVar.feS = cVar;
            gVar.forumId = videoSerializeVideoThreadInfo.forumId;
            gVar.threadId = videoSerializeVideoThreadInfo.threadId;
            gVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            gVar.createTime = videoSerializeVideoThreadInfo.createTime;
            gVar.postNum = videoSerializeVideoThreadInfo.postNum;
            gVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            gVar.feO = videoSerializeVideoThreadInfo.disAgreeNum;
            if (gVar.aaH() != null) {
                gVar.aaH().threadId = videoSerializeVideoThreadInfo.threadId;
                gVar.aaH().agreeType = videoSerializeVideoThreadInfo.agreeType;
                gVar.aaH().hasAgree = videoSerializeVideoThreadInfo.hasAgree;
                gVar.aaH().diffAgreeNum = videoSerializeVideoThreadInfo.diffAgreeNum;
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

    public void beN() {
        if (this.fer != null) {
            this.fer.destroy();
            this.fer = null;
        }
    }

    public void onDestroy() {
        if (this.fxs != null) {
            this.fxs.cancel();
            this.fxs = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        beN();
    }
}
