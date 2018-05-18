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
    private BaseActivity bcK;
    private boolean dAa;
    private LongSparseArray<MetaData> dAc;
    private a dzZ;
    private int pn = 0;
    public List<h> cVa = new ArrayList();
    public int dAb = 1;
    private com.baidu.adp.framework.listener.a cyp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dzZ != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dzZ.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dAa, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dzZ.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dAa, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener cUA = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dzZ != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.lP(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.w(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.lP(1);
                } else {
                    b.this.dzZ.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dAa, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dzZ = aVar;
        this.bcK = baseActivity;
        registerListener();
    }

    public void update() {
        this.dAb = 1;
        this.dAa = true;
        if (j.gD()) {
            lP(1);
        } else {
            lQ(1);
        }
    }

    public void Pl() {
        this.dAa = false;
        lP(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(int i) {
        if (this.bcK != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bcK.sendMessage(godSquareRequestMsg);
        }
    }

    private void lQ(int i) {
        if (this.bcK != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bcK.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bcK != null) {
            this.bcK.registerListener(this.cUA);
            this.bcK.registerListener(this.cyp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.w(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bG(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.w(dataRes.recommend_uid_list) && this.dAa) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dAc.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aaf = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bcK != null && !v.w(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bcK.getResources().getString(d.k.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.w(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dAc.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aaf = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dAb;
                    arrayList3.add(fVar2);
                    this.dAb++;
                }
            }
            if (this.bcK != null && !v.w(arrayList3) && this.dAa) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bcK.getResources().getString(d.k.hot_god);
                if (v.w(arrayList2)) {
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

    private void bG(List<User> list) {
        if (this.dAc == null) {
            this.dAc = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aaf = new MetaData();
            fVar.aaf.parserProtobuf(user);
            this.dAc.put(user.id.longValue(), fVar.aaf);
        }
    }

    public boolean bI(long j) {
        return (this.dAc == null || this.dAc.get(j) == null) ? false : true;
    }
}
