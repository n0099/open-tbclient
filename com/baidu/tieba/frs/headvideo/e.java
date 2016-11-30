package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private int RR;
    private boolean aAG;
    private int cfa;
    private a cfb;
    private final com.baidu.adp.framework.listener.a cfc;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fN(String str);
    }

    public boolean hasMore() {
        return this.RR == 1;
    }

    public void setHasMore(int i) {
        this.RR = i;
    }

    public void a(a aVar) {
        this.cfb = aVar;
    }

    public e(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.RR = 1;
        this.aAG = false;
        this.cfa = 0;
        this.cfc = new f(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.cfc.ch().isSelfListener();
        this.cfc.ci().isSelfListener();
        registerListener(this.cfc);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.cfc.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aAG = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage afU() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void j(long j, long j2) {
        if (!this.aAG) {
            this.aAG = true;
            ForumHeadVideoListRequestMessage afU = afU();
            afU.setFid(j);
            afU.setActiveTid(j2);
            this.curPage++;
            afU.setPn(this.curPage);
            afU.setRn(5);
            sendMessage(afU);
        }
    }

    public void reset() {
        this.curPage = this.cfa;
        this.RR = 1;
        this.mDatas.clear();
        this.aAG = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.cfb != null) {
                this.cfb.fN(MC());
                return;
            }
            return;
        }
        if (this.curPage == this.cfa) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.RR = dataRes.has_more.intValue();
        if (this.cfb != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                bannerThreadInfoData.threadData = bkVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.cfb.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String MC() {
        if (com.baidu.adp.lib.util.k.gD()) {
            return TbadkCoreApplication.m9getInst().getString(r.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(r.j.neterror);
    }
}
