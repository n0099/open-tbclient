package com.baidu.tbadk.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import d.b.h0.l0.c;
import tbclient.GetClientConfig.CPayType;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes3.dex */
public class PayConfigModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.l0.a f13647e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.c.g.a f13648f;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (PayConfigModel.this.v(responsedMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.w(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                        return;
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.w(((ClientConfigSocketResponse) responsedMessage).getData());
                        return;
                    } else {
                        return;
                    }
                }
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
                if (StringUtils.isNull(errorString)) {
                    errorString = string;
                }
                if (PayConfigModel.this.f13647e != null) {
                    PayConfigModel.this.f13647e.onError(errorString);
                }
            }
        }
    }

    public PayConfigModel(BaseActivity<?> baseActivity, d.b.h0.l0.a aVar) {
        super(baseActivity.getPageContext());
        a aVar2 = new a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f13648f = aVar2;
        this.f13647e = aVar;
        registerListener(aVar2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f13648f);
    }

    public final boolean v(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public final void w(DataRes dataRes) {
        CPayType cPayType;
        if (dataRes != null && (cPayType = dataRes.payType) != null) {
            if (cPayType.pay_type.intValue() == 1) {
                d.b.h0.l0.a aVar = this.f13647e;
                if (aVar != null) {
                    aVar.b();
                }
            } else if (dataRes.payType.pay_type.intValue() == 2) {
                d.b.h0.l0.a aVar2 = this.f13647e;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else {
                d.b.h0.l0.a aVar3 = this.f13647e;
                if (aVar3 != null) {
                    aVar3.onError("");
                }
            }
        } else if (this.f13647e != null) {
            this.f13647e.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
        }
    }

    public void x() {
        if (!c.c().g()) {
            d.b.h0.l0.a aVar = this.f13647e;
            if (aVar != null) {
                aVar.a();
            }
        } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
            d.b.h0.l0.a aVar2 = this.f13647e;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else {
            ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
            clientConfigNetMessage.setType("payType");
            sendMessage(clientConfigNetMessage);
        }
    }

    public PayConfigModel(TbPageContext tbPageContext, d.b.h0.l0.a aVar) {
        super(tbPageContext);
        a aVar2 = new a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f13648f = aVar2;
        this.f13647e = aVar;
        registerListener(aVar2);
    }
}
