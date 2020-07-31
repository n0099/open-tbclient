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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.special_forum.data.d;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialConcernTabModel extends BdBaseModel {
    private a fzh;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener fzi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (SpecialConcernTabModel.this.pn == 1) {
                        SpecialConcernTabModel.this.fuL.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (x.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (SpecialConcernTabModel.this.pn == 1) {
                            SpecialConcernTabModel.this.fuL.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.mUserData = dVar.mUserData;
                            fVar.fyR = dVar.fyQ;
                            fVar.fyS = false;
                            SpecialConcernTabModel.this.fuL.add(fVar);
                        }
                    }
                    if (!x.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!x.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.fyT = false;
                        } else {
                            gVar.fyT = true;
                        }
                        SpecialConcernTabModel.this.fuL.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.mUserData = dVar2.mUserData;
                            fVar2.fyR = dVar2.fyQ;
                            fVar2.fyS = true;
                            SpecialConcernTabModel.this.fuL.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.c(SpecialConcernTabModel.this);
                    if (SpecialConcernTabModel.this.fzh != null) {
                        SpecialConcernTabModel.this.fzh.d(SpecialConcernTabModel.this.fuL, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (SpecialConcernTabModel.this.fzh != null) {
                    SpecialConcernTabModel.this.fzh.aB(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<q> fuL = new ArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void aB(int i, String str);

        void d(List<q> list, boolean z, int i);
    }

    static /* synthetic */ int c(SpecialConcernTabModel specialConcernTabModel) {
        int i = specialConcernTabModel.pn;
        specialConcernTabModel.pn = i + 1;
        return i;
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.fzi);
    }

    public void IH() {
        this.pn = 1;
        qr(1);
    }

    public void bxg() {
        qr(this.pn + 1);
    }

    private void qr(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzi);
    }

    public void a(a aVar) {
        this.fzh = aVar;
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
