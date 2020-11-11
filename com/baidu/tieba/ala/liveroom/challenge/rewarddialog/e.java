package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a hdw;

    /* loaded from: classes4.dex */
    private static class a {
        public static final e hdy = new e();
    }

    public static e caC() {
        return a.hdy;
    }

    public void a(com.baidu.live.challenge.c cVar) {
        if (this.hdw == null || !this.hdw.isShowing()) {
            final TbPageContext tbPageContext = cVar.pageContext;
            c cVar2 = new c(tbPageContext);
            cVar2.setLoadDataCallBack(new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.liveroom.challenge.rewarddialog.e.1
                @Override // com.baidu.live.adp.base.BdLoadDataCallBack
                public void callback(Object obj) {
                    if (obj != null && (obj instanceof AlaChallengeRewardData)) {
                        AlaChallengeRewardData alaChallengeRewardData = (AlaChallengeRewardData) obj;
                        if (alaChallengeRewardData.errno == 0) {
                            if (e.this.hdw == null || !e.this.hdw.isShowing()) {
                                e.this.hdw = (com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a) b.a(tbPageContext, alaChallengeRewardData);
                                if (e.this.hdw != null) {
                                    e.this.hdw.show();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        BdUtilHelper.showToast(tbPageContext.getPageActivity(), alaChallengeRewardData.errMsg);
                    }
                }
            });
            cVar2.d(cVar.challengeId, cVar.anchorId, cVar.liveId);
        }
    }
}
