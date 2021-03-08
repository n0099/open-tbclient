package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ai;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class CategoryGiftListModel extends BdBaseModel<GiftTabActivity> {
    private ArrayList<ai> giftList;
    private a jXf;
    private com.baidu.adp.framework.listener.a jdE;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, int i2, ArrayList<ai> arrayList);
    }

    public CategoryGiftListModel(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        super(fVar);
        this.jdE = new com.baidu.adp.framework.listener.a(1003046, CmdConfigSocket.CMD_GIFT_LIST_BY_CATEGORY) { // from class: com.baidu.tieba.gift.giftTab.CategoryGiftListModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof CategoryGiftListHttpResponseMessage) || (responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                        int i = 0;
                        if (responsedMessage instanceof CategoryGiftListHttpResponseMessage) {
                            CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                            CategoryGiftListModel.this.giftList = categoryGiftListHttpResponseMessage.getGiftList();
                            i = categoryGiftListHttpResponseMessage.getCategoryId();
                        } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                            CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                            CategoryGiftListModel.this.giftList = categoryGiftListSocketResponseMessage.getGiftList();
                            i = categoryGiftListSocketResponseMessage.getCategoryId();
                        }
                        if (CategoryGiftListModel.this.jXf != null) {
                            CategoryGiftListModel.this.jXf.a(responsedMessage.getError(), responsedMessage.getErrorString(), i, CategoryGiftListModel.this.giftList);
                        }
                    }
                }
            }
        };
        registerTask();
        registerListener();
    }

    public void loadData(int i) {
        CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
        categoryGiftListRequest.setCategoryId(i);
        sendMessage(categoryGiftListRequest);
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
        registerListener(this.jdE);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GIFT_LIST_BY_CATEGORY, CategoryGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GIFT_LIST_BY_CATEGORY, 1003046, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void a(a aVar) {
        this.jXf = aVar;
    }
}
