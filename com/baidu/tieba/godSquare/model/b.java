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
    private BaseActivity bBV;
    private a esf;
    private boolean esg;
    private LongSparseArray<MetaData> esi;
    private int pn = 0;
    public List<h> dIa = new ArrayList();
    public int esh = 1;
    private com.baidu.adp.framework.listener.a dgR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.esf != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.esf.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.esg, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.esf.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.esg, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dHy = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.esf != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.ow(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.I(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.ow(1);
                } else {
                    b.this.esf.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.esg, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.esf = aVar;
        this.bBV = baseActivity;
        registerListener();
    }

    public void update() {
        this.esh = 1;
        this.esg = true;
        if (j.kK()) {
            ow(1);
        } else {
            ox(1);
        }
    }

    public void aaA() {
        this.esg = false;
        ow(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(int i) {
        if (this.bBV != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bBV.sendMessage(godSquareRequestMsg);
        }
    }

    private void ox(int i) {
        if (this.bBV != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bBV.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bBV != null) {
            this.bBV.registerListener(this.dHy);
            this.bBV.registerListener(this.dgR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.I(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cj(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.I(dataRes.recommend_uid_list) && this.esg) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.esi.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aum = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bBV != null && !v.I(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bBV.getResources().getString(e.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.I(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.esi.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aum = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.esh;
                    arrayList3.add(fVar2);
                    this.esh++;
                }
            }
            if (this.bBV != null && !v.I(arrayList3) && this.esg) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bBV.getResources().getString(e.j.hot_god);
                if (v.I(arrayList2)) {
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

    private void cj(List<User> list) {
        if (this.esi == null) {
            this.esi = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aum = new MetaData();
            fVar.aum.parserProtobuf(user);
            this.esi.put(user.id.longValue(), fVar.aum);
        }
    }

    public boolean ch(long j) {
        return (this.esi == null || this.esi.get(j) == null) ? false : true;
    }
}
