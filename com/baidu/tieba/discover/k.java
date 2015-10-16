package com.baidu.tieba.discover;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.discover.data.OpenUserInfo;
import com.baidu.tieba.discover.data.OpenUserResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends HttpMessageListener {
    final /* synthetic */ a aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(a aVar, int i) {
        super(i);
        this.aKG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        this.aKG.getPageContext().getOrignalPage().closeLoadingDialog();
        if (httpResponsedMessage instanceof OpenUserResponsedMessage) {
            OpenUserResponsedMessage openUserResponsedMessage = (OpenUserResponsedMessage) httpResponsedMessage;
            if (openUserResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) openUserResponsedMessage.getOrginalMessage();
                if (httpMessage.getExtra() instanceof String) {
                    String str = (String) httpMessage.getExtra();
                    if (!openUserResponsedMessage.hasError()) {
                        OpenUserInfo userInfo = openUserResponsedMessage.getUserInfo();
                        if (userInfo != null) {
                            if (!TextUtils.isEmpty(userInfo.toJson())) {
                                if (TbadkCoreApplication.isLogin()) {
                                    com.baidu.tbadk.core.sharedPref.b.tu().putString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), userInfo.toJson());
                                    this.aKG.m(str, userInfo.getOpenID(), userInfo.getUserName());
                                    return;
                                }
                                this.aKG.m(str, "", "");
                                return;
                            }
                            this.aKG.m(str, "", "");
                            return;
                        }
                        this.aKG.m(str, "", "");
                        return;
                    }
                    this.aKG.m(str, "", "");
                }
            }
        }
    }
}
