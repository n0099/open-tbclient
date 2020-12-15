package com.baidu.tieba.ala.alasquare.special_forum.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes6.dex */
public class SpecialConcernTabModel extends BdBaseModel {
    private a gxS;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener gxT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.pn == 1) {
                        SpecialConcernTabModel.this.gtw.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (y.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.pn == 1) {
                            SpecialConcernTabModel.this.gtw.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.mUserData = dVar.mUserData;
                            fVar.gxC = dVar.gxB;
                            fVar.gxD = false;
                            SpecialConcernTabModel.this.gtw.add(fVar);
                        }
                    }
                    if (!y.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!y.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.gxE = false;
                        } else {
                            gVar.gxE = true;
                        }
                        SpecialConcernTabModel.this.gtw.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.mUserData = dVar2.mUserData;
                            fVar2.gxC = dVar2.gxB;
                            fVar2.gxD = true;
                            SpecialConcernTabModel.this.gtw.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.c(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.gxS != null) {
                        SpecialConcernTabModel.this.gxS.d(SpecialConcernTabModel.this.gtw, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.gxS != null) {
                    SpecialConcernTabModel.this.gxS.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<q> gtw = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void d(List<q> list, boolean z, int i);

        void t(int i, String str);
    }

    static /* synthetic */ int c(SpecialConcernTabModel specialConcernTabModel) {
        int i = specialConcernTabModel.pn;
        specialConcernTabModel.pn = i + 1;
        return i;
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.gxT);
    }

    public void VC() {
        this.pn = 1;
        uY(1);
    }

    public void bSp() {
        uY(this.pn + 1);
    }

    private void uY(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gxT);
    }

    public void a(a aVar) {
        this.gxS = aVar;
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
