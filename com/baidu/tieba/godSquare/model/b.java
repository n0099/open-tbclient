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
    private BaseActivity cVo;
    private a fVo;
    private boolean fVp;
    private LongSparseArray<MetaData> fVr;
    private int pn = 0;
    public List<m> fll = new ArrayList();
    public int fVq = 1;
    private com.baidu.adp.framework.listener.a eTE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315) { // from class: com.baidu.tieba.godSquare.model.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.fVo != null) {
                if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                    GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                    b.this.fVo.a(b.this.a(godSquareHttpResponsedMsg.getResult()), b.this.fVp, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
                } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                    GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                    b.this.fVo.a(b.this.a(godSquareSocketResponsedMsg.getResult()), b.this.fVp, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
                }
            }
        }
    };
    private CustomMessageListener fkJ = new CustomMessageListener(2016446) { // from class: com.baidu.tieba.godSquare.model.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fVo != null) {
                if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                    b.this.tj(1);
                    return;
                }
                GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
                if (godSquareCacheResponsedMsg.getResult() == null || v.aa(godSquareCacheResponsedMsg.getResult().user_list)) {
                    b.this.tj(1);
                } else {
                    b.this.fVo.a(b.this.a(godSquareCacheResponsedMsg.getResult()), b.this.fVp, true, godSquareCacheResponsedMsg.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<m> list, boolean z, boolean z2, String str);
    }

    public b(a aVar, BaseActivity baseActivity) {
        this.fVo = aVar;
        this.cVo = baseActivity;
        registerListener();
    }

    public void update() {
        this.fVq = 1;
        this.fVp = true;
        if (j.jG()) {
            tj(1);
        } else {
            tk(1);
        }
    }

    public void aHq() {
        this.fVp = false;
        tj(this.pn + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        if (this.cVo != null) {
            this.pn = i;
            GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
            godSquareRequestMsg.pn = i;
            this.cVo.sendMessage(godSquareRequestMsg);
        }
    }

    private void tk(int i) {
        if (this.cVo != null) {
            GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
            godSquareCacheRequestMsg.cacheKey = i + "";
            this.cVo.sendMessage(godSquareCacheRequestMsg);
        }
    }

    private void registerListener() {
        if (this.cVo != null) {
            this.cVo.registerListener(this.fkJ);
            this.cVo.registerListener(this.eTE);
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
        cy(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(dataRes.recommend_uid_list) && this.fVp) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.fVr.get(l.longValue())) != null) {
                    f fVar = new f();
                    fVar.bJa = metaData2;
                    fVar.type = 1;
                    arrayList2.add(fVar);
                }
            }
            if (this.cVo != null && !v.aa(arrayList2)) {
                com.baidu.tieba.card.divider.b bVar = new com.baidu.tieba.card.divider.b();
                bVar.title = this.cVo.getResources().getString(R.string.special_recommend);
                bVar.needTopMargin = false;
                arrayList2.add(0, bVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!v.aa(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.fVr.get(l2.longValue())) != null) {
                    f fVar2 = new f();
                    fVar2.bJa = metaData;
                    fVar2.type = 0;
                    fVar2.rank = this.fVq;
                    arrayList3.add(fVar2);
                    this.fVq++;
                }
            }
            if (this.cVo != null && !v.aa(arrayList3) && this.fVp) {
                com.baidu.tieba.card.divider.b bVar2 = new com.baidu.tieba.card.divider.b();
                bVar2.title = this.cVo.getResources().getString(R.string.hot_god);
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

    private void cy(List<User> list) {
        if (this.fVr == null) {
            this.fVr = new LongSparseArray<>();
        }
        for (User user : list) {
            f fVar = new f();
            fVar.bJa = new MetaData();
            fVar.bJa.parserProtobuf(user);
            this.fVr.put(user.id.longValue(), fVar.bJa);
        }
    }

    public boolean dh(long j) {
        return (this.fVr == null || this.fVr.get(j) == null) ? false : true;
    }
}
