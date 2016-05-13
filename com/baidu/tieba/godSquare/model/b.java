package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private a bKp;
    private boolean bKq;
    private LongSparseArray<MetaData> bKs;
    private BaseActivity bek;
    private int pn = 0;
    public List<v> bdt = new ArrayList();
    public int bKr = 1;
    private com.baidu.adp.framework.listener.a aTu = new c(this, CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    private CustomMessageListener bcX = new d(this, CmdConfigCustom.CMD_GET_HOT_GOD_CACHE);

    /* loaded from: classes.dex */
    public interface a {
        void a(List<v> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.bKp = aVar;
        this.bek = baseActivity;
        registerListener();
    }

    public void update() {
        this.bKr = 1;
        this.bKq = true;
        if (i.fe()) {
            hM(1);
        } else {
            hN(1);
        }
    }

    public void Pp() {
        this.bKq = false;
        hM(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(int i) {
        if (this.bek != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bek.sendMessage(godSquareRequestMsg);
        }
    }

    private void hN(int i) {
        if (this.bek != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = new StringBuilder(String.valueOf(i)).toString();
            this.bek.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bek != null) {
            this.bek.registerListener(this.bcX);
            this.bek.registerListener(this.aTu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<v> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || y.s(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aP(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!y.s(dataRes.recommend_uid_list) && this.bKq) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.bKs.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.author = metaData2;
                    hVar.type = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.bek != null && !y.s(arrayList2)) {
                com.baidu.tieba.card.b.b bVar = new com.baidu.tieba.card.b.b();
                bVar.title = this.bek.getResources().getString(t.j.special_recommend);
                bVar.aRx = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!y.s(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.bKs.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.author = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.bKr;
                    arrayList3.add(hVar2);
                    this.bKr++;
                }
            }
            if (this.bek != null && !y.s(arrayList3) && this.bKq) {
                com.baidu.tieba.card.b.b bVar2 = new com.baidu.tieba.card.b.b();
                bVar2.title = this.bek.getResources().getString(t.j.hot_god);
                if (y.s(arrayList2)) {
                    bVar2.aRx = false;
                } else {
                    bVar2.aRx = true;
                }
                arrayList3.add(0, bVar2);
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    private void aP(List<User> list) {
        if (this.bKs == null) {
            this.bKs = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.author = new MetaData();
            hVar.author.parserProtobuf(user);
            this.bKs.put(user.id.longValue(), hVar.author);
        }
    }

    public boolean aS(long j) {
        return (this.bKs == null || this.bKs.get(j) == null) ? false : true;
    }
}
