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
    private BaseActivity cWM;
    private a gao;
    private boolean gap;
    private LongSparseArray<MetaData> gar;
    private int pn = 0;
    public List<m> fqk = new ArrayList();
    public int gaq = 1;
    private com.baidu.adp.framework.listener.a eYG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.gao != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.gao.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.gap, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.gao.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.gap, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener fpI = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gao != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.tB(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.aa(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.tB(1);
                } else {
                    b.this.gao.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.gap, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.gao = aVar;
        this.cWM = baseActivity;
        registerListener();
    }

    public void update() {
        this.gaq = 1;
        this.gap = true;
        if (j.jQ()) {
            tB(1);
        } else {
            tC(1);
        }
    }

    public void aIQ() {
        this.gap = false;
        tB(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB(int i) {
        if (this.cWM != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.cWM.sendMessage(godSquareRequestMsg);
        }
    }

    private void tC(int i) {
        if (this.cWM != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.cWM.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.cWM != null) {
            this.cWM.registerListener(this.fpI);
            this.cWM.registerListener(this.eYG);
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
        cz(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(dataRes.recommend_uid_list) && this.gap) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.gar.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.bKb = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.cWM != null && !v.aa(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.cWM.getResources().getString(R.string.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.aa(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.gar.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.bKb = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.gaq;
                    arrayList3.add(fVar2);
                    this.gaq++;
                }
            }
            if (this.cWM != null && !v.aa(arrayList3) && this.gap) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.cWM.getResources().getString(R.string.hot_god);
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

    private void cz(List<User> list) {
        if (this.gar == null) {
            this.gar = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.bKb = new MetaData();
            fVar.bKb.parserProtobuf(user);
            this.gar.put(user.id.longValue(), fVar.bKb);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m21do(long j) {
        return (this.gar == null || this.gar.get(j) == null) ? false : true;
    }
}
