package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class ak implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(OfficialBarTipActivity officialBarTipActivity) {
        this.aZU = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        ap apVar;
        ap apVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        ap apVar3;
        OfficialBarTipModel officialBarTipModel3;
        apVar = this.aZU.aZR;
        if (apVar != null) {
            apVar2 = this.aZU.aZR;
            if (apVar2.Os() != null) {
                officialBarTipModel = this.aZU.aZQ;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aZU.aZQ;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aZU.finish();
                    }
                    apVar3 = this.aZU.aZR;
                    OfficialBarTipListAdapter Os = apVar3.Os();
                    officialBarTipModel3 = this.aZU.aZQ;
                    Os.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
