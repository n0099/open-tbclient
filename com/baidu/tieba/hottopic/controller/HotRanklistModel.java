package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import d.a.j0.c1.c.j;
/* loaded from: classes4.dex */
public class HotRanklistModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f17519e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f17520f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpHotRanklistMessage) || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == HotRanklistModel.this.getUniqueId()) {
                if (!responsedMessage.hasError()) {
                    HotRanklistModel.this.v(responsedMessage);
                } else {
                    HotRanklistModel.this.f17519e.loadNetDataCallback(false, null, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void loadNetDataCallback(boolean z, j jVar, int i2, String str);
    }

    public HotRanklistModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f17519e = null;
        a aVar = new a(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
        this.f17520f = aVar;
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

    public void u(String str, String str2, String str3, long j) {
        w(str, str2, str3, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(ResponsedMessage<?> responsedMessage) {
        String str;
        if (responsedMessage == null) {
            return;
        }
        j jVar = null;
        if (responsedMessage.getOrginalMessage() != null) {
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof RequestHotRanklistMessage) {
                str = ((RequestHotRanklistMessage) extra).getListType();
                if (responsedMessage instanceof ResponseHttpHotRanklistMessage) {
                    ResponseHttpHotRanklistMessage responseHttpHotRanklistMessage = (ResponseHttpHotRanklistMessage) responsedMessage;
                    if (responseHttpHotRanklistMessage.getHotRanklistData() != null) {
                        jVar = responseHttpHotRanklistMessage.getHotRanklistData();
                    }
                }
                if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                    ResponseSocketHotRanklistMessage responseSocketHotRanklistMessage = (ResponseSocketHotRanklistMessage) responsedMessage;
                    if (responseSocketHotRanklistMessage.getHotRanklistData() != null) {
                        jVar = responseSocketHotRanklistMessage.getHotRanklistData();
                    }
                }
                if (!StringUtils.isNull(str) && !ListUtils.isEmpty(jVar.f51708b)) {
                    jVar.f51707a = jVar.f51708b.get(0).f51733f;
                } else {
                    jVar.f51707a = str;
                }
                this.f17519e.loadNetDataCallback(!responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
        str = null;
        if (responsedMessage instanceof ResponseHttpHotRanklistMessage) {
        }
        if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
        }
        if (!StringUtils.isNull(str)) {
        }
        jVar.f51707a = str;
        this.f17519e.loadNetDataCallback(!responsedMessage.hasError(), jVar, responsedMessage.getError(), responsedMessage.getErrorString());
    }

    public final void w(String str, String str2, String str3, long j) {
        RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
        requestHotRanklistMessage.setCallFrom(str);
        requestHotRanklistMessage.setListType(str2);
        requestHotRanklistMessage.setNeedTabList(str3);
        requestHotRanklistMessage.setFid(j);
        sendMessage(requestHotRanklistMessage);
    }

    public void x(b bVar) {
        this.f17519e = bVar;
    }
}
