package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.p;
import tbclient.ThreadList.AdParam;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes2.dex */
public class LoadMoreRequestMessage extends NetMessage {
    private String forumName;
    private long forum_id;
    private boolean isBrandForum;
    private int loadCount;
    private long mLastClickTid;
    private int mPageType;
    private int mSortType;
    private int need_abstract;
    private int pn;
    private int refreshCount;
    private int st_type;
    private String thread_ids;

    public LoadMoreRequestMessage() {
        super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
    }

    public void setLastClickTid(long j) {
        this.mLastClickTid = j;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void setThreadIds(String str) {
        this.thread_ids = str;
    }

    public void setForumId(long j) {
        this.forum_id = j;
    }

    public void setNeedAbstract(int i) {
        this.need_abstract = i;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setPageNumber(int i) {
        this.pn = i;
    }

    public void setStType(int i) {
        this.st_type = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_ids = this.thread_ids;
        builder.forum_id = Long.valueOf(this.forum_id);
        builder.need_abstract = Integer.valueOf(this.need_abstract);
        builder.user_id = Long.valueOf(b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        builder.forum_name = this.forumName;
        builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
        int ah = l.ah(TbadkCoreApplication.getInst());
        int aj = l.aj(TbadkCoreApplication.getInst());
        builder.pn = Integer.valueOf(this.pn);
        builder.st_type = Integer.valueOf(this.st_type);
        builder.scr_h = Integer.valueOf(aj);
        builder.scr_w = Integer.valueOf(ah);
        builder.q_type = Integer.valueOf(ar.zF().zH() ? 2 : 1);
        builder.last_click_tid = Long.valueOf(this.mLastClickTid);
        builder.sort_type = Integer.valueOf(this.mSortType);
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        builder.app_pos = com.baidu.tieba.recapp.d.a.bpy().bpB();
        AdParam.Builder builder2 = new AdParam.Builder();
        builder2.load_count = Integer.valueOf(this.loadCount);
        builder2.refresh_count = Integer.valueOf(this.refreshCount);
        builder.ad_param = builder2.build(false);
        ThreadListReqIdl.Builder builder3 = new ThreadListReqIdl.Builder();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    public void setPageType(int i) {
        this.mPageType = i;
    }

    public int getPageType() {
        return this.mPageType;
    }

    public void setLoadCount(int i) {
        this.loadCount = i;
    }

    public void setRefreshCount(int i) {
        this.refreshCount = i;
    }

    public boolean isBrandForum() {
        return this.isBrandForum;
    }

    public void setBrandForum(boolean z) {
        this.isBrandForum = z;
    }
}
