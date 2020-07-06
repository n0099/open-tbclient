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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;
    private String entryName;
    private boolean flU;
    private List<bu> fug;
    private boolean fvM;
    private a fvN;
    private HttpMessageListener fvO;
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

    /* loaded from: classes3.dex */
    public interface a {
        void an(int i, String str);

        void jM(boolean z);
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
        this.flU = false;
        this.fug = new ArrayList();
        this.mDatas = new ArrayList();
        this.mBdUniqueId = BdUniqueId.gen();
        this.fvO = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                    AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaNewSquareSubListModel.this.fvN != null) {
                                AlaNewSquareSubListModel.this.fvN.an(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bu> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                        AlaNewSquareSubListModel.this.hasMore = alaNewSquareSubListResponseMessage.hasMore();
                        AlaNewSquareSubListModel.this.pn = alaNewSquareSubListRequestMessage.getPn();
                        if (AlaNewSquareSubListModel.this.pn == 0 || w.getCount(AlaNewSquareSubListModel.this.fug) == 0) {
                            AlaNewSquareSubListModel.this.fug.clear();
                            AlaNewSquareSubListModel.this.mDatas.clear();
                            AlaNewSquareSubListModel.this.fug = liveList;
                            AlaNewSquareSubListModel.this.liveCount = alaNewSquareSubListResponseMessage.getLiveCount();
                            AlaNewSquareSubListModel.this.sortTypeList = alaNewSquareSubListResponseMessage.getSortTypeList();
                        } else if (w.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.bz(liveList);
                        }
                        AlaNewSquareSubListModel.e(AlaNewSquareSubListModel.this);
                        AlaNewSquareSubListModel.this.m(AlaNewSquareSubListModel.this.fug, AlaNewSquareSubListModel.this.hasMore);
                        if (AlaNewSquareSubListModel.this.fvN != null) {
                            AlaNewSquareSubListModel.this.fvN.jM(AlaNewSquareSubListModel.this.hasMore);
                        }
                    }
                }
            }
        };
        setUniqueId(this.mBdUniqueId);
        this.fvO.setTag(this.mBdUniqueId);
        this.fvO.setSelfListener(true);
        registerListener(this.fvO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(List<bu> list) {
        boolean z;
        for (bu buVar : list) {
            if (buVar != null && buVar.getThreadType() == 49) {
                String tid = buVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bu> it = this.fug.iterator();
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
                        this.fug.add(buVar);
                    }
                }
            }
        }
    }

    public void m(List<bu> list, boolean z) {
        if (!w.isEmpty(list)) {
            this.mDatas = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.fvM) {
                    com.baidu.tieba.ala.alasquare.subtablist.b.a aVar = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                    c cVar = new c();
                    cVar.flU = this.flU;
                    cVar.entryName = this.entryName;
                    cVar.labelName = this.labelName;
                    cVar.flT = list.get(i);
                    aVar.foi = cVar;
                    if (i + 1 < size) {
                        c cVar2 = new c();
                        cVar2.flU = this.flU;
                        cVar2.entryName = this.entryName;
                        cVar2.labelName = this.labelName;
                        cVar2.flT = list.get(i + 1);
                        aVar.foj = cVar2;
                    }
                    this.mDatas.add(aVar);
                } else {
                    b bVar = new b();
                    c cVar3 = new c();
                    cVar3.flU = this.flU;
                    cVar3.entryName = this.entryName;
                    cVar3.labelName = this.labelName;
                    cVar3.flT = list.get(i);
                    bVar.foi = cVar3;
                    if (i + 1 < size) {
                        c cVar4 = new c();
                        cVar4.flU = this.flU;
                        cVar4.entryName = this.entryName;
                        cVar4.labelName = this.labelName;
                        cVar4.flT = list.get(i + 1);
                        bVar.foj = cVar4;
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

    public boolean buQ() {
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
        this.fvN = aVar;
    }

    public List<q> getDatas() {
        return this.mDatas;
    }

    public List<bu> buH() {
        return this.fug;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortTypeList;
    }

    public void jO(boolean z) {
        this.fvM = z;
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

    public void jP(boolean z) {
        this.flU = z;
    }
}
