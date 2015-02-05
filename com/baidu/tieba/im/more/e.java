package com.baidu.tieba.im.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SecretSettingActivity bjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SecretSettingActivity secretSettingActivity, int i, int i2) {
        super(i, i2);
        this.bjW = secretSettingActivity;
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
            this.bjW.bjS = true;
            this.bjW.hideProgressBar();
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.bjW.showToast(responsedMessage.getErrorString());
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
                aVar = this.bjW.bjR;
                aVar.a(aVar5);
                aVar2 = this.bjW.bjR;
                aVar2.Rz();
                gVar = this.bjW.bjQ;
                gVar.dh(true);
                gVar2 = this.bjW.bjQ;
                aVar3 = this.bjW.bjR;
                gVar2.b(aVar3);
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                aVar4 = this.bjW.bjR;
                m255getInst.setLocationShared(aVar4.RB());
            }
        }
    }
}
