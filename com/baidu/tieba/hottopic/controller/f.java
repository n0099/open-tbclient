package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<BaseActivity<?>> {
    private com.baidu.adp.framework.listener.a bKb;
    private a bKd;
    private BaseActivity<?> bdK;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.d dVar);
    }

    public f(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bKb = new g(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.bdK = baseActivity;
        registerListener(this.bKb);
    }

    private void a(com.baidu.tieba.hottopic.data.k kVar) {
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.h.b.c(kVar.bKm, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(kVar.Wm);
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(L));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(K));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestGetTopicRelateThreadMessage.setRn(Integer.valueOf(kVar.bLx));
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(kVar.bLv));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(com.baidu.tbadk.core.l.rn().getViewImageQuality()));
        sendMessage(requestGetTopicRelateThreadMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.d dVar = null;
            if ((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) && ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                dVar = ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            if ((responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) && ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                dVar = ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            this.bKd.a(!responsedMessage.hasError(), dVar);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.k kVar) {
        if (kVar != null) {
            a(kVar);
        }
    }

    public void a(a aVar) {
        this.bKd = aVar;
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
