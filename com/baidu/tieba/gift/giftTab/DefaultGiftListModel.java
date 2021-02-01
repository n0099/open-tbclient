package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aj;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {
    private String addFreeUrl;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> categoryList;
    private int freeChance;
    private ArrayList<ai> giftList;
    private a jUR;
    private com.baidu.adp.framework.listener.a jbH;
    private ArrayList<e> numberList;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, int i2, String str2, int i3, aj ajVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ai> arrayList2, ArrayList<e> arrayList3);
    }

    public DefaultGiftListModel(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        super(fVar);
        this.jbH = new com.baidu.adp.framework.listener.a(1003045, CmdConfigSocket.CMD_DEFAULT_GIFT_LIST) { // from class: com.baidu.tieba.gift.giftTab.DefaultGiftListModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof DefaultGiftListHttpResponseMessage) || (responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                        int i = 0;
                        aj ajVar = null;
                        if (responsedMessage instanceof DefaultGiftListHttpResponseMessage) {
                            DefaultGiftListHttpResponseMessage defaultGiftListHttpResponseMessage = (DefaultGiftListHttpResponseMessage) responsedMessage;
                            DefaultGiftListModel.this.categoryList = defaultGiftListHttpResponseMessage.getCategoryList();
                            DefaultGiftListModel.this.giftList = defaultGiftListHttpResponseMessage.getGiftList();
                            DefaultGiftListModel.this.numberList = defaultGiftListHttpResponseMessage.getGiftNumberList();
                            DefaultGiftListModel.this.addFreeUrl = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                            DefaultGiftListModel.this.freeChance = defaultGiftListHttpResponseMessage.getFreeChance();
                            i = defaultGiftListHttpResponseMessage.currencyType;
                            ajVar = defaultGiftListHttpResponseMessage.urlTitleData;
                        } else if (responsedMessage instanceof DefaultGiftListSocketResponseMessage) {
                            DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                            DefaultGiftListModel.this.categoryList = defaultGiftListSocketResponseMessage.getCategoryList();
                            DefaultGiftListModel.this.giftList = defaultGiftListSocketResponseMessage.getGiftList();
                            DefaultGiftListModel.this.numberList = defaultGiftListSocketResponseMessage.getGiftNumberList();
                            DefaultGiftListModel.this.addFreeUrl = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                            DefaultGiftListModel.this.freeChance = defaultGiftListSocketResponseMessage.getFreeChance();
                            i = defaultGiftListSocketResponseMessage.currencyType;
                            ajVar = defaultGiftListSocketResponseMessage.urlTitleData;
                        }
                        if (DefaultGiftListModel.this.jUR != null) {
                            DefaultGiftListModel.this.jUR.a(responsedMessage.getError(), responsedMessage.getErrorString(), DefaultGiftListModel.this.freeChance, DefaultGiftListModel.this.addFreeUrl, i, ajVar, DefaultGiftListModel.this.categoryList, DefaultGiftListModel.this.giftList, DefaultGiftListModel.this.numberList);
                        }
                    }
                }
            }
        };
        registerTask();
        registerListener();
    }

    public void H(String str, long j) {
        DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
        defaultGiftListRequest.setFrom(str);
        defaultGiftListRequest.setToUserId(j);
        sendMessage(defaultGiftListRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private void registerListener() {
        registerListener(this.jbH);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_DEFAULT_GIFT_LIST, DefaultGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_DEFAULT_GIFT_LIST, 1003045, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void a(a aVar) {
        this.jUR = aVar;
    }
}
