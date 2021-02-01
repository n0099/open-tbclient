package com.baidu.tieba.faceshop.forumpackage.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.data.b;
import com.baidu.tieba.faceshop.forumpackage.message.ForumEmotionCenterResponseMessage;
/* loaded from: classes9.dex */
public class ForumEmotionModel extends BdBaseModel {
    public static final int NUM_PER_PAGE = 10;
    public static final int PAGE_START = 1;
    private boolean hasMore;
    private final b iZV;
    private final HttpMessageListener jam;
    private int pn;

    /* loaded from: classes9.dex */
    public interface a {
        void a(ForumEmotionData forumEmotionData);

        void b(ForumEmotionData forumEmotionData);

        void onFailed(String str);
    }

    public ForumEmotionModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.pn = 1;
        this.hasMore = true;
        this.iZV = new b();
        this.jam = new HttpMessageListener(1003389) { // from class: com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                a aVar;
                Object extra;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003389 && (httpResponsedMessage instanceof ForumEmotionCenterResponseMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof a)) {
                        aVar = null;
                    } else {
                        aVar = (a) extra;
                    }
                    ForumEmotionCenterResponseMessage forumEmotionCenterResponseMessage = (ForumEmotionCenterResponseMessage) httpResponsedMessage;
                    ForumEmotionModel.this.hasMore = forumEmotionCenterResponseMessage.data != null && forumEmotionCenterResponseMessage.data.has_more == 1;
                    if (aVar != null) {
                        if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                            if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                                if (ForumEmotionModel.this.pn == 1) {
                                    aVar.a(forumEmotionCenterResponseMessage.data);
                                    return;
                                } else {
                                    aVar.b(forumEmotionCenterResponseMessage.data);
                                    return;
                                }
                            }
                            aVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                            return;
                        }
                        aVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                    }
                }
            }
        };
        registerTask();
        this.jam.setTag(getUniqueId());
        this.jam.setSelfListener(true);
        registerListener(this.jam);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003389, TbConfig.SERVER_ADDRESS + Config.FORUM_EMOTION_PACKAGE);
        tbHttpMessageTask.setResponsedClass(ForumEmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(a aVar) {
        this.pn = 1;
        HttpMessage httpMessage = new HttpMessage(1003389);
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, this.pn);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.iZV.cAl() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(aVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003389);
        return true;
    }

    public void b(a aVar) {
        HttpMessage httpMessage = new HttpMessage(1003389);
        int i = this.pn + 1;
        this.pn = i;
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, i);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam("forum_type", this.iZV.cAl() == 1 ? "like_forum" : "all_forum");
        httpMessage.setExtra(aVar);
        sendMessage(httpMessage);
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public b cAm() {
        return this.iZV;
    }
}
