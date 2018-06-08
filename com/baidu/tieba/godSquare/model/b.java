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
    private BaseActivity bkU;
    private a dLj;
    private boolean dLk;
    private LongSparseArray<MetaData> dLm;
    private int pn = 0;
    public List<h> del = new ArrayList();
    public int dLl = 1;
    private com.baidu.adp.framework.listener.a cGS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.dLj != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.dLj.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.dLk, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.dLj.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.dLk, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener ddJ = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dLj != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.mb(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || w.z(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.mb(1);
                } else {
                    b.this.dLj.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.dLk, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.dLj = aVar;
        this.bkU = baseActivity;
        registerListener();
    }

    public void update() {
        this.dLl = 1;
        this.dLk = true;
        if (j.jr()) {
            mb(1);
        } else {
            mc(1);
        }
    }

    public void SJ() {
        this.dLk = false;
        mb(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i) {
        if (this.bkU != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bkU.sendMessage(godSquareRequestMsg);
        }
    }

    private void mc(int i) {
        if (this.bkU != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bkU.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bkU != null) {
            this.bkU.registerListener(this.ddJ);
            this.bkU.registerListener(this.cGS);
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
        bL(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!w.z(dataRes.recommend_uid_list) && this.dLk) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.dLm.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.aik = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bkU != null && !w.z(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bkU.getResources().getString(d.k.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!w.z(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.dLm.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.aik = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.dLl;
                    arrayList3.add(fVar2);
                    this.dLl++;
                }
            }
            if (this.bkU != null && !w.z(arrayList3) && this.dLk) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bkU.getResources().getString(d.k.hot_god);
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

    private void bL(List<User> list) {
        if (this.dLm == null) {
            this.dLm = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.aik = new MetaData();
            fVar.aik.parserProtobuf(user);
            this.dLm.put(user.id.longValue(), fVar.aik);
        }
    }

    public boolean bO(long j) {
        return (this.dLm == null || this.dLm.get(j) == null) ? false : true;
    }
}
