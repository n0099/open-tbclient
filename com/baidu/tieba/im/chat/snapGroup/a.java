package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.co;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
final class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.data.b a;
        UserData userData;
        com.baidu.tieba.im.chat.a aVar;
        ArrayList arrayList = null;
        switch (sVar.w()) {
            case -119:
                if (sVar instanceof com.baidu.tieba.im.message.c) {
                    String a2 = ((com.baidu.tieba.im.message.c) sVar).a();
                    if (!TextUtils.isEmpty(a2) && (a = com.baidu.tieba.im.data.b.a(a2)) != null) {
                        switch (a.h) {
                            case 202:
                                SnapGroupChatActivity.a(this.a, a);
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                }
                return;
            case 106001:
                if (sVar instanceof bn) {
                    bn bnVar = (bn) sVar;
                    com.baidu.adp.lib.util.e.e(bnVar.toString());
                    SnapGroupChatActivity snapGroupChatActivity = this.a;
                    List<Im.UserInfo> a3 = bnVar.a();
                    if (a3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Im.UserInfo userInfo : a3) {
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
                    ((SnapGroupChatView) snapGroupChatActivity.d).P().setData(arrayList);
                    return;
                }
                return;
            case 106101:
                this.a.closeLoadingDialog();
                if (!(sVar instanceof bw)) {
                    this.a.showToast(R.string.neterror);
                    return;
                }
                bw bwVar = (bw) sVar;
                if (bwVar.l()) {
                    if (bwVar.m() > 0) {
                        if (!TextUtils.isEmpty(bwVar.n())) {
                            this.a.showToast(bwVar.n());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(R.string.neterror);
                    return;
                }
                RandChatRoomData a4 = bwVar.a();
                if (a4 != null && a4.e() > 0) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(a4.d()));
                    imMessageCenterPojo.setPulled_msgId(a4.k() * 100);
                    imMessageCenterPojo.setGroup_type(7);
                    imMessageCenterPojo.setGroup_name("聊天室");
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setIs_hidden(1);
                    com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
                    z = this.a.v;
                    if (!z) {
                        SnapGroupChatActivity snapGroupChatActivity2 = this.a;
                        i3 = snapGroupChatActivity2.t;
                        snapGroupChatActivity2.t = i3 + 1;
                    }
                    StringBuilder sb = new StringBuilder("restart time = ");
                    i = this.a.t;
                    com.baidu.adp.lib.util.e.e("simon", "onMessage", sb.append(i).toString());
                    SnapGroupChatActivity snapGroupChatActivity3 = this.a;
                    i2 = this.a.t;
                    WaittingActivity.a(snapGroupChatActivity3, a4, i2);
                    this.a.finish();
                    return;
                }
                return;
            case 106102:
                if (sVar instanceof co) {
                    aVar = this.a.d;
                    aVar.N();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
