package com.baidu.tieba.discover;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements n {
    final /* synthetic */ a anC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.anC = aVar;
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
        bdPullRefreshScrollView = this.anC.anm;
        bdPullRefreshScrollView.ig();
        this.anC.ann = true;
        bannerView = this.anC.and;
        bannerView.reset();
        if (pVar.anV != null && !TextUtils.isEmpty(pVar.anV.anU)) {
            bannerView2 = this.anC.and;
            bannerView2.R("discover_tab_banner_click", "discover_tab_banner_close");
            bannerView3 = this.anC.and;
            bannerView3.S(pVar.anV.anU, pVar.anV.abo);
        }
        this.anC.ano = pVar.ano;
        if (pVar.anW != null) {
            this.anC.anq = pVar.anW.anX;
            this.anC.anp = pVar.anW.anp;
            a aVar = this.anC;
            a aVar2 = this.anC;
            j = this.anC.anp;
            q = aVar2.q(j);
            aVar.anr = q;
            z2 = this.anC.anr;
            if (z2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, true));
            }
        }
        this.anC.ans = pVar.ans;
        a aVar3 = this.anC;
        z = this.anC.anr;
        aVar3.bv(z);
    }

    @Override // com.baidu.tieba.discover.n
    public void b(p pVar) {
        BdPullRefreshScrollView bdPullRefreshScrollView;
        bdPullRefreshScrollView = this.anC.anm;
        bdPullRefreshScrollView.ig();
        this.anC.ann = false;
    }
}
