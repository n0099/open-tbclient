package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.e;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bsQ;
    private a dYA;
    private boolean dYB;
    private LongSparseArray<MetaData> dYD;
    private int pn = 0;
    public List<h> doK = new ArrayList();
    public int dYC = 1;
    private com.baidu.adp.framework.listener.a cNg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dYA != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dYA.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dYB, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dYA.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dYB, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener doi = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dYA != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.mY(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.z(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.mY(1);
                } else {
                    b.this.dYA.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dYB, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dYA = aVar;
        this.bsQ = baseActivity;
        registerListener();
    }

    public void update() {
        this.dYC = 1;
        this.dYB = true;
        if (j.ky()) {
            mY(1);
        } else {
            mZ(1);
        }
    }

    public void Vd() {
        this.dYB = false;
        mY(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(int i) {
        if (this.bsQ != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bsQ.sendMessage(godSquareRequestMsg);
        }
    }

    private void mZ(int i) {
        if (this.bsQ != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bsQ.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bsQ != null) {
            this.bsQ.registerListener(this.doi);
            this.bsQ.registerListener(this.cNg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.z(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bP(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.z(dataRes.recommend_uid_list) && this.dYB) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dYD.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.akB = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bsQ != null && !v.z(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bsQ.getResources().getString(e.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.z(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dYD.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.akB = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dYC;
                    arrayList3.add(fVar2);
                    this.dYC++;
                }
            }
            if (this.bsQ != null && !v.z(arrayList3) && this.dYB) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bsQ.getResources().getString(e.j.hot_god);
                if (v.z(arrayList2)) {
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

    private void bP(List<User> list) {
        if (this.dYD == null) {
            this.dYD = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.akB = new MetaData();
            fVar.akB.parserProtobuf(user);
            this.dYD.put(user.id.longValue(), fVar.akB);
        }
    }

    public boolean bT(long j) {
        return (this.dYD == null || this.dYD.get(j) == null) ? false : true;
    }
}
