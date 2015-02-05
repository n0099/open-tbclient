package com.baidu.tieba.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity bjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.bjW = secretSettingActivity;
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
            this.bjW.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.bjW.showToast(httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        gVar = this.bjW.bjQ;
                        this.bjW.mHandler.postDelayed(new d(this, gVar.RI()), 500L);
                        return;
                    }
                    return;
                }
                this.bjW.showToast(z.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.bjW.bjR;
                    aVar.N(operation, type);
                    gVar2 = this.bjW.bjQ;
                    gVar2.Q(operation, type);
                    return;
                }
                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                gVar3 = this.bjW.bjQ;
                m255getInst.setLocationShared(gVar3.RI());
                gVar4 = this.bjW.bjQ;
                gVar4.di(TbadkCoreApplication.m255getInst().getLocationShared());
            }
        }
    }
}
