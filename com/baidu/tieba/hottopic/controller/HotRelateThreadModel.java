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
import d.a.c.e.p.l;
import d.a.i0.r.k;
import d.a.i0.r.q.z0;
import d.a.j0.c1.c.d;
import d.a.j0.c1.c.e;
import d.a.j0.c1.c.f;
/* loaded from: classes4.dex */
public class HotRelateThreadModel extends BdBaseModel<BaseActivity<?>> {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f17522e;

    /* renamed from: f  reason: collision with root package name */
    public c f17523f;

    /* renamed from: g  reason: collision with root package name */
    public b f17524g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f17525h;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (HotRelateThreadModel.this.f17524g != null) {
                HotRelateThreadModel.this.f17524g.complete();
            }
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == HotRelateThreadModel.this.getUniqueId()) {
                int i2 = 1;
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                    i2 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                }
                if (!responsedMessage.hasError()) {
                    HotRelateThreadModel.this.x(responsedMessage);
                    return;
                }
                if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                    HotRelateThreadModel.this.f17522e.showToast(responsedMessage.getErrorString());
                }
                HotRelateThreadModel.this.f17523f.hotRelateThreadCallback(false, null, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void complete();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void hotRelateThreadCallback(boolean z, d dVar, int i2);
    }

    public HotRelateThreadModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        a aVar = new a(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
        this.f17525h = aVar;
        this.f17522e = baseActivity;
        registerListener(aVar);
    }

    public void A(b bVar) {
        this.f17524g = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void w(e eVar, int i2) {
        if (eVar == null) {
            return;
        }
        y(eVar, i2);
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
        this.f17523f.hotRelateThreadCallback(!responsedMessage.hasError(), dVar, (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) ? 1 : ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue());
    }

    public final void y(e eVar, int i2) {
        f h2 = eVar.h();
        z0 j = eVar.j();
        if (h2 == null || j == null) {
            return;
        }
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        double d2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int k = l.k(TbadkCoreApplication.getInst().getApp());
        int i3 = l.i(TbadkCoreApplication.getInst().getApp());
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(d.a.c.e.m.b.f(h2.f51694e, 0L)));
        requestGetTopicRelateThreadMessage.setTopicName(h2.f51695f);
        Long l = h2.o;
        if (l != null && h2.p != null) {
            requestGetTopicRelateThreadMessage.setPmy_topic_id(l);
            requestGetTopicRelateThreadMessage.setPmy_source(h2.p);
        }
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(i3));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(k));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(d2));
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(j.a() + 1));
        requestGetTopicRelateThreadMessage.setQType(Integer.valueOf(k.c().e()));
        requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
        if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
            requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
            requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
        }
        sendMessage(requestGetTopicRelateThreadMessage);
    }

    public void z(c cVar) {
        this.f17523f = cVar;
    }
}
