package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.view.BdExpandListView;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements TbImageView.a {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.p pVar;
        FrsActivity frsActivity;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.p pVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bkx.bjX;
            if (bannerView != null) {
                bannerView2 = this.bkx.bjX;
                if (bannerView2.zi()) {
                    z2 = this.bkx.bka;
                    if (!z2) {
                        bdExpandListView = this.bkx.bjM;
                        if (bdExpandListView != null) {
                            this.bkx.bka = true;
                            pVar = this.bkx.bjZ;
                            if (pVar != null) {
                                pVar2 = this.bkx.bjZ;
                                String oT = pVar2.oT();
                                if (!StringUtils.isNULL(oT)) {
                                    hashSet = this.bkx.bkl;
                                    if (hashSet.add(oT)) {
                                        this.bkx.hM(oT);
                                    }
                                }
                            }
                            frsActivity = this.bkx.bjB;
                            b Qm = frsActivity.Qm();
                            if (Qm != null) {
                                bdExpandListView2 = this.bkx.bjM;
                                bannerView3 = this.bkx.bjX;
                                Qm.a(bdExpandListView2, bannerView3);
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
