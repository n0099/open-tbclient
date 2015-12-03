package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<GiftTabActivity> {
    private com.baidu.adp.framework.listener.a aWh;
    private a bva;
    private int freeChance;

    /* loaded from: classes.dex */
    public interface a {
        void b(int i, String str, int i2);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public f(com.baidu.adp.base.h<GiftTabActivity> hVar) {
        super(hVar);
        this.aWh = new g(this, CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
        registerListener();
        CQ();
    }

    public void hI(String str) {
        FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
        freeGiftChanceRequest.setFrom(str);
        sendMessage(freeGiftChanceRequest);
    }

    private void registerListener() {
        registerListener(this.aWh);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309060, FreeGiftChanceSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309060, CmdConfigHttp.CMD_USER_FREE_CHANCE, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
    }

    public void a(a aVar) {
        this.bva = aVar;
    }
}
