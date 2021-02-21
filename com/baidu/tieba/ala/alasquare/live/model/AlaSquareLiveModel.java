package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.d;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes10.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    private LinkedList<FunctionListInfo> functionList;
    private List<n> gzP;
    private boolean gzR;
    private List<Long> gzS;
    private a gzl;
    private HeadLiveInfo headLiveInfo;
    private boolean isLoadMore;
    private int isSmallFollow;
    private f mBdPageContext;
    private List<com.baidu.tieba.ala.alasquare.live.b.a> mDatas;
    private List<n> mThreadList;
    private int mPn = 1;
    private boolean mHasMore = false;
    private boolean gzQ = false;
    private com.baidu.adp.framework.listener.a eDt = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE) { // from class: com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            AlaSquareLiveModel.this.gzR = false;
            LinkedList<com.baidu.tieba.ala.alasquare.live.b.a> linkedList = null;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (AlaSquareLiveModel.this.gzQ) {
                        AlaSquareLiveModel.this.gzQ = false;
                    }
                    if (AlaSquareLiveModel.this.gzl != null) {
                        AlaSquareLiveModel.this.gzl.aJ(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                    AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                    alaSquareLiveSocketResponseMessage.setPn(AlaSquareLiveModel.this.mPn);
                    z = alaSquareLiveSocketResponseMessage.hasMore();
                    if (AlaSquareLiveModel.this.mPn == 1) {
                        AlaSquareLiveModel.this.functionList.clear();
                        AlaSquareLiveModel.this.functionList.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                    AlaSquareLiveModel.this.headLiveInfo = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                    AlaSquareLiveModel.this.isSmallFollow = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
                } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                    AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                    alaSquareLiveHttpResponseMessage.setPn(AlaSquareLiveModel.this.mPn);
                    z = alaSquareLiveHttpResponseMessage.hasMore();
                    if (AlaSquareLiveModel.this.mPn == 1) {
                        AlaSquareLiveModel.this.functionList.clear();
                        AlaSquareLiveModel.this.functionList.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                    AlaSquareLiveModel.this.headLiveInfo = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                    AlaSquareLiveModel.this.isSmallFollow = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
                } else {
                    z = false;
                }
                boolean z2 = AlaSquareLiveModel.this.gzQ;
                if (AlaSquareLiveModel.this.gzQ) {
                    AlaSquareLiveModel.this.gzQ = false;
                    d.b(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.gzS);
                } else {
                    AlaSquareLiveModel.this.mDatas = d.c(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.isLoadMore);
                    AlaSquareLiveModel.this.mHasMore = z;
                }
                AlaSquareLiveModel.this.bRl();
                if (AlaSquareLiveModel.this.gzl != null) {
                    AlaSquareLiveModel.this.gzl.j(z, false, z2);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void aJ(int i, String str);

        void j(boolean z, boolean z2, boolean z3);
    }

    public AlaSquareLiveModel(f fVar, BdUniqueId bdUniqueId, a aVar) {
        this.mBdPageContext = fVar;
        this.unique_id = bdUniqueId;
        this.gzl = aVar;
        registerListener(this.eDt);
        bRh();
        this.mDatas = new ArrayList();
        this.functionList = new LinkedList<>();
    }

    private static void bRh() {
        com.baidu.tieba.tbadkCore.a.a.a(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, com.baidu.tieba.tbadkCore.a.a.bV(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bRi() {
        this.gzQ = true;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    public void refresh() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.gzP != null) {
            this.gzP.clear();
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
        }
        this.gzR = true;
        this.gzQ = false;
        this.isLoadMore = false;
        this.mPn = 1;
        sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
    }

    public void bRj() {
        if (hasMore()) {
            this.gzQ = false;
            this.isLoadMore = true;
            this.mPn++;
            sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
        }
    }

    public boolean isRefreshing() {
        return this.gzR;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public List<Long> getCurrentLiveIds() {
        if (y.isEmpty(this.mThreadList)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.mThreadList) {
            if (nVar instanceof e) {
                e eVar = (e) nVar;
                if (eVar.gyO != null && eVar.gyO.boj() != null) {
                    linkedList.add(Long.valueOf(eVar.gyO.boj().live_id));
                }
            }
        }
        return linkedList;
    }

    public int getIsSmallFollow() {
        return this.isSmallFollow;
    }

    public void ce(List<Long> list) {
        if (!y.isEmpty(list) && !this.gzQ) {
            this.gzS = list;
            bRi();
        }
    }

    public List<n> bRk() {
        return this.gzP;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        return this.headLiveInfo;
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        return this.functionList;
    }

    public void bRl() {
        Pair<List<n>, List<n>> e = d.e(this.mBdPageContext.getString(R.string.square_live_category_title_hotest), this.mDatas);
        if (e != null) {
            this.gzP = (List) e.first;
            this.mThreadList = (List) e.second;
        }
    }

    public void onDestroy() {
        if (this.functionList != null) {
            this.functionList.clear();
            this.functionList = null;
        }
        if (this.headLiveInfo != null) {
            this.headLiveInfo = null;
        }
        if (this.mDatas != null) {
            this.mDatas.clear();
            this.mDatas = null;
        }
        if (this.gzP != null) {
            this.gzP.clear();
            this.gzP = null;
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
            this.mThreadList = null;
        }
    }
}
