package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.b;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes6.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    private a duG;
    private List<m> dvk;
    private boolean dvm;
    private List<Long> dvn;
    private LinkedList<FunctionListInfo> functionList;
    private HeadLiveInfo headLiveInfo;
    private boolean isLoadMore;
    private int isSmallFollow;
    private e mBdPageContext;
    private List<com.baidu.tieba.ala.alasquare.live.b.a> mDatas;
    private List<m> mThreadList;
    private int mPn = 1;
    private boolean mHasMore = false;
    private boolean dvl = false;
    private com.baidu.adp.framework.listener.a bRo = new com.baidu.adp.framework.listener.a(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE) { // from class: com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<com.baidu.tieba.ala.alasquare.live.b.a> linkedList;
            boolean z;
            AlaSquareLiveModel.this.dvm = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (AlaSquareLiveModel.this.dvl) {
                        AlaSquareLiveModel.this.dvl = false;
                    }
                    if (AlaSquareLiveModel.this.duG != null) {
                        AlaSquareLiveModel.this.duG.O(responsedMessage.getError(), responsedMessage.getErrorString());
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
                boolean z2 = AlaSquareLiveModel.this.dvl;
                if (AlaSquareLiveModel.this.dvl) {
                    AlaSquareLiveModel.this.dvl = false;
                    com.baidu.tieba.ala.alasquare.a.a.a(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.dvn);
                } else {
                    AlaSquareLiveModel.this.mDatas = com.baidu.tieba.ala.alasquare.a.a.a(AlaSquareLiveModel.this.mDatas, linkedList, AlaSquareLiveModel.this.isLoadMore);
                    AlaSquareLiveModel.this.mHasMore = z;
                }
                AlaSquareLiveModel.this.aIW();
                if (AlaSquareLiveModel.this.duG != null) {
                    AlaSquareLiveModel.this.duG.g(z, false, z2);
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void O(int i, String str);

        void g(boolean z, boolean z2, boolean z3);
    }

    public AlaSquareLiveModel(e eVar, BdUniqueId bdUniqueId, a aVar) {
        this.mBdPageContext = eVar;
        this.unique_id = bdUniqueId;
        this.duG = aVar;
        registerListener(this.bRo);
        aIS();
        this.mDatas = new ArrayList();
        this.functionList = new LinkedList<>();
    }

    private static void aIS() {
        com.baidu.tieba.tbadkCore.a.a.a(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, com.baidu.tieba.tbadkCore.a.a.bl(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
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

    public void aIT() {
        this.dvl = true;
        sendMessage(new AlaSquareLiveRequestMessage(1, false));
    }

    public void refresh() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.dvk != null) {
            this.dvk.clear();
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
        }
        this.dvm = true;
        this.dvl = false;
        this.isLoadMore = false;
        this.mPn = 1;
        sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
    }

    public void aIU() {
        if (hasMore()) {
            this.dvl = false;
            this.isLoadMore = true;
            this.mPn++;
            sendMessage(new AlaSquareLiveRequestMessage(this.mPn, false));
        }
    }

    public boolean isRefreshing() {
        return this.dvm;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public List<Long> getCurrentLiveIds() {
        if (v.isEmpty(this.mThreadList)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.mThreadList) {
            if (mVar instanceof b) {
                b bVar = (b) mVar;
                if (bVar.dur != null && bVar.dur.aiX() != null) {
                    linkedList.add(Long.valueOf(bVar.dur.aiX().live_id));
                }
            }
        }
        return linkedList;
    }

    public int getIsSmallFollow() {
        return this.isSmallFollow;
    }

    public void bi(List<Long> list) {
        if (!v.isEmpty(list) && !this.dvl) {
            this.dvn = list;
            aIT();
        }
    }

    public List<m> aIV() {
        return this.dvk;
    }

    public HeadLiveInfo getHeadLiveInfo() {
        return this.headLiveInfo;
    }

    public LinkedList<FunctionListInfo> getFunctionList() {
        return this.functionList;
    }

    public void aIW() {
        Pair<List<m>, List<m>> e = com.baidu.tieba.ala.alasquare.a.a.e(this.mBdPageContext.getString(R.string.square_live_category_title_hotest), this.mDatas);
        if (e != null) {
            this.dvk = (List) e.first;
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
        if (this.dvk != null) {
            this.dvk.clear();
            this.dvk = null;
        }
        if (this.mThreadList != null) {
            this.mThreadList.clear();
            this.mThreadList = null;
        }
    }
}
