package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
/* loaded from: classes8.dex */
public class HotRelateThreadModel extends BdBaseModel<BaseActivity<?>> {
    private com.baidu.adp.framework.listener.a hja;
    private b iDe;
    private a iDf;
    private BaseActivity<?> mActivity;

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
        this.hja = new com.baidu.adp.framework.listener.a(1003042, CmdConfigSocket.CMD_TOPIC_RELATE_THREAD) { // from class: com.baidu.tieba.hottopic.controller.HotRelateThreadModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (HotRelateThreadModel.this.iDf != null) {
                    HotRelateThreadModel.this.iDf.complete();
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
                        HotRelateThreadModel.this.iDe.a(false, null, i);
                    }
                }
            }
        };
        this.mActivity = baseActivity;
        registerListener(this.hja);
    }

    public void a(a aVar) {
        this.iDf = aVar;
    }

    private void a(e eVar, int i) {
        f clF = eVar.clF();
        at pageData = eVar.getPageData();
        if (clF != null && pageData != null) {
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            double d = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(clF.dYw, 0L)));
            requestGetTopicRelateThreadMessage.setTopicName(clF.dKw);
            if (clF.iEo != null && clF.iEp != null) {
                requestGetTopicRelateThreadMessage.setPmy_topic_id(clF.iEo);
                requestGetTopicRelateThreadMessage.setPmy_source(clF.iEp);
            }
            requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(equipmentHeight));
            requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(equipmentWidth));
            requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(d));
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(pageData.aRd() + 1));
            requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(k.aPA().getViewImageQuality()));
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
            this.iDe.a(responsedMessage.hasError() ? false : true, dVar, (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) ? 1 : ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue());
        }
    }

    public void b(e eVar, int i) {
        if (eVar != null) {
            a(eVar, i);
        }
    }

    public void a(b bVar) {
        this.iDe = bVar;
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
