package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import java.util.List;
/* loaded from: classes20.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {
    private static final String fuo = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask task = new TbHttpMessageTask(1001900, fuo);
    private a fun;
    private final HttpMessageListener fup;

    /* loaded from: classes20.dex */
    public interface a {
        void Ej(String str);

        void cR(String str);
    }

    static {
        task.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, a aVar) {
        super(newFriendsActivity.getPageContext());
        this.fun = null;
        this.fup = new HttpMessageListener(1001900) { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                        if (RecommendFriendModel.this.fun != null) {
                            RecommendFriendModel.this.fun.cR(null);
                            return;
                        }
                        return;
                    }
                    RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
                    final String errMsg = recommendFriendResponseMessage.getErrMsg();
                    if (recommendFriendResponseMessage.getError() != 0) {
                        if (RecommendFriendModel.this.fun != null) {
                            RecommendFriendModel.this.fun.cR(errMsg);
                            return;
                        }
                        return;
                    }
                    final List<com.baidu.tieba.im.data.a> datas = recommendFriendResponseMessage.getDatas();
                    ae.b(new ad<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.ad
                        /* renamed from: bCO */
                        public Void doInBackground() {
                            if (datas != null && datas.size() > 0) {
                                b.bCU().bz(datas);
                                return null;
                            }
                            return null;
                        }
                    }, new m<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.m
                        /* renamed from: a */
                        public void onReturnDataInUI(Void r3) {
                            RecommendFriendModel.this.fun.Ej(errMsg);
                        }
                    });
                }
            }
        };
        this.fun = aVar;
    }

    public void registerListener() {
        registerListener(this.fup);
    }

    public void bDa() {
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
