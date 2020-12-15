package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
    private String forumId;
    private boolean gMd;
    private List<by> gMe;
    private List<q> gMf;
    private List<q> gMg;
    private int gMh;
    private a gMi;
    private List<by> gxY;
    private HttpMessageListener gzG;
    private boolean hasMore;
    private int liveCount;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes6.dex */
    public interface a {
        void aC(int i, String str);

        void mn(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<by> list, List<by> list2) {
        this.gMf = cn(list);
        this.gMg = cn(list2);
        if (y.getCount(this.gMf) != 0 || y.getCount(this.gMg) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.gMf == null || this.gMf.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.gMd = false;
            } else {
                this.mDatas.addAll(this.gMf);
                this.gMd = true;
            }
            if (y.getCount(this.gMg) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < y.getCount(this.gMg); i++) {
                    if (this.gMg.get(i) != null) {
                        this.mDatas.add(this.gMg.get(i));
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
        this.gMh = 1;
        this.gzG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.gMi != null) {
                                AlaFrsStoryLiveGatherModel.this.gMi.aC(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<by> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<by> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || y.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.gMh = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || y.getCount(AlaFrsStoryLiveGatherModel.this.gxY) == 0) {
                                AlaFrsStoryLiveGatherModel.this.gxY = liveList;
                            } else if (y.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.gxY = AlaFrsStoryLiveGatherModel.this.q(AlaFrsStoryLiveGatherModel.this.gxY, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = y.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.gxY = liveList;
                            AlaFrsStoryLiveGatherModel.this.gMe = recommandList;
                            AlaFrsStoryLiveGatherModel.this.gMh = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.r(AlaFrsStoryLiveGatherModel.this.gxY, AlaFrsStoryLiveGatherModel.this.gMe);
                        if (AlaFrsStoryLiveGatherModel.this.gMi != null) {
                            AlaFrsStoryLiveGatherModel.this.gMi.mn(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.gzG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<by> q(List<by> list, List<by> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (by byVar : list2) {
            if (byVar != null && byVar.getThreadType() == 49) {
                String tid = byVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<by> it = list.iterator();
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
                        linkedList.add(byVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<q> cn(List<by> list) {
        if (list == null || y.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.gNq = list.get(i);
            if (aVar.gNq.boP() != null) {
                TiebaStatic.log(new ar("c12549").dY("obj_param1", aVar.gNq.boP().getUserId()));
            }
            if (i + 1 < size) {
                aVar.gNr = list.get(i + 1);
                if (aVar.gNr.boP() != null) {
                    TiebaStatic.log(new ar("c12549").dY("obj_param1", aVar.gNr.boP().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gMh);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bTg() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gMh);
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
        this.gMi = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public boolean bVS() {
        return this.gMd;
    }

    public List<by> bSZ() {
        return this.gxY;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
