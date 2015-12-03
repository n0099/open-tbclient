package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<BaseActivity<?>> {
    private BaseActivity<?> aXA;
    private com.baidu.adp.framework.listener.a bDa;
    private com.baidu.tieba.hottopic.data.c bDi;
    private a bDo;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.c cVar);
    }

    public i(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bDi = null;
        this.bDo = null;
        this.bDa = new j(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050);
        this.aXA = baseActivity;
        registerListener(this.bDa);
        this.bDi = new com.baidu.tieba.hottopic.data.c();
    }

    public com.baidu.tieba.hottopic.data.c getHotTopicData() {
        return this.bDi;
    }

    public void aG(String str, String str2) {
        f(com.baidu.adp.lib.h.b.c(str, 0L), str2);
    }

    private void f(long j, String str) {
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestHotTopicMessage.setTopicId(Long.valueOf(j));
        requestHotTopicMessage.setTopicName(str);
        requestHotTopicMessage.setScrH(Integer.valueOf(L));
        requestHotTopicMessage.setScrW(Integer.valueOf(K));
        requestHotTopicMessage.setSrcDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestHotTopicMessage.setQType(Integer.valueOf(com.baidu.tbadk.core.m.rh().getViewImageQuality()));
        sendMessage(requestHotTopicMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.c cVar = null;
            if ((responsedMessage instanceof ResponseHttpHotTopicMessage) && ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                cVar = ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData();
            }
            if ((responsedMessage instanceof ResponseSocketHotTopicMessage) && ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                cVar = ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData();
            }
            this.bDo.a(!responsedMessage.hasError(), cVar);
        }
    }

    public void a(a aVar) {
        this.bDo = aVar;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }
}
