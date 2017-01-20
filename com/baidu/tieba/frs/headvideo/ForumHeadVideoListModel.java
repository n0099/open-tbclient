package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class ForumHeadVideoListModel extends BdBaseModel {
    public static final int LOAD_MORE_COUNT = 5;
    private int QW;
    private int bRc;
    private a bRd;
    private final com.baidu.adp.framework.listener.a bRe;
    private int curPage;
    private boolean isLoading;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fG(String str);
    }

    public boolean hasMore() {
        return this.QW == 1;
    }

    public void setHasMore(int i) {
        this.QW = i;
    }

    public void a(a aVar) {
        this.bRd = aVar;
    }

    public ForumHeadVideoListModel(com.baidu.adp.base.g<?> gVar) {
        super(gVar);
        this.curPage = 0;
        this.QW = 1;
        this.isLoading = false;
        this.bRc = 0;
        this.bRe = new e(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.bRe.getHttpMessageListener().isSelfListener();
        this.bRe.getSocketMessageListener().isSelfListener();
        registerListener(this.bRe);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bRe.setTag(bdUniqueId);
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

    private ForumHeadVideoListRequestMessage abv() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void d(long j, long j2) {
        if (!this.isLoading) {
            this.isLoading = true;
            ForumHeadVideoListRequestMessage abv = abv();
            abv.setFid(j);
            abv.setActiveTid(j2);
            this.curPage++;
            abv.setPn(this.curPage);
            abv.setRn(5);
            sendMessage(abv);
        }
    }

    public void reset() {
        this.curPage = this.bRc;
        this.QW = 1;
        this.mDatas.clear();
        this.isLoading = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.bRd != null) {
                this.bRd.fG(abw());
                return;
            }
            return;
        }
        if (this.curPage == this.bRc) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.QW = dataRes.has_more.intValue();
        if (this.bRd != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                bannerThreadInfoData.threadData = bhVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.bRd.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String abw() {
        if (com.baidu.adp.lib.util.k.gB()) {
            return TbadkCoreApplication.m9getInst().getString(r.l.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(r.l.neterror);
    }
}
