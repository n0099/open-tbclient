package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes9.dex */
public class d {
    private com.baidu.tieba.play.c hFU;
    private h icd;
    private com.baidu.tieba.frs.aggregation.g ice;
    private ValueAnimator icf;
    private View rootView;

    public void a(h hVar) {
        this.icd = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g cgm() {
        if (this.ice == null) {
            this.ice = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.ice, this.icd.cgt());
        return this.ice;
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
                    bVar.hGF = new g.b.a();
                    bVar.hGF.name = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                    bVar.hGF.auth_id = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                    bVar.hGF.auth_desc = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                    bVar.hGF.avatar = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                    bVar.hGF.avatar_h = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                    bVar.hGF.brief = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
                }
            }
            gVar.hGu = bVar;
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
            gVar.hGv = cVar;
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
            gVar.hGr = videoSerializeVideoThreadInfo.disAgreeNum;
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            if (gVar.aUg() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
                gVar.aUg().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
                gVar.aUg().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
                gVar.aUg().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
                gVar.aUg().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
                gVar.aUg().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
                gVar.aUg().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
            }
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void caH() {
        if (this.hFU != null) {
            this.hFU.destroy();
            this.hFU = null;
        }
    }

    public void onDestroy() {
        if (this.icf != null) {
            this.icf.cancel();
            this.icf = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        caH();
    }
}
