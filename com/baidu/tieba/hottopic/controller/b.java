package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e<BaseActivity<?>> {
    private BaseActivity<?> aXA;
    private a bCZ;
    private com.baidu.adp.framework.listener.a bDa;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.b bVar);
    }

    public b(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bDa = new c(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.aXA = baseActivity;
        registerListener(this.bDa);
    }

    private void a(com.baidu.tieba.hottopic.data.h hVar) {
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.h.b.c(hVar.bDj, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(hVar.bBb);
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(L));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(K));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestGetTopicRelateThreadMessage.setRn(Integer.valueOf(hVar.bEr));
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(hVar.bEp));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(com.baidu.tbadk.core.m.rh().getViewImageQuality()));
        sendMessage(requestGetTopicRelateThreadMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.b bVar = null;
            if ((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) && ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                bVar = ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            if ((responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) && ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                bVar = ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            this.bCZ.a(!responsedMessage.hasError(), bVar);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.h hVar) {
        if (hVar != null) {
            a(hVar);
        }
    }

    public void a(a aVar) {
        this.bCZ = aVar;
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
