package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
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
    private a fiH;
    private TbPageContext mTbPageContext;
    private int pn = 1;
    private HttpMessageListener fiD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB) { // from class: com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (SpecialRecommendTabModel.this.pn == 0) {
                        SpecialRecommendTabModel.this.mDatas.clear();
                        SpecialRecommendTabModel.this.fiI.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (v.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        SpecialRecommendTabModel.this.bq(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel.this.br(SpecialRecommendTabModel.this.fiI);
                    if (SpecialRecommendTabModel.this.pn == 0 && alaSpecialRecommendResponse.mSpecialActivityListData != null) {
                        SpecialRecommendTabModel.this.a(alaSpecialRecommendResponse.mSpecialActivityListData);
                    }
                    SpecialRecommendTabModel.d(SpecialRecommendTabModel.this);
                    if (SpecialRecommendTabModel.this.fiH != null) {
                        SpecialRecommendTabModel.this.fiH.l(SpecialRecommendTabModel.this.mDatas, z);
                    }
                } else if (SpecialRecommendTabModel.this.fiH != null) {
                    SpecialRecommendTabModel.this.fiH.ax(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private List<o> mDatas = new LinkedList();
    private List<bk> fiI = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void ax(int i, String str);

        void l(List<o> list, boolean z);
    }

    static /* synthetic */ int d(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.pn;
        specialRecommendTabModel.pn = i + 1;
        return i;
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.fiD);
    }

    public void Ho() {
        this.pn = 0;
        pB(0);
    }

    public void bqX() {
        pB(this.pn);
    }

    private void pB(int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("tab_name", "推荐");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && !v.isEmpty(cVar.fij)) {
            if (v.getCount(this.mDatas) > 2) {
                this.mDatas.add(2, cVar);
            } else {
                this.mDatas.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(List<bk> list) {
        boolean z;
        for (bk bkVar : list) {
            if (bkVar != null && bkVar.getThreadType() == 49) {
                String tid = bkVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bk> it = this.fiI.iterator();
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
                        this.fiI.add(bkVar);
                    }
                }
            }
        }
    }

    public void br(List<bk> list) {
        if (!v.isEmpty(list)) {
            this.mDatas = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                b bVar = new b();
                com.baidu.tieba.ala.alasquare.a.c cVar = new com.baidu.tieba.ala.alasquare.a.c();
                cVar.fay = list.get(i);
                bVar.fcN = cVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.c cVar2 = new com.baidu.tieba.ala.alasquare.a.c();
                    cVar2.fay = list.get(i + 1);
                    bVar.fcO = cVar2;
                }
                this.mDatas.add(bVar);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fiD);
    }

    public void a(a aVar) {
        this.fiH = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<bk> brI() {
        return this.fiI;
    }
}
