package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2.g() == 103008) {
            if (socketResponsedMessage2 instanceof ResponseUserPermissionMessage) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage2;
                    if (responseUserPermissionMessage.e() > 0) {
                        this.a.a(responseUserPermissionMessage.f());
                    } else {
                        GroupPermData d = responseUserPermissionMessage.d();
                        if (d != null) {
                            if (d.isCreatePersonal()) {
                                CreateGroupStepActivity.a(this.a.getActivity(), 2, 0, 1011, d.getCanCreateNormalNum(), d.getCanCreateOfficialNum(), d.getCanCreatePersonalNum());
                            } else if (!TextUtils.isEmpty(d.getCreatePersonalTip())) {
                                this.a.a(d.getCreatePersonalTip());
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else if (socketResponsedMessage2.g() == 106101) {
            eVar = this.a.g;
            eVar.c();
            if (!(socketResponsedMessage2 instanceof ResponseEnterChatRoomMessage)) {
                this.a.a(com.baidu.tieba.im.j.neterror);
                return;
            }
            ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage2;
            if (responseEnterChatRoomMessage.e() != 0) {
                if (responseEnterChatRoomMessage.e() <= 0) {
                    this.a.a(com.baidu.tieba.im.j.neterror);
                    return;
                } else if (TextUtils.isEmpty(responseEnterChatRoomMessage.f())) {
                    return;
                } else {
                    this.a.a(responseEnterChatRoomMessage.f());
                    return;
                }
            }
            RandChatRoomData d2 = responseEnterChatRoomMessage.d();
            if (d2 == null || d2.e() <= 0) {
                return;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(d2.d()));
            imMessageCenterPojo.setPulled_msgId(d2.k() * 100);
            imMessageCenterPojo.setCustomGroupType(3);
            imMessageCenterPojo.setGroup_name("聊天室");
            imMessageCenterPojo.setIs_delete(0);
            imMessageCenterPojo.setIs_hidden(1);
            com.baidu.tieba.im.f.h.a(imMessageCenterPojo);
            eVar2 = this.a.g;
            WaittingActivity.a(eVar2, d2, 0);
        }
    }
}
