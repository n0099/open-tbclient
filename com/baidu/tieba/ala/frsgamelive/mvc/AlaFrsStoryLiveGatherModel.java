package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private List<bw> fNX;
    private HttpMessageListener fPF;
    private String forumId;
    private boolean gbn;
    private List<bw> gbo;
    private List<q> gbp;
    private List<q> gbq;
    private int gbr;
    private a gbs;
    private boolean hasMore;
    private int liveCount;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes4.dex */
    public interface a {
        void an(int i, String str);

        void kS(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(List<bw> list, List<bw> list2) {
        this.gbp = bP(list);
        this.gbq = bP(list2);
        if (y.getCount(this.gbp) != 0 || y.getCount(this.gbq) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.gbp == null || this.gbp.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.gbn = false;
            } else {
                this.mDatas.addAll(this.gbp);
                this.gbn = true;
            }
            if (y.getCount(this.gbq) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < y.getCount(this.gbq); i++) {
                    if (this.gbq.get(i) != null) {
                        this.mDatas.add(this.gbq.get(i));
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
        this.gbr = 1;
        this.fPF = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.gbs != null) {
                                AlaFrsStoryLiveGatherModel.this.gbs.an(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bw> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bw> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || y.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.gbr = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || y.getCount(AlaFrsStoryLiveGatherModel.this.fNX) == 0) {
                                AlaFrsStoryLiveGatherModel.this.fNX = liveList;
                            } else if (y.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.fNX = AlaFrsStoryLiveGatherModel.this.n(AlaFrsStoryLiveGatherModel.this.fNX, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = y.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.fNX = liveList;
                            AlaFrsStoryLiveGatherModel.this.gbo = recommandList;
                            AlaFrsStoryLiveGatherModel.this.gbr = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.o(AlaFrsStoryLiveGatherModel.this.fNX, AlaFrsStoryLiveGatherModel.this.gbo);
                        if (AlaFrsStoryLiveGatherModel.this.gbs != null) {
                            AlaFrsStoryLiveGatherModel.this.gbs.kS(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.fPF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bw> n(List<bw> list, List<bw> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bw bwVar : list2) {
            if (bwVar != null && bwVar.getThreadType() == 49) {
                String tid = bwVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bw> it = list.iterator();
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
                        linkedList.add(bwVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<q> bP(List<bw> list) {
        if (list == null || y.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.gcA = list.get(i);
            if (aVar.gcA.bfy() != null) {
                TiebaStatic.log(new aq("c12549").dF("obj_param1", aVar.gcA.bfy().getUserId()));
            }
            if (i + 1 < size) {
                aVar.gcB = list.get(i + 1);
                if (aVar.gcB.bfy() != null) {
                    TiebaStatic.log(new aq("c12549").dF("obj_param1", aVar.gcB.bfy().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gbr);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bIp() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gbr);
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
        this.gbs = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public boolean bKZ() {
        return this.gbn;
    }

    public List<bw> bIg() {
        return this.fNX;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
