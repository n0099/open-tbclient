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
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes18.dex */
public class b {
    private a iqr;
    private boolean iqs;
    private LongSparseArray<MetaData> iqu;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<q> hBA = new ArrayList();
    public int iqt = 1;
    private com.baidu.adp.framework.listener.a hAY = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.iqr != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.iqr.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.iqs, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.iqr.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.iqs, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener hAZ = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.iqr != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.xd(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || x.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.xd(1);
                } else {
                    b.this.iqr.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.iqs, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes18.dex */
    public interface a {
        void a(List<q> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.iqr = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.iqt = 1;
        this.iqs = true;
        if (j.isNetworkAvailableForImmediately()) {
            xd(1);
        } else {
            xe(1);
        }
    }

    public void bwE() {
        this.iqs = false;
        xd(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void xe(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.hAZ);
            this.mActivity.registerListener(this.hAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || x.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cY(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!x.isEmpty(dataRes.recommend_uid_list) && this.iqs) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.iqu.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.dSF = metaData2;
                    hVar.type = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.mActivity != null && !x.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.title = this.mActivity.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!x.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.iqu.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.dSF = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.iqt;
                    arrayList3.add(hVar2);
                    this.iqt++;
                }
            }
            if (this.mActivity != null && !x.isEmpty(arrayList3) && this.iqs) {
                e eVar2 = new e();
                eVar2.title = this.mActivity.getResources().getString(R.string.hot_god);
                if (x.isEmpty(arrayList2)) {
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

    private void cY(List<User> list) {
        if (this.iqu == null) {
            this.iqu = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.dSF = new MetaData();
            hVar.dSF.parserProtobuf(user);
            this.iqu.put(user.id.longValue(), hVar.dSF);
        }
    }

    public boolean eB(long j) {
        return (this.iqu == null || this.iqu.get(j) == null) ? false : true;
    }
}
