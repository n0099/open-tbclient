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
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f16273e;

    /* renamed from: f  reason: collision with root package name */
    public int f16274f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16275g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16276h;
    public HttpMessageListener j;
    public b k;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f16277i = BdUniqueId.gen();
    public d.a.j0.q0.u1.d.a l = new d.a.j0.q0.u1.d.a();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.f16277i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.f16276h);
                    }
                } else {
                    d.a.j0.q0.u1.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    AlaGameRecommendModel.this.f16275g = data.f58792a;
                    if (AlaGameRecommendModel.this.f16276h) {
                        AlaGameRecommendModel.z(AlaGameRecommendModel.this);
                    }
                    AlaGameRecommendModel.this.l.c(AlaGameRecommendModel.this.f16274f, data);
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.a(AlaGameRecommendModel.this.f16275g, AlaGameRecommendModel.this.l.a());
                    }
                }
                AlaGameRecommendModel.this.f16276h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaGameRecommendModel(String str, b bVar) {
        this.f16273e = str;
        this.k = bVar;
        E();
        registerListener();
    }

    public static /* synthetic */ int z(AlaGameRecommendModel alaGameRecommendModel) {
        int i2 = alaGameRecommendModel.f16274f;
        alaGameRecommendModel.f16274f = i2 + 1;
        return i2;
    }

    public boolean B() {
        return !ListUtils.isEmpty(this.l.a());
    }

    public void C() {
        this.f16276h = false;
        this.f16274f = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f16273e);
        httpMessage.addParam("recom_pn", this.f16274f);
        httpMessage.setTag(this.f16277i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void D() {
        if (!this.f16275g || this.f16276h) {
            return;
        }
        this.f16276h = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f16273e);
        httpMessage.addParam("recom_pn", this.f16274f + 1);
        httpMessage.setTag(this.f16277i);
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
