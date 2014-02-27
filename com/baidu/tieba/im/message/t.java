package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgReq;
import protobuf.Im;
/* loaded from: classes.dex */
public final class t extends s implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private List<GroupMidData> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;

    public t() {
        e(202003);
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void d(int i) {
        this.e = i;
    }

    public final List<GroupMidData> b() {
        return this.a;
    }

    public final void a(List<GroupMidData> list) {
        this.a = list;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public final IDuplicateProcess.RemoveState c() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        protobuf.GetGroupMsg.b a = GetGroupMsgReq.DataReq.newBuilder().b(this.c).a(this.b).d(this.e).c(this.d).a(this.f);
        for (GroupMidData groupMidData : this.a) {
            a.a(Im.GroupLastId.newBuilder().a(groupMidData.getGroupId()).a(groupMidData.getLastMsgId()));
        }
        return GetGroupMsgReq.GetGroupMsgReqIdl.newBuilder().a(com.baidu.tieba.im.e.b()).a(a.build()).build();
    }
}
