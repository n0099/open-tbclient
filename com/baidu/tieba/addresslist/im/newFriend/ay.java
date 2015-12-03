package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.e<NewFriendsActivity> {
    private static final String aJe = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask aJf = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, aJe);
    private a aJd;
    private final HttpMessageListener aJg;

    /* loaded from: classes.dex */
    public interface a {
        void bK(String str);

        void gt(String str);
    }

    static {
        aJf.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aJf);
    }

    public ay(NewFriendsActivity newFriendsActivity, a aVar) {
        super(newFriendsActivity.getPageContext());
        this.aJd = null;
        this.aJg = new az(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.aJd = aVar;
    }

    public void registerListener() {
        registerListener(this.aJg);
    }

    public void Hx() {
        sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
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
