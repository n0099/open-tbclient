package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {
    private static final String cPD = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, cPD);
    private a cPC;
    private final HttpMessageListener cPE;

    /* loaded from: classes3.dex */
    public interface a {
        void onLoadFailed(String str);

        void rc(String str);
    }

    static {
        task.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, a aVar) {
        super(newFriendsActivity.getPageContext());
        this.cPC = null;
        this.cPE = new HttpMessageListener(CmdConfigHttp.RECOMMOEND_FRIEND_CMD) { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                        if (RecommendFriendModel.this.cPC != null) {
                            RecommendFriendModel.this.cPC.onLoadFailed(null);
                            return;
                        }
                        return;
                    }
                    RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
                    final String errMsg = recommendFriendResponseMessage.getErrMsg();
                    if (recommendFriendResponseMessage.getError() != 0) {
                        if (RecommendFriendModel.this.cPC != null) {
                            RecommendFriendModel.this.cPC.onLoadFailed(errMsg);
                            return;
                        }
                        return;
                    }
                    final List<com.baidu.tieba.im.data.a> datas = recommendFriendResponseMessage.getDatas();
                    aa.b(new z<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.z
                        /* renamed from: awV */
                        public Void doInBackground() {
                            if (datas != null && datas.size() > 0) {
                                b.awZ().av(datas);
                                return null;
                            }
                            return null;
                        }
                    }, new k<Void>() { // from class: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.k
                        /* renamed from: b */
                        public void onReturnDataInUI(Void r3) {
                            RecommendFriendModel.this.cPC.rc(errMsg);
                        }
                    });
                }
            }
        };
        this.cPC = aVar;
    }

    public void registerListener() {
        registerListener(this.cPE);
    }

    public void axf() {
        sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
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
