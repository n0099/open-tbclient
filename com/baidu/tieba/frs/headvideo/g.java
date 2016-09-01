package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e {
    private int Rp;
    private boolean aAl;
    private int cbC;
    private a cbD;
    private final com.baidu.adp.framework.listener.a cbE;
    private int curPage;
    private final List<ThreadInfo> mDatas;

    /* loaded from: classes.dex */
    public interface a {
        void c(int i, List<BannerThreadInfoData> list);

        void fG(String str);
    }

    public boolean hasMore() {
        return this.Rp == 1;
    }

    public void setHasMore(int i) {
        this.Rp = i;
    }

    public void a(a aVar) {
        this.cbD = aVar;
    }

    public g(com.baidu.adp.base.h<?> hVar) {
        super(hVar);
        this.curPage = 0;
        this.Rp = 1;
        this.aAl = false;
        this.cbC = 0;
        this.cbE = new h(this, CmdConfigHttp.CMD_FRS_HEAD_VIDEO_LIST, 309387);
        this.mDatas = new ArrayList();
        this.cbE.ch().isSelfListener();
        this.cbE.ci().isSelfListener();
        registerListener(this.cbE);
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.cbE.setTag(bdUniqueId);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        this.aAl = false;
        return true;
    }

    private ForumHeadVideoListRequestMessage aen() {
        return new ForumHeadVideoListRequestMessage();
    }

    public void i(long j, long j2) {
        if (!this.aAl) {
            this.aAl = true;
            ForumHeadVideoListRequestMessage aen = aen();
            aen.setFid(j);
            aen.setActiveTid(j2);
            this.curPage++;
            aen.setPn(this.curPage);
            aen.setRn(5);
            sendMessage(aen);
        }
    }

    public void reset() {
        this.curPage = this.cbC;
        this.Rp = 1;
        this.mDatas.clear();
        this.aAl = false;
    }

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.cbD != null) {
                this.cbD.fG(Lp());
                return;
            }
            return;
        }
        if (this.curPage == this.cbC) {
            this.mDatas.clear();
        }
        this.mDatas.addAll(dataRes.thread_list);
        this.curPage = dataRes.pn.intValue();
        this.Rp = dataRes.has_more.intValue();
        if (this.cbD != null) {
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                bg bgVar = new bg();
                bgVar.a(threadInfo);
                bannerThreadInfoData.threadData = bgVar;
                arrayList.add(bannerThreadInfoData);
            }
            this.cbD.c(this.curPage, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Lp() {
        if (com.baidu.adp.lib.util.k.gD()) {
            return TbadkCoreApplication.m9getInst().getString(t.j.no_data_text);
        }
        return TbadkCoreApplication.m9getInst().getString(t.j.neterror);
    }
}
