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
    private BaseActivity bBf;
    private a eoI;
    private boolean eoJ;
    private LongSparseArray<MetaData> eoL;
    private int pn = 0;
    public List<h> dED = new ArrayList();
    public int eoK = 1;
    private com.baidu.adp.framework.listener.a ddn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.eoI != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.eoI.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.eoJ, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.eoI.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.eoJ, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener dEb = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eoI != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.oi(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.I(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.oi(1);
                } else {
                    b.this.eoI.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.eoJ, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<h> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.eoI = aVar;
        this.bBf = baseActivity;
        registerListener();
    }

    public void update() {
        this.eoK = 1;
        this.eoJ = true;
        if (j.kK()) {
            oi(1);
        } else {
            oj(1);
        }
    }

    public void aab() {
        this.eoJ = false;
        oi(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(int i) {
        if (this.bBf != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bBf.sendMessage(godSquareRequestMsg);
        }
    }

    private void oj(int i) {
        if (this.bBf != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.bBf.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bBf != null) {
            this.bBf.registerListener(this.dEb);
            this.bBf.registerListener(this.ddn);
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
        ch(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.I(dataRes.recommend_uid_list) && this.eoJ) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.eoL.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.atK = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.bBf != null && !v.I(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.bBf.getResources().getString(e.j.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.I(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.eoL.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.atK = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.eoK;
                    arrayList3.add(fVar2);
                    this.eoK++;
                }
            }
            if (this.bBf != null && !v.I(arrayList3) && this.eoJ) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.bBf.getResources().getString(e.j.hot_god);
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

    private void ch(List<User> list) {
        if (this.eoL == null) {
            this.eoL = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.atK = new MetaData();
            fVar.atK.parserProtobuf(user);
            this.eoL.put(user.id.longValue(), fVar.atK);
        }
    }

    public boolean cc(long j) {
        return (this.eoL == null || this.eoL.get(j) == null) ? false : true;
    }
}
