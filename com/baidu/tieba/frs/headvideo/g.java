package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    private int Oq;
    private boolean awp;
    private int bOI;
    private a bOJ;
    private final com.baidu.adp.framework.listener.a bOK;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fF(String str);
    }

    public boolean hasMore() {
        return this.Oq == 1;
    }

    public void setHasMore(int i) {
        this.Oq = i;
    }

    public void a(a aVar) {
        this.bOJ = aVar;
    }

    public g(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.Oq = 1;
        this.awp = false;
        this.bOI = 0;
        this.bOK = new h(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.bOK.bn().isSelfListener();
        this.bOK.bo().isSelfListener();
        registerListener(this.bOK);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bOK.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.awp = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage Zg() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void c(long j, long j2) {
        if (!this.awp) {
            this.awp = true;
            ForumHeadVideoListRequestMessage Zg = Zg();
            Zg.setFid(j);
            Zg.setActiveTid(j2);
            this.curPage++;
            Zg.setPn(this.curPage);
            Zg.setRn(5);
            sendMessage(Zg);
        }
    }

    public void reset() {
        this.curPage = this.bOI;
        this.Oq = 1;
        this.mDatas.clear();
        this.awp = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.bOJ != null) {
                this.bOJ.fF(Zh());
                return;
            }
            return;
        }
        if (this.curPage == this.bOI) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.Oq = dataRes.has_more.intValue();
        if (this.bOJ != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                az azVar = new az();
                azVar.a(threadInfo);
                bannerThreadInfoData.threadData = azVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.bOJ.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Zh() {
        if (com.baidu.adp.lib.util.k.fI()) {
            return TbadkCoreApplication.m9getInst().getString(u.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(u.j.neterror);
    }
}
