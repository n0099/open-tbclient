package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import java.util.List;
import tbclient.CommonReq;
import tbclient.GetForumBroadcastList.DataReq;
import tbclient.GetForumBroadcastList.GetForumBroadcastListReqIdl;
/* loaded from: classes4.dex */
public class BroadcastMajorHistoryRequestMessage extends NetMessage {
    public static final int LOAD_RN = 15;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public static final int QUERY_TYPE_BCASTID = 2;
    public static final int QUERY_TYPE_FORUMID = 1;
    public List<Long> bcastIds;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17612common;
    public long forumId;
    public long lastId;
    public int needCount;
    public int queryType;

    public BroadcastMajorHistoryRequestMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69568common = this.f17612common;
        builder.query_type = Integer.valueOf(this.queryType);
        builder.forum_id = Long.valueOf(this.forumId);
        builder.need_cnt = Integer.valueOf(this.needCount);
        builder.staff_id = 1;
        builder.bcast_ids = this.bcastIds;
        builder.staff_id64 = Long.valueOf(this.lastId);
        if (z) {
            w.a(builder, true);
        }
        GetForumBroadcastListReqIdl.Builder builder2 = new GetForumBroadcastListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f17612common = commonReq;
    }
}
