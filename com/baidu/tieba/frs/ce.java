package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements BannerView.a {
    final /* synthetic */ cd bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.bdg = cdVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zI() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.bdg.bcV;
        if (jVar != null) {
            jVar2 = this.bdg.bcV;
            if (jVar2.getType() == 2) {
                this.bdg.Nt();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zJ() {
        this.bdg.NH();
    }
}
