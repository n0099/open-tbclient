package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<GiftTabActivity> {
    private com.baidu.adp.framework.listener.a aWh;
    private String addFreeUrl;
    private a buY;
    private ArrayList<c> categoryList;
    private int freeChance;
    private ArrayList<com.baidu.tbadk.core.data.l> giftList;
    private ArrayList<k> numberList;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, int i2, String str2, ArrayList<c> arrayList, ArrayList<com.baidu.tbadk.core.data.l> arrayList2, ArrayList<k> arrayList3);
    }

    public d(com.baidu.adp.base.h<GiftTabActivity> hVar) {
        super(hVar);
        this.aWh = new e(this, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
        CQ();
        registerListener();
    }

    public void i(String str, long j) {
        DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
        defaultGiftListRequest.setFrom(str);
        defaultGiftListRequest.setToUserId(j);
        sendMessage(defaultGiftListRequest);
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
        com.baidu.tieba.tbadkCore.a.a.a(309054, DefaultGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void a(a aVar) {
        this.buY = aVar;
    }
}
