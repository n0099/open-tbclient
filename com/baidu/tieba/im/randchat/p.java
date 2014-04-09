package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseUpdateChatroomTopicMessage;
import com.baidu.tieba.im.message.au;
import com.baidu.tieba.im.model.bv;
import com.baidu.tieba.im.randchat.WaitingTipView;
import java.util.ArrayList;
import protobuf.Im;
/* loaded from: classes.dex */
final class p extends com.baidu.adp.framework.c.g {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(WaittingActivity waittingActivity, int i) {
        super(0);
        this.a = waittingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        bv bvVar;
        ArrayList arrayList;
        f fVar;
        bv bvVar2;
        bv bvVar3;
        WaitingTipView.Type type;
        f fVar2;
        bv bvVar4;
        f fVar3;
        f fVar4;
        bv unused;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        this.a.closeLoadingDialog();
        if (socketResponsedMessage2 == null) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.g() == 106103) {
            if ((socketResponsedMessage2 instanceof ResponseUpdateChatroomTopicMessage) && ((ResponseUpdateChatroomTopicMessage) socketResponsedMessage2).e() == 0) {
                type = this.a.i;
                if (type == WaitingTipView.Type.PERSONS_READY) {
                    fVar4 = this.a.a;
                    fVar4.d().getLoadingView().setVisibility(0);
                    return;
                }
                fVar2 = this.a.a;
                com.baidu.tieba.im.view.h chatterboxView = fVar2.d().getChatterboxView();
                bvVar4 = this.a.b;
                chatterboxView.setTitle(bvVar4.h());
                fVar3 = this.a.a;
                fVar3.d().getLoadingView().setVisibility(8);
            }
        } else if (socketResponsedMessage2.g() == 106102) {
            if (!(socketResponsedMessage2 instanceof ResponseQuitChatRoomMessage)) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
            }
            ResponseQuitChatRoomMessage responseQuitChatRoomMessage = (ResponseQuitChatRoomMessage) socketResponsedMessage2;
            com.baidu.adp.framework.message.d<?> h = responseQuitChatRoomMessage.h();
            if (!(h instanceof au) || ((au) h).i() == 0) {
                if (responseQuitChatRoomMessage.e() != 0) {
                    if (responseQuitChatRoomMessage.e() <= 0) {
                        this.a.showToast(com.baidu.tieba.im.j.neterror);
                    } else if (!TextUtils.isEmpty(responseQuitChatRoomMessage.f())) {
                        this.a.showToast(responseQuitChatRoomMessage.f());
                    }
                }
                bvVar3 = this.a.b;
                com.baidu.tieba.im.f.h.a(String.valueOf(bvVar3.f().d()));
                this.a.finish();
            }
        } else if (socketResponsedMessage2 != null && socketResponsedMessage2.g() == 106101) {
            if (!(socketResponsedMessage2 instanceof ResponseEnterChatRoomMessage)) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            }
            ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage2;
            if (responseEnterChatRoomMessage.e() != 0) {
                if (responseEnterChatRoomMessage.e() <= 0) {
                    this.a.showToast(com.baidu.tieba.im.j.neterror);
                    return;
                } else if (TextUtils.isEmpty(responseEnterChatRoomMessage.f())) {
                    return;
                } else {
                    this.a.showToast(responseEnterChatRoomMessage.f());
                    return;
                }
            }
            RandChatRoomData d = responseEnterChatRoomMessage.d();
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(d.d()));
            imMessageCenterPojo.setPulled_msgId(d.k() * 100);
            imMessageCenterPojo.setCustomGroupType(3);
            imMessageCenterPojo.setGroup_name("聊天室");
            imMessageCenterPojo.setIs_delete(0);
            imMessageCenterPojo.setIs_hidden(1);
            com.baidu.tieba.im.f.h.a(imMessageCenterPojo);
            this.a.a(d, false);
            bvVar2 = this.a.b;
            bvVar2.b(d);
            this.a.b();
            this.a.c();
        } else if (socketResponsedMessage2.g() == 106001 && (socketResponsedMessage2 instanceof ResponseChatRoomInfoMessage)) {
            ResponseChatRoomInfoMessage responseChatRoomInfoMessage = (ResponseChatRoomInfoMessage) socketResponsedMessage2;
            bvVar = this.a.b;
            RandChatRoomData f = bvVar.f();
            unused = this.a.b;
            if (responseChatRoomInfoMessage == null || responseChatRoomInfoMessage.d() == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Im.UserInfo userInfo : responseChatRoomInfoMessage.d()) {
                    UserData userData = new UserData();
                    userData.setInTime(userInfo.getInTime());
                    userData.setLastReplyTime(userInfo.getLastReplyTime());
                    userData.setLat(String.valueOf(userInfo.getLat()));
                    userData.setLng(String.valueOf(userInfo.getLng()));
                    userData.setLoginTime(userInfo.getLoginTime());
                    userData.setPortrait(userInfo.getPortrait());
                    userData.setPosition(userInfo.getPosition());
                    userData.setSex(userInfo.getSex());
                    userData.setUserIdLong(userInfo.getUserId());
                    userData.setUserName(userInfo.getUserName());
                    arrayList2.add(userData);
                }
                arrayList = arrayList2;
            }
            f.b(arrayList);
            fVar = this.a.a;
            fVar.d().c();
            this.a.c();
        }
    }
}
