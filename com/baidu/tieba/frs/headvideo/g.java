package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    private int OC;
    private boolean axe;
    private int bQu;
    private a bQv;
    private final com.baidu.adp.framework.listener.a bQw;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fD(String str);
    }

    public boolean hasMore() {
        return this.OC == 1;
    }

    public void setHasMore(int i) {
        this.OC = i;
    }

    public void a(a aVar) {
        this.bQv = aVar;
    }

    public g(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.OC = 1;
        this.axe = false;
        this.bQu = 0;
        this.bQw = new h(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.bQw.bm().isSelfListener();
        this.bQw.bn().isSelfListener();
        registerListener(this.bQw);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bQw.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.axe = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage ZC() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void c(long j, long j2) {
        if (!this.axe) {
            this.axe = true;
            ForumHeadVideoListRequestMessage ZC = ZC();
            ZC.setFid(j);
            ZC.setActiveTid(j2);
            this.curPage++;
            ZC.setPn(this.curPage);
            ZC.setRn(5);
            sendMessage(ZC);
        }
    }

    public void reset() {
        this.curPage = this.bQu;
        this.OC = 1;
        this.mDatas.clear();
        this.axe = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.bQv != null) {
                this.bQv.fD(ZD());
                return;
            }
            return;
        }
        if (this.curPage == this.bQu) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.OC = dataRes.has_more.intValue();
        if (this.bQv != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                be beVar = new be();
                beVar.a(threadInfo);
                bannerThreadInfoData.threadData = beVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.bQv.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ZD() {
        if (com.baidu.adp.lib.util.k.fH()) {
            return TbadkCoreApplication.m10getInst().getString(u.j.no_data_text);
        }
        return TbadkCoreApplication.m10getInst().getString(u.j.neterror);
    }
}
