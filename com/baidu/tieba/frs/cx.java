package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements com.baidu.adp.lib.f.c<cv.a> {
    final /* synthetic */ cv bdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cv cvVar) {
        this.bdx = cvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: NY */
    public cv.a hc() {
        Context context;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        context = this.bdx.mContext;
        View inflate = LayoutInflater.from(context).inflate(n.g.frs_item_livecard, (ViewGroup) null);
        cv.a aVar = new cv.a();
        aVar.aYP = (LinearLayout) inflate.findViewById(n.f.live_card_layout);
        aVar.aYQ = (LiveBroadcastCard) inflate.findViewById(n.f.item_card);
        baseActivity = this.bdx.aXA;
        baseActivity.getLayoutMode().af(this.bdx.mSkinType == 1);
        baseActivity2 = this.bdx.aXA;
        baseActivity2.getLayoutMode().k(inflate);
        aVar.afY = this.bdx.mSkinType;
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(cv.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public cv.a m(cv.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public cv.a n(cv.a aVar) {
        return aVar;
    }
}
