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
    private BaseActivity bwX;
    private a egt;
    private boolean egu;
    private LongSparseArray<MetaData> egw;
    private int pn = 0;
    public List<h> dwM = new ArrayList();
    public int egv = 1;
    private com.baidu.adp.framework.listener.a cVx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.egt != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.egt.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.egu, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.egt.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.egu, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dwk = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.egt != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.nw(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.J(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.nw(1);
                } else {
                    b.this.egt.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.egu, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.egt = aVar;
        this.bwX = baseActivity;
        registerListener();
    }

    public void update() {
        this.egv = 1;
        this.egu = true;
        if (j.kM()) {
            nw(1);
        } else {
            nx(1);
        }
    }

    public void YK() {
        this.egu = false;
        nw(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(int i) {
        if (this.bwX != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bwX.sendMessage(godSquareRequestMsg);
        }
    }

    private void nx(int i) {
        if (this.bwX != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bwX.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bwX != null) {
            this.bwX.registerListener(this.dwk);
            this.bwX.registerListener(this.cVx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.J(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cf(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.J(dataRes.recommend_uid_list) && this.egu) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.egw.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.apx = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bwX != null && !v.J(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bwX.getResources().getString(e.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.J(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.egw.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.apx = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.egv;
                    arrayList3.add(fVar2);
                    this.egv++;
                }
            }
            if (this.bwX != null && !v.J(arrayList3) && this.egu) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bwX.getResources().getString(e.j.hot_god);
                if (v.J(arrayList2)) {
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

    private void cf(List<User> list) {
        if (this.egw == null) {
            this.egw = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.apx = new MetaData();
            fVar.apx.parserProtobuf(user);
            this.egw.put(user.id.longValue(), fVar.apx);
        }
    }

    public boolean ca(long j) {
        return (this.egw == null || this.egw.get(j) == null) ? false : true;
    }
}
