package com.baidu.tieba.enterForum.model;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.q.c;
/* loaded from: classes4.dex */
public class EnterForumAdModel extends BdBaseModel {
    private com.baidu.tieba.enterForum.data.a fcT;
    private boolean fcU = false;
    private HttpMessageListener dDQ = new HttpMessageListener(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST) { // from class: com.baidu.tieba.enterForum.model.EnterForumAdModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof EnterForumAdResponsedMessage) {
                EnterForumAdResponsedMessage enterForumAdResponsedMessage = (EnterForumAdResponsedMessage) httpResponsedMessage;
                if (enterForumAdResponsedMessage.hasError()) {
                    EnterForumAdModel.this.fcT = null;
                } else {
                    EnterForumAdModel.this.fcT = enterForumAdResponsedMessage.getAdData();
                    if (EnterForumAdModel.this.mLoadDataCallBack != null) {
                        EnterForumAdModel.this.mLoadDataCallBack.callback(EnterForumAdModel.this.fcT);
                    }
                }
                EnterForumAdModel.this.fcU = false;
            }
        }
    };

    public EnterForumAdModel() {
        this.unique_id = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.dDQ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void aEP() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST));
    }

    public com.baidu.tieba.enterForum.data.a beK() {
        return this.fcT;
    }

    public void dr(Context context) {
        if (!this.fcU) {
            com.baidu.tieba.enterForum.data.a aVar = this.fcT;
            if (this.fcT != null && aVar.isValid()) {
                c.cnk().b(i.ab(context).getUniqueId(), com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.ENTER_FORUM, "common_fill", true, 1, 5));
                this.fcU = true;
            }
        }
    }
}
