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
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class RecommendModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.i0.k.a f15162e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f15163f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15164g;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecommendModel.this.f15164g = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || RecommendModel.this.unique_id != responsedMessage.getOrginalMessage().getTag() || RecommendModel.this.f15162e == null) {
                return;
            }
            d.b.j0.i0.k.c.a recommendData = responsedMessage instanceof ResponseHttpRecommendMessage ? ((ResponseHttpRecommendMessage) responsedMessage).getRecommendData() : null;
            if (responsedMessage instanceof ResponseSocketRecommendMessage) {
                recommendData = ((ResponseSocketRecommendMessage) responsedMessage).getRecommendData();
            }
            RecommendModel.this.f15162e.v(responsedMessage.getError(), recommendData);
        }
    }

    public RecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f15163f = new a(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
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
        MessageManager.getInstance().unRegisterListener(this.f15163f);
        this.f15164g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f15163f.setTag(bdUniqueId);
        registerListener(this.f15163f);
    }

    public void v() {
        if (!j.A()) {
            d.b.j0.i0.k.a aVar = this.f15162e;
            if (aVar != null) {
                aVar.v(-1, null);
            }
        } else if (this.f15164g) {
        } else {
            cancelLoadData();
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestRecommendMessage)) {
                this.f15164g = true;
            }
        }
    }

    public void w(d.b.j0.i0.k.a aVar) {
        this.f15162e = aVar;
    }
}
