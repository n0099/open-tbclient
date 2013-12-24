package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgReq;
import protobuf.Im;
/* loaded from: classes.dex */
public class o extends n implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private List<GroupMidData> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;

    public o() {
        e(202003);
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public String f() {
        return this.f;
    }

    public List<GroupMidData> g() {
        return this.a;
    }

    public void a(List<GroupMidData> list) {
        this.a = list;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(n nVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        protobuf.GetGroupMsg.c a = GetGroupMsgReq.DataReq.newBuilder().b(c()).a(b()).d(e()).c(d()).a(f());
        for (GroupMidData groupMidData : g()) {
            a.a(Im.GroupLastId.newBuilder().a(groupMidData.getGroupId()).a(groupMidData.getLastMsgId()));
        }
        return GetGroupMsgReq.GetGroupMsgReqIdl.newBuilder().a(com.baidu.tieba.im.i.a()).a(a.build()).build();
    }
}
