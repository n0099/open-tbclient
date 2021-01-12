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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.b.b;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static final int FIRST_PN = 0;
    private String entryName;
    private List<bz> gEv;
    private boolean gGb;
    private a gGc;
    private HttpMessageListener gGd;
    private boolean gvY;
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

    /* loaded from: classes9.dex */
    public interface a {
        void aF(int i, String str);

        void mG(boolean z);
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
        this.gvY = false;
        this.gEv = new ArrayList();
        this.mDatas = new ArrayList();
        this.mBdUniqueId = BdUniqueId.gen();
        this.gGd = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST) { // from class: com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                    AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
                        AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError()) {
                            if (AlaNewSquareSubListModel.this.gGc != null) {
                                AlaNewSquareSubListModel.this.gGc.aF(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        List<bz> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                        AlaNewSquareSubListModel.this.hasMore = alaNewSquareSubListResponseMessage.hasMore();
                        AlaNewSquareSubListModel.this.pn = alaNewSquareSubListRequestMessage.getPn();
                        if (AlaNewSquareSubListModel.this.pn == 0 || x.getCount(AlaNewSquareSubListModel.this.gEv) == 0) {
                            AlaNewSquareSubListModel.this.gEv.clear();
                            AlaNewSquareSubListModel.this.mDatas.clear();
                            AlaNewSquareSubListModel.this.gEv = liveList;
                            AlaNewSquareSubListModel.this.liveCount = alaNewSquareSubListResponseMessage.getLiveCount();
                            AlaNewSquareSubListModel.this.sortTypeList = alaNewSquareSubListResponseMessage.getSortTypeList();
                        } else if (x.getCount(liveList) > 0) {
                            AlaNewSquareSubListModel.this.co(liveList);
                        }
                        AlaNewSquareSubListModel.e(AlaNewSquareSubListModel.this);
                        AlaNewSquareSubListModel.this.n(AlaNewSquareSubListModel.this.gEv, AlaNewSquareSubListModel.this.hasMore);
                        if (AlaNewSquareSubListModel.this.gGc != null) {
                            AlaNewSquareSubListModel.this.gGc.mG(AlaNewSquareSubListModel.this.hasMore);
                        }
                    }
                }
            }
        };
        setUniqueId(this.mBdUniqueId);
        this.gGd.setTag(this.mBdUniqueId);
        this.gGd.setSelfListener(true);
        registerListener(this.gGd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(List<bz> list) {
        boolean z;
        for (bz bzVar : list) {
            if (bzVar != null && bzVar.getThreadType() == 49) {
                String tid = bzVar.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    Iterator<bz> it = this.gEv.iterator();
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
                        this.gEv.add(bzVar);
                    }
                }
            }
        }
    }

    public void n(List<bz> list, boolean z) {
        if (!x.isEmpty(list)) {
            this.mDatas = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.gGb) {
                    com.baidu.tieba.ala.alasquare.subtablist.b.a aVar = new com.baidu.tieba.ala.alasquare.subtablist.b.a();
                    e eVar = new e();
                    eVar.gvY = this.gvY;
                    eVar.entryName = this.entryName;
                    eVar.labelName = this.labelName;
                    eVar.gvQ = list.get(i);
                    aVar.gyo = eVar;
                    if (i + 1 < size) {
                        e eVar2 = new e();
                        eVar2.gvY = this.gvY;
                        eVar2.entryName = this.entryName;
                        eVar2.labelName = this.labelName;
                        eVar2.gvQ = list.get(i + 1);
                        aVar.gyp = eVar2;
                    }
                    this.mDatas.add(aVar);
                } else {
                    b bVar = new b();
                    e eVar3 = new e();
                    eVar3.gvY = this.gvY;
                    eVar3.entryName = this.entryName;
                    eVar3.labelName = this.labelName;
                    eVar3.gvQ = list.get(i);
                    bVar.gyo = eVar3;
                    if (i + 1 < size) {
                        e eVar4 = new e();
                        eVar4.gvY = this.gvY;
                        eVar4.entryName = this.entryName;
                        eVar4.labelName = this.labelName;
                        eVar4.gvQ = list.get(i + 1);
                        bVar.gyp = eVar4;
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

    public boolean bRT() {
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
        this.gGc = aVar;
    }

    public List<n> getDatas() {
        return this.mDatas;
    }

    public List<bz> bRM() {
        return this.gEv;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortTypeList;
    }

    public void mI(boolean z) {
        this.gGb = z;
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

    public void mJ(boolean z) {
        this.gvY = z;
    }
}
