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
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bmt;
    private a dOA;
    private boolean dOB;
    private LongSparseArray<MetaData> dOD;
    private int pn = 0;
    public List<h> dgd = new ArrayList();
    public int dOC = 1;
    private com.baidu.adp.framework.listener.a cEL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dOA != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dOA.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dOB, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dOA.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dOB, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dfB = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dOA != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.mi(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || w.A(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.mi(1);
                } else {
                    b.this.dOA.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dOB, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dOA = aVar;
        this.bmt = baseActivity;
        registerListener();
    }

    public void update() {
        this.dOC = 1;
        this.dOB = true;
        if (j.jr()) {
            mi(1);
        } else {
            mj(1);
        }
    }

    public void Tf() {
        this.dOB = false;
        mi(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(int i) {
        if (this.bmt != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bmt.sendMessage(godSquareRequestMsg);
        }
    }

    private void mj(int i) {
        if (this.bmt != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bmt.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bmt != null) {
            this.bmt.registerListener(this.dfB);
            this.bmt.registerListener(this.cEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || w.A(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bP(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!w.A(dataRes.recommend_uid_list) && this.dOB) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dOD.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aiE = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bmt != null && !w.A(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bmt.getResources().getString(d.k.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!w.A(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dOD.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aiE = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dOC;
                    arrayList3.add(fVar2);
                    this.dOC++;
                }
            }
            if (this.bmt != null && !w.A(arrayList3) && this.dOB) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bmt.getResources().getString(d.k.hot_god);
                if (w.A(arrayList2)) {
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
        if (this.dOD == null) {
            this.dOD = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aiE = new MetaData();
            fVar.aiE.parserProtobuf(user);
            this.dOD.put(user.id.longValue(), fVar.aiE);
        }
    }

    public boolean bK(long j) {
        return (this.dOD == null || this.dOD.get(j) == null) ? false : true;
    }
}
