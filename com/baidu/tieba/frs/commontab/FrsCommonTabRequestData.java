package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.p.l;
import d.b.h0.g0.b.g;
import d.b.h0.z0.w;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes4.dex */
public class FrsCommonTabRequestData extends OrmObject implements g {
    public String adExtParams;
    public long fid;
    public int pn;
    public int tabId;
    public String tabName;
    public int tabType;
    public int rn = 30;
    public long lastThreadId = -1;
    public int isDefaultNavTab = 0;
    public int isGeneralTab = 0;
    public int sortType = 0;

    @Override // d.b.h0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = Integer.valueOf(this.tabId);
        builder.tab_type = Integer.valueOf(this.tabType);
        builder.forum_id = Long.valueOf(this.fid);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.tab_name = this.tabName;
        builder.is_general_tab = Integer.valueOf(this.isGeneralTab);
        builder.sort_type = Integer.valueOf(this.sortType);
        long j = this.lastThreadId;
        if (j >= 0) {
            builder.last_thread_id = Long.valueOf(j);
        }
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_dip = Integer.valueOf((int) l.h(TbadkCoreApplication.getInst()));
        builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
        builder.ad_ext_params = this.adExtParams;
        w.c(builder, true, false, true);
        GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, Object> k() {
        return null;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, String> p() {
        return null;
    }
}
