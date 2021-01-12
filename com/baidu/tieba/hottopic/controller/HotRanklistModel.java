package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
/* loaded from: classes7.dex */
public class HotRanklistModel extends BdBaseModel {
    private j klj;
    private a klk;
    private com.baidu.adp.framework.listener.a netMessageListener;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, j jVar, int i, String str);
    }

    public HotRanklistModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.klj = null;
        this.klk = null;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(1003078, CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST) { // from class: com.baidu.tieba.hottopic.controller.HotRanklistModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpHotRanklistMessage) || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == HotRanklistModel.this.getUniqueId()) {
                        if (!responsedMessage.hasError()) {
                            HotRanklistModel.this.i(responsedMessage);
                        } else {
                            HotRanklistModel.this.klk.a(false, null, responsedMessage.getError(), responsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        registerListener(this.netMessageListener);
        this.klj = new j();
    }

    public void g(String str, String str2, String str3, long j) {
        h(str, str2, str3, j);
    }

    private void h(String str, String str2, String str3, long j) {
        RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
        requestHotRanklistMessage.setCallFrom(str);
        requestHotRanklistMessage.setListType(str2);
        requestHotRanklistMessage.setNeedTabList(str3);
        requestHotRanklistMessage.setFid(j);
        sendMessage(requestHotRanklistMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(ResponsedMessage<?> responsedMessage) {
        String str;
        j jVar = null;
        if (responsedMessage != null) {
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestHotRanklistMessage) {
                    str = ((RequestHotRanklistMessage) extra).getListType();
                    if ((responsedMessage instanceof ResponseHttpHotRanklistMessage) && ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData() != null) {
                        jVar = ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData();
                    }
                    if ((responsedMessage instanceof ResponseSocketHotRanklistMessage) && ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData() != null) {
                        jVar = ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData();
                    }
                    if (!StringUtils.isNull(str) && !x.isEmpty(jVar.kmN)) {
                        jVar.type = jVar.kmN.get(0).hag;
                    } else {
                        jVar.type = str;
                    }
                    this.klk.a(responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
            str = null;
            if (responsedMessage instanceof ResponseHttpHotRanklistMessage) {
                jVar = ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData();
            }
            if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                jVar = ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData();
            }
            if (!StringUtils.isNull(str)) {
            }
            jVar.type = str;
            this.klk.a(responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
        }
    }

    public void a(a aVar) {
        this.klk = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }
}
