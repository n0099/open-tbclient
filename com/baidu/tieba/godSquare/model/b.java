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
    private a hGs;
    private boolean hGt;
    private LongSparseArray<MetaData> hGv;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<m> gUJ = new ArrayList();
    public int hGu = 1;
    private com.baidu.adp.framework.listener.a gUg = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.hGs != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.hGs.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.hGt, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.hGs.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.hGt, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener gUh = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hGs != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.vx(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.vx(1);
                } else {
                    b.this.hGs.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.hGt, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.hGs = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.hGu = 1;
        this.hGt = true;
        if (j.isNetworkAvailableForImmediately()) {
            vx(1);
        } else {
            vy(1);
        }
    }

    public void bkZ() {
        this.hGt = false;
        vx(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void vy(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.gUh);
            this.mActivity.registerListener(this.gUg);
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
        cL(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(dataRes.recommend_uid_list) && this.hGt) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.hGv.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.drO = metaData2;
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
                if (l2 != null && (metaData = this.hGv.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.drO = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.hGu;
                    arrayList3.add(hVar2);
                    this.hGu++;
                }
            }
            if (this.mActivity != null && !v.isEmpty(arrayList3) && this.hGt) {
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

    private void cL(List<User> list) {
        if (this.hGv == null) {
            this.hGv = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.drO = new MetaData();
            hVar.drO.parserProtobuf(user);
            this.hGv.put(user.id.longValue(), hVar.drO);
        }
    }

    public boolean ek(long j) {
        return (this.hGv == null || this.hGv.get(j) == null) ? false : true;
    }
}
