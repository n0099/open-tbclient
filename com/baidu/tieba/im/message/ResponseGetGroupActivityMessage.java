package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
public class ResponseGetGroupActivityMessage extends TbSocketReponsedMessage {
    private GroupActivityData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupActivityRes.QueryGroupActivityResIdl parseFrom = QueryGroupActivityRes.QueryGroupActivityResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            QueryGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setActivityPortrait(data.getActivityPortrait());
            groupActivityData.setgActivityArea(data.getGActivityArea());
            groupActivityData.setgActivityContent(data.getGActivityContent());
            groupActivityData.setgActivityTime(data.getGActivityTime());
            groupActivityData.setgActivityTitle(data.getGActivityTitle());
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setActivityId(data.getActivityId());
            groupActivityData.setUserId(data.getUserId());
            groupActivityData.setUserName(data.getUserName());
            groupActivityData.setIsEnd(data.getIsEnd());
            this.a = groupActivityData;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (this.a == null || e() != 0) {
            return;
        }
        a(com.baidu.tbadk.core.c.b.a().r(), "group_activity" + (TbadkApplication.N() != null ? TbadkApplication.N().getID() : "") + this.a.getActivityId(), bArr2);
    }

    public ResponseGetGroupActivityMessage() {
        super(103015);
    }

    public final GroupActivityData d() {
        return this.a;
    }
}
