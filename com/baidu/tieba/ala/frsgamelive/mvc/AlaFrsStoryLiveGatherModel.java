package com.baidu.tieba.ala.frsgamelive.mvc;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bk;
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
    private List<bk> fiT;
    private HttpMessageListener fkB;
    private String forumId;
    private boolean fvs;
    private List<bk> fvt;
    private List<o> fvu;
    private List<o> fvv;
    private int fvw;
    private a fvx;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List<bk> list, List<bk> list2) {
        this.fvu = bw(list);
        this.fvv = bw(list2);
        if (v.getCount(this.fvu) != 0 || v.getCount(this.fvv) != 0) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            } else {
                this.mDatas.clear();
            }
            if (this.fvu == null || this.fvu.size() == 0) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.a());
                this.fvs = false;
            } else {
                this.mDatas.addAll(this.fvu);
                this.fvs = true;
            }
            if (v.getCount(this.fvv) > 0 && !this.hasMore) {
                this.mDatas.add(new com.baidu.tieba.ala.frsgamelive.b.b());
                for (int i = 0; i < 3 && i < v.getCount(this.fvv); i++) {
                    if (this.fvv.get(i) != null) {
                        this.mDatas.add(this.fvv.get(i));
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
        this.fvw = 1;
        this.fkB = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFrsStoryLiveGatherRespMessage)) {
                    AlaFrsStoryLiveGatherRespMessage alaFrsStoryLiveGatherRespMessage = (AlaFrsStoryLiveGatherRespMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaFrsStoryLiveGatherRequestMessage) {
                        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = (AlaFrsStoryLiveGatherRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaFrsStoryLiveGatherModel.this.fvx != null) {
                                AlaFrsStoryLiveGatherModel.this.fvx.al(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bk> liveList = alaFrsStoryLiveGatherRespMessage.getLiveList();
                        List<bk> recommandList = alaFrsStoryLiveGatherRespMessage.getRecommandList();
                        if (AlaFrsStoryLiveGatherModel.this.pn != 1 || v.getCount(liveList) > 10) {
                            AlaFrsStoryLiveGatherModel.this.fvw = 0;
                            AlaFrsStoryLiveGatherModel.this.hasMore = alaFrsStoryLiveGatherRespMessage.hasMore();
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = alaFrsStoryLiveGatherRespMessage.getLiveCount();
                            if (AlaFrsStoryLiveGatherModel.this.pn == 1 || v.getCount(AlaFrsStoryLiveGatherModel.this.fiT) == 0) {
                                AlaFrsStoryLiveGatherModel.this.fiT = liveList;
                            } else if (v.getCount(liveList) > 0) {
                                AlaFrsStoryLiveGatherModel.this.fiT = AlaFrsStoryLiveGatherModel.this.i(AlaFrsStoryLiveGatherModel.this.fiT, liveList);
                            }
                        } else {
                            AlaFrsStoryLiveGatherModel.this.hasMore = false;
                            AlaFrsStoryLiveGatherModel.this.pn = alaFrsStoryLiveGatherRequestMessage.getPn();
                            AlaFrsStoryLiveGatherModel.this.liveCount = v.getCount(liveList);
                            AlaFrsStoryLiveGatherModel.this.fiT = liveList;
                            AlaFrsStoryLiveGatherModel.this.fvt = recommandList;
                            AlaFrsStoryLiveGatherModel.this.fvw = 1;
                        }
                        AlaFrsStoryLiveGatherModel.this.j(AlaFrsStoryLiveGatherModel.this.fiT, AlaFrsStoryLiveGatherModel.this.fvt);
                        if (AlaFrsStoryLiveGatherModel.this.fvx != null) {
                            AlaFrsStoryLiveGatherModel.this.fvx.jz(AlaFrsStoryLiveGatherModel.this.hasMore);
                        }
                    }
                }
            }
        };
        registerListener(this.fkB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<bk> i(List<bk> list, List<bk> list2) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        for (bk bkVar : list2) {
            if (bkVar != null && bkVar.getThreadType() == 49) {
                String tid = bkVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bk> it = list.iterator();
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
                        linkedList.add(bkVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public List<o> bw(List<bk> list) {
        if (list == null || v.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            com.baidu.tieba.ala.gamelist.b.a aVar = new com.baidu.tieba.ala.gamelist.b.a();
            aVar.fwF = list.get(i);
            if (aVar.fwF.aQx() != null) {
                TiebaStatic.log(new an("c12549").dh("obj_param1", aVar.fwF.aQx().getUserId()));
            }
            if (i + 1 < size) {
                aVar.fwG = list.get(i + 1);
                if (aVar.fwG.aQx() != null) {
                    TiebaStatic.log(new an("c12549").dh("obj_param1", aVar.fwG.aQx().getUserId()));
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
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fvw);
        alaFrsStoryLiveGatherRequestMessage.setHttpParams();
        sendMessage(alaFrsStoryLiveGatherRequestMessage);
    }

    public boolean brT() {
        if (!this.hasMore) {
            return false;
        }
        AlaFrsStoryLiveGatherRequestMessage alaFrsStoryLiveGatherRequestMessage = new AlaFrsStoryLiveGatherRequestMessage();
        alaFrsStoryLiveGatherRequestMessage.setForumId(this.forumId);
        alaFrsStoryLiveGatherRequestMessage.setPn(this.pn + 1);
        alaFrsStoryLiveGatherRequestMessage.setPs(this.ps);
        alaFrsStoryLiveGatherRequestMessage.setSortType(this.sortType);
        alaFrsStoryLiveGatherRequestMessage.setNeedRecommend(this.fvw);
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
        this.fvx = aVar;
    }

    public List<o> getDatas() {
        return this.mDatas;
    }

    public boolean buh() {
        return this.fvs;
    }

    public List<bk> brK() {
        return this.fiT;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
