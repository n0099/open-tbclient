package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class CommonGroupMsglistModel extends MsglistModel {
    protected GroupData a;
    private f e;
    private final com.baidu.adp.framework.c.g f;

    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.f = new c(this, 0);
        this.e = new f(this, (byte) 0);
        com.baidu.tieba.im.chat.x.b().a(this.e);
        com.baidu.adp.framework.c.a().a(103112, this.f);
        com.baidu.adp.framework.c.a().a(103102, this.f);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.f);
        com.baidu.tieba.im.chat.x.b().b(this.e);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void a(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.s.a(new d(this, aVar), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void b(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.s.a(new e(this, aVar), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        return null;
    }

    public final void a(GroupData groupData) {
        this.a = groupData;
    }

    public final GroupData b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        LinkedList<com.baidu.tieba.im.message.a.a> c;
        if (fVar instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) fVar;
            if (this.a != null && groupMsgData.b() != null && groupMsgData.b().getGroupId() == this.a.getGroupId() && (c = groupMsgData.c()) != null) {
                a(c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0.i().equals(java.lang.String.valueOf(r3.a.getGroupId())) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ boolean a(CommonGroupMsglistModel commonGroupMsglistModel, ResponseCommitGroupMessage responseCommitGroupMessage) {
        if (responseCommitGroupMessage != null && commonGroupMsglistModel.a != null) {
            if (responseCommitGroupMessage.e() != 0) {
                if (responseCommitGroupMessage.h() != null && (responseCommitGroupMessage.h() instanceof com.baidu.tieba.im.message.a.b)) {
                    com.baidu.tieba.im.message.a.b bVar = (com.baidu.tieba.im.message.a.b) responseCommitGroupMessage.h();
                    if (bVar.i() != null) {
                    }
                }
                return false;
            } else if (responseCommitGroupMessage.j() == null || !responseCommitGroupMessage.j().equals(String.valueOf(commonGroupMsglistModel.a.getGroupId()))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(CommonGroupMsglistModel commonGroupMsglistModel, com.baidu.adp.framework.message.f fVar) {
        com.baidu.adp.framework.message.d<?> h;
        String[] split;
        if (fVar instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) fVar;
            if (responseRemoveMembersMessage.e() == 0 && (h = responseRemoveMembersMessage.h()) != null && (h instanceof com.baidu.tieba.im.message.aw)) {
                com.baidu.tieba.im.message.aw awVar = (com.baidu.tieba.im.message.aw) h;
                if (awVar.i() == commonGroupMsglistModel.a.getGroupId()) {
                    String j = awVar.j();
                    if (TextUtils.isEmpty(j) || (split = j.split(",")) == null || split.length == 0) {
                        return;
                    }
                    String id = TbadkApplication.N().getID();
                    if (TextUtils.isEmpty(id)) {
                        return;
                    }
                    for (String str : split) {
                        if (id.equals(str)) {
                            commonGroupMsglistModel.mLoadDataMode = 9;
                            commonGroupMsglistModel.mLoadDataCallBack.a(null);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(CommonGroupMsglistModel commonGroupMsglistModel, com.baidu.adp.framework.message.f fVar) {
        if (!(fVar instanceof ResponseUpdateGroupMessage)) {
            com.baidu.adp.lib.util.f.e("transform error");
            return;
        }
        ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) fVar;
        if (responseUpdateGroupMessage.e() != 0) {
            com.baidu.adp.lib.util.f.b("has error");
        } else if (responseUpdateGroupMessage.d() != null) {
            commonGroupMsglistModel.mLoadDataMode = 10;
            commonGroupMsglistModel.mLoadDataCallBack.a(responseUpdateGroupMessage.d().getName());
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.c(String.valueOf(this.a.getGroupId()));
        aVar.a(null);
        com.baidu.tieba.im.message.ao aoVar = new com.baidu.tieba.im.message.ao();
        aoVar.a((com.baidu.tieba.im.message.ao) String.valueOf(this.a.getGroupId()));
        com.baidu.adp.framework.c.a().a(aoVar);
    }
}
