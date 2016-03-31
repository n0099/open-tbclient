package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private a bKk;
    private boolean bKl;
    private LongSparseArray<MetaData> bKo;
    private BaseActivity bix;
    private int pn = 0;
    public List<u> bKm = new ArrayList();
    public int bKn = 1;
    private com.baidu.adp.framework.listener.a aXA = new c(this, CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    private CustomMessageListener bhh = new d(this, CmdConfigCustom.CMD_GET_HOT_GOD_CACHE);

    /* loaded from: classes.dex */
    public interface a {
        void a(List<u> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.bKk = aVar;
        this.bix = baseActivity;
        EH();
        registerListener();
    }

    private void EH() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE, com.baidu.tieba.godSquare.model.req.a.class);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_GET_HOT_GOD, 309315, TbConfig.GET_HOT_GOD, GodSquareHttpResponsedMsg.class, GodSquareSocketResponsedMsg.class);
    }

    public void update() {
        this.bKn = 1;
        this.bKl = true;
        if (i.iT()) {
            il(1);
        } else {
            im(1);
        }
    }

    public void Qq() {
        this.bKl = false;
        il(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(int i) {
        if (this.bix != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.bix.sendMessage(godSquareRequestMsg);
        }
    }

    private void im(int i) {
        if (this.bix != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = new StringBuilder(String.valueOf(i)).toString();
            this.bix.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.bix != null) {
            this.bix.registerListener(this.bhh);
            this.bix.registerListener(this.aXA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<u> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || y.q(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aR(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!y.q(dataRes.recommend_uid_list) && this.bKl) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.bKo.get(l.longValue())) != null) {
                    k kVar = new k();
                    kVar.author = metaData2;
                    kVar.type = 1;
                    arrayList2.add(kVar);
                }
            }
            if (this.bix != null && !y.q(arrayList2)) {
                com.baidu.tieba.card.b.b bVar = new com.baidu.tieba.card.b.b();
                bVar.title = this.bix.getResources().getString(t.j.special_recommend);
                bVar.aVs = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!y.q(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.bKo.get(l2.longValue())) != null) {
                    k kVar2 = new k();
                    kVar2.author = metaData;
                    kVar2.type = 0;
                    kVar2.rank = this.bKn;
                    arrayList3.add(kVar2);
                    this.bKn++;
                }
            }
            if (this.bix != null && !y.q(arrayList3) && this.bKl) {
                com.baidu.tieba.card.b.b bVar2 = new com.baidu.tieba.card.b.b();
                bVar2.title = this.bix.getResources().getString(t.j.hot_god);
                if (y.q(arrayList2)) {
                    bVar2.aVs = false;
                } else {
                    bVar2.aVs = true;
                }
                arrayList3.add(0, bVar2);
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    private void aR(List<User> list) {
        if (this.bKo == null) {
            this.bKo = new LongSparseArray<>();
        }
        for (User user : list) {
            k kVar = new k();
            kVar.author = new MetaData();
            kVar.author.parserProtobuf(user);
            this.bKo.put(user.id.longValue(), kVar.author);
        }
    }

    public boolean aR(long j) {
        return (this.bKo == null || this.bKo.get(j) == null) ? false : true;
    }
}
