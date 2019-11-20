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
    private a gbC;
    private boolean gbD;
    private LongSparseArray<MetaData> gbF;
    private BaseActivity mActivity;
    private int pn = 0;
    public List<m> fqS = new ArrayList();
    public int gbE = 1;
    private com.baidu.adp.framework.listener.a fcu = new com.baidu.adp.framework.listener.a(1003099, CmdConfigSocket.CMD_GET_HOT_GOD) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.gbC != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.gbC.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.gbD, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.gbC.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.gbD, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener fqp = new CustomMessageListener(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gbC != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.sB(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.sB(1);
                } else {
                    b.this.gbC.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.gbD, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.gbC = aVar;
        this.mActivity = baseActivity;
        registerListener();
    }

    public void update() {
        this.gbE = 1;
        this.gbD = true;
        if (j.isNetworkAvailableForImmediately()) {
            sB(1);
        } else {
            sC(1);
        }
    }

    public void aIU() {
        this.gbD = false;
        sB(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        if (this.mActivity != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.mActivity.sendMessage(godSquareRequestMsg);
        }
    }

    private void sC(int i) {
        if (this.mActivity != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.mActivity.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.mActivity != null) {
            this.mActivity.registerListener(this.fqp);
            this.mActivity.registerListener(this.fcu);
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
        if (!v.isEmpty(dataRes.recommend_uid_list) && this.gbD) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.gbF.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.cbv = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.mActivity != null && !v.isEmpty(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.mActivity.getResources().getString(R.string.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.gbF.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.cbv = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.gbE;
                    arrayList3.add(fVar2);
                    this.gbE++;
                }
            }
            if (this.mActivity != null && !v.isEmpty(arrayList3) && this.gbD) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.mActivity.getResources().getString(R.string.hot_god);
                if (v.isEmpty(arrayList2)) {
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

    private void cL(List<User> list) {
        if (this.gbF == null) {
            this.gbF = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.cbv = new MetaData();
            fVar.cbv.parserProtobuf(user);
            this.gbF.put(user.id.longValue(), fVar.cbv);
        }
    }

    public boolean cQ(long j) {
        return (this.gbF == null || this.gbF.get(j) == null) ? false : true;
    }
}
