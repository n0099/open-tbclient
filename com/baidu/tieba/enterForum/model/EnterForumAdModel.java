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
import com.baidu.tieba.enterForum.data.c;
/* loaded from: classes9.dex */
public class EnterForumAdModel extends BdBaseModel {
    private c gDP;
    private boolean gDQ = false;
    private HttpMessageListener eXG = new HttpMessageListener(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST) { // from class: com.baidu.tieba.enterForum.model.EnterForumAdModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof EnterForumAdResponsedMessage) {
                EnterForumAdResponsedMessage enterForumAdResponsedMessage = (EnterForumAdResponsedMessage) httpResponsedMessage;
                if (enterForumAdResponsedMessage.hasError()) {
                    EnterForumAdModel.this.gDP = null;
                } else {
                    EnterForumAdModel.this.gDP = enterForumAdResponsedMessage.getAdData();
                    if (EnterForumAdModel.this.mLoadDataCallBack != null) {
                        EnterForumAdModel.this.mLoadDataCallBack.callback(EnterForumAdModel.this.gDP);
                    }
                }
                EnterForumAdModel.this.gDQ = false;
            }
        }
    };

    public EnterForumAdModel() {
        this.unique_id = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.eXG);
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

    public c bIT() {
        return this.gDP;
    }

    public void es(Context context) {
        if (!this.gDQ) {
            c cVar = this.gDP;
            if (this.gDP != null && cVar.isValid()) {
                com.baidu.tieba.s.c.cVp().b(i.G(context).getUniqueId(), com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.ENTER_FORUM, "common_fill", true, 1, 5));
                this.gDQ = true;
            }
        }
    }
}
