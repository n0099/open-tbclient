package com.baidu.tieba.homepage.listview.card.discover;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ a byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.byW = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (this.byW.pageContext != null && (this.byW.pageContext.getOrignalPage() instanceof BaseFragmentActivity)) {
            TbPageContext<?> tbPageContext = this.byW.pageContext;
            ((BaseFragmentActivity) tbPageContext.getOrignalPage()).closeLoadingDialog();
            if (httpResponsedMessage instanceof OpenUserResponsedMessage) {
                OpenUserResponsedMessage openUserResponsedMessage = (OpenUserResponsedMessage) httpResponsedMessage;
                if (openUserResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                    HttpMessage httpMessage = (HttpMessage) openUserResponsedMessage.getOrginalMessage();
                    if (httpMessage.getExtra() instanceof String) {
                        String str = (String) httpMessage.getExtra();
                        if (openUserResponsedMessage.hasError()) {
                            c.a(tbPageContext, str, "", "");
                            return;
                        }
                        OpenUserInfo userInfo = openUserResponsedMessage.getUserInfo();
                        if (userInfo == null) {
                            c.a(tbPageContext, str, "", "");
                        } else if (TextUtils.isEmpty(userInfo.toJson())) {
                            c.a(tbPageContext, str, "", "");
                        } else if (!TbadkCoreApplication.isLogin()) {
                            c.a(tbPageContext, str, "", "");
                        } else {
                            com.baidu.tbadk.core.sharedPref.b.tZ().putString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), userInfo.toJson());
                            c.a(tbPageContext, str, userInfo.getOpenID(), userInfo.getUserName());
                        }
                    }
                }
            }
        }
    }
}
