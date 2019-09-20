package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.r;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes4.dex */
public class FrsCommonTabRequestData extends OrmObject implements h {
    public long fid;
    public int pn;
    public int tabId;
    public int rn = 30;
    public long lastThreadId = -1;
    public int isDefaultNavTab = 0;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> auu() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> auv() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object fz(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = Integer.valueOf(this.tabId);
        builder.forum_id = Long.valueOf(this.fid);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (this.lastThreadId >= 0) {
            builder.last_thread_id = Long.valueOf(this.lastThreadId);
        }
        builder.scr_h = Integer.valueOf(l.ah(TbadkCoreApplication.getInst()));
        builder.scr_w = Integer.valueOf(l.af(TbadkCoreApplication.getInst()));
        builder.scr_dip = Integer.valueOf((int) l.ai(TbadkCoreApplication.getInst()));
        builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
        r.bindCommonParamsToProtobufData(builder, true, false, true);
        GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
