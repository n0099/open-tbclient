package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.v;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes2.dex */
public class FrsCommonTabRequestData extends OrmObject implements h {
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

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> bDk() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> bDl() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object lg(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = Integer.valueOf(this.tabId);
        builder.tab_type = Integer.valueOf(this.tabType);
        builder.forum_id = Long.valueOf(this.fid);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.tab_name = this.tabName;
        builder.is_general_tab = Integer.valueOf(this.isGeneralTab);
        builder.sort_type = Integer.valueOf(this.sortType);
        if (this.lastThreadId >= 0) {
            builder.last_thread_id = Long.valueOf(this.lastThreadId);
        }
        builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        builder.scr_dip = Integer.valueOf((int) l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
        builder.ad_ext_params = this.adExtParams;
        v.a(builder, true, false, true);
        GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
