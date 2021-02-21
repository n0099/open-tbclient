package com.baidu.tieba.ala.alasquare.special_forum.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.special_forum.data.d;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SpecialConcernTabModel extends BdBaseModel {
    private a gHn;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener gHo = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.pn == 1) {
                        SpecialConcernTabModel.this.gCM.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (y.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.pn == 1) {
                            SpecialConcernTabModel.this.gCM.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.mUserData = dVar.mUserData;
                            fVar.gGX = dVar.gGW;
                            fVar.gGY = false;
                            SpecialConcernTabModel.this.gCM.add(fVar);
                        }
                    }
                    if (!y.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!y.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.gGZ = false;
                        } else {
                            gVar.gGZ = true;
                        }
                        SpecialConcernTabModel.this.gCM.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.mUserData = dVar2.mUserData;
                            fVar2.gGX = dVar2.gGW;
                            fVar2.gGY = true;
                            SpecialConcernTabModel.this.gCM.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.c(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.gHn != null) {
                        SpecialConcernTabModel.this.gHn.d(SpecialConcernTabModel.this.gCM, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.gHn != null) {
                    SpecialConcernTabModel.this.gHn.A(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<n> gCM = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void A(int i, String str);

        void d(List<n> list, boolean z, int i);
    }

    static /* synthetic */ int c(SpecialConcernTabModel specialConcernTabModel) {
        int i = specialConcernTabModel.pn;
        specialConcernTabModel.pn = i + 1;
        return i;
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.gHo);
    }

    public void Ut() {
        this.pn = 1;
        loadData(1);
    }

    public void bRL() {
        loadData(this.pn + 1);
    }

    private void loadData(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gHo);
    }

    public void a(a aVar) {
        this.gHn = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
