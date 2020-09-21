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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.i;
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
/* loaded from: classes23.dex */
public class b {
    private a iLW;
    private boolean iLX;
    private LongSparseArray<MetaData> iLZ;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<q> hVV = new ArrayList();
    public int iLY = 1;
    private com.baidu.adp.framework.listener.a hVt = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.iLW != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.iLW.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.iLX, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.iLW.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.iLX, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener hVu = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.iLW != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.zV(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || y.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.zV(1);
                } else {
                    b.this.iLW.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.iLX, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void a(List<q> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.iLW = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.iLY = 1;
        this.iLX = true;
        if (j.isNetworkAvailableForImmediately()) {
            zV(1);
        } else {
            zW(1);
        }
    }

    public void bGU() {
        this.iLX = false;
        zV(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void zW(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.hVu);
            this.mActivity.registerListener(this.hVt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || y.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        df(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(dataRes.recommend_uid_list) && this.iLX) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.iLZ.get(l.longValue())) != null) {
                    i iVar = new i();
                    iVar.eep = metaData2;
                    iVar.type = 1;
                    arrayList2.add(iVar);
                }
            }
            if (this.mActivity != null && !y.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.title = this.mActivity.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!y.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.iLZ.get(l2.longValue())) != null) {
                    i iVar2 = new i();
                    iVar2.eep = metaData;
                    iVar2.type = 0;
                    iVar2.rank = this.iLY;
                    arrayList3.add(iVar2);
                    this.iLY++;
                }
            }
            if (this.mActivity != null && !y.isEmpty(arrayList3) && this.iLX) {
                e eVar2 = new e();
                eVar2.title = this.mActivity.getResources().getString(R.string.hot_god);
                if (y.isEmpty(arrayList2)) {
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

    private void df(List<User> list) {
        if (this.iLZ == null) {
            this.iLZ = new LongSparseArray<>();
        }
        for (User user : list) {
            i iVar = new i();
            iVar.eep = new MetaData();
            iVar.eep.parserProtobuf(user);
            this.iLZ.put(user.id.longValue(), iVar.eep);
        }
    }

    public boolean fa(long j) {
        return (this.iLZ == null || this.iLZ.get(j) == null) ? false : true;
    }
}
