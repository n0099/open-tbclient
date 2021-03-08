package com.baidu.tieba.godSquare.model;

import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes7.dex */
public class b {
    private a jZU;
    private boolean jZV;
    private LongSparseArray<MetaData> jZX;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<n> jeg = new ArrayList();
    public int jZW = 1;
    private com.baidu.adp.framework.listener.a jdE = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.jZU != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.jZU.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.jZV, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.jZU.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.jZV, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener jdF = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.jZU != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.Bt(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || y.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.Bt(1);
                } else {
                    b.this.jZU.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.jZV, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.jZU = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.jZW = 1;
        this.jZV = true;
        if (j.isNetworkAvailableForImmediately()) {
            Bt(1);
        } else {
            Bu(1);
        }
    }

    public void bRp() {
        this.jZV = false;
        Bt(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void Bu(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.jdF);
            this.mActivity.registerListener(this.jdE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || y.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        dN(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(dataRes.recommend_uid_list) && this.jZV) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.jZX.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.eTa = metaData2;
                    hVar.type = 1;
                    arrayList2.add(hVar);
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
                if (l2 != null && (metaData = this.jZX.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.eTa = metaData;
                    hVar2.type = 0;
                    hVar2.rank = this.jZW;
                    arrayList3.add(hVar2);
                    this.jZW++;
                }
            }
            if (this.mActivity != null && !y.isEmpty(arrayList3) && this.jZV) {
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

    private void dN(List<User> list) {
        if (this.jZX == null) {
            this.jZX = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            hVar.eTa = new MetaData();
            hVar.eTa.parserProtobuf(user);
            this.jZX.put(user.id.longValue(), hVar.eTa);
        }
    }

    public boolean gB(long j) {
        return (this.jZX == null || this.jZX.get(j) == null) ? false : true;
    }
}
