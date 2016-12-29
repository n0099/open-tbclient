package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private int RM;
    private boolean aAd;
    private int bKJ;
    private a bKK;
    private final com.baidu.adp.framework.listener.a bKL;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fJ(String str);
    }

    public boolean hasMore() {
        return this.RM == 1;
    }

    public void setHasMore(int i) {
        this.RM = i;
    }

    public void a(a aVar) {
        this.bKK = aVar;
    }

    public e(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.RM = 1;
        this.aAd = false;
        this.bKJ = 0;
        this.bKL = new f(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.bKL.ch().isSelfListener();
        this.bKL.ci().isSelfListener();
        registerListener(this.bKL);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bKL.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aAd = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage aaq() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void i(long j, long j2) {
        if (!this.aAd) {
            this.aAd = true;
            ForumHeadVideoListRequestMessage aaq = aaq();
            aaq.setFid(j);
            aaq.setActiveTid(j2);
            this.curPage++;
            aaq.setPn(this.curPage);
            aaq.setRn(5);
            sendMessage(aaq);
        }
    }

    public void reset() {
        this.curPage = this.bKJ;
        this.RM = 1;
        this.mDatas.clear();
        this.aAd = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.bKK != null) {
                this.bKK.fJ(LV());
                return;
            }
            return;
        }
        if (this.curPage == this.bKJ) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.RM = dataRes.has_more.intValue();
        if (this.bKK != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bg bgVar = new bg();
                bgVar.a(threadInfo);
                bannerThreadInfoData.threadData = bgVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.bKK.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LV() {
        if (com.baidu.adp.lib.util.k.gD()) {
            return TbadkCoreApplication.m9getInst().getString(r.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(r.j.neterror);
    }
}
