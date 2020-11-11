package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private String forumGameLabel;
    private String forumId;
    private boolean gDo;
    private a gDp;
    private HttpMessageListener grO;
    private int gwN;
    private boolean hasMore;
    private int liveCount;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes4.dex */
    public interface a {
        void aE(int i, String str);

        void lR(boolean z);
    }

    public AlaFrsLiveModel(e eVar) {
        super(eVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.gwN = 1;
        this.gDo = false;
        this.grO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                    AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsLiveModel.this.gDp != null) {
                                AlaFrsLiveModel.this.gDp.aE(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<q> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                        if (AlaFrsLiveModel.this.mDatas == null) {
                            AlaFrsLiveModel.this.mDatas = new ArrayList();
                        }
                        if (AlaFrsLiveModel.this.pn != 1 || y.getCount(liveList) != 0 || AlaFrsLiveModel.this.gwN != 2) {
                            AlaFrsLiveModel.this.gDo = false;
                            AlaFrsLiveModel.this.hasMore = alaGameFrsLiveThreadsRespMessage.hasMore();
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                            if (AlaFrsLiveModel.this.pn == 1 || y.getCount(AlaFrsLiveModel.this.mDatas) == 0) {
                                if (liveList != null) {
                                    AlaFrsLiveModel.this.mDatas.clear();
                                    AlaFrsLiveModel.this.mDatas.addAll(liveList);
                                }
                            } else if (y.getCount(liveList) > 0) {
                                AlaFrsLiveModel.this.mDatas = AlaFrsLiveModel.this.r(AlaFrsLiveModel.this.mDatas, liveList);
                            }
                        } else {
                            List<q> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                            AlaFrsLiveModel.this.hasMore = false;
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = 0;
                            if (recommandList != null) {
                                AlaFrsLiveModel.this.mDatas.clear();
                                AlaFrsLiveModel.this.mDatas.addAll(recommandList);
                            }
                            AlaFrsLiveModel.this.gDo = true;
                        }
                        if (AlaFrsLiveModel.this.gDp != null) {
                            AlaFrsLiveModel.this.gDp.lR(AlaFrsLiveModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.grO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> r(List<q> list, List<q> list2) {
        bw bwVar;
        boolean z;
        bw bwVar2;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (q qVar : list2) {
            if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).exA) != null && bwVar.getThreadType() == 49) {
                String tid = bwVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<q> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        q next = it.next();
                        if (next != null && (next instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) next).exA) != null && tid.equals(bwVar2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        linkedList.add(qVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public void refreshData() {
        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
        alaGameFrsLiveThreadsRequestMessage.setForumId(this.forumId);
        alaGameFrsLiveThreadsRequestMessage.setPn(1);
        alaGameFrsLiveThreadsRequestMessage.setPs(this.ps);
        alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.forumGameLabel);
        alaGameFrsLiveThreadsRequestMessage.setSortType(this.sortType);
        alaGameFrsLiveThreadsRequestMessage.setHttpParams();
        sendMessage(alaGameFrsLiveThreadsRequestMessage);
    }

    public boolean bQb() {
        if (!this.hasMore) {
            return false;
        }
        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = new AlaGameFrsLiveThreadsRequestMessage();
        alaGameFrsLiveThreadsRequestMessage.setForumId(this.forumId);
        alaGameFrsLiveThreadsRequestMessage.setPn(this.pn + 1);
        alaGameFrsLiveThreadsRequestMessage.setPs(this.ps);
        alaGameFrsLiveThreadsRequestMessage.setForumGameLabel(this.forumGameLabel);
        alaGameFrsLiveThreadsRequestMessage.setSortType(this.sortType);
        alaGameFrsLiveThreadsRequestMessage.setHttpParams();
        sendMessage(alaGameFrsLiveThreadsRequestMessage);
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

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void setFromType(int i) {
        this.gwN = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void a(a aVar) {
        this.gDp = aVar;
    }

    public List<q> getData() {
        return this.mDatas;
    }

    public void clearData() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public boolean bSN() {
        return this.gDo;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
