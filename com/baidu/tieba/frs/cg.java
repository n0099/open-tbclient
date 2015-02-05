package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.adp.lib.e.c<cl> {
    final /* synthetic */ cf aGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cf cfVar) {
        this.aGq = cfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Hk */
    public cl eb() {
        Context context;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        context = this.aGq.mContext;
        View inflate = ei.inflate(context, com.baidu.tieba.x.frs_item_livecard, null);
        cl clVar = new cl(this.aGq);
        clVar.aCw = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.live_card_layout);
        clVar.aCx = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.w.item_card);
        frsActivity = this.aGq.aEa;
        frsActivity.getLayoutMode().ab(this.aGq.mSkinType == 1);
        frsActivity2 = this.aGq.aEa;
        frsActivity2.getLayoutMode().h(inflate);
        clVar.Yh = this.aGq.mSkinType;
        return clVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(cl clVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public cl l(cl clVar) {
        return clVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public cl m(cl clVar) {
        return clVar;
    }
}
