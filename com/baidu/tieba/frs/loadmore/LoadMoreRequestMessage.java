package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import d.b.c.e.m.b;
import d.b.c.e.p.l;
import d.b.i0.z0.w;
import d.b.j0.s2.d0.a;
import tbclient.ThreadList.AdParam;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes4.dex */
public class LoadMoreRequestMessage extends NetMessage {
    public String adFloorInfo;
    public String forumName;
    public long forum_id;
    public boolean isBrandForum;
    public int loadCount;
    public long mLastClickTid;
    public int mPageType;
    public int mSortType;
    public int need_abstract;
    public int pn;
    public int refreshCount;
    public int st_type;
    public String thread_ids;

    public LoadMoreRequestMessage() {
        super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.adFloorInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_ids = this.thread_ids;
        builder.forum_id = Long.valueOf(this.forum_id);
        builder.need_abstract = Integer.valueOf(this.need_abstract);
        builder.user_id = Long.valueOf(b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
        builder.forum_name = this.forumName;
        builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        int k = l.k(TbadkCoreApplication.getInst());
        int i = l.i(TbadkCoreApplication.getInst());
        builder.pn = Integer.valueOf(this.pn);
        builder.st_type = Integer.valueOf(this.st_type);
        builder.scr_h = Integer.valueOf(i);
        builder.scr_w = Integer.valueOf(k);
        builder.q_type = Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
        builder.last_click_tid = Long.valueOf(this.mLastClickTid);
        builder.sort_type = Integer.valueOf(this.mSortType);
        builder.ad_context_list = d.b.j0.s2.f0.b.f().d("FRS");
        AdExtParam.a b2 = AdExtParam.a.b();
        b2.e(this.adFloorInfo);
        builder.ad_ext_params = b2.a();
        w.c(builder, true, false, true);
        builder.app_pos = a.e().a();
        AdParam.Builder builder2 = new AdParam.Builder();
        builder2.load_count = Integer.valueOf(this.loadCount);
        builder2.refresh_count = Integer.valueOf(this.refreshCount);
        builder.ad_param = builder2.build(false);
        ThreadListReqIdl.Builder builder3 = new ThreadListReqIdl.Builder();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    public long getForumId() {
        return this.forum_id;
    }

    public int getPageType() {
        return this.mPageType;
    }

    public boolean isBrandForum() {
        return this.isBrandForum;
    }

    public void setAdFloorInfo(String str) {
        this.adFloorInfo = str;
    }

    public void setBrandForum(boolean z) {
        this.isBrandForum = z;
    }

    public void setForumId(long j) {
        this.forum_id = j;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setLastClickTid(long j) {
        this.mLastClickTid = j;
    }

    public void setLoadCount(int i) {
        this.loadCount = i;
    }

    public void setNeedAbstract(int i) {
        this.need_abstract = i;
    }

    public void setPageNumber(int i) {
        this.pn = i;
    }

    public void setPageType(int i) {
        this.mPageType = i;
    }

    public void setRefreshCount(int i) {
        this.refreshCount = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void setStType(int i) {
        this.st_type = i;
    }

    public void setThreadIds(String str) {
        this.thread_ids = str;
    }
}
