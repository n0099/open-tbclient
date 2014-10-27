package com.baidu.tieba.game;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.base.e {
    private bq aJe;

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(Context context) {
        super(context);
    }

    public com.baidu.adp.framework.listener.a HK() {
        return new bo(this, CmdConfigHttp.CMD_GET_MUTIL_GAME_LIST, 303015);
    }

    public CustomMessageListener HL() {
        return new bp(this, 2001240, true);
    }

    public static void HM() {
        com.baidu.tieba.ai.a(303015, ResponseMutilGameSocketMessage.class, false, false);
        com.baidu.tieba.ai.a(303015, CmdConfigHttp.CMD_GET_MUTIL_GAME_LIST, "c/u/game/getMutilGameList", ResponseMutilGameHttpMessage.class, false, false, false, false);
    }

    public void registerListener() {
        registerListener(HK());
        registerListener(HL());
    }

    public void HN() {
        sendMessage(new RequestRecommendGameLocalMessage());
    }

    public void HO() {
        RequestMutilGameNetMessage requestMutilGameNetMessage = new RequestMutilGameNetMessage();
        requestMutilGameNetMessage.setType(1);
        sendMessage(requestMutilGameNetMessage);
    }

    public void a(bq bqVar) {
        this.aJe = bqVar;
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
