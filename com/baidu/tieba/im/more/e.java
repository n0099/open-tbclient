package com.baidu.tieba.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity beT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.beT = secretSettingActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        a aVar2;
        g gVar;
        g gVar2;
        a aVar3;
        a aVar4;
        if (responsedMessage != null) {
            this.beT.beP = true;
            this.beT.hideProgressBar();
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.beT.showToast(responsedMessage.getErrorString());
                return;
            }
            a aVar5 = null;
            if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                aVar5 = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
            }
            if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                aVar5 = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
            }
            if (aVar5 != null) {
                aVar = this.beT.beO;
                aVar.a(aVar5);
                aVar2 = this.beT.beO;
                aVar2.QG();
                gVar = this.beT.beN;
                gVar.dn(true);
                gVar2 = this.beT.beN;
                aVar3 = this.beT.beO;
                gVar2.b(aVar3);
                TbadkApplication m251getInst = TbadkApplication.m251getInst();
                aVar4 = this.beT.beO;
                m251getInst.setLocationShared(aVar4.QI());
            }
        }
    }
}
