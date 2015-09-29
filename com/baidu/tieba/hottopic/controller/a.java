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
    private BaseActivity<?> aRT;
    private InterfaceC0056a bol;
    private com.baidu.adp.framework.listener.a bom;

    /* renamed from: com.baidu.tieba.hottopic.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        void a(boolean z, com.baidu.tieba.hottopic.data.a aVar);
    }

    public a(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bom = new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.aRT = baseActivity;
        registerListener(this.bom);
    }

    private void a(com.baidu.tieba.hottopic.data.f fVar) {
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.bot, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(fVar.bou);
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(L));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(K));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestGetTopicRelateThreadMessage.setRn(Integer.valueOf(fVar.bpd));
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(fVar.bpb));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(m.qX().getViewImageQuality()));
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
            this.bol.a(!responsedMessage.hasError(), aVar);
        }
    }

    public void b(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            a(fVar);
        }
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.bol = interfaceC0056a;
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
