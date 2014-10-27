package com.baidu.tieba.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ SecretSettingActivity beT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity, int i, boolean z) {
        super(i, z);
        this.beT = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        g gVar;
        a aVar;
        g gVar2;
        g gVar3;
        g gVar4;
        if (httpResponsedMessage != null) {
            this.beT.hideProgressBar();
            if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    this.beT.showToast(httpResponsedMessage.getErrorString());
                    if (TextUtils.equals("location", operation)) {
                        gVar = this.beT.beN;
                        this.beT.mHandler.postDelayed(new d(this, gVar.QP()), 500L);
                        return;
                    }
                    return;
                }
                this.beT.showToast(y.success);
                if (!TextUtils.equals("location", operation)) {
                    aVar = this.beT.beO;
                    aVar.H(operation, type);
                    gVar2 = this.beT.beN;
                    gVar2.J(operation, type);
                    return;
                }
                TbadkApplication m251getInst = TbadkApplication.m251getInst();
                gVar3 = this.beT.beN;
                m251getInst.setLocationShared(gVar3.QP());
                gVar4 = this.beT.beN;
                gVar4.dp(TbadkApplication.m251getInst().getLocationShared());
            }
        }
    }
}
