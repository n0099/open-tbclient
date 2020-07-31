package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;
    private String entryName;
    private boolean fAT;
    private a fAU;
    private HttpMessageListener fAV;
    private boolean frd;
    private List<bv> fzn;
    private boolean hasMore;
    private String labelName;
    private String lat;
    private int liveCount;
    private String lng;
    private BdUniqueId mBdUniqueId;
    private List<q> mDatas;
    private int pn;
    private int ps;
    private String sortType;
    private List<String> sortTypeList;

    /* loaded from: classes4.dex */
    public interface a {
        void ao(int i, String str);

        void kq(boolean z);
    }

    static /* synthetic */ int e(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i = alaNewSquareSubListModel.pn;
        alaNewSquareSubListModel.pn = i + 1;
        return i;
    }

    public AlaNewSquareSubListModel(e eVar) {
        super(eVar);
        this.pn = 0;
        this.ps = 20;
        this.lng = "";
        this.lat = "";
        this.frd = false;
        this.fzn = new ArrayList();
        this.mDatas = new ArrayList();
        this.mBdUniqueId = BdUniqueId.gen();
        this.fAV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                    AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaNewSquareSubListModel.this.fAU != null) {
                                AlaNewSquareSubListModel.this.fAU.ao(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bv> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                        AlaNewSquareSubListModel.this.hasMore = alaNewSquareSubListResponseMessage.hasMore();
                        AlaNewSquareSubListModel.this.pn = alaNewSquareSubListRequestMessage.getPn();
                        if (AlaNewSquareSubListModel.this.pn == 0 || x.getCount(AlaNewSquareSubListModel.this.fzn) == 0) {
                            AlaNewSquareSubListModel.this.fzn.clear();
                            AlaNewSquareSubListModel.this.mDatas.clear();
                            AlaNewSquareSubListModel.this.fzn = liveList;
                            AlaNewSquareSubListModel.this.liveCount = alaNewSquareSubListResponseMessage.getLiveCount();
                            AlaNewSquareSubListModel.this.sortTypeList = alaNewSquareSubListResponseMessage.getSortTypeList();
                        } else if (x.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.bD(liveList);
                        }
                        AlaNewSquareSubListModel.e(AlaNewSquareSubListModel.this);
                        AlaNewSquareSubListModel.this.k(AlaNewSquareSubListModel.this.fzn, AlaNewSquareSubListModel.this.hasMore);
                        if (AlaNewSquareSubListModel.this.fAU != null) {
                            AlaNewSquareSubListModel.this.fAU.kq(AlaNewSquareSubListModel.this.hasMore);
                        }
                    }
                }
            }
        };
        setUniqueId(this.mBdUniqueId);
        this.fAV.setTag(this.mBdUniqueId);
        this.fAV.setSelfListener(true);
        registerListener(this.fAV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(List<bv> list) {
        boolean z;
        for (bv bvVar : list) {
            if (bvVar != null && bvVar.getThreadType() == 49) {
                String tid = bvVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bv> it = this.fzn.iterator();
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
                        this.fzn.add(bvVar);
                    }
                }
            }
        }
    }

    public void k(List<bv> list, boolean z) {
        if (!x.isEmpty(list)) {
            this.mDatas = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.fAT) {
                    com.baidu.tieba.ala.alasquare.subtablist.b.a aVar = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                    c cVar = new c();
                    cVar.frd = this.frd;
                    cVar.entryName = this.entryName;
                    cVar.labelName = this.labelName;
                    cVar.frb = list.get(i);
                    aVar.fts = cVar;
                    if (i + 1 < size) {
                        c cVar2 = new c();
                        cVar2.frd = this.frd;
                        cVar2.entryName = this.entryName;
                        cVar2.labelName = this.labelName;
                        cVar2.frb = list.get(i + 1);
                        aVar.ftt = cVar2;
                    }
                    this.mDatas.add(aVar);
                } else {
                    b bVar = new b();
                    c cVar3 = new c();
                    cVar3.frd = this.frd;
                    cVar3.entryName = this.entryName;
                    cVar3.labelName = this.labelName;
                    cVar3.frb = list.get(i);
                    bVar.fts = cVar3;
                    if (i + 1 < size) {
                        c cVar4 = new c();
                        cVar4.frd = this.frd;
                        cVar4.entryName = this.entryName;
                        cVar4.labelName = this.labelName;
                        cVar4.frb = list.get(i + 1);
                        bVar.ftt = cVar4;
                    }
                    this.mDatas.add(bVar);
                }
            }
        }
    }

    public void refreshData() {
        this.pn = 0;
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(this.pn);
        alaNewSquareSubListRequestMessage.setPs(this.ps);
        alaNewSquareSubListRequestMessage.setSortType(this.sortType);
        alaNewSquareSubListRequestMessage.setEntryName(this.entryName);
        alaNewSquareSubListRequestMessage.setLableName(this.labelName);
        alaNewSquareSubListRequestMessage.setLat(this.lat);
        alaNewSquareSubListRequestMessage.setLng(this.lng);
        alaNewSquareSubListRequestMessage.setHttpParams();
        sendMessage(alaNewSquareSubListRequestMessage);
    }

    public boolean bxZ() {
        if (!this.hasMore) {
            return false;
        }
        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
        alaNewSquareSubListRequestMessage.setPn(this.pn);
        alaNewSquareSubListRequestMessage.setPs(this.ps);
        alaNewSquareSubListRequestMessage.setSortType(this.sortType);
        alaNewSquareSubListRequestMessage.setEntryName(this.entryName);
        alaNewSquareSubListRequestMessage.setLableName(this.labelName);
        alaNewSquareSubListRequestMessage.setLat(this.lat);
        alaNewSquareSubListRequestMessage.setLng(this.lng);
        alaNewSquareSubListRequestMessage.setHttpParams();
        sendMessage(alaNewSquareSubListRequestMessage);
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

    public int getPn() {
        return this.pn;
    }

    public void setSortType(String str) {
        this.sortType = str;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setEntryName(String str) {
        this.entryName = str;
    }

    public void a(a aVar) {
        this.fAU = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public List<bv> bxQ() {
        return this.fzn;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortTypeList;
    }

    public void ks(boolean z) {
        this.fAT = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mBdUniqueId);
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void kt(boolean z) {
        this.frd = z;
    }
}
