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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.special_forum.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    private a dBD;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener dBz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.pn == 0) {
                        SpecialRecommendTabModel.this.mDatas.clear();
                        SpecialRecommendTabModel.this.dBE.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (v.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.bm(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel.this.bn(SpecialRecommendTabModel.this.dBE);
                    if (SpecialRecommendTabModel.this.pn == 0 && alaSpecialRecommendResponse.mSpecialActivityListData != null) {
                        SpecialRecommendTabModel.this.a(alaSpecialRecommendResponse.mSpecialActivityListData);
                    }
                    SpecialRecommendTabModel.d(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.dBD != null) {
                        SpecialRecommendTabModel.this.dBD.h(SpecialRecommendTabModel.this.mDatas, z);
                    }
                } else if (SpecialRecommendTabModel.this.dBD != null) {
                    SpecialRecommendTabModel.this.dBD.R(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<m> mDatas = new LinkedList();
    private List<bh> dBE = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void R(int i, String str);

        void h(List<m> list, boolean z);
    }

    static /* synthetic */ int d(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.pn;
        specialRecommendTabModel.pn = i + 1;
        return i;
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.dBz);
    }

    public void vV() {
        this.pn = 0;
        mf(0);
    }

    public void aJr() {
        mf(this.pn);
    }

    private void mf(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("tab_name", "推荐");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && !v.isEmpty(cVar.dBg)) {
            if (v.getCount(this.mDatas) > 2) {
                this.mDatas.add(2, cVar);
            } else {
                this.mDatas.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<bh> list) {
        boolean z;
        for (bh bhVar : list) {
            if (bhVar != null && bhVar.getThreadType() == 49) {
                String tid = bhVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bh> it = this.dBE.iterator();
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
                        this.dBE.add(bhVar);
                    }
                }
            }
        }
    }

    public void bn(List<bh> list) {
        if (!v.isEmpty(list)) {
            this.mDatas = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                b bVar = new b();
                com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                bVar2.dur = list.get(i);
                bVar.dwA = bVar2;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar3 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar3.dur = list.get(i + 1);
                    bVar.dwB = bVar3;
                }
                this.mDatas.add(bVar);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dBz);
    }

    public void a(a aVar) {
        this.dBD = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<bh> aKe() {
        return this.dBE;
    }
}
