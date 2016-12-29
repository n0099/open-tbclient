package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.BdExpandListView;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements TbImageView.a {
    final /* synthetic */ ax bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.bAv = axVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.v vVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.v vVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bAv.bAb;
            if (bannerView != null) {
                bannerView2 = this.bAv.bAb;
                if (bannerView2.AA()) {
                    z2 = this.bAv.bAd;
                    if (!z2) {
                        bdExpandListView = this.bAv.bzO;
                        if (bdExpandListView != null) {
                            this.bAv.bAd = true;
                            vVar = this.bAv.anZ;
                            if (vVar != null) {
                                vVar2 = this.bAv.anZ;
                                String pA = vVar2.pA();
                                if (!StringUtils.isNULL(pA)) {
                                    hashSet = this.bAv.bAl;
                                    if (hashSet.add(pA)) {
                                        this.bAv.iB(pA);
                                    }
                                }
                            }
                            frsActivity = this.bAv.bzH;
                            com.baidu.tieba.frs.entelechy.b.b Wb = frsActivity.Wb();
                            if (Wb != null) {
                                frsActivity2 = this.bAv.bzH;
                                bdExpandListView2 = this.bAv.bzO;
                                bannerView3 = this.bAv.bAb;
                                Wb.a(frsActivity2, bdExpandListView2, bannerView3);
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
