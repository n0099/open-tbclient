package com.baidu.tieba.im.newFriend;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.base.e {
    private static final String aEy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask aEz = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, aEy);
    private final HttpMessageListener aEA;
    private be bhr;

    static {
        aEz.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aEz);
    }

    public ba(Context context, be beVar) {
        super(context);
        this.bhr = null;
        this.aEA = new bb(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.bhr = beVar;
    }

    public void registerListener() {
        registerListener(this.aEA);
    }

    public void xF() {
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
