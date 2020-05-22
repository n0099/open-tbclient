package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a fQb;

    /* loaded from: classes3.dex */
    private static class a {
        public static final e fQd = new e();
    }

    public static e bAu() {
        return a.fQd;
    }

    public void a(com.baidu.live.challenge.c cVar) {
        if (this.fQb == null || !this.fQb.isShowing()) {
            final TbPageContext tbPageContext = cVar.pageContext;
            c cVar2 = new c(tbPageContext);
            cVar2.setLoadDataCallBack(new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.liveroom.challenge.rewarddialog.e.1
                @Override // com.baidu.live.adp.base.BdLoadDataCallBack
                public void callback(Object obj) {
                    if (obj != null && (obj instanceof AlaChallengeRewardData)) {
                        AlaChallengeRewardData alaChallengeRewardData = (AlaChallengeRewardData) obj;
                        if (alaChallengeRewardData.errno == 0) {
                            if (e.this.fQb == null || !e.this.fQb.isShowing()) {
                                e.this.fQb = (com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a) b.a(tbPageContext, alaChallengeRewardData);
                                if (e.this.fQb != null) {
                                    e.this.fQb.show();
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
            cVar2.b(cVar.challengeId, cVar.aul, cVar.liveId);
        }
    }
}
