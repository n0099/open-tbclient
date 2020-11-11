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
    private String forumId;
    private List<q> gDA;
    private int gDB;
    private a gDC;
    private boolean gDx;
    private List<bw> gDy;
    private List<q> gDz;
    private List<bw> gqg;
    private HttpMessageListener grO;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List<bw> list, List<bw> list2) {
        this.gDz = cj(list);
        this.gDA = cj(list2);
        if (y.getCount(this.gDz) != 0 || y.getCount(this.gDA) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.gDz == null || this.gDz.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.gDx = false;
            } else {
                this.mDatas.addAll(this.gDz);
                this.gDx = true;
            }
            if (y.getCount(this.gDA) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < y.getCount(this.gDA); i++) {
                    if (this.gDA.get(i) != null) {
                        this.mDatas.add(this.gDA.get(i));
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
        this.gDB = 1;
        this.grO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.gDC != null) {
                                AlaFrsStoryLiveGatherModel.this.gDC.aE(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bw> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bw> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || y.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.gDB = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || y.getCount(AlaFrsStoryLiveGatherModel.this.gqg) == 0) {
                                AlaFrsStoryLiveGatherModel.this.gqg = liveList;
                            } else if (y.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.gqg = AlaFrsStoryLiveGatherModel.this.r(AlaFrsStoryLiveGatherModel.this.gqg, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = y.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.gqg = liveList;
                            AlaFrsStoryLiveGatherModel.this.gDy = recommandList;
                            AlaFrsStoryLiveGatherModel.this.gDB = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.s(AlaFrsStoryLiveGatherModel.this.gqg, AlaFrsStoryLiveGatherModel.this.gDy);
                        if (AlaFrsStoryLiveGatherModel.this.gDC != null) {
                            AlaFrsStoryLiveGatherModel.this.gDC.lR(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.grO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bw> r(List<bw> list, List<bw> list2) {
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

    public List<q> cj(List<bw> list) {
        if (list == null || y.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.gEK = list.get(i);
            if (aVar.gEK.bmA() != null) {
                TiebaStatic.log(new aq("c12549").dR("obj_param1", aVar.gEK.bmA().getUserId()));
            }
            if (i + 1 < size) {
                aVar.gEL = list.get(i + 1);
                if (aVar.gEL.bmA() != null) {
                    TiebaStatic.log(new aq("c12549").dR("obj_param1", aVar.gEL.bmA().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gDB);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bQb() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gDB);
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
        this.gDC = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public boolean bSO() {
        return this.gDx;
    }

    public List<bw> bPU() {
        return this.gqg;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
