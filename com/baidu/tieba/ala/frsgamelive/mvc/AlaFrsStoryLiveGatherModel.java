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
    private boolean eDa;
    private List<bj> eDb;
    private List<m> eDc;
    private List<m> eDd;
    private int eDe;
    private a eDf;
    private List<bj> esx;
    private HttpMessageListener eug;
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

        void ig(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<bj> list, List<bj> list2) {
        this.eDc = bq(list);
        this.eDd = bq(list2);
        if (v.getCount(this.eDc) != 0 || v.getCount(this.eDd) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.eDc == null || this.eDc.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.eDa = false;
            } else {
                this.mDatas.addAll(this.eDc);
                this.eDa = true;
            }
            if (v.getCount(this.eDd) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < v.getCount(this.eDd); i++) {
                    if (this.eDd.get(i) != null) {
                        this.mDatas.add(this.eDd.get(i));
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
        this.eDe = 1;
        this.eug = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.eDf != null) {
                                AlaFrsStoryLiveGatherModel.this.eDf.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bj> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bj> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || v.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.eDe = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || v.getCount(AlaFrsStoryLiveGatherModel.this.esx) == 0) {
                                AlaFrsStoryLiveGatherModel.this.esx = liveList;
                            } else if (v.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.esx = AlaFrsStoryLiveGatherModel.this.h(AlaFrsStoryLiveGatherModel.this.esx, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = v.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.esx = liveList;
                            AlaFrsStoryLiveGatherModel.this.eDb = recommandList;
                            AlaFrsStoryLiveGatherModel.this.eDe = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.i(AlaFrsStoryLiveGatherModel.this.esx, AlaFrsStoryLiveGatherModel.this.eDb);
                        if (AlaFrsStoryLiveGatherModel.this.eDf != null) {
                            AlaFrsStoryLiveGatherModel.this.eDf.ig(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.eug);
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
            aVar.eEn = list.get(i);
            if (aVar.eEn.aCr() != null) {
                TiebaStatic.log(new an("c12549").cx("obj_param1", aVar.eEn.aCr().getUserId()));
            }
            if (i + 1 < size) {
                aVar.eEo = list.get(i + 1);
                if (aVar.eEo.aCr() != null) {
                    TiebaStatic.log(new an("c12549").cx("obj_param1", aVar.eEo.aCr().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.eDe);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bdE() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.eDe);
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
        this.eDf = aVar;
    }

    public List<m> getDatas() {
        return this.mDatas;
    }

    public boolean beZ() {
        return this.eDa;
    }

    public List<bj> bdv() {
        return this.esx;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
