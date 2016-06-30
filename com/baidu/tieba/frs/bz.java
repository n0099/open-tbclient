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
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.r rVar;
        FrsActivity frsActivity;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.r rVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bFI.bFk;
            if (bannerView != null) {
                bannerView2 = this.bFI.bFk;
                if (bannerView2.zo()) {
                    z2 = this.bFI.bFn;
                    if (!z2) {
                        bdExpandListView = this.bFI.bFa;
                        if (bdExpandListView != null) {
                            this.bFI.bFn = true;
                            rVar = this.bFI.bFm;
                            if (rVar != null) {
                                rVar2 = this.bFI.bFm;
                                String oL = rVar2.oL();
                                if (!StringUtils.isNULL(oL)) {
                                    hashSet = this.bFI.bFv;
                                    if (hashSet.add(oL)) {
                                        this.bFI.iX(oL);
                                    }
                                }
                            }
                            frsActivity = this.bFI.bET;
                            b VP = frsActivity.VP();
                            if (VP != null) {
                                bdExpandListView2 = this.bFI.bFa;
                                bannerView3 = this.bFI.bFk;
                                VP.a(bdExpandListView2, bannerView3);
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
