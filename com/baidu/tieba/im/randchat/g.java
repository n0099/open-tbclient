package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.be;
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
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        ar arVar;
        ar arVar2;
        f fVar;
        com.baidu.tieba.im.data.b a;
        ar arVar3;
        ar arVar4;
        WaitingTipView.Type type;
        ar arVar5;
        boolean a2;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        ar arVar6;
        ar arVar7;
        WaitingTipView.Type type2;
        f fVar6;
        ar arVar8;
        f fVar7;
        f fVar8;
        this.a.closeLoadingDialog();
        if (sVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (sVar.w() == 106103) {
            if ((sVar instanceof cv) && !((cv) sVar).l()) {
                type2 = this.a.h;
                if (type2 == WaitingTipView.Type.PERSONS_READY) {
                    fVar8 = this.a.a;
                    fVar8.a().getLoadingView().setVisibility(0);
                    return;
                }
                fVar6 = this.a.a;
                com.baidu.tieba.view.p chatterboxView = fVar6.a().getChatterboxView();
                arVar8 = this.a.b;
                chatterboxView.setTitle(arVar8.h());
                fVar7 = this.a.a;
                fVar7.a().getLoadingView().setVisibility(8);
            }
        } else if (sVar.w() == 106102) {
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
                arVar7 = this.a.b;
                com.baidu.tieba.im.util.d.a(String.valueOf(arVar7.f().d()));
                this.a.finish();
            }
        } else if (sVar != null && sVar.w() == 106101) {
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
            imMessageCenterPojo.setPulled_msgId(be.b(a3.k()));
            imMessageCenterPojo.setGroup_type(7);
            imMessageCenterPojo.setGroup_name("聊天室");
            imMessageCenterPojo.setIs_delete(0);
            imMessageCenterPojo.setIs_hidden(1);
            com.baidu.tieba.im.util.d.a(imMessageCenterPojo);
            this.a.a(a3, false);
            arVar6 = this.a.b;
            arVar6.b(a3);
            this.a.i();
            this.a.j();
        } else if (sVar.w() == -119) {
            if (sVar instanceof com.baidu.tieba.im.message.c) {
                String a4 = ((com.baidu.tieba.im.message.c) sVar).a();
                if (TextUtils.isEmpty(a4) || (a = com.baidu.tieba.im.data.b.a(a4)) == null) {
                    return;
                }
                switch (a.h) {
                    case 201:
                        this.a.a(a);
                        return;
                    case 202:
                        this.a.b(a);
                        return;
                    case 203:
                        this.a.c(a);
                        return;
                    case 204:
                    default:
                        return;
                    case 205:
                        arVar3 = this.a.b;
                        arVar3.a(a.j);
                        arVar4 = this.a.b;
                        arVar4.b(a.i);
                        type = this.a.h;
                        if (type != WaitingTipView.Type.PERSONS_READY) {
                            WaittingActivity waittingActivity = this.a;
                            arVar5 = this.a.b;
                            a2 = waittingActivity.a(arVar5.f());
                            if (!a2) {
                                this.a.b(WaitingTipView.Type.TOPIC_UPDATE, (Object[]) null);
                            }
                            if (!TextUtils.isEmpty(a.j)) {
                                fVar2 = this.a.a;
                                fVar2.a().getLoadingView().setVisibility(8);
                            } else if (!a2) {
                                fVar5 = this.a.a;
                                fVar5.a().getLoadingView().setVisibility(0);
                            } else {
                                fVar4 = this.a.a;
                                fVar4.a().getLoadingView().setVisibility(8);
                            }
                            fVar3 = this.a.a;
                            fVar3.a().getChatterboxView().setTitle(a.j);
                            return;
                        }
                        return;
                }
            }
        } else if (sVar.w() == 106001 && (sVar instanceof bn)) {
            arVar = this.a.b;
            RandChatRoomData f = arVar.f();
            arVar2 = this.a.b;
            f.b(arVar2.a((bn) sVar));
            fVar = this.a.a;
            fVar.a().c();
            this.a.j();
        }
    }
}
