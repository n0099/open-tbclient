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
import com.baidu.tieba.f;
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
    private BaseActivity bnc;
    private a dRi;
    private boolean dRj;
    private LongSparseArray<MetaData> dRl;
    private int pn = 0;
    public List<h> diR = new ArrayList();
    public int dRk = 1;
    private com.baidu.adp.framework.listener.a cHp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dRi != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dRi.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dRj, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dRi.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dRj, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dip = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dRi != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.mu(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || w.z(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.mu(1);
                } else {
                    b.this.dRi.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dRj, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dRi = aVar;
        this.bnc = baseActivity;
        registerListener();
    }

    public void update() {
        this.dRk = 1;
        this.dRj = true;
        if (j.js()) {
            mu(1);
        } else {
            mv(1);
        }
    }

    public void Tq() {
        this.dRj = false;
        mu(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(int i) {
        if (this.bnc != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bnc.sendMessage(godSquareRequestMsg);
        }
    }

    private void mv(int i) {
        if (this.bnc != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bnc.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bnc != null) {
            this.bnc.registerListener(this.dip);
            this.bnc.registerListener(this.cHp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || w.z(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bO(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!w.z(dataRes.recommend_uid_list) && this.dRj) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dRl.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aib = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bnc != null && !w.z(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bnc.getResources().getString(f.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!w.z(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dRl.get(l2.longValue())) != null) {
                    com.baidu.tieba.card.data.f fVar2 = new com.baidu.tieba.card.data.f();
                    fVar2.aib = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dRk;
                    arrayList3.add(fVar2);
                    this.dRk++;
                }
            }
            if (this.bnc != null && !w.z(arrayList3) && this.dRj) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bnc.getResources().getString(f.j.hot_god);
                if (w.z(arrayList2)) {
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

    private void bO(List<User> list) {
        if (this.dRl == null) {
            this.dRl = new LongSparseArray<>();
        }
        for (User user : list) {
            com.baidu.tieba.card.data.f fVar = new com.baidu.tieba.card.data.f();
            fVar.aib = new MetaData();
            fVar.aib.parserProtobuf(user);
            this.dRl.put(user.id.longValue(), fVar.aib);
        }
    }

    public boolean bP(long j) {
        return (this.dRl == null || this.dRl.get(j) == null) ? false : true;
    }
}
