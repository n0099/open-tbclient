package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements com.baidu.adp.lib.f.c<cy.a> {
    final /* synthetic */ cy bhx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cy cyVar) {
        this.bhx = cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Or */
    public cy.a hc() {
        Context context;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        context = this.bhx.mContext;
        View inflate = LayoutInflater.from(context).inflate(n.h.frs_item_livecard, (ViewGroup) null);
        cy.a aVar = new cy.a();
        aVar.bcL = (LinearLayout) inflate.findViewById(n.g.live_card_layout);
        aVar.bcM = (LiveBroadcastCard) inflate.findViewById(n.g.item_card);
        baseActivity = this.bhx.bbA;
        baseActivity.getLayoutMode().ac(this.bhx.mSkinType == 1);
        baseActivity2 = this.bhx.bbA;
        baseActivity2.getLayoutMode().k(inflate);
        aVar.ahf = this.bhx.mSkinType;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(cy.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public cy.a m(cy.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public cy.a n(cy.a aVar) {
        return aVar;
    }
}
