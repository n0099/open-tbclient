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
import com.baidu.tieba.t.c;
/* loaded from: classes22.dex */
public class EnterForumAdModel extends BdBaseModel {
    private com.baidu.tieba.enterForum.data.b iyd;
    private boolean iye = false;
    private HttpMessageListener gzG = new HttpMessageListener(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST) { // from class: com.baidu.tieba.enterForum.model.EnterForumAdModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof EnterForumAdResponsedMessage) {
                EnterForumAdResponsedMessage enterForumAdResponsedMessage = (EnterForumAdResponsedMessage) httpResponsedMessage;
                if (enterForumAdResponsedMessage.hasError()) {
                    EnterForumAdModel.this.iyd = null;
                } else {
                    EnterForumAdModel.this.iyd = enterForumAdResponsedMessage.getAdData();
                    if (EnterForumAdModel.this.mLoadDataCallBack != null) {
                        EnterForumAdModel.this.mLoadDataCallBack.callback(EnterForumAdModel.this.iyd);
                    }
                }
                EnterForumAdModel.this.iye = false;
            }
        }
    };

    public EnterForumAdModel() {
        this.unique_id = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.gzG);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void loadAd() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST));
    }

    public com.baidu.tieba.enterForum.data.b cwl() {
        return this.iyd;
    }

    public void fQ(Context context) {
        if (!this.iye) {
            com.baidu.tieba.enterForum.data.b bVar = this.iyd;
            if (this.iyd != null && bVar.isValid()) {
                c.dOf().b(i.J(context).getUniqueId(), com.baidu.tieba.t.a.a(PageStayDurationConstants.PageName.ENTER_FORUM, "common_fill", true, 1, 5));
                this.iye = true;
            }
        }
    }
}
