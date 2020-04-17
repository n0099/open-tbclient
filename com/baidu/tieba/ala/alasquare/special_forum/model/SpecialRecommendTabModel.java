package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.special_forum.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    private a eVS;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener eVO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.pn == 0) {
                        SpecialRecommendTabModel.this.mDatas.clear();
                        SpecialRecommendTabModel.this.eVT.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (v.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.bv(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel.this.bw(SpecialRecommendTabModel.this.eVT);
                    if (SpecialRecommendTabModel.this.pn == 0 && alaSpecialRecommendResponse.mSpecialActivityListData != null) {
                        SpecialRecommendTabModel.this.a(alaSpecialRecommendResponse.mSpecialActivityListData);
                    }
                    SpecialRecommendTabModel.d(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.eVS != null) {
                        SpecialRecommendTabModel.this.eVS.l(SpecialRecommendTabModel.this.mDatas, z);
                    }
                } else if (SpecialRecommendTabModel.this.eVS != null) {
                    SpecialRecommendTabModel.this.eVS.as(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<m> mDatas = new LinkedList();
    private List<bj> eVT = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void as(int i, String str);

        void l(List<m> list, boolean z);
    }

    static /* synthetic */ int d(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.pn;
        specialRecommendTabModel.pn = i + 1;
        return i;
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.eVO);
    }

    public void FH() {
        this.pn = 0;
        pa(0);
    }

    public void blB() {
        pa(this.pn);
    }

    private void pa(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("tab_name", "推荐");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && !v.isEmpty(cVar.eVv)) {
            if (v.getCount(this.mDatas) > 2) {
                this.mDatas.add(2, cVar);
            } else {
                this.mDatas.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(List<bj> list) {
        boolean z;
        for (bj bjVar : list) {
            if (bjVar != null && bjVar.getThreadType() == 49) {
                String tid = bjVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bj> it = this.eVT.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (tid.equals(it.next().getTid())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.eVT.add(bjVar);
                    }
                }
            }
        }
    }

    public void bw(List<bj> list) {
        if (!v.isEmpty(list)) {
            this.mDatas = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                b bVar = new b();
                com.baidu.tieba.ala.alasquare.a.c cVar = new com.baidu.tieba.ala.alasquare.a.c();
                cVar.eNM = list.get(i);
                bVar.ePZ = cVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.c cVar2 = new com.baidu.tieba.ala.alasquare.a.c();
                    cVar2.eNM = list.get(i + 1);
                    bVar.eQa = cVar2;
                }
                this.mDatas.add(bVar);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eVO);
    }

    public void a(a aVar) {
        this.eVS = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<bj> bmm() {
        return this.eVT;
    }
}
