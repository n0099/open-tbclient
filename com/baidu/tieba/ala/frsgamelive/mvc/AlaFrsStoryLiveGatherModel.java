package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private boolean eCq;
    private List<bj> eCr;
    private List<m> eCs;
    private List<m> eCt;
    private int eCu;
    private a eCv;
    private List<bj> erN;
    private HttpMessageListener etw;
    private String forumId;
    private boolean hasMore;
    private int liveCount;
    private List<m> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes3.dex */
    public interface a {
        void ag(int i, String str);

        void ie(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<bj> list, List<bj> list2) {
        this.eCs = bq(list);
        this.eCt = bq(list2);
        if (v.getCount(this.eCs) != 0 || v.getCount(this.eCt) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.eCs == null || this.eCs.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.eCq = false;
            } else {
                this.mDatas.addAll(this.eCs);
                this.eCq = true;
            }
            if (v.getCount(this.eCt) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < v.getCount(this.eCt); i++) {
                    if (this.eCt.get(i) != null) {
                        this.mDatas.add(this.eCt.get(i));
                    }
                }
            }
        }
    }

    public AlaFrsStoryLiveGatherModel(e eVar) {
        super(eVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.eCu = 1;
        this.etw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.eCv != null) {
                                AlaFrsStoryLiveGatherModel.this.eCv.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bj> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bj> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || v.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.eCu = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || v.getCount(AlaFrsStoryLiveGatherModel.this.erN) == 0) {
                                AlaFrsStoryLiveGatherModel.this.erN = liveList;
                            } else if (v.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.erN = AlaFrsStoryLiveGatherModel.this.h(AlaFrsStoryLiveGatherModel.this.erN, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = v.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.erN = liveList;
                            AlaFrsStoryLiveGatherModel.this.eCr = recommandList;
                            AlaFrsStoryLiveGatherModel.this.eCu = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.i(AlaFrsStoryLiveGatherModel.this.erN, AlaFrsStoryLiveGatherModel.this.eCr);
                        if (AlaFrsStoryLiveGatherModel.this.eCv != null) {
                            AlaFrsStoryLiveGatherModel.this.eCv.ie(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.etw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bj> h(List<bj> list, List<bj> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bj bjVar : list2) {
            if (bjVar != null && bjVar.getThreadType() == 49) {
                String tid = bjVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bj> it = list.iterator();
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
                        linkedList.add(bjVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<m> bq(List<bj> list) {
        if (list == null || v.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.eDD = list.get(i);
            if (aVar.eDD.aCm() != null) {
                TiebaStatic.log(new an("c12549").cy("obj_param1", aVar.eDD.aCm().getUserId()));
            }
            if (i + 1 < size) {
                aVar.eDE = list.get(i + 1);
                if (aVar.eDE.aCm() != null) {
                    TiebaStatic.log(new an("c12549").cy("obj_param1", aVar.eDE.aCm().getUserId()));
                }
            }
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public void refreshData() {
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.eCu);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bdw() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.eCu);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void a(a aVar) {
        this.eCv = aVar;
    }

    public List<m> getDatas() {
        return this.mDatas;
    }

    public boolean beR() {
        return this.eCq;
    }

    public List<bj> bdn() {
        return this.erN;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
