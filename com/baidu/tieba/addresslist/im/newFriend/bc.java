package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.f<NewFriendsActivity> {
    private static final String ayG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask ayH = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, ayG);
    private bg ayF;
    private final HttpMessageListener ayI;

    static {
        ayH.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(ayH);
    }

    public bc(NewFriendsActivity newFriendsActivity, bg bgVar) {
        super(newFriendsActivity.getPageContext());
        this.ayF = null;
        this.ayI = new bd(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.ayF = bgVar;
    }

    public void registerListener() {
        registerListener(this.ayI);
    }

    public void Fd() {
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
