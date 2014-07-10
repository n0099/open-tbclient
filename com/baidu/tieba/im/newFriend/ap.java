package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.e {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask c = new TbHttpMessageTask(1001900, b);
    private at a;
    private HttpMessageListener d = new aq(this, 1001900);

    static {
        c.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(c);
    }

    public ap(at atVar) {
        this.a = null;
        this.a = atVar;
    }

    public void a() {
        registerListener(this.d);
    }

    public void b() {
        HttpMessage httpMessage = new HttpMessage(1001900);
        httpMessage.setTag(1001900);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
