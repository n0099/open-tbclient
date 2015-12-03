package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<GiftTabActivity> {
    private com.baidu.adp.framework.listener.a aWh;
    private InterfaceC0062a buU;
    private ArrayList<com.baidu.tbadk.core.data.l> giftList;

    /* renamed from: com.baidu.tieba.gift.giftTab.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void a(int i, String str, int i2, ArrayList<com.baidu.tbadk.core.data.l> arrayList);
    }

    public a(com.baidu.adp.base.h<GiftTabActivity> hVar) {
        super(hVar);
        this.aWh = new b(this, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
        CQ();
        registerListener();
    }

    public void fL(int i) {
        CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
        categoryGiftListRequest.setCategoryId(i);
        sendMessage(categoryGiftListRequest);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private void registerListener() {
        registerListener(this.aWh);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309055, CategoryGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309055, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.buU = interfaceC0062a;
    }
}
