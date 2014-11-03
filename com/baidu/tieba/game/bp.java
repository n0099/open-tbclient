package com.baidu.tieba.game;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.e {
    private bs aJr;

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(Context context) {
        super(context);
    }

    public com.baidu.adp.framework.listener.a HO() {
        return new bq(this, CmdConfigHttp.CMD_GET_MUTIL_GAME_LIST, 303015);
    }

    public CustomMessageListener HP() {
        return new br(this, 2001240, true);
    }

    public static void HQ() {
        com.baidu.tieba.ai.a(303015, ResponseMutilGameSocketMessage.class, false, false);
        com.baidu.tieba.ai.a(303015, CmdConfigHttp.CMD_GET_MUTIL_GAME_LIST, "c/u/game/getMutilGameList", ResponseMutilGameHttpMessage.class, false, false, false, false);
    }

    public void registerListener() {
        registerListener(HO());
        registerListener(HP());
    }

    public void HR() {
        sendMessage(new RequestRecommendGameLocalMessage());
    }

    public void HS() {
        RequestMutilGameNetMessage requestMutilGameNetMessage = new RequestMutilGameNetMessage();
        requestMutilGameNetMessage.setType(1);
        sendMessage(requestMutilGameNetMessage);
    }

    public void a(bs bsVar) {
        this.aJr = bsVar;
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
