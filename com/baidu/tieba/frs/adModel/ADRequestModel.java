package com.baidu.tieba.frs.adModel;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes4.dex */
public class ADRequestModel extends BdBaseModel<BaseFragmentActivity> {
    private a feb;
    private final com.baidu.adp.framework.listener.a fec;

    /* loaded from: classes4.dex */
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
        this.fec = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, 309611) { // from class: com.baidu.tieba.frs.adModel.ADRequestModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ADSocketResponseMessage) || (responsedMessage instanceof ADHttpResponseMessage)) && ADRequestModel.this.feb != null) {
                        if (responsedMessage instanceof ADSocketResponseMessage) {
                            ADRequestModel.this.feb.a((ADSocketResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof ADHttpResponseMessage) {
                            ADRequestModel.this.feb.a((ADHttpResponseMessage) responsedMessage);
                        }
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(309611, ADSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309611, CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, "c/f/frs/getadlist", ADHttpResponseMessage.class, false, false, true, false);
        registerListener(this.fec);
    }

    public void b(long j, int i, int i2) {
        cancelMessage();
        ADRequestMessage aDRequestMessage = new ADRequestMessage();
        aDRequestMessage.setFid(j);
        aDRequestMessage.setRn(i2);
        aDRequestMessage.setOffset(i);
        sendMessage(aDRequestMessage);
    }

    public void a(a aVar) {
        this.feb = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fec);
    }
}
