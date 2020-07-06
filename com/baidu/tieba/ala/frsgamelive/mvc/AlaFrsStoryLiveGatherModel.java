package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    private boolean fGC;
    private List<bu> fGD;
    private List<q> fGE;
    private List<q> fGF;
    private int fGG;
    private a fGH;
    private String forumId;
    private List<bu> fug;
    private HttpMessageListener fvO;
    private boolean hasMore;
    private int liveCount;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes3.dex */
    public interface a {
        void an(int i, String str);

        void jM(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<bu> list, List<bu> list2) {
        this.fGE = bF(list);
        this.fGF = bF(list2);
        if (w.getCount(this.fGE) != 0 || w.getCount(this.fGF) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.fGE == null || this.fGE.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.fGC = false;
            } else {
                this.mDatas.addAll(this.fGE);
                this.fGC = true;
            }
            if (w.getCount(this.fGF) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < w.getCount(this.fGF); i++) {
                    if (this.fGF.get(i) != null) {
                        this.mDatas.add(this.fGF.get(i));
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
        this.fGG = 1;
        this.fvO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.fGH != null) {
                                AlaFrsStoryLiveGatherModel.this.fGH.an(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bu> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bu> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || w.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.fGG = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || w.getCount(AlaFrsStoryLiveGatherModel.this.fug) == 0) {
                                AlaFrsStoryLiveGatherModel.this.fug = liveList;
                            } else if (w.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.fug = AlaFrsStoryLiveGatherModel.this.j(AlaFrsStoryLiveGatherModel.this.fug, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = w.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.fug = liveList;
                            AlaFrsStoryLiveGatherModel.this.fGD = recommandList;
                            AlaFrsStoryLiveGatherModel.this.fGG = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.k(AlaFrsStoryLiveGatherModel.this.fug, AlaFrsStoryLiveGatherModel.this.fGD);
                        if (AlaFrsStoryLiveGatherModel.this.fGH != null) {
                            AlaFrsStoryLiveGatherModel.this.fGH.jM(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.fvO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bu> j(List<bu> list, List<bu> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bu buVar : list2) {
            if (buVar != null && buVar.getThreadType() == 49) {
                String tid = buVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bu> it = list.iterator();
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
                        linkedList.add(buVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<q> bF(List<bu> list) {
        if (list == null || w.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.fHP = list.get(i);
            if (aVar.fHP.aSp() != null) {
                TiebaStatic.log(new ao("c12549").dk("obj_param1", aVar.fHP.aSp().getUserId()));
            }
            if (i + 1 < size) {
                aVar.fHQ = list.get(i + 1);
                if (aVar.fHQ.aSp() != null) {
                    TiebaStatic.log(new ao("c12549").dk("obj_param1", aVar.fHQ.aSp().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fGG);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean buQ() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fGG);
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
        this.fGH = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public boolean bxd() {
        return this.fGC;
    }

    public List<bu> buH() {
        return this.fug;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
