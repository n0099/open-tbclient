package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarTipActivity officialBarTipActivity) {
        this.aUQ = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        ao aoVar;
        ao aoVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        ao aoVar3;
        OfficialBarTipModel officialBarTipModel3;
        aoVar = this.aUQ.aUP;
        if (aoVar != null) {
            aoVar2 = this.aUQ.aUP;
            if (aoVar2.La() != null) {
                officialBarTipModel = this.aUQ.aUO;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aUQ.aUO;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aUQ.finish();
                    }
                    aoVar3 = this.aUQ.aUP;
                    OfficialBarTipListAdapter La = aoVar3.La();
                    officialBarTipModel3 = this.aUQ.aUO;
                    La.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
