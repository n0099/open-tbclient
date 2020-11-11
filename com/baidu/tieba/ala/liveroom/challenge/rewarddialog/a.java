package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.tieba.pb.interactionpopupwindow.a<d, AlaChallengeRewardData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public a(TbPageContext tbPageContext, AlaChallengeRewardData alaChallengeRewardData) {
        super(tbPageContext, new d(tbPageContext), alaChallengeRewardData);
        if (this.bCp instanceof d) {
            ((d) this.bCp).a(this);
        }
        fT(80);
        cH(true);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean RJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean RK() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }
}
