package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a ghq;

    /* loaded from: classes4.dex */
    private static class a {
        public static final e ghs = new e();
    }

    public static e bGH() {
        return a.ghs;
    }

    public void a(com.baidu.live.challenge.c cVar) {
        if (this.ghq == null || !this.ghq.isShowing()) {
            final TbPageContext tbPageContext = cVar.pageContext;
            c cVar2 = new c(tbPageContext);
            cVar2.setLoadDataCallBack(new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.liveroom.challenge.rewarddialog.e.1
                @Override // com.baidu.live.adp.base.BdLoadDataCallBack
                public void callback(Object obj) {
                    if (obj != null && (obj instanceof AlaChallengeRewardData)) {
                        AlaChallengeRewardData alaChallengeRewardData = (AlaChallengeRewardData) obj;
                        if (alaChallengeRewardData.errno == 0) {
                            if (e.this.ghq == null || !e.this.ghq.isShowing()) {
                                e.this.ghq = (com.baidu.tieba.ala.liveroom.challenge.rewarddialog.a) b.a(tbPageContext, alaChallengeRewardData);
                                if (e.this.ghq != null) {
                                    e.this.ghq.show();
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
            cVar2.d(cVar.challengeId, cVar.axs, cVar.liveId);
        }
    }
}
