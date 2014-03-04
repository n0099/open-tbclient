package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ay;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.co;
import com.baidu.tieba.im.message.cv;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import protobuf.Im;
/* loaded from: classes.dex */
final class h implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        ar arVar;
        f fVar;
        com.baidu.tieba.im.data.b a;
        ar arVar2;
        ar arVar3;
        WaitingTipView.Type type;
        ar arVar4;
        boolean a2;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        ar arVar5;
        ar arVar6;
        WaitingTipView.Type type2;
        f fVar6;
        ar arVar7;
        f fVar7;
        f fVar8;
        ar unused;
        ArrayList arrayList = null;
        this.a.closeLoadingDialog();
        if (sVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (sVar.v() == 106103) {
            if ((sVar instanceof cv) && !((cv) sVar).l()) {
                type2 = this.a.h;
                if (type2 == WaitingTipView.Type.PERSONS_READY) {
                    fVar8 = this.a.a;
                    fVar8.d().getLoadingView().setVisibility(0);
                    return;
                }
                fVar6 = this.a.a;
                com.baidu.tieba.view.p chatterboxView = fVar6.d().getChatterboxView();
                arVar7 = this.a.b;
                chatterboxView.setTitle(arVar7.h());
                fVar7 = this.a.a;
                fVar7.d().getLoadingView().setVisibility(8);
            }
        } else if (sVar.v() == 106102) {
            if (!(sVar instanceof co)) {
                this.a.showToast(R.string.neterror);
            }
            co coVar = (co) sVar;
            com.baidu.tieba.im.message.s o = coVar.o();
            if (!(o instanceof ay) || ((ay) o).b() == 0) {
                if (coVar.l()) {
                    if (coVar.m() > 0) {
                        if (!TextUtils.isEmpty(coVar.n())) {
                            this.a.showToast(coVar.n());
                        }
                    } else {
                        this.a.showToast(R.string.neterror);
                    }
                }
                arVar6 = this.a.b;
                com.baidu.tieba.im.util.d.a(String.valueOf(arVar6.f().d()));
                this.a.finish();
            }
        } else if (sVar != null && sVar.v() == 106101) {
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
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(a3.d()));
            imMessageCenterPojo.setPulled_msgId(a3.k() * 100);
            imMessageCenterPojo.setGroup_type(7);
            imMessageCenterPojo.setGroup_name("聊天室");
            imMessageCenterPojo.setIs_delete(0);
            imMessageCenterPojo.setIs_hidden(1);
            com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
            this.a.a(a3, false);
            arVar5 = this.a.b;
            arVar5.b(a3);
            this.a.b();
            this.a.c();
        } else if (sVar.v() == -119) {
            if (sVar instanceof com.baidu.tieba.im.message.c) {
                String a4 = ((com.baidu.tieba.im.message.c) sVar).a();
                if (!TextUtils.isEmpty(a4) && (a = com.baidu.tieba.im.data.b.a(a4)) != null) {
                    switch (a.h) {
                        case 201:
                            WaittingActivity.a(this.a, a);
                            return;
                        case 202:
                            WaittingActivity.b(this.a, a);
                            return;
                        case 203:
                            this.a.a(a.a);
                            return;
                        case 204:
                        default:
                            return;
                        case 205:
                            arVar2 = this.a.b;
                            arVar2.a(a.j);
                            arVar3 = this.a.b;
                            arVar3.b(a.i);
                            type = this.a.h;
                            if (type != WaitingTipView.Type.PERSONS_READY) {
                                WaittingActivity waittingActivity = this.a;
                                arVar4 = this.a.b;
                                a2 = WaittingActivity.a(arVar4.f());
                                if (!a2) {
                                    this.a.b(WaitingTipView.Type.TOPIC_UPDATE, (Object[]) null);
                                }
                                if (!TextUtils.isEmpty(a.j)) {
                                    fVar2 = this.a.a;
                                    fVar2.d().getLoadingView().setVisibility(8);
                                } else if (!a2) {
                                    fVar5 = this.a.a;
                                    fVar5.d().getLoadingView().setVisibility(0);
                                } else {
                                    fVar4 = this.a.a;
                                    fVar4.d().getLoadingView().setVisibility(8);
                                }
                                fVar3 = this.a.a;
                                fVar3.d().getChatterboxView().setTitle(a.j);
                                return;
                            }
                            return;
                    }
                }
            }
        } else if (sVar.v() == 106001 && (sVar instanceof bn)) {
            bn bnVar = (bn) sVar;
            arVar = this.a.b;
            RandChatRoomData f = arVar.f();
            unused = this.a.b;
            if (bnVar != null && bnVar.a() != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Im.UserInfo userInfo : bnVar.a()) {
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
