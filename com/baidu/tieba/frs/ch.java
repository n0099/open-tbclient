package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements com.baidu.adp.lib.e.c<cf.a> {
    final /* synthetic */ cf aXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cf cfVar) {
        this.aXf = cfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Mk */
    public cf.a gZ() {
        Context context;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        context = this.aXf.mContext;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_item_livecard, (ViewGroup) null);
        cf.a aVar = new cf.a();
        aVar.aTi = (LinearLayout) inflate.findViewById(i.f.live_card_layout);
        aVar.aTj = (LiveBroadcastCard) inflate.findViewById(i.f.item_card);
        baseActivity = this.aXf.aRT;
        baseActivity.getLayoutMode().ad(this.aXf.mSkinType == 1);
        baseActivity2 = this.aXf.aRT;
        baseActivity2.getLayoutMode().k(inflate);
        aVar.apR = this.aXf.mSkinType;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void l(cf.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public cf.a m(cf.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public cf.a n(cf.a aVar) {
        return aVar;
    }
}
