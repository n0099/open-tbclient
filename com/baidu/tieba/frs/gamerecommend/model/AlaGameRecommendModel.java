package com.baidu.tieba.frs.gamerecommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f16062e;

    /* renamed from: f  reason: collision with root package name */
    public int f16063f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16064g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16065h;
    public HttpMessageListener j;
    public b k;
    public BdUniqueId i = BdUniqueId.gen();
    public d.b.i0.q0.u1.d.a l = new d.b.i0.q0.u1.d.a();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.f16065h);
                    }
                } else {
                    d.b.i0.q0.u1.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    AlaGameRecommendModel.this.f16064g = data.f60264a;
                    if (AlaGameRecommendModel.this.f16065h) {
                        AlaGameRecommendModel.z(AlaGameRecommendModel.this);
                    }
                    AlaGameRecommendModel.this.l.c(AlaGameRecommendModel.this.f16063f, data);
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.a(AlaGameRecommendModel.this.f16064g, AlaGameRecommendModel.this.l.a());
                    }
                }
                AlaGameRecommendModel.this.f16065h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i, String str, boolean z);
    }

    public AlaGameRecommendModel(String str, b bVar) {
        this.f16062e = str;
        this.k = bVar;
        E();
        registerListener();
    }

    public static /* synthetic */ int z(AlaGameRecommendModel alaGameRecommendModel) {
        int i = alaGameRecommendModel.f16063f;
        alaGameRecommendModel.f16063f = i + 1;
        return i;
    }

    public boolean B() {
        return !ListUtils.isEmpty(this.l.a());
    }

    public void C() {
        this.f16065h = false;
        this.f16063f = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f16062e);
        httpMessage.addParam("recom_pn", this.f16063f);
        httpMessage.setTag(this.i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void D() {
        if (!this.f16064g || this.f16065h) {
            return;
        }
        this.f16065h = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f16062e);
        httpMessage.addParam("recom_pn", this.f16063f + 1);
        httpMessage.setTag(this.i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void E() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
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
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public final void registerListener() {
        this.j = new a(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        MessageManager.getInstance().registerListener(this.j);
    }
}
