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
    final /* synthetic */ bm bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bm bmVar) {
        this.bSc = bmVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.t tVar;
        FrsActivity frsActivity;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.t tVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bSc.bRG;
            if (bannerView != null) {
                bannerView2 = this.bSc.bRG;
                if (bannerView2.AD()) {
                    z2 = this.bSc.bRI;
                    if (!z2) {
                        bdExpandListView = this.bSc.bRw;
                        if (bdExpandListView != null) {
                            this.bSc.bRI = true;
                            tVar = this.bSc.anV;
                            if (tVar != null) {
                                tVar2 = this.bSc.anV;
                                String pw = tVar2.pw();
                                if (!StringUtils.isNULL(pw)) {
                                    hashSet = this.bSc.bRQ;
                                    if (hashSet.add(pw)) {
                                        this.bSc.jM(pw);
                                    }
                                }
                            }
                            frsActivity = this.bSc.bRp;
                            b abf = frsActivity.abf();
                            if (abf != null) {
                                bdExpandListView2 = this.bSc.bRw;
                                bannerView3 = this.bSc.bRG;
                                abf.a(bdExpandListView2, bannerView3);
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
