package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes21.dex */
public class HotTopicModel extends BdBaseModel<BaseActivity<?>> {
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 0;
    private a kcN;
    private BaseActivity<?> mActivity;
    private com.baidu.adp.framework.listener.a netMessageListener;

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z, e eVar);
    }

    public HotTopicModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.kcN = null;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(1003041, CmdConfigSocket.CMD_HOT_TOPIC) { // from class: com.baidu.tieba.hottopic.controller.HotTopicModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpHotTopicMessage) || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicModel.this.getUniqueId()) {
                        if (!responsedMessage.hasError()) {
                            HotTopicModel.this.i(responsedMessage);
                            return;
                        }
                        if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                            HotTopicModel.this.mActivity.showToast(responsedMessage.getErrorString());
                        }
                        HotTopicModel.this.kcN.a(false, null);
                    }
                }
            }
        };
        this.mActivity = baseActivity;
        registerListener(this.netMessageListener);
    }

    public void a(String str, String str2, int i, long j, String str3, String str4, String str5, long j2) {
        a(com.baidu.adp.lib.f.b.toLong(str, 0L), str2, i, j < 0 ? 0L : j, StringUtils.isNull(str3) ? "" : str3, StringUtils.isNull(str4) ? "" : str4, str5, j2);
    }

    private void a(long j, String str, int i, long j2, String str2, String str3, String str4, long j3) {
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        double d = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        requestHotTopicMessage.setTopicId(Long.valueOf(j));
        requestHotTopicMessage.setCall_from(MD(str4));
        requestHotTopicMessage.setTopicName(str);
        requestHotTopicMessage.setScrH(Integer.valueOf(equipmentHeight));
        requestHotTopicMessage.setTopic_tid(j3);
        requestHotTopicMessage.setScrW(Integer.valueOf(equipmentWidth));
        requestHotTopicMessage.setSrcDip(Double.valueOf(d));
        requestHotTopicMessage.setFid(Long.valueOf(j2));
        requestHotTopicMessage.setFirst_dir(str2);
        requestHotTopicMessage.setSecond_dir(str3);
        requestHotTopicMessage.setQType(Integer.valueOf(k.blV().getViewImageQuality()));
        requestHotTopicMessage.setSort_type(Integer.valueOf(i));
        if (requestHotTopicMessage.getHttpMessage() != null) {
            requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i));
            requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestHotTopicMessage.getSocketMessage() != null) {
            requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i));
            requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
        }
        sendMessage(requestHotTopicMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            e eVar = null;
            if ((responsedMessage instanceof ResponseHttpHotTopicMessage) && ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                eVar = ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData();
            }
            if ((responsedMessage instanceof ResponseSocketHotTopicMessage) && ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                eVar = ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData();
            }
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                eVar.sortType = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
            }
            this.kcN.a(!responsedMessage.hasError(), eVar);
        }
    }

    public void a(a aVar) {
        this.kcN = aVar;
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

    private int MD(String str) {
        if ("1".equals(str)) {
            return 1;
        }
        if ("2".equals(str)) {
            return 2;
        }
        if ("3".equals(str)) {
            return 3;
        }
        if ("4".equals(str)) {
            return 4;
        }
        return "5".equals(str) ? 5 : 1;
    }
}
