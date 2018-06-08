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
/* loaded from: classes3.dex */
public class a<T> {
    private BaseActivity<T> bkU;
    private com.baidu.adp.framework.listener.a cGS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetLevelInfoHttpResponsedMessage) {
                GetLevelInfoHttpResponsedMessage getLevelInfoHttpResponsedMessage = (GetLevelInfoHttpResponsedMessage) responsedMessage;
                a.this.dfB.a(getLevelInfoHttpResponsedMessage.getResult(), true, getLevelInfoHttpResponsedMessage.getError(), getLevelInfoHttpResponsedMessage.getErrorString());
            } else if (responsedMessage instanceof GetLevelInfoSocketResponsedMessage) {
                GetLevelInfoSocketResponsedMessage getLevelInfoSocketResponsedMessage = (GetLevelInfoSocketResponsedMessage) responsedMessage;
                a.this.dfB.a(getLevelInfoSocketResponsedMessage.getmResult(), true, getLevelInfoSocketResponsedMessage.getError(), getLevelInfoSocketResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener ddJ = new CustomMessageListener(2003007) { // from class: com.baidu.tieba.forumMember.tbtitle.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof GetLevelInfoReadCacheResponsedMessage)) {
                GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = (GetLevelInfoReadCacheResponsedMessage) customResponsedMessage;
                a.this.dfB.a(getLevelInfoReadCacheResponsedMessage.getResult(), false, getLevelInfoReadCacheResponsedMessage.getError(), getLevelInfoReadCacheResponsedMessage.getErrorString());
            }
        }
    };
    private InterfaceC0149a dfB;

    /* renamed from: com.baidu.tieba.forumMember.tbtitle.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0149a {
        void a(DataRes dataRes, boolean z, int i, String str);
    }

    public a(InterfaceC0149a interfaceC0149a, BaseActivity<T> baseActivity) {
        this.dfB = interfaceC0149a;
        this.bkU = baseActivity;
        asv();
    }

    public void jX(int i) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = new GetLevelInfoRequestMessage();
        getLevelInfoRequestMessage.setForumId(i);
        this.bkU.sendMessage(getLevelInfoRequestMessage);
    }

    public void jY(int i) {
        GetLevelInfoReadCacheRequestMessage getLevelInfoReadCacheRequestMessage = new GetLevelInfoReadCacheRequestMessage();
        getLevelInfoReadCacheRequestMessage.setCacheKey("" + i);
        this.bkU.sendMessage(getLevelInfoReadCacheRequestMessage);
    }

    private void asv() {
        this.bkU.registerListener(this.ddJ);
        this.bkU.registerListener(this.cGS);
    }
}
