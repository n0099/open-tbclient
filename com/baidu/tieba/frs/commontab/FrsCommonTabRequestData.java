package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.s;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes4.dex */
public class FrsCommonTabRequestData extends OrmObject implements h {
    public long fid;
    public int pn;
    public int rn = 30;
    public int tabId;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> anV() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> anW() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object eW(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = Integer.valueOf(this.tabId);
        builder.forum_id = Long.valueOf(this.fid);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_h = Integer.valueOf(l.aQ(TbadkCoreApplication.getInst()));
        builder.scr_w = Integer.valueOf(l.aO(TbadkCoreApplication.getInst()));
        builder.scr_dip = Integer.valueOf((int) l.aR(TbadkCoreApplication.getInst()));
        s.bindCommonParamsToProtobufData(builder, true, false, true);
        GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
