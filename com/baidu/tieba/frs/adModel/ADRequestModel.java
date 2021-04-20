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
    public b f15808e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.c.g.a f15809f;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ADSocketResponseMessage;
            if ((z || (responsedMessage instanceof ADHttpResponseMessage)) && ADRequestModel.this.f15808e != null) {
                if (z) {
                    ADRequestModel.this.f15808e.b((ADSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof ADHttpResponseMessage) {
                    ADRequestModel.this.f15808e.a((ADHttpResponseMessage) responsedMessage);
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
        this.f15809f = new a(CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, 309611);
        d.b.i0.d3.d0.a.h(309611, ADSocketResponseMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309611, CmdConfigHttp.CMD_HTTP_FRS_TAB_AD, "c/f/frs/getadlist", ADHttpResponseMessage.class, false, false, true, false);
        registerListener(this.f15809f);
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
        MessageManager.getInstance().unRegisterListener(this.f15809f);
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
        this.f15808e = bVar;
    }
}
