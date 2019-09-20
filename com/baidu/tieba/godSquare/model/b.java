package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes6.dex */
public class b {
    private BaseActivity cXM;
    private a gcV;
    private boolean gcW;
    private LongSparseArray<MetaData> gcY;
    private int pn = 0;
    public List<m> fsx = new ArrayList();
    public int gcX = 1;
    private com.baidu.adp.framework.listener.a faA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.gcV != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.gcV.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.gcW, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.gcV.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.gcW, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener frV = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gcV != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.tH(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.aa(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.tH(1);
                } else {
                    b.this.gcV.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.gcW, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.gcV = aVar;
        this.cXM = baseActivity;
        registerListener();
    }

    public void update() {
        this.gcX = 1;
        this.gcW = true;
        if (j.jQ()) {
            tH(1);
        } else {
            tI(1);
        }
    }

    public void aJw() {
        this.gcW = false;
        tH(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(int i) {
        if (this.cXM != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.cXM.sendMessage(godSquareRequestMsg);
        }
    }

    private void tI(int i) {
        if (this.cXM != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.cXM.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.cXM != null) {
            this.cXM.registerListener(this.frV);
            this.cXM.registerListener(this.faA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<m> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.aa(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cy(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(dataRes.recommend_uid_list) && this.gcW) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.gcY.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.bKE = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.cXM != null && !v.aa(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.cXM.getResources().getString(R.string.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.aa(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.gcY.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.bKE = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.gcX;
                    arrayList3.add(fVar2);
                    this.gcX++;
                }
            }
            if (this.cXM != null && !v.aa(arrayList3) && this.gcW) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.cXM.getResources().getString(R.string.hot_god);
                if (v.aa(arrayList2)) {
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

    private void cy(List<User> list) {
        if (this.gcY == null) {
            this.gcY = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.bKE = new MetaData();
            fVar.bKE.parserProtobuf(user);
            this.gcY.put(user.id.longValue(), fVar.bKE);
        }
    }

    public boolean dr(long j) {
        return (this.gcY == null || this.gcY.get(j) == null) ? false : true;
    }
}
