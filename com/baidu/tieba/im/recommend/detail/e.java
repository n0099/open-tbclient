package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import tbclient.Bigvip.UserInfoBigVip;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ c bmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, int i) {
        super(i);
        this.bmb = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        g gVar;
        g gVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserInfoBigVip)) {
            UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
            gVar = this.bmb.blX;
            if (gVar != null && userInfoBigVip != null) {
                this.bmb.aQr = true;
                gVar2 = this.bmb.blX;
                gVar2.a(userInfoBigVip, false);
            }
            this.bmb.Tc();
            return;
        }
        this.bmb.Tc();
    }
}
