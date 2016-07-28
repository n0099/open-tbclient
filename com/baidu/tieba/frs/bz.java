package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.view.BdExpandListView;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements TbImageView.a {
    final /* synthetic */ bq bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bq bqVar) {
        this.bGW = bqVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.s sVar;
        FrsActivity frsActivity;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.s sVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bGW.bGy;
            if (bannerView != null) {
                bannerView2 = this.bGW.bGy;
                if (bannerView2.zo()) {
                    z2 = this.bGW.bGB;
                    if (!z2) {
                        bdExpandListView = this.bGW.bGo;
                        if (bdExpandListView != null) {
                            this.bGW.bGB = true;
                            sVar = this.bGW.bGA;
                            if (sVar != null) {
                                sVar2 = this.bGW.bGA;
                                String oA = sVar2.oA();
                                if (!StringUtils.isNULL(oA)) {
                                    hashSet = this.bGW.bGJ;
                                    if (hashSet.add(oA)) {
                                        this.bGW.jd(oA);
                                    }
                                }
                            }
                            frsActivity = this.bGW.bGh;
                            b Wi = frsActivity.Wi();
                            if (Wi != null) {
                                bdExpandListView2 = this.bGW.bGo;
                                bannerView3 = this.bGW.bGy;
                                Wi.a(bdExpandListView2, bannerView3);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
