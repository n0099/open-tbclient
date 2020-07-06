package com.baidu.tieba.godSquare.model;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.w;
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
    private a ikm;
    private boolean ikn;
    private LongSparseArray<MetaData> ikp;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<q> hvO = new ArrayList();
    public int iko = 1;
    private com.baidu.adp.framework.listener.a hvm = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.ikm != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.ikm.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.ikn, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.ikm.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.ikn, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener hvn = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.ikm != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.wL(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || w.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.wL(1);
                } else {
                    b.this.ikm.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.ikn, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(List<q> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.ikm = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.iko = 1;
        this.ikn = true;
        if (j.isNetworkAvailableForImmediately()) {
            wL(1);
        } else {
            wM(1);
        }
    }

    public void btv() {
        this.ikn = false;
        wL(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void wM(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.hvn);
            this.mActivity.registerListener(this.hvm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || w.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cT(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!w.isEmpty(dataRes.recommend_uid_list) && this.ikn) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.ikp.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.dMu = metaData2;
                    hVar.type = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.mActivity != null && !w.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.title = this.mActivity.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!w.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.ikp.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.dMu = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.iko;
                    arrayList3.add(hVar2);
                    this.iko++;
                }
            }
            if (this.mActivity != null && !w.isEmpty(arrayList3) && this.ikn) {
                e eVar2 = new e();
                eVar2.title = this.mActivity.getResources().getString(R.string.hot_god);
                if (w.isEmpty(arrayList2)) {
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

    private void cT(List<User> list) {
        if (this.ikp == null) {
            this.ikp = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.dMu = new MetaData();
            hVar.dMu.parserProtobuf(user);
            this.ikp.put(user.id.longValue(), hVar.dMu);
        }
    }

    public boolean eo(long j) {
        return (this.ikp == null || this.ikp.get(j) == null) ? false : true;
    }
}
