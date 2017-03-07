package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class ForumHeadVideoListModel extends BdBaseModel {
    public static final int LOAD_MORE_COUNT = 5;
    private int Wi;
    private int bYk;
    private a bYl;
    private final com.baidu.adp.framework.listener.a bYm;
    private int curPage;
    private boolean isLoading;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fv(String str);
    }

    public boolean hasMore() {
        return this.Wi == 1;
    }

    public void setHasMore(int i) {
        this.Wi = i;
    }

    public void a(a aVar) {
        this.bYl = aVar;
    }

    public ForumHeadVideoListModel(com.baidu.adp.base.g<?> gVar) {
        super(gVar);
        this.curPage = 0;
        this.Wi = 1;
        this.isLoading = false;
        this.bYk = 0;
        this.bYm = new e(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.bYm.getHttpMessageListener().isSelfListener();
        this.bYm.getSocketMessageListener().isSelfListener();
        registerListener(this.bYm);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bYm.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage acs() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void d(long j, long j2) {
        if (!this.isLoading) {
            this.isLoading = true;
            ForumHeadVideoListRequestMessage acs = acs();
            acs.setFid(j);
            acs.setActiveTid(j2);
            this.curPage++;
            acs.setPn(this.curPage);
            acs.setRn(5);
            sendMessage(acs);
        }
    }

    public void reset() {
        this.curPage = this.bYk;
        this.Wi = 1;
        this.mDatas.clear();
        this.isLoading = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.bYl != null) {
                this.bYl.fv(act());
                return;
            }
            return;
        }
        if (this.curPage == this.bYk) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.Wi = dataRes.has_more.intValue();
        if (this.bYl != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                bannerThreadInfoData.threadData = bjVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.bYl.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String act() {
        if (com.baidu.adp.lib.util.k.hv()) {
            return TbadkCoreApplication.m9getInst().getString(w.l.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(w.l.neterror);
    }
}
