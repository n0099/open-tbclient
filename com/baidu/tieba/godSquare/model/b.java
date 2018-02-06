package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.i;
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
    private BaseActivity bSO;
    private a eel;
    private boolean eem;
    private LongSparseArray<MetaData> eeo;
    private int pn = 0;
    public List<i> dBt = new ArrayList();
    public int een = 1;
    private com.baidu.adp.framework.listener.a dfD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.eel != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.eel.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.eem, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.eel.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.eem, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dAT = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eel != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.oq(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.E(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.oq(1);
                } else {
                    b.this.eel.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.eem, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<i> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.eel = aVar;
        this.bSO = baseActivity;
        registerListener();
    }

    public void update() {
        this.een = 1;
        this.eem = true;
        if (j.ox()) {
            oq(1);
        } else {
            or(1);
        }
    }

    public void WO() {
        this.eem = false;
        oq(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(int i) {
        if (this.bSO != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bSO.sendMessage(godSquareRequestMsg);
        }
    }

    private void or(int i) {
        if (this.bSO != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bSO.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bSO != null) {
            this.bSO.registerListener(this.dAT);
            this.bSO.registerListener(this.dfD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<i> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.E(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bJ(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.E(dataRes.recommend_uid_list) && this.eem) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.eeo.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aOQ = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bSO != null && !v.E(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bSO.getResources().getString(d.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.E(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.eeo.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aOQ = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.een;
                    arrayList3.add(fVar2);
                    this.een++;
                }
            }
            if (this.bSO != null && !v.E(arrayList3) && this.eem) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bSO.getResources().getString(d.j.hot_god);
                if (v.E(arrayList2)) {
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

    private void bJ(List<User> list) {
        if (this.eeo == null) {
            this.eeo = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aOQ = new MetaData();
            fVar.aOQ.parserProtobuf(user);
            this.eeo.put(user.id.longValue(), fVar.aOQ);
        }
    }

    public boolean bK(long j) {
        return (this.eeo == null || this.eeo.get(j) == null) ? false : true;
    }
}
