package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes16.dex */
public class d {
    private com.baidu.tieba.play.c hLQ;
    private h iif;
    private com.baidu.tieba.frs.aggregation.g iig;
    private ValueAnimator iih;
    private View rootView;

    public void a(h hVar) {
        this.iif = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g cjM() {
        if (this.iig == null) {
            this.iig = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.iig, this.iif.cjT());
        return this.iig;
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
                if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                    bVar.hMA = new g.b.a();
                    bVar.hMA.name = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                    bVar.hMA.auth_id = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                    bVar.hMA.auth_desc = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                    bVar.hMA.avatar = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                    bVar.hMA.avatar_h = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                    bVar.hMA.brief = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
                }
            }
            gVar.hMq = bVar;
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
            gVar.hMr = cVar;
            if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
                baijiahaoData.forwardUrl = videoSerializeVideoThreadInfo.getBaijiahaoData().forwardUrl;
                gVar.mBaijiahao = baijiahaoData;
            }
            gVar.forumId = videoSerializeVideoThreadInfo.forumId;
            gVar.threadId = videoSerializeVideoThreadInfo.threadId;
            gVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            gVar.createTime = videoSerializeVideoThreadInfo.createTime;
            gVar.postNum = videoSerializeVideoThreadInfo.postNum;
            gVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            gVar.hMn = videoSerializeVideoThreadInfo.disAgreeNum;
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            if (gVar.aYc() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
                gVar.aYc().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
                gVar.aYc().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
                gVar.aYc().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
                gVar.aYc().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
                gVar.aYc().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
                gVar.aYc().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
            }
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void ceg() {
        if (this.hLQ != null) {
            this.hLQ.destroy();
            this.hLQ = null;
        }
    }

    public void onDestroy() {
        if (this.iih != null) {
            this.iih.cancel();
            this.iih = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        ceg();
    }
}
