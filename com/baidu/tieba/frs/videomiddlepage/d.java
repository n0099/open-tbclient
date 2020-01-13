package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes7.dex */
public class d {
    private h gLS;
    private com.baidu.tieba.frs.aggregation.g gLT;
    private ValueAnimator gLU;
    private com.baidu.tieba.play.c grV;
    private View rootView;

    public void a(h hVar) {
        this.gLS = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g bJQ() {
        if (this.gLT == null) {
            this.gLT = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.gLT, this.gLS.bJW());
        return this.gLT;
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
                    bVar.gsG = new g.b.a();
                    bVar.gsG.name = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                    bVar.gsG.auth_id = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                    bVar.gsG.auth_desc = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                    bVar.gsG.avatar = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                    bVar.gsG.avatar_h = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                    bVar.gsG.brief = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
                }
            }
            gVar.gsv = bVar;
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
            gVar.gsw = cVar;
            if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
                baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
                baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
                baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
                gVar.mBaijiahao = baijiahaoData;
            }
            gVar.forumId = videoSerializeVideoThreadInfo.forumId;
            gVar.threadId = videoSerializeVideoThreadInfo.threadId;
            gVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            gVar.createTime = videoSerializeVideoThreadInfo.createTime;
            gVar.postNum = videoSerializeVideoThreadInfo.postNum;
            gVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            gVar.gss = videoSerializeVideoThreadInfo.disAgreeNum;
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            if (gVar.aBM() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
                gVar.aBM().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
                gVar.aBM().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
                gVar.aBM().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
                gVar.aBM().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
                gVar.aBM().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
                gVar.aBM().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
            }
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void bEH() {
        if (this.grV != null) {
            this.grV.destroy();
            this.grV = null;
        }
    }

    public void onDestroy() {
        if (this.gLU != null) {
            this.gLU.cancel();
            this.gLU = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        bEH();
    }
}
