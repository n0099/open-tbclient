package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {
    private static final String dkF = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask task = new TbHttpMessageTask(1001900, dkF);
    private a dkE;
    private final HttpMessageListener dkG;

    /* loaded from: classes3.dex */
    public interface a {
        void bh(String str);

        void rM(String str);
    }

    static {
        task.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, a aVar) {
        super(newFriendsActivity.getPageContext());
        this.dkE = null;
        this.dkG = new HttpMessageListener(1001900) { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                        if (RecommendFriendModel.this.dkE != null) {
                            RecommendFriendModel.this.dkE.bh(null);
                            return;
                        }
                        return;
                    }
                    RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
                    final String errMsg = recommendFriendResponseMessage.getErrMsg();
                    if (recommendFriendResponseMessage.getError() != 0) {
                        if (RecommendFriendModel.this.dkE != null) {
                            RecommendFriendModel.this.dkE.bh(errMsg);
                            return;
                        }
                        return;
                    }
                    final List<com.baidu.tieba.im.data.a> datas = recommendFriendResponseMessage.getDatas();
                    z.b(new y<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.y
                        /* renamed from: aEg */
                        public Void doInBackground() {
                            if (datas != null && datas.size() > 0) {
                                b.aEl().aV(datas);
                                return null;
                            }
                            return null;
                        }
                    }, new j<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        /* renamed from: a */
                        public void onReturnDataInUI(Void r3) {
                            RecommendFriendModel.this.dkE.rM(errMsg);
                        }
                    });
                }
            }
        };
        this.dkE = aVar;
    }

    public void registerListener() {
        registerListener(this.dkG);
    }

    public void aEr() {
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
