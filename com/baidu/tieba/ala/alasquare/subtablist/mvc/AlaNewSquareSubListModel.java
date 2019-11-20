package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;
    private List<bh> dBE;
    private boolean dCX;
    private a dCY;
    private HttpMessageListener dCZ;
    private boolean dus;
    private String entryName;
    private boolean hasMore;
    private String labelName;
    private String lat;
    private int liveCount;
    private String lng;
    private BdUniqueId mBdUniqueId;
    private List<m> mDatas;
    private int pn;
    private int ps;
    private String sortType;
    private List<String> sortTypeList;

    /* loaded from: classes6.dex */
    public interface a {
        void O(int i, String str);

        void gI(boolean z);
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
        this.dus = false;
        this.dBE = new ArrayList();
        this.mDatas = new ArrayList();
        this.mBdUniqueId = BdUniqueId.gen();
        this.dCZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                    AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaNewSquareSubListModel.this.dCY != null) {
                                AlaNewSquareSubListModel.this.dCY.O(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bh> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                        AlaNewSquareSubListModel.this.hasMore = alaNewSquareSubListResponseMessage.hasMore();
                        AlaNewSquareSubListModel.this.pn = alaNewSquareSubListRequestMessage.getPn();
                        if (AlaNewSquareSubListModel.this.pn == 0 || v.getCount(AlaNewSquareSubListModel.this.dBE) == 0) {
                            AlaNewSquareSubListModel.this.dBE.clear();
                            AlaNewSquareSubListModel.this.mDatas.clear();
                            AlaNewSquareSubListModel.this.dBE = liveList;
                            AlaNewSquareSubListModel.this.liveCount = alaNewSquareSubListResponseMessage.getLiveCount();
                            AlaNewSquareSubListModel.this.sortTypeList = alaNewSquareSubListResponseMessage.getSortTypeList();
                        } else if (v.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.bm(liveList);
                        }
                        AlaNewSquareSubListModel.e(AlaNewSquareSubListModel.this);
                        AlaNewSquareSubListModel.this.i(AlaNewSquareSubListModel.this.dBE, AlaNewSquareSubListModel.this.hasMore);
                        if (AlaNewSquareSubListModel.this.dCY != null) {
                            AlaNewSquareSubListModel.this.dCY.gI(AlaNewSquareSubListModel.this.hasMore);
                        }
                    }
                }
            }
        };
        setUniqueId(this.mBdUniqueId);
        this.dCZ.setTag(this.mBdUniqueId);
        this.dCZ.setSelfListener(true);
        registerListener(this.dCZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<bh> list) {
        boolean z;
        for (bh bhVar : list) {
            if (bhVar != null && bhVar.getThreadType() == 49) {
                String tid = bhVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bh> it = this.dBE.iterator();
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
                        this.dBE.add(bhVar);
                    }
                }
            }
        }
    }

    public void i(List<bh> list, boolean z) {
        if (!v.isEmpty(list)) {
            this.mDatas = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.dCX) {
                    com.baidu.tieba.ala.alasquare.subtablist.b.a aVar = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                    b bVar = new b();
                    bVar.dus = this.dus;
                    bVar.entryName = this.entryName;
                    bVar.labelName = this.labelName;
                    bVar.dur = list.get(i);
                    aVar.dwA = bVar;
                    if (i + 1 < size) {
                        b bVar2 = new b();
                        bVar2.dus = this.dus;
                        bVar2.entryName = this.entryName;
                        bVar2.labelName = this.labelName;
                        bVar2.dur = list.get(i + 1);
                        aVar.dwB = bVar2;
                    }
                    this.mDatas.add(aVar);
                } else {
                    com.baidu.tieba.ala.alasquare.subtablist.b.b bVar3 = new com.baidu.tieba.ala.alasquare.subtablist.b.b();
                    b bVar4 = new b();
                    bVar4.dus = this.dus;
                    bVar4.entryName = this.entryName;
                    bVar4.labelName = this.labelName;
                    bVar4.dur = list.get(i);
                    bVar3.dwA = bVar4;
                    if (i + 1 < size) {
                        b bVar5 = new b();
                        bVar5.dus = this.dus;
                        bVar5.entryName = this.entryName;
                        bVar5.labelName = this.labelName;
                        bVar5.dur = list.get(i + 1);
                        bVar3.dwB = bVar5;
                    }
                    this.mDatas.add(bVar3);
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

    public boolean aKn() {
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
        this.dCY = aVar;
    }

    public List<m> getDatas() {
        return this.mDatas;
    }

    public List<bh> aKe() {
        return this.dBE;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortTypeList;
    }

    public void gK(boolean z) {
        this.dCX = z;
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

    public void gL(boolean z) {
        this.dus = z;
    }
}
