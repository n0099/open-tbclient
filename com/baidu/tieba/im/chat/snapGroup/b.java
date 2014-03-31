package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
final class b extends com.baidu.adp.framework.c.g {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SnapGroupChatActivity snapGroupChatActivity, int i) {
        super(0);
        this.a = snapGroupChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        int i;
        int i2;
        int i3;
        UserData userData;
        com.baidu.tieba.im.chat.h hVar;
        ArrayList arrayList = null;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        switch (socketResponsedMessage2.g()) {
            case 106001:
                if (socketResponsedMessage2 instanceof ResponseChatRoomInfoMessage) {
                    ResponseChatRoomInfoMessage responseChatRoomInfoMessage = (ResponseChatRoomInfoMessage) socketResponsedMessage2;
                    com.baidu.adp.lib.util.f.e(responseChatRoomInfoMessage.toString());
                    SnapGroupChatActivity snapGroupChatActivity = this.a;
                    List<Im.UserInfo> d = responseChatRoomInfoMessage.d();
                    if (d != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Im.UserInfo userInfo : d) {
                            if (userInfo == null) {
                                userData = null;
                            } else {
                                UserData userData2 = new UserData();
                                userData2.setLoginTime(userInfo.getLoginTime());
                                userData2.setLastReplyTime(userInfo.getLastReplyTime());
                                userData2.setInTime(userInfo.getInTime());
                                userData2.setLat(String.valueOf(userInfo.getLat()));
                                userData2.setLng(String.valueOf(userInfo.getLng()));
                                userData2.setPortrait(userInfo.getPortrait());
                                userData2.setUserIdLong(userInfo.getUserId());
                                userData2.setUserName(userInfo.getUserName());
                                userData2.setPortrait(userInfo.getPortrait());
                                userData2.setSex(userInfo.getSex());
                                userData = userData2;
                            }
                            arrayList2.add(userData);
                        }
                        arrayList = arrayList2;
                    }
                    ((SnapGroupChatView) snapGroupChatActivity.d).R().setData(arrayList);
                    return;
                }
                return;
            case 106101:
                this.a.closeLoadingDialog();
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
                RandChatRoomData d2 = responseEnterChatRoomMessage.d();
                if (d2 == null || d2.e() <= 0) {
                    return;
                }
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(d2.d()));
                imMessageCenterPojo.setPulled_msgId(d2.k() * 100);
                imMessageCenterPojo.setGroup_name("聊天室");
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setIs_hidden(1);
                com.baidu.tieba.im.f.h.a(imMessageCenterPojo);
                z = this.a.t;
                if (!z) {
                    SnapGroupChatActivity snapGroupChatActivity2 = this.a;
                    i3 = snapGroupChatActivity2.r;
                    snapGroupChatActivity2.r = i3 + 1;
                }
                StringBuilder sb = new StringBuilder("restart time = ");
                i = this.a.r;
                com.baidu.adp.lib.util.f.e("simon", "onMessage", sb.append(i).toString());
                SnapGroupChatActivity snapGroupChatActivity3 = this.a;
                i2 = this.a.r;
                WaittingActivity.a(snapGroupChatActivity3, d2, i2);
                this.a.finish();
                return;
            case 106102:
                if (socketResponsedMessage2 instanceof ResponseQuitChatRoomMessage) {
                    hVar = this.a.d;
                    hVar.P();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
