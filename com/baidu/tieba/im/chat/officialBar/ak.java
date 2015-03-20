package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class ak implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(OfficialBarTipActivity officialBarTipActivity) {
        this.aZE = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        ap apVar;
        ap apVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        ap apVar3;
        OfficialBarTipModel officialBarTipModel3;
        apVar = this.aZE.aZB;
        if (apVar != null) {
            apVar2 = this.aZE.aZB;
            if (apVar2.Of() != null) {
                officialBarTipModel = this.aZE.aZA;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aZE.aZA;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aZE.finish();
                    }
                    apVar3 = this.aZE.aZB;
                    OfficialBarTipListAdapter Of = apVar3.Of();
                    officialBarTipModel3 = this.aZE.aZA;
                    Of.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
