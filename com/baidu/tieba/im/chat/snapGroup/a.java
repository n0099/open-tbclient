package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.co;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.im.util.m;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.data.b a;
        com.baidu.tieba.im.chat.a aVar;
        switch (sVar.w()) {
            case -119:
                if (sVar instanceof com.baidu.tieba.im.message.c) {
                    String a2 = ((com.baidu.tieba.im.message.c) sVar).a();
                    if (!TextUtils.isEmpty(a2) && (a = com.baidu.tieba.im.data.b.a(a2)) != null) {
                        switch (a.h) {
                            case 202:
                                this.a.a(a);
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
                    com.baidu.adp.lib.util.f.e(bnVar.toString());
                    this.a.a(m.a(bnVar.a()));
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
                RandChatRoomData a3 = bwVar.a();
                if (a3 != null && a3.e() > 0) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(a3.d()));
                    imMessageCenterPojo.setPulled_msgId(be.b(a3.k()));
                    imMessageCenterPojo.setGroup_type(7);
                    imMessageCenterPojo.setGroup_name("聊天室");
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setIs_hidden(1);
                    com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
                    z = this.a.v;
                    if (!z) {
                        SnapGroupChatActivity snapGroupChatActivity = this.a;
                        i3 = snapGroupChatActivity.t;
                        snapGroupChatActivity.t = i3 + 1;
                    }
                    StringBuilder sb = new StringBuilder("restart time = ");
                    i = this.a.t;
                    com.baidu.adp.lib.util.f.e("simon", "onMessage", sb.append(i).toString());
                    SnapGroupChatActivity snapGroupChatActivity2 = this.a;
                    i2 = this.a.t;
                    WaittingActivity.a(snapGroupChatActivity2, a3, i2);
                    this.a.finish();
                    return;
                }
                return;
            case 106102:
                if (sVar instanceof co) {
                    aVar = this.a.d;
                    aVar.P();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
