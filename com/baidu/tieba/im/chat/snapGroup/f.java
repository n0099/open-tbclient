package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.bo;
import com.baidu.tieba.im.message.cf;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        boolean z;
        int i;
        int i2;
        com.baidu.tieba.im.data.b a;
        com.baidu.tieba.im.chat.a aVar;
        switch (qVar.w()) {
            case -119:
                if (qVar instanceof com.baidu.tieba.im.message.c) {
                    String a2 = ((com.baidu.tieba.im.message.c) qVar).a();
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
                if (qVar instanceof bh) {
                    bh bhVar = (bh) qVar;
                    com.baidu.adp.lib.g.e.d(bhVar.toString());
                    this.a.a(com.baidu.tieba.im.d.e.a(bhVar.a()));
                    return;
                }
                return;
            case 106101:
                this.a.closeLoadingDialog();
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
                if (a3 != null && a3.e() > 0) {
                    com.baidu.tieba.im.d.c.a(a3);
                    z = this.a.w;
                    if (!z) {
                        SnapGroupChatActivity.p(this.a);
                    }
                    StringBuilder append = new StringBuilder().append("restart time = ");
                    i = this.a.u;
                    com.baidu.adp.lib.g.e.e("simon", "onMessage", append.append(i).toString());
                    SnapGroupChatActivity snapGroupChatActivity = this.a;
                    i2 = this.a.u;
                    WaittingActivity.a(snapGroupChatActivity, a3, i2);
                    this.a.finish();
                    return;
                }
                return;
            case 106102:
                if (qVar instanceof cf) {
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
