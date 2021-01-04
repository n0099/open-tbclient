package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private String forumGameLabel;
    private String forumId;
    private HttpMessageListener gKJ;
    private int gQS;
    private boolean gXG;
    private a gXH;
    private boolean hasMore;
    private int liveCount;
    private List<n> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes10.dex */
    public interface a {
        void aE(int i, String str);

        void mK(boolean z);
    }

    public AlaFrsLiveModel(f fVar) {
        super(fVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.gQS = 1;
        this.gXG = false;
        this.gKJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                    AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsLiveModel.this.gXH != null) {
                                AlaFrsLiveModel.this.gXH.aE(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<n> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                        if (AlaFrsLiveModel.this.mDatas == null) {
                            AlaFrsLiveModel.this.mDatas = new ArrayList();
                        }
                        if (AlaFrsLiveModel.this.pn != 1 || x.getCount(liveList) != 0 || AlaFrsLiveModel.this.gQS != 2) {
                            AlaFrsLiveModel.this.gXG = false;
                            AlaFrsLiveModel.this.hasMore = alaGameFrsLiveThreadsRespMessage.hasMore();
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                            if (AlaFrsLiveModel.this.pn == 1 || x.getCount(AlaFrsLiveModel.this.mDatas) == 0) {
                                if (liveList != null) {
                                    AlaFrsLiveModel.this.mDatas.clear();
                                    AlaFrsLiveModel.this.mDatas.addAll(liveList);
                                }
                            } else if (x.getCount(liveList) > 0) {
                                AlaFrsLiveModel.this.mDatas = AlaFrsLiveModel.this.s(AlaFrsLiveModel.this.mDatas, liveList);
                            }
                        } else {
                            List<n> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                            AlaFrsLiveModel.this.hasMore = false;
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = 0;
                            if (recommandList != null) {
                                AlaFrsLiveModel.this.mDatas.clear();
                                AlaFrsLiveModel.this.mDatas.addAll(recommandList);
                            }
                            AlaFrsLiveModel.this.gXG = true;
                        }
                        if (AlaFrsLiveModel.this.gXH != null) {
                            AlaFrsLiveModel.this.gXH.mK(AlaFrsLiveModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.gKJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> s(List<n> list, List<n> list2) {
        bz bzVar;
        boolean z;
        bz bzVar2;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (n nVar : list2) {
            if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bzVar = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eMv) != null && bzVar.getThreadType() == 49) {
                String tid = bzVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<n> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        n next = it.next();
                        if (next != null && (next instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bzVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) next).eMv) != null && tid.equals(bzVar2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        linkedList.add(nVar);
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

    public boolean bVK() {
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
        this.gQS = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void a(a aVar) {
        this.gXH = aVar;
    }

    public List<n> getData() {
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

    public boolean bYw() {
        return this.gXG;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
