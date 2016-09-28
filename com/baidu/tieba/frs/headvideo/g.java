package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    private int Rv;
    private boolean azO;
    private int cbE;
    private a cbF;
    private final com.baidu.adp.framework.listener.a cbG;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fK(String str);
    }

    public boolean hasMore() {
        return this.Rv == 1;
    }

    public void setHasMore(int i) {
        this.Rv = i;
    }

    public void a(a aVar) {
        this.cbF = aVar;
    }

    public g(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.Rv = 1;
        this.azO = false;
        this.cbE = 0;
        this.cbG = new h(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.cbG.ch().isSelfListener();
        this.cbG.ci().isSelfListener();
        registerListener(this.cbG);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.cbG.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.azO = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage aeC() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void j(long j, long j2) {
        if (!this.azO) {
            this.azO = true;
            ForumHeadVideoListRequestMessage aeC = aeC();
            aeC.setFid(j);
            aeC.setActiveTid(j2);
            this.curPage++;
            aeC.setPn(this.curPage);
            aeC.setRn(5);
            sendMessage(aeC);
        }
    }

    public void reset() {
        this.curPage = this.cbE;
        this.Rv = 1;
        this.mDatas.clear();
        this.azO = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.cbF != null) {
                this.cbF.fK(LW());
                return;
            }
            return;
        }
        if (this.curPage == this.cbE) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.Rv = dataRes.has_more.intValue();
        if (this.cbF != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bi biVar = new bi();
                biVar.a(threadInfo);
                bannerThreadInfoData.threadData = biVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.cbF.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LW() {
        if (com.baidu.adp.lib.util.k.gD()) {
            return TbadkCoreApplication.m9getInst().getString(r.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(r.j.neterror);
    }
}
