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
import d.a.m0.l0.d;
import tbclient.GetClientConfig.CPayType;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes3.dex */
public class PayConfigModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.l0.a f12964e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.c.c.g.a f12965f;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (PayConfigModel.this.z(responsedMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.A(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                        return;
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.A(((ClientConfigSocketResponse) responsedMessage).getData());
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
                if (PayConfigModel.this.f12964e != null) {
                    PayConfigModel.this.f12964e.onError(errorString);
                }
            }
        }
    }

    public PayConfigModel(BaseActivity<?> baseActivity, d.a.m0.l0.a aVar) {
        super(baseActivity.getPageContext());
        a aVar2 = new a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f12965f = aVar2;
        this.f12964e = aVar;
        registerListener(aVar2);
    }

    public final void A(DataRes dataRes) {
        CPayType cPayType;
        if (dataRes != null && (cPayType = dataRes.payType) != null) {
            if (cPayType.pay_type.intValue() == 1) {
                d.a.m0.l0.a aVar = this.f12964e;
                if (aVar != null) {
                    aVar.b();
                }
            } else if (dataRes.payType.pay_type.intValue() == 2) {
                d.a.m0.l0.a aVar2 = this.f12964e;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else {
                d.a.m0.l0.a aVar3 = this.f12964e;
                if (aVar3 != null) {
                    aVar3.onError("");
                }
            }
        } else if (this.f12964e != null) {
            this.f12964e.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
        }
    }

    public void B() {
        if (!d.c().g()) {
            d.a.m0.l0.a aVar = this.f12964e;
            if (aVar != null) {
                aVar.a();
            }
        } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
            d.a.m0.l0.a aVar2 = this.f12964e;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else {
            ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
            clientConfigNetMessage.setType("payType");
            sendMessage(clientConfigNetMessage);
        }
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
        MessageManager.getInstance().unRegisterListener(this.f12965f);
    }

    public final boolean z(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public PayConfigModel(TbPageContext tbPageContext, d.a.m0.l0.a aVar) {
        super(tbPageContext);
        a aVar2 = new a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f12965f = aVar2;
        this.f12964e = aVar;
        registerListener(aVar2);
    }
}
