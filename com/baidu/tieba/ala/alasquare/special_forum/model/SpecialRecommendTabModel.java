package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.special_forum.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    private a gxV;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener gxR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.pn == 0) {
                        SpecialRecommendTabModel.this.mDatas.clear();
                        SpecialRecommendTabModel.this.gxW.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (y.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.ch(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel.this.ci(SpecialRecommendTabModel.this.gxW);
                    if (SpecialRecommendTabModel.this.pn == 0 && alaSpecialRecommendResponse.mSpecialActivityListData != null) {
                        SpecialRecommendTabModel.this.a(alaSpecialRecommendResponse.mSpecialActivityListData);
                    }
                    SpecialRecommendTabModel.d(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.gxV != null) {
                        SpecialRecommendTabModel.this.gxV.m(SpecialRecommendTabModel.this.mDatas, z);
                    }
                } else if (SpecialRecommendTabModel.this.gxV != null) {
                    SpecialRecommendTabModel.this.gxV.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<q> mDatas = new LinkedList();
    private List<by> gxW = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void m(List<q> list, boolean z);

        void t(int i, String str);
    }

    static /* synthetic */ int d(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.pn;
        specialRecommendTabModel.pn = i + 1;
        return i;
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.gxR);
    }

    public void VC() {
        this.pn = 0;
        uY(0);
    }

    public void bSo() {
        uY(this.pn);
    }

    private void uY(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("tab_name", "推荐");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && !y.isEmpty(cVar.gxy)) {
            if (y.getCount(this.mDatas) > 2) {
                this.mDatas.add(2, cVar);
            } else {
                this.mDatas.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<by> list) {
        boolean z;
        for (by byVar : list) {
            if (byVar != null && byVar.getThreadType() == 49) {
                String tid = byVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<by> it = this.gxW.iterator();
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
                        this.gxW.add(byVar);
                    }
                }
            }
        }
    }

    public void ci(List<by> list) {
        if (!y.isEmpty(list)) {
            this.mDatas = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                b bVar = new b();
                com.baidu.tieba.ala.alasquare.a.c cVar = new com.baidu.tieba.ala.alasquare.a.c();
                cVar.gpF = list.get(i);
                bVar.grU = cVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.c cVar2 = new com.baidu.tieba.ala.alasquare.a.c();
                    cVar2.gpF = list.get(i + 1);
                    bVar.grV = cVar2;
                }
                this.mDatas.add(bVar);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gxR);
    }

    public void a(a aVar) {
        this.gxV = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<by> bSY() {
        return this.gxW;
    }
}
