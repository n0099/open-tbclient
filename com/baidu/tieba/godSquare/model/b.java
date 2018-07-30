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
    private BaseActivity bmZ;
    private a dRn;
    private boolean dRo;
    private LongSparseArray<MetaData> dRq;
    private int pn = 0;
    public List<h> diT = new ArrayList();
    public int dRp = 1;
    private com.baidu.adp.framework.listener.a cHs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dRn != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dRn.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dRo, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dRn.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dRo, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dir = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dRn != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.mu(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || w.z(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.mu(1);
                } else {
                    b.this.dRn.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dRo, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dRn = aVar;
        this.bmZ = baseActivity;
        registerListener();
    }

    public void update() {
        this.dRp = 1;
        this.dRo = true;
        if (j.js()) {
            mu(1);
        } else {
            mv(1);
        }
    }

    public void Tn() {
        this.dRo = false;
        mu(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(int i) {
        if (this.bmZ != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bmZ.sendMessage(godSquareRequestMsg);
        }
    }

    private void mv(int i) {
        if (this.bmZ != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bmZ.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bmZ != null) {
            this.bmZ.registerListener(this.dir);
            this.bmZ.registerListener(this.cHs);
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
        if (!w.z(dataRes.recommend_uid_list) && this.dRo) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dRq.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aib = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bmZ != null && !w.z(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bmZ.getResources().getString(d.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!w.z(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dRq.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aib = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dRp;
                    arrayList3.add(fVar2);
                    this.dRp++;
                }
            }
            if (this.bmZ != null && !w.z(arrayList3) && this.dRo) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bmZ.getResources().getString(d.j.hot_god);
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
        if (this.dRq == null) {
            this.dRq = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aib = new MetaData();
            fVar.aib.parserProtobuf(user);
            this.dRq.put(user.id.longValue(), fVar.aib);
        }
    }

    public boolean bP(long j) {
        return (this.dRq == null || this.dRq.get(j) == null) ? false : true;
    }
}
