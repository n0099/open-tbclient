package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
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
    private HttpMessageListener gJb;
    private int gPg;
    private boolean gVY;
    private a gVZ;
    private boolean hasMore;
    private int liveCount;
    private List<n> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes10.dex */
    public interface a {
        void aJ(int i, String str);

        void mK(boolean z);
    }

    public AlaFrsLiveModel(f fVar) {
        super(fVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.gPg = 1;
        this.gVY = false;
        this.gJb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                    AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsLiveModel.this.gVZ != null) {
                                AlaFrsLiveModel.this.gVZ.aJ(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<n> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                        if (AlaFrsLiveModel.this.mDatas == null) {
                            AlaFrsLiveModel.this.mDatas = new ArrayList();
                        }
                        if (AlaFrsLiveModel.this.pn != 1 || y.getCount(liveList) != 0 || AlaFrsLiveModel.this.gPg != 2) {
                            AlaFrsLiveModel.this.gVY = false;
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
                            List<n> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                            AlaFrsLiveModel.this.hasMore = false;
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = 0;
                            if (recommandList != null) {
                                AlaFrsLiveModel.this.mDatas.clear();
                                AlaFrsLiveModel.this.mDatas.addAll(recommandList);
                            }
                            AlaFrsLiveModel.this.gVY = true;
                        }
                        if (AlaFrsLiveModel.this.gVZ != null) {
                            AlaFrsLiveModel.this.gVZ.mK(AlaFrsLiveModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.gJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> r(List<n> list, List<n> list2) {
        cb cbVar;
        boolean z;
        cb cbVar2;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (n nVar : list2) {
            if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (cbVar = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eJQ) != null && cbVar.getThreadType() == 49) {
                String tid = cbVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<n> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        n next = it.next();
                        if (next != null && (next instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (cbVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) next).eJQ) != null && tid.equals(cbVar2.getTid())) {
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

    public boolean bSD() {
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
        this.gPg = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void a(a aVar) {
        this.gVZ = aVar;
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

    public boolean bVq() {
        return this.gVY;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
