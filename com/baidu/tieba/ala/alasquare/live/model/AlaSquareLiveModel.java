package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.b;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes4.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    private LinkedList<FunctionListInfo> functionList;
    private List<q> giH;
    private boolean giJ;
    private List<Long> giK;
    private a gic;
    private HeadLiveInfo headLiveInfo;
    private boolean isLoadMore;
    private int isSmallFollow;
    private e mBdPageContext;
    private List<com.baidu.tieba.ala.alasquare.live.b.a> mDatas;
    private List<q> mThreadList;
    private int mPn = 1;
    private boolean mHasMore = false;
    private boolean giI = false;
    private com.baidu.adp.framework.listener.a ers = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE) { // from class: com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<com.baidu.tieba.ala.alasquare.live.b.a> linkedList;
            boolean z;
            AlaSquareLiveModel.this.giJ = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (AlaSquareLiveModel.this.giI) {
                        AlaSquareLiveModel.this.giI = false;
                    }
                    if (AlaSquareLiveModel.this.gic != null) {
                        AlaSquareLiveModel.this.gic.aE(responsedMessage.getError(), responsedMessage.getErrorString());
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
                } else if (!(responsedMessage instanceof AlaSquareLiveHttpResponseMessage)) {
                    linkedList = null;
                    z = false;
                } else {
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
                }
                boolean z2 = AlaSquareLiveModel.this.giI;
                if (AlaSquareLiveModel.this.giI) {
                    AlaSquareLiveModel.this.giI = false;
                    b.a(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.giK);
                } else {
                    AlaSquareLiveModel.this.mDatas = b.a(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.isLoadMore);
                    AlaSquareLiveModel.this.mHasMore = z;
                }
                AlaSquareLiveModel.this.bOK();
                if (AlaSquareLiveModel.this.gic != null) {
                    AlaSquareLiveModel.this.gic.i(z, false, z2);
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void aE(int i, String str);

        void i(boolean z, boolean z2, boolean z3);
    }

    public AlaSquareLiveModel(e eVar, BdUniqueId bdUniqueId, a aVar) {
        this.mBdPageContext = eVar;
        this.unique_id = bdUniqueId;
        this.gic = aVar;
        registerListener(this.ers);
        bOG();
        this.mDatas = new ArrayList();
        this.functionList = new LinkedList<>();
    }

    private static void bOG() {
        com.baidu.tieba.tbadkCore.a.a.a(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, com.baidu.tieba.tbadkCore.a.a.bL(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
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

    public void bOH() {
        this.giI = true;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    public void refresh() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.giH != null) {
            this.giH.clear();
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
        }
        this.giJ = true;
        this.giI = false;
        this.isLoadMore = false;
        this.mPn = 1;
        sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
    }

    public void bOI() {
        if (hasMore()) {
            this.giI = false;
            this.isLoadMore = true;
            this.mPn++;
            sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
        }
    }

    public boolean isRefreshing() {
        return this.giJ;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public List<Long> getCurrentLiveIds() {
        if (y.isEmpty(this.mThreadList)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.mThreadList) {
            if (qVar instanceof c) {
                c cVar = (c) qVar;
                if (cVar.ghO != null && cVar.ghO.bmU() != null) {
                    linkedList.add(Long.valueOf(cVar.ghO.bmU().live_id));
                }
            }
        }
        return linkedList;
    }

    public int getIsSmallFollow() {
        return this.isSmallFollow;
    }

    public void bY(List<Long> list) {
        if (!y.isEmpty(list) && !this.giI) {
            this.giK = list;
            bOH();
        }
    }

    public List<q> bOJ() {
        return this.giH;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        return this.headLiveInfo;
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        return this.functionList;
    }

    public void bOK() {
        Pair<List<q>, List<q>> e = b.e(this.mBdPageContext.getString(R.string.square_live_category_title_hotest), this.mDatas);
        if (e != null) {
            this.giH = (List) e.first;
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
        if (this.giH != null) {
            this.giH.clear();
            this.giH = null;
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
            this.mThreadList = null;
        }
    }
}
