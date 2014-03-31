package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.aw;
import com.baidu.tieba.im.message.y;
import com.baidu.tieba.im.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.framework.c.g {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i) {
        super(0);
        this.a = hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.adp.framework.message.d<?> h;
        String[] split;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.g() != 103112) {
                if (socketResponsedMessage2.g() == 103101 && (socketResponsedMessage2 instanceof ResponseAddGroupMessage)) {
                    ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage2;
                    if (responseAddGroupMessage.e() == 0) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        y yVar = (y) responseAddGroupMessage.h();
                        imMessageCenterPojo.setGroup_name(yVar.i());
                        imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.c.a.a(yVar.l()));
                        AddGroupInfoData d = responseAddGroupMessage.d();
                        if (d != null) {
                            imMessageCenterPojo.setGroup_head(d.getPortrait());
                            imMessageCenterPojo.setGid(String.valueOf(d.getGroupId()));
                            com.baidu.tieba.im.f.h.a(imMessageCenterPojo);
                        }
                    }
                }
            } else if (socketResponsedMessage2 instanceof ResponseRemoveMembersMessage) {
                ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage2;
                if (responseRemoveMembersMessage.e() == 0 && (h = responseRemoveMembersMessage.h()) != null && (h instanceof aw)) {
                    String j = ((aw) h).j();
                    if (TextUtils.isEmpty(j) || (split = j.split(",")) == null || split.length == 0) {
                        return;
                    }
                    String id = TbadkApplication.N().getID();
                    if (TextUtils.isEmpty(id)) {
                        return;
                    }
                    for (String str : split) {
                        if (id.equals(str)) {
                            this.a.a(responseRemoveMembersMessage.d());
                            s.a(new j(this, responseRemoveMembersMessage), null);
                            h.a().a(responseRemoveMembersMessage.d());
                            return;
                        }
                    }
                }
            }
        }
    }
}
