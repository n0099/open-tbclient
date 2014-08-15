package com.baidu.tieba.im.newFriend;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.e {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/getRecommendList";
    private static TbHttpMessageTask c = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, b);
    private ba a;
    private final HttpMessageListener d;

    static {
        c.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(c);
    }

    public aw(Context context, ba baVar) {
        super(context);
        this.a = null;
        this.d = new ax(this, CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.a = baVar;
    }

    public void a() {
        registerListener(this.d);
    }

    public void b() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
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
