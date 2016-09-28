package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.view.BdExpandListView;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements TbImageView.a {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.u uVar;
        FrsActivity frsActivity;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.u uVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bRV.bRz;
            if (bannerView != null) {
                bannerView2 = this.bRV.bRz;
                if (bannerView2.AG()) {
                    z2 = this.bRV.bRB;
                    if (!z2) {
                        bdExpandListView = this.bRV.bRp;
                        if (bdExpandListView != null) {
                            this.bRV.bRB = true;
                            uVar = this.bRV.anD;
                            if (uVar != null) {
                                uVar2 = this.bRV.anD;
                                String px = uVar2.px();
                                if (!StringUtils.isNULL(px)) {
                                    hashSet = this.bRV.bRJ;
                                    if (hashSet.add(px)) {
                                        this.bRV.jT(px);
                                    }
                                }
                            }
                            frsActivity = this.bRV.bRi;
                            b abr = frsActivity.abr();
                            if (abr != null) {
                                bdExpandListView2 = this.bRV.bRp;
                                bannerView3 = this.bRV.bRz;
                                abr.a(bdExpandListView2, bannerView3);
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
