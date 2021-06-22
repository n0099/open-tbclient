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
import d.a.c.k.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;

    /* renamed from: e  reason: collision with root package name */
    public String f15635e;

    /* renamed from: f  reason: collision with root package name */
    public int f15636f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15637g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15638h;
    public HttpMessageListener j;
    public b k;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f15639i = BdUniqueId.gen();
    public d.a.o0.r0.u1.d.a l = new d.a.o0.r0.u1.d.a();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.f15639i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.f15638h);
                    }
                } else {
                    d.a.o0.r0.u1.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    AlaGameRecommendModel.this.f15637g = data.f63491a;
                    if (AlaGameRecommendModel.this.f15638h) {
                        AlaGameRecommendModel.D(AlaGameRecommendModel.this);
                    }
                    AlaGameRecommendModel.this.l.c(AlaGameRecommendModel.this.f15636f, data);
                    if (AlaGameRecommendModel.this.k != null) {
                        AlaGameRecommendModel.this.k.a(AlaGameRecommendModel.this.f15637g, AlaGameRecommendModel.this.l.a());
                    }
                }
                AlaGameRecommendModel.this.f15638h = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaGameRecommendModel(String str, b bVar) {
        this.f15635e = str;
        this.k = bVar;
        G();
        registerListener();
    }

    public static /* synthetic */ int D(AlaGameRecommendModel alaGameRecommendModel) {
        int i2 = alaGameRecommendModel.f15636f;
        alaGameRecommendModel.f15636f = i2 + 1;
        return i2;
    }

    public void F() {
        this.f15638h = false;
        this.f15636f = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f15635e);
        httpMessage.addParam("recom_pn", this.f15636f);
        httpMessage.setTag(this.f15639i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void G() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean b() {
        return !ListUtils.isEmpty(this.l.a());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void loadMore() {
        if (!this.f15637g || this.f15638h) {
            return;
        }
        this.f15638h = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.f15635e);
        httpMessage.addParam("recom_pn", this.f15636f + 1);
        httpMessage.setTag(this.f15639i);
        MessageManager.getInstance().sendMessage(httpMessage);
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
