package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.divider.e;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes11.dex */
public class b {
    private a gVa;
    private boolean gVb;
    private LongSparseArray<MetaData> gVd;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<m> gkA = new ArrayList();
    public int gVc = 1;
    private com.baidu.adp.framework.listener.a gjW = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.gVa != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.gVa.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.gVb, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.gVa.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.gVb, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener gjX = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gVa != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.uS(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.uS(1);
                } else {
                    b.this.gVa.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.gVb, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.gVa = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.gVc = 1;
        this.gVb = true;
        if (j.isNetworkAvailableForImmediately()) {
            uS(1);
        } else {
            uT(1);
        }
    }

    public void bcd() {
        this.gVb = false;
        uS(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void uT(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.gjX);
            this.mActivity.registerListener(this.gjW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<m> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || v.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cA(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(dataRes.recommend_uid_list) && this.gVb) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.gVd.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.cSm = metaData2;
                    hVar.type = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.mActivity != null && !v.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.title = this.mActivity.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.gVd.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.cSm = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.gVc;
                    arrayList3.add(hVar2);
                    this.gVc++;
                }
            }
            if (this.mActivity != null && !v.isEmpty(arrayList3) && this.gVb) {
                e eVar2 = new e();
                eVar2.title = this.mActivity.getResources().getString(R.string.hot_god);
                if (v.isEmpty(arrayList2)) {
                    eVar2.needTopMargin = false;
                } else {
                    eVar2.needTopMargin = true;
                }
                arrayList3.add(0, eVar2);
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    private void cA(List<User> list) {
        if (this.gVd == null) {
            this.gVd = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.cSm = new MetaData();
            hVar.cSm.parserProtobuf(user);
            this.gVd.put(user.id.longValue(), hVar.cSm);
        }
    }

    public boolean dB(long j) {
        return (this.gVd == null || this.gVd.get(j) == null) ? false : true;
    }
}
