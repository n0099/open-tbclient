package com.baidu.tieba.discover;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements n {
    final /* synthetic */ a anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.anL = aVar;
    }

    @Override // com.baidu.tieba.discover.n
    public void a(p pVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        BannerView bannerView;
        boolean z;
        long j;
        boolean q;
        boolean z2;
        BannerView bannerView2;
        BannerView bannerView3;
        bdPullRefreshScrollView = this.anL.anv;
        bdPullRefreshScrollView.ig();
        this.anL.anw = true;
        bannerView = this.anL.anm;
        bannerView.reset();
        if (pVar.aoe != null && !TextUtils.isEmpty(pVar.aoe.aod)) {
            bannerView2 = this.anL.anm;
            bannerView2.R("discover_tab_banner_click", "discover_tab_banner_close");
            bannerView3 = this.anL.anm;
            bannerView3.S(pVar.aoe.aod, pVar.aoe.abu);
        }
        this.anL.anx = pVar.anx;
        if (pVar.aof != null) {
            this.anL.anz = pVar.aof.aog;
            this.anL.any = pVar.aof.any;
            a aVar = this.anL;
            a aVar2 = this.anL;
            j = this.anL.any;
            q = aVar2.q(j);
            aVar.anA = q;
            z2 = this.anL.anA;
            if (z2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, true));
            }
        }
        this.anL.anB = pVar.anB;
        a aVar3 = this.anL;
        z = this.anL.anA;
        aVar3.bv(z);
    }

    @Override // com.baidu.tieba.discover.n
    public void b(p pVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        bdPullRefreshScrollView = this.anL.anv;
        bdPullRefreshScrollView.ig();
        this.anL.anw = false;
    }
}
