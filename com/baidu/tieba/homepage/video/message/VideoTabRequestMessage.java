package com.baidu.tieba.homepage.video.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.b.e.p.l;
import d.b.h0.z0.w;
import tbclient.RecomVideo.DataReq;
import tbclient.RecomVideo.RecomVideoReqIdl;
/* loaded from: classes4.dex */
public class VideoTabRequestMessage extends NetMessage {
    public int load_type;
    public int new_net_type;
    public int page_thread_count;

    public VideoTabRequestMessage() {
        super(CmdConfigHttp.CMD_VIDEO_TAB, 309648);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
        builder.new_net_type = Integer.valueOf(this.new_net_type);
        builder.load_type = Integer.valueOf(this.load_type);
        builder.page_thread_count = Integer.valueOf(this.page_thread_count);
        if (z) {
            w.a(builder, true);
        }
        RecomVideoReqIdl.Builder builder2 = new RecomVideoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
