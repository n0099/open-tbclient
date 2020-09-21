package com.baidu.tieba.frs.videomiddlepage;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes21.dex */
public class d {
    private h iDO;
    private com.baidu.tieba.frs.aggregation.g iDP;
    private ValueAnimator iDQ;
    private com.baidu.tieba.play.c ihi;
    private View rootView;

    public void a(h hVar) {
        this.iDO = hVar;
    }

    public com.baidu.tieba.frs.aggregation.g cxK() {
        if (this.iDP == null) {
            this.iDP = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.iDP, this.iDO.cxR());
        return this.iDP;
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
                    bVar.ihS = new g.b.a();
                    bVar.ihS.name = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                    bVar.ihS.auth_id = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                    bVar.ihS.auth_desc = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                    bVar.ihS.avatar = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                    bVar.ihS.avatar_h = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                    bVar.ihS.brief = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
                }
            }
            gVar.ihI = bVar;
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
            gVar.ihJ = cVar;
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
            gVar.ihF = videoSerializeVideoThreadInfo.disAgreeNum;
            gVar.agreeType = videoSerializeVideoThreadInfo.agreeType;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            if (gVar.bhp() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
                gVar.bhp().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
                gVar.bhp().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
                gVar.bhp().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
                gVar.bhp().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
                gVar.bhp().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
                gVar.bhp().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
            }
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.title = videoSerializeVideoThreadInfo.title;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.extra = videoSerializeVideoThreadInfo.extra;
            gVar.abtest_tag = videoSerializeVideoThreadInfo.ab_tag;
            gVar.weight = videoSerializeVideoThreadInfo.weight;
        }
    }

    public void crY() {
        if (this.ihi != null) {
            this.ihi.destroy();
            this.ihi = null;
        }
    }

    public void onDestroy() {
        if (this.iDQ != null) {
            this.iDQ.cancel();
            this.iDQ = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        crY();
    }
}
