package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements com.baidu.adp.lib.e.c<bz.a> {
    final /* synthetic */ bz aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bz bzVar) {
        this.aXQ = bzVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Mu */
    public bz.a hb() {
        Context context;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        context = this.aXQ.mContext;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_item_livecard, (ViewGroup) null);
        bz.a aVar = new bz.a();
        aVar.aTY = (LinearLayout) inflate.findViewById(i.f.live_card_layout);
        aVar.aTZ = (LiveBroadcastCard) inflate.findViewById(i.f.item_card);
        baseActivity = this.aXQ.aSJ;
        baseActivity.getLayoutMode().ad(this.aXQ.mSkinType == 1);
        baseActivity2 = this.aXQ.aSJ;
        baseActivity2.getLayoutMode().k(inflate);
        aVar.apH = this.aXQ.mSkinType;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void l(bz.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bz.a m(bz.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bz.a n(bz.a aVar) {
        return aVar;
    }
}
