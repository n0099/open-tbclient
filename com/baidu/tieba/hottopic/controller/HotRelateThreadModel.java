package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import d.b.c.e.p.l;
import d.b.h0.r.k;
import d.b.h0.r.q.z0;
import d.b.i0.c1.c.d;
import d.b.i0.c1.c.e;
import d.b.i0.c1.c.f;
/* loaded from: classes4.dex */
public class HotRelateThreadModel extends BdBaseModel<BaseActivity<?>> {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f17221e;

    /* renamed from: f  reason: collision with root package name */
    public c f17222f;

    /* renamed from: g  reason: collision with root package name */
    public b f17223g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f17224h;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (HotRelateThreadModel.this.f17223g != null) {
                HotRelateThreadModel.this.f17223g.complete();
            }
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == HotRelateThreadModel.this.getUniqueId()) {
                int i = 1;
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                    i = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                }
                if (!responsedMessage.hasError()) {
                    HotRelateThreadModel.this.x(responsedMessage);
                    return;
                }
                if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                    HotRelateThreadModel.this.f17221e.showToast(responsedMessage.getErrorString());
                }
                HotRelateThreadModel.this.f17222f.hotRelateThreadCallback(false, null, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void complete();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void hotRelateThreadCallback(boolean z, d dVar, int i);
    }

    public HotRelateThreadModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        a aVar = new a(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.f17224h = aVar;
        this.f17221e = baseActivity;
        registerListener(aVar);
    }

    public void A(b bVar) {
        this.f17223g = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void w(e eVar, int i) {
        if (eVar == null) {
            return;
        }
        y(eVar, i);
    }

    public final void x(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        d dVar = null;
        if (responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) {
            ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
            if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                dVar = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
            }
        }
        if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
            ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
            if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                dVar = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
            }
        }
        this.f17222f.hotRelateThreadCallback(!responsedMessage.hasError(), dVar, (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) ? 1 : ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue());
    }

    public final void y(e eVar, int i) {
        f h2 = eVar.h();
        z0 j = eVar.j();
        if (h2 == null || j == null) {
            return;
        }
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        double d2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int k = l.k(TbadkCoreApplication.getInst().getApp());
        int i2 = l.i(TbadkCoreApplication.getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(d.b.c.e.m.b.f(h2.f53512e, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(h2.f53513f);
        Long l = h2.o;
        if (l != null && h2.p != null) {
            requestGetTopicRelateThreadMessage.setPmy_topic_id(l);
            requestGetTopicRelateThreadMessage.setPmy_source(h2.p);
        }
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(i2));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(k));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(d2));
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(j.a() + 1));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(k.c().e()));
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

    public void z(c cVar) {
        this.f17222f = cVar;
    }
}
