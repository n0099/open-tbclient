package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* loaded from: classes8.dex */
public class HotRelateThreadModel extends BdBaseModel<BaseActivity<?>> {
    private b ktt;
    private a ktu;
    private BaseActivity<?> mActivity;
    private com.baidu.adp.framework.listener.a netMessageListener;

    /* loaded from: classes8.dex */
    public interface a {
        void complete();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i);
    }

    public HotRelateThreadModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.netMessageListener = new com.baidu.adp.framework.listener.a(1003042, CmdConfigSocket.CMD_TOPIC_RELATE_THREAD) { // from class: com.baidu.tieba.hottopic.controller.HotRelateThreadModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (HotRelateThreadModel.this.ktu != null) {
                    HotRelateThreadModel.this.ktu.complete();
                }
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == HotRelateThreadModel.this.getUniqueId()) {
                        int i = 1;
                        if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                            i = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        }
                        if (!responsedMessage.hasError()) {
                            HotRelateThreadModel.this.i(responsedMessage);
                            return;
                        }
                        if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                            HotRelateThreadModel.this.mActivity.showToast(responsedMessage.getErrorString());
                        }
                        HotRelateThreadModel.this.ktt.a(false, null, i);
                    }
                }
            }
        };
        this.mActivity = baseActivity;
        registerListener(this.netMessageListener);
    }

    public void a(a aVar) {
        this.ktu = aVar;
    }

    private void a(e eVar, int i) {
        f cTh = eVar.cTh();
        az pageData = eVar.getPageData();
        if (cTh != null && pageData != null) {
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            double d = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cTh.fey, 0L)));
            requestGetTopicRelateThreadMessage.setTopicName(cTh.ePt);
            if (cTh.kuD != null && cTh.kuE != null) {
                requestGetTopicRelateThreadMessage.setPmy_topic_id(cTh.kuD);
                requestGetTopicRelateThreadMessage.setPmy_source(cTh.kuE);
            }
            requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(equipmentHeight));
            requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(equipmentWidth));
            requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(d));
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(pageData.bmD() + 1));
            requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(k.bkT().getViewImageQuality()));
            requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i));
            if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i));
                requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i));
                requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
            }
            sendMessage(requestGetTopicRelateThreadMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            com.baidu.tieba.hottopic.data.d dVar = null;
            if ((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) && ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                dVar = ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            if ((responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) && ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                dVar = ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
            }
            this.ktt.a(responsedMessage.hasError() ? false : true, dVar, (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) ? 1 : ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue());
        }
    }

    public void b(e eVar, int i) {
        if (eVar != null) {
            a(eVar, i);
        }
    }

    public void a(b bVar) {
        this.ktt = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
