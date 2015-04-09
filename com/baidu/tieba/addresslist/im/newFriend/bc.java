package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.f<NewFriendsActivity> {
    private static final String ayO = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask ayP = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, ayO);
    private bg ayN;
    private final HttpMessageListener ayQ;

    static {
        ayP.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(ayP);
    }

    public bc(NewFriendsActivity newFriendsActivity, bg bgVar) {
        super(newFriendsActivity.getPageContext());
        this.ayN = null;
        this.ayQ = new bd(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.ayN = bgVar;
    }

    public void registerListener() {
        registerListener(this.ayQ);
    }

    public void Fj() {
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
