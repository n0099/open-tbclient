package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.m;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e<BaseActivity<?>> {
    private BaseActivity<?> aSm;
    private com.baidu.adp.framework.listener.a bpb;
    private com.baidu.tieba.hottopic.data.b bph;
    private a bpq;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.b bVar);
    }

    public h(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bph = null;
        this.bpq = null;
        this.bpb = new i(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050);
        this.aSm = baseActivity;
        registerListener(this.bpb);
        this.bph = new com.baidu.tieba.hottopic.data.b();
    }

    public com.baidu.tieba.hottopic.data.b getHotTopicData() {
        return this.bph;
    }

    public void aB(String str, String str2) {
        d(com.baidu.adp.lib.g.b.c(str, 0L), str2);
    }

    private void d(long j, String str) {
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        requestHotTopicMessage.setTopicId(Long.valueOf(j));
        requestHotTopicMessage.setTopicName(str);
        requestHotTopicMessage.setScrH(Integer.valueOf(L));
        requestHotTopicMessage.setScrW(Integer.valueOf(K));
        requestHotTopicMessage.setSrcDip(Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density));
        requestHotTopicMessage.setQType(Integer.valueOf(m.qV().getViewImageQuality()));
        sendMessage(requestHotTopicMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.b bVar = null;
            if ((responsedMessage instanceof ResponseHttpHotTopicMessage) && ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                bVar = ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData();
            }
            if ((responsedMessage instanceof ResponseSocketHotTopicMessage) && ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                bVar = ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData();
            }
            this.bpq.a(!responsedMessage.hasError(), bVar);
        }
    }

    public void a(a aVar) {
        this.bpq = aVar;
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
