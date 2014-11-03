package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tieba.im.model.OfficialBarTipModel;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ OfficialBarTipActivity aSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(OfficialBarTipActivity officialBarTipActivity) {
        this.aSi = officialBarTipActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Km() {
        au auVar;
        au auVar2;
        OfficialBarTipModel officialBarTipModel;
        OfficialBarTipModel officialBarTipModel2;
        au auVar3;
        OfficialBarTipModel officialBarTipModel3;
        auVar = this.aSi.aSh;
        if (auVar != null) {
            auVar2 = this.aSi.aSh;
            if (auVar2.KC() != null) {
                officialBarTipModel = this.aSi.aSg;
                if (officialBarTipModel != null) {
                    officialBarTipModel2 = this.aSi.aSg;
                    if (officialBarTipModel2.getData().size() == 0) {
                        this.aSi.finish();
                    }
                    auVar3 = this.aSi.aSh;
                    OfficialBarTipListAdapter KC = auVar3.KC();
                    officialBarTipModel3 = this.aSi.aSg;
                    KC.setData(officialBarTipModel3.getData());
                }
            }
        }
    }
}
