package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.tieba.pb.interactionpopupwindow.a<d, AlaChallengeRewardData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public a(TbPageContext tbPageContext, AlaChallengeRewardData alaChallengeRewardData) {
        super(tbPageContext, new d(tbPageContext), alaChallengeRewardData);
        if (this.bhk instanceof d) {
            ((d) this.bhk).a(this);
        }
        dr(80);
        cf(true);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ig() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ih() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }
}
