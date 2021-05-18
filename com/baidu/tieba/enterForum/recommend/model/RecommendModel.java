package com.baidu.tieba.enterForum.recommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.recommend.message.RequestRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
import d.a.c.e.p.j;
/* loaded from: classes4.dex */
public class RecommendModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.i0.k.a f14605e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f14606f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14607g;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecommendModel.this.f14607g = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || RecommendModel.this.unique_id != responsedMessage.getOrginalMessage().getTag() || RecommendModel.this.f14605e == null) {
                return;
            }
            d.a.k0.i0.k.c.a recommendData = responsedMessage instanceof ResponseHttpRecommendMessage ? ((ResponseHttpRecommendMessage) responsedMessage).getRecommendData() : null;
            if (responsedMessage instanceof ResponseSocketRecommendMessage) {
                recommendData = ((ResponseSocketRecommendMessage) responsedMessage).getRecommendData();
            }
            RecommendModel.this.f14605e.f(responsedMessage.getError(), recommendData);
        }
    }

    public RecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f14606f = new a(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f14606f);
        this.f14607g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f14606f.setTag(bdUniqueId);
        registerListener(this.f14606f);
    }

    public void v() {
        if (!j.A()) {
            d.a.k0.i0.k.a aVar = this.f14605e;
            if (aVar != null) {
                aVar.f(-1, null);
            }
        } else if (this.f14607g) {
        } else {
            cancelLoadData();
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestRecommendMessage)) {
                this.f14607g = true;
            }
        }
    }

    public void w(d.a.k0.i0.k.a aVar) {
        this.f14605e = aVar;
    }
}
