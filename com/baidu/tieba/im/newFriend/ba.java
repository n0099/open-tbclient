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
    private static final String aEo = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask aEp = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, aEo);
    private final HttpMessageListener aEq;
    private be bhd;

    static {
        aEp.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aEp);
    }

    public ba(Context context, be beVar) {
        super(context);
        this.bhd = null;
        this.aEq = new bb(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.bhd = beVar;
    }

    public void registerListener() {
        registerListener(this.aEq);
    }

    public void xD() {
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
