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
    public b f14500f;

    /* renamed from: g  reason: collision with root package name */
    public int f14501g;

    /* renamed from: h  reason: collision with root package name */
    public int f14502h;
    public boolean i;
    public boolean j;
    public HttpMessageListener l;
    public BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.j0.t.d.e.b.b> f14499e = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021082 && (httpResponsedMessage instanceof AlaRecentHistoryResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaRecentHistoryModel.this.k) {
                AlaRecentHistoryResponseMessage alaRecentHistoryResponseMessage = (AlaRecentHistoryResponseMessage) httpResponsedMessage;
                if (!alaRecentHistoryResponseMessage.isSuccess()) {
                    if (AlaRecentHistoryModel.this.f14500f != null) {
                        AlaRecentHistoryModel.this.f14500f.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaRecentHistoryModel.this.j);
                    }
                } else {
                    d.b.j0.t.d.e.b.a recentHistoryData = alaRecentHistoryResponseMessage.getRecentHistoryData();
                    if (recentHistoryData == null) {
                        return;
                    }
                    AlaRecentHistoryModel.this.i = recentHistoryData.f62492a;
                    List<d.b.j0.t.d.e.b.b> list = recentHistoryData.f62493b;
                    if (!AlaRecentHistoryModel.this.j) {
                        AlaRecentHistoryModel.this.f14499e.clear();
                        if (!ListUtils.isEmpty(list)) {
                            AlaRecentHistoryModel.this.f14499e.addAll(list);
                        }
                    } else if (!ListUtils.isEmpty(list)) {
                        AlaRecentHistoryModel.x(AlaRecentHistoryModel.this);
                        AlaRecentHistoryModel.this.f14499e.addAll(list);
                    }
                    if (AlaRecentHistoryModel.this.f14500f != null) {
                        AlaRecentHistoryModel.this.f14500f.a(AlaRecentHistoryModel.this.i, AlaRecentHistoryModel.this.f14499e);
                    }
                }
                AlaRecentHistoryModel.this.j = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, List<d.b.j0.t.d.e.b.b> list);

        void b(int i, String str, boolean z);
    }

    public AlaRecentHistoryModel(TbPageContext tbPageContext, int i, b bVar) {
        this.f14501g = i;
        this.f14500f = bVar;
        registerListener();
        registerTask();
    }

    public static /* synthetic */ int x(AlaRecentHistoryModel alaRecentHistoryModel) {
        int i = alaRecentHistoryModel.f14502h;
        alaRecentHistoryModel.f14502h = i + 1;
        return i;
    }

    public void A() {
        if (!this.i || this.j) {
            return;
        }
        this.j = true;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("type", this.f14501g);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f14502h + 1);
        httpMessage.setTag(this.k);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void B() {
        this.j = false;
        this.f14502h = 0;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("type", this.f14501g);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f14502h);
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

    public List<d.b.j0.t.d.e.b.b> getData() {
        return this.f14499e;
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
