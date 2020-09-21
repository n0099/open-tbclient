package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.tieba.pb.interactionpopupwindow.a<d, AlaChallengeRewardData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public a(TbPageContext tbPageContext, AlaChallengeRewardData alaChallengeRewardData) {
        super(tbPageContext, new d(tbPageContext), alaChallengeRewardData);
        if (this.bqj instanceof d) {
            ((d) this.bqj).a(this);
        }
        fv(80);
        cs(true);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean OI() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean OJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }
}
