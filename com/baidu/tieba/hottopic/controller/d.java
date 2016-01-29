package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private ArrayList<com.baidu.adp.widget.ListView.u> Zg;
    private com.baidu.tieba.hottopic.data.i bJZ;
    private a bKa;
    private com.baidu.adp.framework.listener.a bKb;
    private BaseActivity<?> bdK;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.hottopic.data.i iVar);
    }

    public d(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.Zg = new ArrayList<>();
        this.bJZ = null;
        this.bKa = null;
        this.bKb = new e(this, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
        this.bdK = baseActivity;
        registerListener(this.bKb);
        this.bJZ = new com.baidu.tieba.hottopic.data.i();
    }

    public void aD(String str, String str2) {
        aE(str, str2);
    }

    private void aE(String str, String str2) {
        RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
        requestHotRanklistMessage.setCallFrom(str);
        requestHotRanklistMessage.setListType(str2);
        sendMessage(requestHotRanklistMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.i iVar = null;
            if ((responsedMessage instanceof ResponseHttpHotRanklistMessage) && ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData() != null) {
                iVar = ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData();
            }
            if ((responsedMessage instanceof ResponseSocketHotRanklistMessage) && ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData() != null) {
                iVar = ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData();
            }
            this.bKa.a(!responsedMessage.hasError(), iVar);
        }
    }

    public void a(a aVar) {
        this.bKa = aVar;
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
