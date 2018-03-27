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
    private BaseActivity bSF;
    private a eep;
    private boolean eeq;
    private LongSparseArray<MetaData> ees;
    private int pn = 0;
    public List<i> dBk = new ArrayList();
    public int eer = 1;
    private com.baidu.adp.framework.listener.a dfu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.eep != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.eep.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.eeq, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.eep.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.eeq, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dAK = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eep != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.or(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.E(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.or(1);
                } else {
                    b.this.eep.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.eeq, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<i> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.eep = aVar;
        this.bSF = baseActivity;
        registerListener();
    }

    public void update() {
        this.eer = 1;
        this.eeq = true;
        if (j.ox()) {
            or(1);
        } else {
            os(1);
        }
    }

    public void WO() {
        this.eeq = false;
        or(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(int i) {
        if (this.bSF != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bSF.sendMessage(godSquareRequestMsg);
        }
    }

    private void os(int i) {
        if (this.bSF != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bSF.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bSF != null) {
            this.bSF.registerListener(this.dAK);
            this.bSF.registerListener(this.dfu);
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
        if (!v.E(dataRes.recommend_uid_list) && this.eeq) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.ees.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aOG = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bSF != null && !v.E(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bSF.getResources().getString(d.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.E(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.ees.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aOG = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.eer;
                    arrayList3.add(fVar2);
                    this.eer++;
                }
            }
            if (this.bSF != null && !v.E(arrayList3) && this.eeq) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bSF.getResources().getString(d.j.hot_god);
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
        if (this.ees == null) {
            this.ees = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aOG = new MetaData();
            fVar.aOG.parserProtobuf(user);
            this.ees.put(user.id.longValue(), fVar.aOG);
        }
    }

    public boolean bK(long j) {
        return (this.ees == null || this.ees.get(j) == null) ? false : true;
    }
}
