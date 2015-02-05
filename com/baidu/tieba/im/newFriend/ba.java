package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.base.f<NewFriendsActivity> {
    private static final String blG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask blH = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, blG);
    private be blF;
    private final HttpMessageListener blI;

    static {
        blH.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(blH);
    }

    public ba(NewFriendsActivity newFriendsActivity, be beVar) {
        super(newFriendsActivity.getPageContext());
        this.blF = null;
        this.blI = new bb(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.blF = beVar;
    }

    public void registerListener() {
        registerListener(this.blI);
    }

    public void Bs() {
        sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
