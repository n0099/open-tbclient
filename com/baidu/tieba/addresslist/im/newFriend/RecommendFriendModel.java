package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import java.util.List;
/* loaded from: classes15.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {
    private static final String ffD = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask task = new TbHttpMessageTask(1001900, ffD);
    private a ffC;
    private final HttpMessageListener ffE;

    /* loaded from: classes15.dex */
    public interface a {
        void Br(String str);

        void cJ(String str);
    }

    static {
        task.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, a aVar) {
        super(newFriendsActivity.getPageContext());
        this.ffC = null;
        this.ffE = new HttpMessageListener(1001900) { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                        if (RecommendFriendModel.this.ffC != null) {
                            RecommendFriendModel.this.ffC.cJ(null);
                            return;
                        }
                        return;
                    }
                    RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
                    final String errMsg = recommendFriendResponseMessage.getErrMsg();
                    if (recommendFriendResponseMessage.getError() != 0) {
                        if (RecommendFriendModel.this.ffC != null) {
                            RecommendFriendModel.this.ffC.cJ(errMsg);
                            return;
                        }
                        return;
                    }
                    final List<com.baidu.tieba.im.data.a> datas = recommendFriendResponseMessage.getDatas();
                    ad.b(new ac<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.ac
                        /* renamed from: bsE */
                        public Void doInBackground() {
                            if (datas != null && datas.size() > 0) {
                                b.bsK().bu(datas);
                                return null;
                            }
                            return null;
                        }
                    }, new l<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        /* renamed from: a */
                        public void onReturnDataInUI(Void r3) {
                            RecommendFriendModel.this.ffC.Br(errMsg);
                        }
                    });
                }
            }
        };
        this.ffC = aVar;
    }

    public void registerListener() {
        registerListener(this.ffE);
    }

    public void bsQ() {
        sendMessage(new HttpMessage(1001900));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
