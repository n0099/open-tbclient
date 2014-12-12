package com.baidu.tieba.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity biA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.biA = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        if (httpResponsedMessage != null) {
            this.biA.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.biA.showToast(httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        gVar = this.biA.biu;
                        this.biA.mHandler.postDelayed(new d(this, gVar.Rr()), 500L);
                        return;
                    }
                    return;
                }
                this.biA.showToast(z.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.biA.biv;
                    aVar.N(operation, type);
                    gVar2 = this.biA.biu;
                    gVar2.Q(operation, type);
                    return;
                }
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                gVar3 = this.biA.biu;
                m255getInst.setLocationShared(gVar3.Rr());
                gVar4 = this.biA.biu;
                gVar4.dd(TbadkCoreApplication.m255getInst().getLocationShared());
            }
        }
    }
}
