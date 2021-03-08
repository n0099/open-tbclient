package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class FreeGiftChanceModel extends BdBaseModel<GiftTabActivity> {
    private int freeChance;
    private a jXj;
    private com.baidu.adp.framework.listener.a jdE;

    /* loaded from: classes8.dex */
    public interface a {
        void c(int i, String str, int i2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public FreeGiftChanceModel(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        super(fVar);
        this.jdE = new com.baidu.adp.framework.listener.a(1003047, CmdConfigSocket.CMD_USER_FREE_CHANCE) { // from class: com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof FreeGiftChanceHttpResponseMessage) || (responsedMessage instanceof FreeGiftChanceSocketResponseMessage)) {
                        if (responsedMessage instanceof FreeGiftChanceHttpResponseMessage) {
                            FreeGiftChanceModel.this.freeChance = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                        } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                            FreeGiftChanceModel.this.freeChance = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                        }
                        if (FreeGiftChanceModel.this.jXj != null) {
                            FreeGiftChanceModel.this.jXj.c(responsedMessage.getError(), responsedMessage.getErrorString(), FreeGiftChanceModel.this.freeChance);
                        }
                    }
                }
            }
        };
        registerListener();
        registerTask();
    }

    public void gR(String str) {
        FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
        freeGiftChanceRequest.setFrom(str);
        sendMessage(freeGiftChanceRequest);
    }

    private void registerListener() {
        registerListener(this.jdE);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_FREE_CHANCE, FreeGiftChanceSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_FREE_CHANCE, 1003047, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
    }

    public void a(a aVar) {
        this.jXj = aVar;
    }
}
