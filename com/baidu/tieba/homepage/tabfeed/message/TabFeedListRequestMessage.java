package com.baidu.tieba.homepage.tabfeed.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.util.u;
import tbclient.ActivityPage.ActivityPageReqIdl;
import tbclient.ActivityPage.DataReq;
/* loaded from: classes22.dex */
public class TabFeedListRequestMessage extends NetMessage {
    public static final int LOAD_RN = 20;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public int loadType;
    public int pn;
    public String tabCode;
    public String tabName;

    public TabFeedListRequestMessage() {
        super(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.activity_name = this.tabCode;
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = 20;
            builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) l.getEquipmentDensity(TbadkCoreApplication.getInst()));
            builder.q_type = Integer.valueOf(k.bfo().getViewImageQuality());
            if (z) {
                u.a(builder, true);
            }
            ActivityPageReqIdl.Builder builder2 = new ActivityPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
