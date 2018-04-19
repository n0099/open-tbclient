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
    private BaseActivity bcJ;
    private a dyV;
    private boolean dyW;
    private LongSparseArray<MetaData> dyY;
    private int pn = 0;
    public List<h> cTW = new ArrayList();
    public int dyX = 1;
    private com.baidu.adp.framework.listener.a cxj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dyV != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dyV.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dyW, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dyV.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dyW, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener cTw = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dyV != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.lQ(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.w(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.lQ(1);
                } else {
                    b.this.dyV.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dyW, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dyV = aVar;
        this.bcJ = baseActivity;
        registerListener();
    }

    public void update() {
        this.dyX = 1;
        this.dyW = true;
        if (j.gD()) {
            lQ(1);
        } else {
            lR(1);
        }
    }

    public void Po() {
        this.dyW = false;
        lQ(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(int i) {
        if (this.bcJ != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bcJ.sendMessage(godSquareRequestMsg);
        }
    }

    private void lR(int i) {
        if (this.bcJ != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bcJ.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bcJ != null) {
            this.bcJ.registerListener(this.cTw);
            this.bcJ.registerListener(this.cxj);
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
        bD(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.w(dataRes.recommend_uid_list) && this.dyW) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dyY.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aae = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bcJ != null && !v.w(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bcJ.getResources().getString(d.k.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.w(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dyY.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aae = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dyX;
                    arrayList3.add(fVar2);
                    this.dyX++;
                }
            }
            if (this.bcJ != null && !v.w(arrayList3) && this.dyW) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bcJ.getResources().getString(d.k.hot_god);
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

    private void bD(List<User> list) {
        if (this.dyY == null) {
            this.dyY = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aae = new MetaData();
            fVar.aae.parserProtobuf(user);
            this.dyY.put(user.id.longValue(), fVar.aae);
        }
    }

    public boolean bI(long j) {
        return (this.dyY == null || this.dyY.get(j) == null) ? false : true;
    }
}
