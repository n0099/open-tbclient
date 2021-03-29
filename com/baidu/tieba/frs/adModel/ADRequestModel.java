package com.baidu.tieba.frs.adModel;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes4.dex */
public class ADRequestModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f16147e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.b.c.g.a f16148f;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ADSocketResponseMessage;
            if ((z || (responsedMessage instanceof ADHttpResponseMessage)) && ADRequestModel.this.f16147e != null) {
                if (z) {
                    ADRequestModel.this.f16147e.b((ADSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof ADHttpResponseMessage) {
                    ADRequestModel.this.f16147e.a((ADHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ADHttpResponseMessage aDHttpResponseMessage);

        void b(ADSocketResponseMessage aDSocketResponseMessage);
    }

    public ADRequestModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f16148f = new a(CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, 309611);
        d.b.i0.c3.d0.a.h(309611, ADSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309611, CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, "c/f/frs/getadlist", ADHttpResponseMessage.class, false, false, true, false);
        registerListener(this.f16148f);
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
        MessageManager.getInstance().unRegisterListener(this.f16148f);
    }

    public void t(long j, int i, int i2) {
        cancelMessage();
        ADRequestMessage aDRequestMessage = new ADRequestMessage();
        aDRequestMessage.setFid(j);
        aDRequestMessage.setRn(i2);
        aDRequestMessage.setOffset(i);
        sendMessage(aDRequestMessage);
    }

    public void u(b bVar) {
        this.f16147e = bVar;
    }
}
