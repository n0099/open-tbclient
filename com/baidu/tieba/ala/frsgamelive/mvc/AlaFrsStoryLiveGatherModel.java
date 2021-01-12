package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRequestMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaFrsStoryLiveGatherModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    public static final int SORT_TYPE_HOT = 1;
    public static final int SORT_TYPE_NEW = 2;
    private String forumId;
    private List<bz> gEv;
    private HttpMessageListener gGd;
    private boolean gTj;
    private List<bz> gTk;
    private List<n> gTl;
    private List<n> gTm;
    private int gTn;
    private a gTo;
    private boolean hasMore;
    private int liveCount;
    private List<n> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes9.dex */
    public interface a {
        void aF(int i, String str);

        void mG(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(List<bz> list, List<bz> list2) {
        this.gTl = cu(list);
        this.gTm = cu(list2);
        if (x.getCount(this.gTl) != 0 || x.getCount(this.gTm) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.gTl == null || this.gTl.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.gTj = false;
            } else {
                this.mDatas.addAll(this.gTl);
                this.gTj = true;
            }
            if (x.getCount(this.gTm) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < x.getCount(this.gTm); i++) {
                    if (this.gTm.get(i) != null) {
                        this.mDatas.add(this.gTm.get(i));
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
        this.gTn = 1;
        this.gGd = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.gTo != null) {
                                AlaFrsStoryLiveGatherModel.this.gTo.aF(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bz> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bz> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || x.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.gTn = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || x.getCount(AlaFrsStoryLiveGatherModel.this.gEv) == 0) {
                                AlaFrsStoryLiveGatherModel.this.gEv = liveList;
                            } else if (x.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.gEv = AlaFrsStoryLiveGatherModel.this.s(AlaFrsStoryLiveGatherModel.this.gEv, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = x.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.gEv = liveList;
                            AlaFrsStoryLiveGatherModel.this.gTk = recommandList;
                            AlaFrsStoryLiveGatherModel.this.gTn = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.t(AlaFrsStoryLiveGatherModel.this.gEv, AlaFrsStoryLiveGatherModel.this.gTk);
                        if (AlaFrsStoryLiveGatherModel.this.gTo != null) {
                            AlaFrsStoryLiveGatherModel.this.gTo.mG(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.gGd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bz> s(List<bz> list, List<bz> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bz bzVar : list2) {
            if (bzVar != null && bzVar.getThreadType() == 49) {
                String tid = bzVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bz> it = list.iterator();
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
                        linkedList.add(bzVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<n> cu(List<bz> list) {
        if (list == null || x.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.gUu = list.get(i);
            if (aVar.gUu.bnx() != null) {
                TiebaStatic.log(new aq("c12549").dW("obj_param1", aVar.gUu.bnx().getUserId()));
            }
            if (i + 1 < size) {
                aVar.gUv = list.get(i + 1);
                if (aVar.gUv.bnx() != null) {
                    TiebaStatic.log(new aq("c12549").dW("obj_param1", aVar.gUv.bnx().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gTn);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bRT() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.gTn);
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
        this.gTo = aVar;
    }

    public List<n> getDatas() {
        return this.mDatas;
    }

    public boolean bUG() {
        return this.gTj;
    }

    public List<bz> bRM() {
        return this.gEv;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
