package com.baidu.tieba.frs.adModel;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes22.dex */
public class ADRequestModel extends BdBaseModel<BaseFragmentActivity> {
    private a ivN;
    private final com.baidu.adp.framework.listener.a ivO;

    /* loaded from: classes22.dex */
    public interface a {
        void a(ADHttpResponseMessage aDHttpResponseMessage);

        void a(ADSocketResponseMessage aDSocketResponseMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public ADRequestModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ivO = new com.baidu.adp.framework.listener.a(1003411, 309611) { // from class: com.baidu.tieba.frs.adModel.ADRequestModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ADSocketResponseMessage) || (responsedMessage instanceof ADHttpResponseMessage)) && ADRequestModel.this.ivN != null) {
                        if (responsedMessage instanceof ADSocketResponseMessage) {
                            ADRequestModel.this.ivN.a((ADSocketResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof ADHttpResponseMessage) {
                            ADRequestModel.this.ivN.a((ADHttpResponseMessage) responsedMessage);
                        }
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(309611, ADSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309611, 1003411, "c/f/frs/getadlist", ADHttpResponseMessage.class, false, false, true, false);
        registerListener(this.ivO);
    }

    public void c(long j, int i, int i2) {
        cancelMessage();
        ADRequestMessage aDRequestMessage = new ADRequestMessage();
        aDRequestMessage.setFid(j);
        aDRequestMessage.setRn(i2);
        aDRequestMessage.setOffset(i);
        sendMessage(aDRequestMessage);
    }

    public void a(a aVar) {
        this.ivN = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ivO);
    }
}
