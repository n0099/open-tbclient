package com.baidu.tieba.ala.alasquare.recent_history.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.recent_history.message.AlaRecentHistoryResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryModel extends BdBaseModel {

    /* renamed from: f  reason: collision with root package name */
    public b f13887f;

    /* renamed from: g  reason: collision with root package name */
    public int f13888g;

    /* renamed from: h  reason: collision with root package name */
    public int f13889h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13890i;
    public boolean j;
    public HttpMessageListener l;
    public BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.k0.t.d.e.b.b> f13886e = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021082 && (httpResponsedMessage instanceof AlaRecentHistoryResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaRecentHistoryModel.this.k) {
                AlaRecentHistoryResponseMessage alaRecentHistoryResponseMessage = (AlaRecentHistoryResponseMessage) httpResponsedMessage;
                if (!alaRecentHistoryResponseMessage.isSuccess()) {
                    if (AlaRecentHistoryModel.this.f13887f != null) {
                        AlaRecentHistoryModel.this.f13887f.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaRecentHistoryModel.this.j);
                    }
                } else {
                    d.a.k0.t.d.e.b.a recentHistoryData = alaRecentHistoryResponseMessage.getRecentHistoryData();
                    if (recentHistoryData == null) {
                        return;
                    }
                    AlaRecentHistoryModel.this.f13890i = recentHistoryData.f61403a;
                    List<d.a.k0.t.d.e.b.b> list = recentHistoryData.f61404b;
                    if (!AlaRecentHistoryModel.this.j) {
                        AlaRecentHistoryModel.this.f13886e.clear();
                        if (!ListUtils.isEmpty(list)) {
                            AlaRecentHistoryModel.this.f13886e.addAll(list);
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        AlaRecentHistoryModel.x(AlaRecentHistoryModel.this);
                        AlaRecentHistoryModel.this.f13886e.addAll(list);
                    }
                    if (AlaRecentHistoryModel.this.f13887f != null) {
                        AlaRecentHistoryModel.this.f13887f.a(AlaRecentHistoryModel.this.f13890i, AlaRecentHistoryModel.this.f13886e);
                    }
                }
                AlaRecentHistoryModel.this.j = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<d.a.k0.t.d.e.b.b> list);

        void b(int i2, String str, boolean z);
    }

    public AlaRecentHistoryModel(TbPageContext tbPageContext, int i2, b bVar) {
        this.f13888g = i2;
        this.f13887f = bVar;
        registerListener();
        registerTask();
    }

    public static /* synthetic */ int x(AlaRecentHistoryModel alaRecentHistoryModel) {
        int i2 = alaRecentHistoryModel.f13889h;
        alaRecentHistoryModel.f13889h = i2 + 1;
        return i2;
    }

    public void A() {
        if (!this.f13890i || this.j) {
            return;
        }
        this.j = true;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("type", this.f13888g);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f13889h + 1);
        httpMessage.setTag(this.k);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void B() {
        this.j = false;
        this.f13889h = 0;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("type", this.f13888g);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f13889h);
        httpMessage.setTag(this.k);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<d.a.k0.t.d.e.b.b> getData() {
        return this.f13886e;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void registerListener() {
        this.l = new a(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        MessageManager.getInstance().registerListener(this.l);
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_RECENT_HISTORY_LIST);
        tbHttpMessageTask.setResponsedClass(AlaRecentHistoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
