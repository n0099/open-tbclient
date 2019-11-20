package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private List<bh> dBE;
    private HttpMessageListener dCZ;
    private boolean dII;
    private List<bh> dIJ;
    private List<m> dIK;
    private List<m> dIL;
    private int dIM;
    private a dIN;
    private String forumId;
    private boolean hasMore;
    private int liveCount;
    private List<m> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes6.dex */
    public interface a {
        void O(int i, String str);

        void gI(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<bh> list, List<bh> list2) {
        this.dIK = br(list);
        this.dIL = br(list2);
        if (v.getCount(this.dIK) != 0 || v.getCount(this.dIL) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.dIK == null || this.dIK.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.dII = false;
            } else {
                this.mDatas.addAll(this.dIK);
                this.dII = true;
            }
            if (v.getCount(this.dIL) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < v.getCount(this.dIL); i++) {
                    if (this.dIL.get(i) != null) {
                        this.mDatas.add(this.dIL.get(i));
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
        this.dIM = 1;
        this.dCZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.dIN != null) {
                                AlaFrsStoryLiveGatherModel.this.dIN.O(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bh> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bh> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || v.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.dIM = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || v.getCount(AlaFrsStoryLiveGatherModel.this.dBE) == 0) {
                                AlaFrsStoryLiveGatherModel.this.dBE = liveList;
                            } else if (v.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.dBE = AlaFrsStoryLiveGatherModel.this.f(AlaFrsStoryLiveGatherModel.this.dBE, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = v.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.dBE = liveList;
                            AlaFrsStoryLiveGatherModel.this.dIJ = recommandList;
                            AlaFrsStoryLiveGatherModel.this.dIM = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.g(AlaFrsStoryLiveGatherModel.this.dBE, AlaFrsStoryLiveGatherModel.this.dIJ);
                        if (AlaFrsStoryLiveGatherModel.this.dIN != null) {
                            AlaFrsStoryLiveGatherModel.this.dIN.gI(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.dCZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bh> f(List<bh> list, List<bh> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bh bhVar : list2) {
            if (bhVar != null && bhVar.getThreadType() == 49) {
                String tid = bhVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bh> it = list.iterator();
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
                        linkedList.add(bhVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<m> br(List<bh> list) {
        if (list == null || v.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.dJV = list.get(i);
            if (aVar.dJV.aiE() != null) {
                TiebaStatic.log(new an("c12549").bS("obj_param1", aVar.dJV.aiE().getUserId()));
            }
            if (i + 1 < size) {
                aVar.dJW = list.get(i + 1);
                if (aVar.dJW.aiE() != null) {
                    TiebaStatic.log(new an("c12549").bS("obj_param1", aVar.dJW.aiE().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.dIM);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean aKn() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.dIM);
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
        this.dIN = aVar;
    }

    public List<m> getDatas() {
        return this.mDatas;
    }

    public boolean aKX() {
        return this.dII;
    }

    public List<bh> aKe() {
        return this.dBE;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
