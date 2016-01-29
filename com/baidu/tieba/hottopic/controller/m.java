package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.e<BaseActivity<?>> {
    private com.baidu.adp.framework.listener.a bKb;
    private com.baidu.tieba.hottopic.data.e bKl;
    private a bKs;
    private BaseActivity<?> bdK;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.e eVar);
    }

    public m(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bKl = null;
        this.bKs = null;
        this.bKb = new n(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050);
        this.bdK = baseActivity;
        registerListener(this.bKb);
        this.bKl = new com.baidu.tieba.hottopic.data.e();
    }

    public com.baidu.tieba.hottopic.data.e getHotTopicData() {
        return this.bKl;
    }

    public void aF(String str, String str2) {
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
        requestHotTopicMessage.setQType(Integer.valueOf(com.baidu.tbadk.core.l.rn().getViewImageQuality()));
        sendMessage(requestHotTopicMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.e eVar = null;
            if ((responsedMessage instanceof ResponseHttpHotTopicMessage) && ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                eVar = ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData();
            }
            if ((responsedMessage instanceof ResponseSocketHotTopicMessage) && ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                eVar = ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData();
            }
            this.bKs.a(!responsedMessage.hasError(), eVar);
        }
    }

    public void a(a aVar) {
        this.bKs = aVar;
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
