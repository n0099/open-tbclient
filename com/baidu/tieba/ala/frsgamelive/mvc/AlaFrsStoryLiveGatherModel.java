package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private String forumId;
    private List<cb> gHt;
    private HttpMessageListener gJb;
    private boolean gWh;
    private List<cb> gWi;
    private List<n> gWj;
    private List<n> gWk;
    private int gWl;
    private a gWm;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List<cb> list, List<cb> list2) {
        this.gWj = cp(list);
        this.gWk = cp(list2);
        if (y.getCount(this.gWj) != 0 || y.getCount(this.gWk) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.gWj == null || this.gWj.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.gWh = false;
            } else {
                this.mDatas.addAll(this.gWj);
                this.gWh = true;
            }
            if (y.getCount(this.gWk) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < y.getCount(this.gWk); i++) {
                    if (this.gWk.get(i) != null) {
                        this.mDatas.add(this.gWk.get(i));
                    }
                }
            }
        }
    }

    public AlaFrsStoryLiveGatherModel(f fVar) {
        super(fVar);
        this.pn = 1;
        this.ps = 30;
        this.sortType = 1;
        this.gWl = 1;
        this.gJb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.gWm != null) {
                                AlaFrsStoryLiveGatherModel.this.gWm.aJ(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<cb> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<cb> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || y.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.gWl = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || y.getCount(AlaFrsStoryLiveGatherModel.this.gHt) == 0) {
                                AlaFrsStoryLiveGatherModel.this.gHt = liveList;
                            } else if (y.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.gHt = AlaFrsStoryLiveGatherModel.this.r(AlaFrsStoryLiveGatherModel.this.gHt, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = y.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.gHt = liveList;
                            AlaFrsStoryLiveGatherModel.this.gWi = recommandList;
                            AlaFrsStoryLiveGatherModel.this.gWl = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.s(AlaFrsStoryLiveGatherModel.this.gHt, AlaFrsStoryLiveGatherModel.this.gWi);
                        if (AlaFrsStoryLiveGatherModel.this.gWm != null) {
                            AlaFrsStoryLiveGatherModel.this.gWm.mK(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.gJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<cb> r(List<cb> list, List<cb> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (cb cbVar : list2) {
            if (cbVar != null && cbVar.getThreadType() == 49) {
                String tid = cbVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<cb> it = list.iterator();
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
                        linkedList.add(cbVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<n> cp(List<cb> list) {
        if (list == null || y.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.gXs = list.get(i);
            if (aVar.gXs.bnQ() != null) {
                TiebaStatic.log(new ar("c12549").dR("obj_param1", aVar.gXs.bnQ().getUserId()));
            }
            if (i + 1 < size) {
                aVar.gXt = list.get(i + 1);
                if (aVar.gXt.bnQ() != null) {
                    TiebaStatic.log(new ar("c12549").dR("obj_param1", aVar.gXt.bnQ().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gWl);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bSD() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gWl);
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
        this.gWm = aVar;
    }

    public List<n> getDatas() {
        return this.mDatas;
    }

    public boolean bVs() {
        return this.gWh;
    }

    public List<cb> bSw() {
        return this.gHt;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
