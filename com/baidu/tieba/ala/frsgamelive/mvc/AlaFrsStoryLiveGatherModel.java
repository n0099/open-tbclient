package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
    private HttpMessageListener fAV;
    private boolean fLX;
    private List<bv> fLY;
    private List<q> fLZ;
    private List<q> fMa;
    private int fMb;
    private a fMc;
    private String forumId;
    private List<bv> fzn;
    private boolean hasMore;
    private int liveCount;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private int sortType;

    /* loaded from: classes4.dex */
    public interface a {
        void ao(int i, String str);

        void kq(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<bv> list, List<bv> list2) {
        this.fLZ = bJ(list);
        this.fMa = bJ(list2);
        if (x.getCount(this.fLZ) != 0 || x.getCount(this.fMa) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.fLZ == null || this.fLZ.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.fLX = false;
            } else {
                this.mDatas.addAll(this.fLZ);
                this.fLX = true;
            }
            if (x.getCount(this.fMa) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < x.getCount(this.fMa); i++) {
                    if (this.fMa.get(i) != null) {
                        this.mDatas.add(this.fMa.get(i));
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
        this.fMb = 1;
        this.fAV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.fMc != null) {
                                AlaFrsStoryLiveGatherModel.this.fMc.ao(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bv> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bv> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || x.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.fMb = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || x.getCount(AlaFrsStoryLiveGatherModel.this.fzn) == 0) {
                                AlaFrsStoryLiveGatherModel.this.fzn = liveList;
                            } else if (x.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.fzn = AlaFrsStoryLiveGatherModel.this.j(AlaFrsStoryLiveGatherModel.this.fzn, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = x.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.fzn = liveList;
                            AlaFrsStoryLiveGatherModel.this.fLY = recommandList;
                            AlaFrsStoryLiveGatherModel.this.fMb = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.k(AlaFrsStoryLiveGatherModel.this.fzn, AlaFrsStoryLiveGatherModel.this.fLY);
                        if (AlaFrsStoryLiveGatherModel.this.fMc != null) {
                            AlaFrsStoryLiveGatherModel.this.fMc.kq(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.fAV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bv> j(List<bv> list, List<bv> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bv bvVar : list2) {
            if (bvVar != null && bvVar.getThreadType() == 49) {
                String tid = bvVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bv> it = list.iterator();
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
                        linkedList.add(bvVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<q> bJ(List<bv> list) {
        if (list == null || x.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.fNk = list.get(i);
            if (aVar.fNk.aWl() != null) {
                TiebaStatic.log(new ap("c12549").dn("obj_param1", aVar.fNk.aWl().getUserId()));
            }
            if (i + 1 < size) {
                aVar.fNl = list.get(i + 1);
                if (aVar.fNl.aWl() != null) {
                    TiebaStatic.log(new ap("c12549").dn("obj_param1", aVar.fNl.aWl().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fMb);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean bxZ() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fMb);
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
        this.fMc = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public boolean bAt() {
        return this.fLX;
    }

    public List<bv> bxQ() {
        return this.fzn;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
