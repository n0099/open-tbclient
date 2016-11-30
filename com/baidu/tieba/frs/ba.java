package com.baidu.tieba.frs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.view.BdExpandListView;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements TbImageView.a {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(au auVar) {
        this.bUk = auVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdExpandListView bdExpandListView;
        com.baidu.tbadk.core.data.w wVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        BdExpandListView bdExpandListView2;
        BannerView bannerView3;
        com.baidu.tbadk.core.data.w wVar2;
        HashSet hashSet;
        if (z) {
            bannerView = this.bUk.bTQ;
            if (bannerView != null) {
                bannerView2 = this.bUk.bTQ;
                if (bannerView2.AN()) {
                    z2 = this.bUk.bTS;
                    if (!z2) {
                        bdExpandListView = this.bUk.bTH;
                        if (bdExpandListView != null) {
                            this.bUk.bTS = true;
                            wVar = this.bUk.aox;
                            if (wVar != null) {
                                wVar2 = this.bUk.aox;
                                String pA = wVar2.pA();
                                if (!StringUtils.isNULL(pA)) {
                                    hashSet = this.bUk.bUa;
                                    if (hashSet.add(pA)) {
                                        this.bUk.jW(pA);
                                    }
                                }
                            }
                            frsActivity = this.bUk.bTA;
                            b abM = frsActivity.abM();
                            if (abM != null) {
                                frsActivity2 = this.bUk.bTA;
                                bdExpandListView2 = this.bUk.bTH;
                                bannerView3 = this.bUk.bTQ;
                                abM.a(frsActivity2, bdExpandListView2, bannerView3);
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
