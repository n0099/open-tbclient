package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.live.tieba.pb.interactionpopupwindow.a<d, AlaChallengeRewardData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public a(TbPageContext tbPageContext, AlaChallengeRewardData alaChallengeRewardData) {
        super(tbPageContext, new d(tbPageContext), alaChallengeRewardData);
        if (this.bFO instanceof d) {
            ((d) this.bFO).a(this);
        }
        eI(80);
        cW(true);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QI() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }
}
