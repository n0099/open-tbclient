package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.RecomVertical.DataReq;
import tbclient.RecomVertical.RecomVerticalReqIdl;
/* loaded from: classes2.dex */
public class GameVideoRequestMessage extends NetMessage {
    public String class_id;
    public int load_type;
    public int new_net_type;
    public int page_thread_count;
    public int sub_class_id;

    public GameVideoRequestMessage() {
        super(CmdConfigHttp.CMD_GAME_VIDEO, 309646);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.class_id = this.class_id;
        builder.sub_class_id = Integer.valueOf(this.sub_class_id);
        builder.new_net_type = Integer.valueOf(this.new_net_type);
        builder.load_type = Integer.valueOf(this.load_type);
        builder.page_thread_count = Integer.valueOf(this.page_thread_count);
        if (z) {
            v.b(builder, true);
        }
        RecomVerticalReqIdl.Builder builder2 = new RecomVerticalReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
