package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.f<NewFriendsActivity> {
    private final HttpMessageListener aAB;
    private bg aAy;
    private static final String aAz = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask aAA = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, aAz);

    static {
        aAA.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aAA);
    }

    public bc(NewFriendsActivity newFriendsActivity, bg bgVar) {
        super(newFriendsActivity.getPageContext());
        this.aAy = null;
        this.aAB = new bd(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.aAy = bgVar;
    }

    public void registerListener() {
        registerListener(this.aAB);
    }

    public void Gc() {
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
