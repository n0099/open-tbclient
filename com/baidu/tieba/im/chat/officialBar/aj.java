package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aUR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(OfficialBarTipActivity officialBarTipActivity) {
        this.aUR = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        ao aoVar;
        ao aoVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        ao aoVar3;
        OfficialBarTipModel officialBarTipModel3;
        aoVar = this.aUR.aUQ;
        if (aoVar != null) {
            aoVar2 = this.aUR.aUQ;
            if (aoVar2.Lf() != null) {
                officialBarTipModel = this.aUR.aUP;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aUR.aUP;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aUR.finish();
                    }
                    aoVar3 = this.aUR.aUQ;
                    OfficialBarTipListAdapter Lf = aoVar3.Lf();
                    officialBarTipModel3 = this.aUR.aUP;
                    Lf.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
