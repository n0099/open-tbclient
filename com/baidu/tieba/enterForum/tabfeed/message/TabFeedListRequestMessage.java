package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.p.l;
import d.a.n0.z0.w;
import tbclient.Tabfeedlist.DataReq;
import tbclient.Tabfeedlist.TabfeedlistReqIdl;
/* loaded from: classes4.dex */
public class TabFeedListRequestMessage extends NetMessage {
    public static final int LOAD_RN = 30;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public int loadType;
    public int pn;
    public String tabCode;
    public String tabName;

    public TabFeedListRequestMessage() {
        super(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.load_type = Integer.valueOf(this.loadType);
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = 30;
            builder.tab_name = this.tabName;
            builder.tab_code = this.tabCode;
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
            builder.scr_d = Integer.valueOf((int) l.h(TbadkCoreApplication.getInst()));
            if (z) {
                w.a(builder, true);
            }
            TabfeedlistReqIdl.Builder builder2 = new TabfeedlistReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }
}
