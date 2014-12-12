package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarTipActivity officialBarTipActivity) {
        this.aTB = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        ao aoVar;
        ao aoVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        ao aoVar3;
        OfficialBarTipModel officialBarTipModel3;
        aoVar = this.aTB.aTA;
        if (aoVar != null) {
            aoVar2 = this.aTB.aTA;
            if (aoVar2.KK() != null) {
                officialBarTipModel = this.aTB.aTz;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aTB.aTz;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aTB.finish();
                    }
                    aoVar3 = this.aTB.aTA;
                    OfficialBarTipListAdapter KK = aoVar3.KK();
                    officialBarTipModel3 = this.aTB.aTz;
                    KK.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
