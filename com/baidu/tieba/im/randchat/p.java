package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.bo;
import com.baidu.tieba.im.message.cf;
import com.baidu.tieba.im.message.cm;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
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
        if (qVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (qVar.w() == 106103) {
            if ((qVar instanceof cm) && !((cm) qVar).k()) {
                type2 = this.a.h;
                if (type2 == WaitingTipView.Type.PERSONS_READY) {
                    fVar8 = this.a.a;
                    fVar8.a().getLoadingView().setVisibility(0);
                    return;
                }
                fVar6 = this.a.a;
                com.baidu.tieba.view.o chatterboxView = fVar6.a().getChatterboxView();
                arVar8 = this.a.b;
                chatterboxView.setTitle(arVar8.h());
                fVar7 = this.a.a;
                fVar7.a().getLoadingView().setVisibility(8);
            }
        } else if (qVar.w() == 106102) {
            if (!(qVar instanceof cf)) {
                this.a.showToast(R.string.neterror);
            }
            cf cfVar = (cf) qVar;
            com.baidu.tieba.im.message.q n = cfVar.n();
            if (!(n instanceof as) || ((as) n).b() == 0) {
                if (cfVar.k()) {
                    if (cfVar.l() > 0) {
                        if (!TextUtils.isEmpty(cfVar.m())) {
                            this.a.showToast(cfVar.m());
                        }
                    } else {
                        this.a.showToast(R.string.neterror);
                    }
                }
                arVar7 = this.a.b;
                com.baidu.tieba.im.d.c.a(String.valueOf(arVar7.f().d()));
                this.a.finish();
            }
        } else if (qVar != null && qVar.w() == 106101) {
            if (!(qVar instanceof bo)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bo boVar = (bo) qVar;
            if (boVar.k()) {
                if (boVar.l() > 0) {
                    if (!TextUtils.isEmpty(boVar.m())) {
                        this.a.showToast(boVar.m());
                        return;
                    }
                    return;
                }
                this.a.showToast(R.string.neterror);
                return;
            }
            RandChatRoomData a3 = boVar.a();
            com.baidu.tieba.im.d.c.a(a3);
            this.a.a(a3, false);
            arVar6 = this.a.b;
            arVar6.b(a3);
            this.a.h();
            this.a.i();
        } else if (qVar.w() == -119) {
            if (qVar instanceof com.baidu.tieba.im.message.c) {
                String a4 = ((com.baidu.tieba.im.message.c) qVar).a();
                if (!TextUtils.isEmpty(a4) && (a = com.baidu.tieba.im.data.b.a(a4)) != null) {
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
            }
        } else if (qVar.w() == 106001 && (qVar instanceof bh)) {
            arVar = this.a.b;
            RandChatRoomData f = arVar.f();
            arVar2 = this.a.b;
            f.b(arVar2.a((bh) qVar));
            fVar = this.a.a;
            fVar.a().c();
            this.a.i();
        }
    }
}
