package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes6.dex */
public class b {
    private BaseActivity cNd;
    private a fEr;
    private boolean fEs;
    private LongSparseArray<MetaData> fEu;
    private int pn = 0;
    public List<m> eVb = new ArrayList();
    public int fEt = 1;
    private com.baidu.adp.framework.listener.a eDK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.fEr != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.fEr.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.fEs, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.fEr.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.fEs, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener eUz = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fEr != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.sb(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.T(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.sb(1);
                } else {
                    b.this.fEr.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.fEs, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.fEr = aVar;
        this.cNd = baseActivity;
        registerListener();
    }

    public void update() {
        this.fEt = 1;
        this.fEs = true;
        if (j.kM()) {
            sb(1);
        } else {
            sc(1);
        }
    }

    public void aAZ() {
        this.fEs = false;
        sb(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        if (this.cNd != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.cNd.sendMessage(godSquareRequestMsg);
        }
    }

    private void sc(int i) {
        if (this.cNd != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.cNd.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.cNd != null) {
            this.cNd.registerListener(this.eUz);
            this.cNd.registerListener(this.eDK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<m> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.T(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cq(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.T(dataRes.recommend_uid_list) && this.fEs) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.fEu.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.bBK = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.cNd != null && !v.T(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.cNd.getResources().getString(d.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.T(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.fEu.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.bBK = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.fEt;
                    arrayList3.add(fVar2);
                    this.fEt++;
                }
            }
            if (this.cNd != null && !v.T(arrayList3) && this.fEs) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.cNd.getResources().getString(d.j.hot_god);
                if (v.T(arrayList2)) {
                    bVar2.needTopMargin = false;
                } else {
                    bVar2.needTopMargin = true;
                }
                arrayList3.add(0, bVar2);
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    private void cq(List<User> list) {
        if (this.fEu == null) {
            this.fEu = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.bBK = new MetaData();
            fVar.bBK.parserProtobuf(user);
            this.fEu.put(user.id.longValue(), fVar.bBK);
        }
    }

    public boolean cK(long j) {
        return (this.fEu == null || this.fEu.get(j) == null) ? false : true;
    }
}
