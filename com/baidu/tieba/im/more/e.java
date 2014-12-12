package com.baidu.tieba.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity biA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.biA = secretSettingActivity;
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
            this.biA.biw = true;
            this.biA.hideProgressBar();
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.biA.showToast(responsedMessage.getErrorString());
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
                aVar = this.biA.biv;
                aVar.a(aVar5);
                aVar2 = this.biA.biv;
                aVar2.Ri();
                gVar = this.biA.biu;
                gVar.dc(true);
                gVar2 = this.biA.biu;
                aVar3 = this.biA.biv;
                gVar2.b(aVar3);
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                aVar4 = this.biA.biv;
                m255getInst.setLocationShared(aVar4.Rk());
            }
        }
    }
}
