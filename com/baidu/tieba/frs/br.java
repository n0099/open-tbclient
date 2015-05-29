package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.adp.lib.e.c<bu> {
    final /* synthetic */ bq aOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.aOw = bqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: LH */
    public bu hk() {
        Context context;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        context = this.aOw.mContext;
        View inflate = hr.inflate(context, com.baidu.tieba.r.frs_item_livecard, null);
        bu buVar = new bu(this.aOw);
        buVar.aKI = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.live_card_layout);
        buVar.aKJ = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.q.item_card);
        frsActivity = this.aOw.aMk;
        frsActivity.getLayoutMode().ab(this.aOw.mSkinType == 1);
        frsActivity2 = this.aOw.aMk;
        frsActivity2.getLayoutMode().j(inflate);
        buVar.ajy = this.aOw.mSkinType;
        return buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(bu buVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bu l(bu buVar) {
        return buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bu m(bu buVar) {
        return buVar;
    }
}
