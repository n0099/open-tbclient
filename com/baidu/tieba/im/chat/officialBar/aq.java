package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(OfficialBarTipActivity officialBarTipActivity) {
        this.aRU = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Ki() {
        au auVar;
        au auVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        au auVar3;
        OfficialBarTipModel officialBarTipModel3;
        auVar = this.aRU.aRT;
        if (auVar != null) {
            auVar2 = this.aRU.aRT;
            if (auVar2.Ky() != null) {
                officialBarTipModel = this.aRU.aRS;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aRU.aRS;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aRU.finish();
                    }
                    auVar3 = this.aRU.aRT;
                    OfficialBarTipListAdapter Ky = auVar3.Ky();
                    officialBarTipModel3 = this.aRU.aRS;
                    Ky.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
