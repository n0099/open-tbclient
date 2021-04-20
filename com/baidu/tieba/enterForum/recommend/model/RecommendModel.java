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
    public d.b.i0.i0.k.a f15154e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f15155f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15156g;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RecommendModel.this.f15156g = false;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || RecommendModel.this.unique_id != responsedMessage.getOrginalMessage().getTag() || RecommendModel.this.f15154e == null) {
                return;
            }
            d.b.i0.i0.k.c.a recommendData = responsedMessage instanceof ResponseHttpRecommendMessage ? ((ResponseHttpRecommendMessage) responsedMessage).getRecommendData() : null;
            if (responsedMessage instanceof ResponseSocketRecommendMessage) {
                recommendData = ((ResponseSocketRecommendMessage) responsedMessage).getRecommendData();
            }
            RecommendModel.this.f15154e.v(responsedMessage.getError(), recommendData);
        }
    }

    public RecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f15155f = new a(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
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
        MessageManager.getInstance().unRegisterListener(this.f15155f);
        this.f15156g = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f15155f.setTag(bdUniqueId);
        registerListener(this.f15155f);
    }

    public void v() {
        if (!j.A()) {
            d.b.i0.i0.k.a aVar = this.f15154e;
            if (aVar != null) {
                aVar.v(-1, null);
            }
        } else if (this.f15156g) {
        } else {
            cancelLoadData();
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestRecommendMessage)) {
                this.f15156g = true;
            }
        }
    }

    public void w(d.b.i0.i0.k.a aVar) {
        this.f15154e = aVar;
    }
}
