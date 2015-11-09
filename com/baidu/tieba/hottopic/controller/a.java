package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.m;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<BaseActivity<?>> {
    private BaseActivity<?> aSm;
    private InterfaceC0056a bpa;
    private com.baidu.adp.framework.listener.a bpb;

    /* renamed from: com.baidu.tieba.hottopic.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        void a(boolean z, com.baidu.tieba.hottopic.data.a aVar);
    }

    public a(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bpb = new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.aSm = baseActivity;
        registerListener(this.bpb);
    }

    private void a(com.baidu.tieba.hottopic.data.f fVar) {
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.bpi, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(fVar.bpj);
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(L));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(K));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestGetTopicRelateThreadMessage.setRn(Integer.valueOf(fVar.bpS));
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(fVar.bpQ));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(m.qV().getViewImageQuality()));
        sendMessage(requestGetTopicRelateThreadMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.a aVar = null;
            if ((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) && ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                aVar = ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            if ((responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) && ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                aVar = ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            this.bpa.a(!responsedMessage.hasError(), aVar);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            a(fVar);
        }
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.bpa = interfaceC0056a;
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
