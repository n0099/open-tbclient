package com.baidu.tieba.forumMember.tbtitle.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.forumMember.tbtitle.model.cache.GetLevelInfoReadCacheResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes23.dex */
public class a<T> {
    private com.baidu.adp.framework.listener.a iOw = new com.baidu.adp.framework.listener.a(1001710, CmdConfigSocket.CMD_GET_LEVEL_INFO) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetLevelInfoHttpResponsedMessage) {
                GetLevelInfoHttpResponsedMessage getLevelInfoHttpResponsedMessage = (GetLevelInfoHttpResponsedMessage) responsedMessage;
                a.this.iQj.a(getLevelInfoHttpResponsedMessage.getResult(), true, getLevelInfoHttpResponsedMessage.getError(), getLevelInfoHttpResponsedMessage.getErrorString());
            } else if (responsedMessage instanceof GetLevelInfoSocketResponsedMessage) {
                GetLevelInfoSocketResponsedMessage getLevelInfoSocketResponsedMessage = (GetLevelInfoSocketResponsedMessage) responsedMessage;
                a.this.iQj.a(getLevelInfoSocketResponsedMessage.getmResult(), true, getLevelInfoSocketResponsedMessage.getError(), getLevelInfoSocketResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener iOx = new CustomMessageListener(CmdConfigCustom.CMD_GET_LEVEL_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof GetLevelInfoReadCacheResponsedMessage)) {
                GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = (GetLevelInfoReadCacheResponsedMessage) customResponsedMessage;
                a.this.iQj.a(getLevelInfoReadCacheResponsedMessage.getResult(), false, getLevelInfoReadCacheResponsedMessage.getError(), getLevelInfoReadCacheResponsedMessage.getErrorString());
            }
        }
    };
    private InterfaceC0737a iQj;
    private BaseActivity<T> mActivity;

    /* renamed from: com.baidu.tieba.forumMember.tbtitle.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0737a {
        void a(DataRes dataRes, boolean z, int i, String str);
    }

    public a(InterfaceC0737a interfaceC0737a, BaseActivity<T> baseActivity) {
        this.iQj = interfaceC0737a;
        this.mActivity = baseActivity;
        cAE();
    }

    public void zy(int i) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = new GetLevelInfoRequestMessage();
        getLevelInfoRequestMessage.setForumId(i);
        this.mActivity.sendMessage(getLevelInfoRequestMessage);
    }

    public void zz(int i) {
        GetLevelInfoReadCacheRequestMessage getLevelInfoReadCacheRequestMessage = new GetLevelInfoReadCacheRequestMessage();
        getLevelInfoReadCacheRequestMessage.setCacheKey("" + i);
        this.mActivity.sendMessage(getLevelInfoReadCacheRequestMessage);
    }

    private void cAE() {
        this.mActivity.registerListener(this.iOx);
        this.mActivity.registerListener(this.iOw);
    }
}
