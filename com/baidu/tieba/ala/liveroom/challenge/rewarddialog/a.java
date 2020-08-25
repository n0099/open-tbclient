package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class a extends com.baidu.live.tieba.pb.interactionpopupwindow.a<d, AlaChallengeRewardData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public a(TbPageContext tbPageContext, AlaChallengeRewardData alaChallengeRewardData) {
        super(tbPageContext, new d(tbPageContext), alaChallengeRewardData);
        if (this.bnl instanceof d) {
            ((d) this.bnl).a(this);
        }
        fk(80);
        cq(true);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Of() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Og() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }
}
