package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import d.b.b.e.p.l;
import d.b.h0.r.k;
import d.b.i0.b1.c.e;
/* loaded from: classes3.dex */
public class HotTopicModel extends BdBaseModel<BaseActivity<?>> {
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 0;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f17554e;

    /* renamed from: f  reason: collision with root package name */
    public b f17555f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f17556g;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpHotTopicMessage) || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicModel.this.getUniqueId()) {
                if (!responsedMessage.hasError()) {
                    HotTopicModel.this.w(responsedMessage);
                    return;
                }
                if (!StringUtils.isNull(responsedMessage.getErrorString())) {
                    HotTopicModel.this.f17554e.showToast(responsedMessage.getErrorString());
                }
                HotTopicModel.this.f17555f.hotTopicDataCallback(false, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void hotTopicDataCallback(boolean z, e eVar);
    }

    public HotTopicModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.f17555f = null;
        a aVar = new a(CmdConfigHttp.CMD_HOT_TOPIC, 303050);
        this.f17556g = aVar;
        this.f17554e = baseActivity;
        registerListener(aVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void v(String str, String str2, int i, long j, String str3, String str4, String str5, long j2) {
        x(d.b.b.e.m.b.f(str, 0L), str2, i, j < 0 ? 0L : j, StringUtils.isNull(str3) ? "" : str3, StringUtils.isNull(str4) ? "" : str4, str5, j2);
    }

    public final void w(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        e eVar = null;
        if (responsedMessage instanceof ResponseHttpHotTopicMessage) {
            ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
            if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                eVar = responseHttpHotTopicMessage.getHotTopicData();
            }
        }
        if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
            ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
            if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                eVar = responseSocketHotTopicMessage.getHotTopicData();
            }
        }
        if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
            eVar.s = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
        }
        this.f17555f.hotTopicDataCallback(!responsedMessage.hasError(), eVar);
    }

    public final void x(long j, String str, int i, long j2, String str2, String str3, String str4, long j3) {
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        int k = l.k(TbadkCoreApplication.getInst().getApp());
        int i2 = l.i(TbadkCoreApplication.getInst().getApp());
        requestHotTopicMessage.setTopicId(Long.valueOf(j));
        requestHotTopicMessage.setCall_from(z(str4));
        requestHotTopicMessage.setTopicName(str);
        requestHotTopicMessage.setScrH(Integer.valueOf(i2));
        requestHotTopicMessage.setTopic_tid(j3);
        requestHotTopicMessage.setScrW(Integer.valueOf(k));
        requestHotTopicMessage.setSrcDip(Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
        requestHotTopicMessage.setFid(Long.valueOf(j2));
        requestHotTopicMessage.setFirst_dir(str2);
        requestHotTopicMessage.setSecond_dir(str3);
        requestHotTopicMessage.setQType(Integer.valueOf(k.c().e()));
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

    public void y(b bVar) {
        this.f17555f = bVar;
    }

    public final int z(String str) {
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
