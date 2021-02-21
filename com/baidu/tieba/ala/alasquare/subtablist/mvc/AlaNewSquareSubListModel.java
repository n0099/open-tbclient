package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;
    private String entryName;
    private List<cb> gHt;
    private boolean gIZ;
    private a gJa;
    private HttpMessageListener gJb;
    private boolean gyW;
    private boolean hasMore;
    private String labelName;
    private String lat;
    private int liveCount;
    private String lng;
    private BdUniqueId mBdUniqueId;
    private List<n> mDatas;
    private int pn;
    private int ps;
    private String sortType;
    private List<String> sortTypeList;

    /* loaded from: classes10.dex */
    public interface a {
        void aJ(int i, String str);

        void mK(boolean z);
    }

    static /* synthetic */ int e(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i = alaNewSquareSubListModel.pn;
        alaNewSquareSubListModel.pn = i + 1;
        return i;
    }

    public AlaNewSquareSubListModel(f fVar) {
        super(fVar);
        this.pn = 0;
        this.ps = 20;
        this.lng = "";
        this.lat = "";
        this.gyW = false;
        this.gHt = new ArrayList();
        this.mDatas = new ArrayList();
        this.mBdUniqueId = BdUniqueId.gen();
        this.gJb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                    AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaNewSquareSubListModel.this.gJa != null) {
                                AlaNewSquareSubListModel.this.gJa.aJ(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<cb> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                        AlaNewSquareSubListModel.this.hasMore = alaNewSquareSubListResponseMessage.hasMore();
                        AlaNewSquareSubListModel.this.pn = alaNewSquareSubListRequestMessage.getPn();
                        if (AlaNewSquareSubListModel.this.pn == 0 || y.getCount(AlaNewSquareSubListModel.this.gHt) == 0) {
                            AlaNewSquareSubListModel.this.gHt.clear();
                            AlaNewSquareSubListModel.this.mDatas.clear();
                            AlaNewSquareSubListModel.this.gHt = liveList;
                            AlaNewSquareSubListModel.this.liveCount = alaNewSquareSubListResponseMessage.getLiveCount();
                            AlaNewSquareSubListModel.this.sortTypeList = alaNewSquareSubListResponseMessage.getSortTypeList();
                        } else if (y.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.cj(liveList);
                        }
                        AlaNewSquareSubListModel.e(AlaNewSquareSubListModel.this);
                        AlaNewSquareSubListModel.this.n(AlaNewSquareSubListModel.this.gHt, AlaNewSquareSubListModel.this.hasMore);
                        if (AlaNewSquareSubListModel.this.gJa != null) {
                            AlaNewSquareSubListModel.this.gJa.mK(AlaNewSquareSubListModel.this.hasMore);
                        }
                    }
                }
            }
        };
        setUniqueId(this.mBdUniqueId);
        this.gJb.setTag(this.mBdUniqueId);
        this.gJb.setSelfListener(true);
        registerListener(this.gJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(List<cb> list) {
        boolean z;
        for (cb cbVar : list) {
            if (cbVar != null && cbVar.getThreadType() == 49) {
                String tid = cbVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<cb> it = this.gHt.iterator();
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
                        this.gHt.add(cbVar);
                    }
                }
            }
        }
    }

    public void n(List<cb> list, boolean z) {
        if (!y.isEmpty(list)) {
            this.mDatas = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.gIZ) {
                    com.baidu.tieba.ala.alasquare.subtablist.b.a aVar = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                    e eVar = new e();
                    eVar.gyW = this.gyW;
                    eVar.entryName = this.entryName;
                    eVar.labelName = this.labelName;
                    eVar.gyO = list.get(i);
                    aVar.gBm = eVar;
                    if (i + 1 < size) {
                        e eVar2 = new e();
                        eVar2.gyW = this.gyW;
                        eVar2.entryName = this.entryName;
                        eVar2.labelName = this.labelName;
                        eVar2.gyO = list.get(i + 1);
                        aVar.gBn = eVar2;
                    }
                    this.mDatas.add(aVar);
                } else {
                    b bVar = new b();
                    e eVar3 = new e();
                    eVar3.gyW = this.gyW;
                    eVar3.entryName = this.entryName;
                    eVar3.labelName = this.labelName;
                    eVar3.gyO = list.get(i);
                    bVar.gBm = eVar3;
                    if (i + 1 < size) {
                        e eVar4 = new e();
                        eVar4.gyW = this.gyW;
                        eVar4.entryName = this.entryName;
                        eVar4.labelName = this.labelName;
                        eVar4.gyO = list.get(i + 1);
                        bVar.gBn = eVar4;
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

    public boolean bSD() {
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
        this.gJa = aVar;
    }

    public List<n> getDatas() {
        return this.mDatas;
    }

    public List<cb> bSw() {
        return this.gHt;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortTypeList;
    }

    public void mM(boolean z) {
        this.gIZ = z;
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

    public void mN(boolean z) {
        this.gyW = z;
    }
}
