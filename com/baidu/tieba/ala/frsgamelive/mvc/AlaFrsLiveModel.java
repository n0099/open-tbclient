package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private HttpMessageListener fkq;
    private String forumGameLabel;
    private String forumId;
    private int fpq;
    private boolean fuY;
    private a fuZ;
    private boolean hasMore;
    private int liveCount;
    private List<o> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes3.dex */
    public interface a {
        void al(int i, String str);

        void jz(boolean z);
    }

    public AlaFrsLiveModel(e eVar) {
        super(eVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.fpq = 1;
        this.fuY = false;
        this.fkq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, true) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGameFrsLiveThreadsRespMessage)) {
                    AlaGameFrsLiveThreadsRespMessage alaGameFrsLiveThreadsRespMessage = (AlaGameFrsLiveThreadsRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaGameFrsLiveThreadsRequestMessage) {
                        AlaGameFrsLiveThreadsRequestMessage alaGameFrsLiveThreadsRequestMessage = (AlaGameFrsLiveThreadsRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsLiveModel.this.fuZ != null) {
                                AlaFrsLiveModel.this.fuZ.al(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<o> liveList = alaGameFrsLiveThreadsRespMessage.getLiveList();
                        if (AlaFrsLiveModel.this.mDatas == null) {
                            AlaFrsLiveModel.this.mDatas = new ArrayList();
                        }
                        if (AlaFrsLiveModel.this.pn != 1 || v.getCount(liveList) != 0 || AlaFrsLiveModel.this.fpq != 2) {
                            AlaFrsLiveModel.this.fuY = false;
                            AlaFrsLiveModel.this.hasMore = alaGameFrsLiveThreadsRespMessage.hasMore();
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = alaGameFrsLiveThreadsRespMessage.getLiveCount();
                            if (AlaFrsLiveModel.this.pn == 1 || v.getCount(AlaFrsLiveModel.this.mDatas) == 0) {
                                if (liveList != null) {
                                    AlaFrsLiveModel.this.mDatas.clear();
                                    AlaFrsLiveModel.this.mDatas.addAll(liveList);
                                }
                            } else if (v.getCount(liveList) > 0) {
                                AlaFrsLiveModel.this.mDatas = AlaFrsLiveModel.this.i(AlaFrsLiveModel.this.mDatas, liveList);
                            }
                        } else {
                            List<o> recommandList = alaGameFrsLiveThreadsRespMessage.getRecommandList();
                            AlaFrsLiveModel.this.hasMore = false;
                            AlaFrsLiveModel.this.pn = alaGameFrsLiveThreadsRequestMessage.getPn();
                            AlaFrsLiveModel.this.liveCount = 0;
                            if (recommandList != null) {
                                AlaFrsLiveModel.this.mDatas.clear();
                                AlaFrsLiveModel.this.mDatas.addAll(recommandList);
                            }
                            AlaFrsLiveModel.this.fuY = true;
                        }
                        if (AlaFrsLiveModel.this.fuZ != null) {
                            AlaFrsLiveModel.this.fuZ.jz(AlaFrsLiveModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.fkq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<o> i(List<o> list, List<o> list2) {
        bk bkVar;
        boolean z;
        bk bkVar2;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (o oVar : list2) {
            if (oVar != null && (oVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bkVar = ((com.baidu.tieba.ala.frsgamelive.b.c) oVar).dEA) != null && bkVar.getThreadType() == 49) {
                String tid = bkVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<o> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        o next = it.next();
                        if (next != null && (next instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bkVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) next).dEA) != null && tid.equals(bkVar2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        linkedList.add(oVar);
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

    public boolean brR() {
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
        this.fpq = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    public void a(a aVar) {
        this.fuZ = aVar;
    }

    public List<o> getData() {
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

    public boolean bue() {
        return this.fuY;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
