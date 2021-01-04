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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.special_forum.data.d;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SpecialConcernTabModel extends BdBaseModel {
    private a gIV;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener gIW = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.pn == 1) {
                        SpecialConcernTabModel.this.gEv.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (x.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.pn == 1) {
                            SpecialConcernTabModel.this.gEv.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.mUserData = dVar.mUserData;
                            fVar.gIF = dVar.gIE;
                            fVar.gIG = false;
                            SpecialConcernTabModel.this.gEv.add(fVar);
                        }
                    }
                    if (!x.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!x.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.gIH = false;
                        } else {
                            gVar.gIH = true;
                        }
                        SpecialConcernTabModel.this.gEv.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.mUserData = dVar2.mUserData;
                            fVar2.gIF = dVar2.gIE;
                            fVar2.gIG = true;
                            SpecialConcernTabModel.this.gEv.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.c(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.gIV != null) {
                        SpecialConcernTabModel.this.gIV.d(SpecialConcernTabModel.this.gEv, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.gIV != null) {
                    SpecialConcernTabModel.this.gIV.v(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<n> gEv = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void d(List<n> list, boolean z, int i);

        void v(int i, String str);
    }

    static /* synthetic */ int c(SpecialConcernTabModel specialConcernTabModel) {
        int i = specialConcernTabModel.pn;
        specialConcernTabModel.pn = i + 1;
        return i;
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.gIW);
    }

    public void WE() {
        this.pn = 1;
        loadData(1);
    }

    public void bUR() {
        loadData(this.pn + 1);
    }

    private void loadData(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gIW);
    }

    public void a(a aVar) {
        this.gIV = aVar;
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
