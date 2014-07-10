package com.baidu.tieba.im.live;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        String str2;
        if (customResponsedMessage instanceof AccessTokenUpdatedMessage) {
            AccessTokenUpdatedMessage accessTokenUpdatedMessage = (AccessTokenUpdatedMessage) customResponsedMessage;
            if (!accessTokenUpdatedMessage.hasError()) {
                String bduss = accessTokenUpdatedMessage.getBduss();
                String accessToken = accessTokenUpdatedMessage.getAccessToken();
                AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
                if (parseBDUSS != null && bduss != null && bduss.equals(parseBDUSS.mBduss) && accessToken != null && accessToken.length() > 0) {
                    str = this.a.b;
                    if (str != null) {
                        str2 = this.a.b;
                        if (accessToken.equals(str2)) {
                            return;
                        }
                    }
                    this.a.b = accessToken;
                }
            }
        }
    }
}
