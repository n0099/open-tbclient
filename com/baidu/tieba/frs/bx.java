package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements com.baidu.adp.lib.e.c<bv.a> {
    final /* synthetic */ bv aXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bv bvVar) {
        this.aXL = bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Ml */
    public bv.a gY() {
        Context context;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        context = this.aXL.mContext;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_item_livecard, (ViewGroup) null);
        bv.a aVar = new bv.a();
        aVar.aUm = (LinearLayout) inflate.findViewById(i.f.live_card_layout);
        aVar.aUn = (LiveBroadcastCard) inflate.findViewById(i.f.item_card);
        baseActivity = this.aXL.aSX;
        baseActivity.getLayoutMode().ad(this.aXL.mSkinType == 1);
        baseActivity2 = this.aXL.aSX;
        baseActivity2.getLayoutMode().k(inflate);
        aVar.arr = this.aXL.mSkinType;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void l(bv.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bv.a m(bv.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bv.a n(bv.a aVar) {
        return aVar;
    }
}
