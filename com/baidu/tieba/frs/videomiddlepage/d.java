package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes2.dex */
public class d {
    private h jMY;
    private com.baidu.tieba.frs.aggregation.g jMZ;
    private ValueAnimator jNa;
    private com.baidu.tieba.play.c jnF;
    private View rootView;

    public void a(h hVar) {
        this.jMY = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g cMr() {
        if (this.jMZ == null) {
            this.jMZ = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.jMZ, this.jMY.cMy());
        return this.jMZ;
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
                    bVar.jop = new g.b.a();
                    bVar.jop.name = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                    bVar.jop.auth_id = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                    bVar.jop.auth_desc = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                    bVar.jop.avatar = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                    bVar.jop.avatar_h = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                    bVar.jop.brief = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
                }
            }
            gVar.jof = bVar;
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
            gVar.jog = cVar;
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
            gVar.joc = videoSerializeVideoThreadInfo.disAgreeNum;
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            if (gVar.bpJ() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
                gVar.bpJ().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
                gVar.bpJ().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
                gVar.bpJ().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
                gVar.bpJ().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
                gVar.bpJ().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
                gVar.bpJ().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
            }
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void cFt() {
        if (this.jnF != null) {
            this.jnF.destroy();
            this.jnF = null;
        }
    }

    public void onDestroy() {
        if (this.jNa != null) {
            this.jNa.cancel();
            this.jNa = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        cFt();
    }
}
