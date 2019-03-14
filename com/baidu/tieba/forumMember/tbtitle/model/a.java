package com.baidu.tieba.forumMember.tbtitle.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.tbtitle.model.cache.GetLevelInfoReadCacheResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes5.dex */
public class a<T> {
    private BaseActivity<T> cNa;
    private com.baidu.adp.framework.listener.a eDY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetLevelInfoHttpResponsedMessage) {
                GetLevelInfoHttpResponsedMessage getLevelInfoHttpResponsedMessage = (GetLevelInfoHttpResponsedMessage) responsedMessage;
                a.this.eWF.a(getLevelInfoHttpResponsedMessage.getResult(), true, getLevelInfoHttpResponsedMessage.getError(), getLevelInfoHttpResponsedMessage.getErrorString());
            } else if (responsedMessage instanceof GetLevelInfoSocketResponsedMessage) {
                GetLevelInfoSocketResponsedMessage getLevelInfoSocketResponsedMessage = (GetLevelInfoSocketResponsedMessage) responsedMessage;
                a.this.eWF.a(getLevelInfoSocketResponsedMessage.getmResult(), true, getLevelInfoSocketResponsedMessage.getError(), getLevelInfoSocketResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eUM = new CustomMessageListener(2003007) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof GetLevelInfoReadCacheResponsedMessage)) {
                GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = (GetLevelInfoReadCacheResponsedMessage) customResponsedMessage;
                a.this.eWF.a(getLevelInfoReadCacheResponsedMessage.getResult(), false, getLevelInfoReadCacheResponsedMessage.getError(), getLevelInfoReadCacheResponsedMessage.getErrorString());
            }
        }
    };
    private InterfaceC0287a eWF;

    /* renamed from: com.baidu.tieba.forumMember.tbtitle.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0287a {
        void a(DataRes dataRes, boolean z, int i, String str);
    }

    public a(InterfaceC0287a interfaceC0287a, BaseActivity<T> baseActivity) {
        this.eWF = interfaceC0287a;
        this.cNa = baseActivity;
        bbm();
    }

    public void pO(int i) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = new GetLevelInfoRequestMessage();
        getLevelInfoRequestMessage.setForumId(i);
        this.cNa.sendMessage(getLevelInfoRequestMessage);
    }

    public void pP(int i) {
        GetLevelInfoReadCacheRequestMessage getLevelInfoReadCacheRequestMessage = new GetLevelInfoReadCacheRequestMessage();
        getLevelInfoReadCacheRequestMessage.setCacheKey("" + i);
        this.cNa.sendMessage(getLevelInfoReadCacheRequestMessage);
    }

    private void bbm() {
        this.cNa.registerListener(this.eUM);
        this.cNa.registerListener(this.eDY);
    }
}
