package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.adp.lib.e.c<cl> {
    final /* synthetic */ cf aGt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cf cfVar) {
        this.aGt = cfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Hq */
    public cl eb() {
        Context context;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        context = this.aGt.mContext;
        View inflate = ei.inflate(context, com.baidu.tieba.x.frs_item_livecard, null);
        cl clVar = new cl(this.aGt);
        clVar.aCz = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.live_card_layout);
        clVar.aCA = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.w.item_card);
        frsActivity = this.aGt.aEd;
        frsActivity.getLayoutMode().ab(this.aGt.mSkinType == 1);
        frsActivity2 = this.aGt.aEd;
        frsActivity2.getLayoutMode().h(inflate);
        clVar.Yk = this.aGt.mSkinType;
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
