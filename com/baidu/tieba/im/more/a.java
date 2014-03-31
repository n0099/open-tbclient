package com.baidu.tieba.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.c.g;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.message.d;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.c;
import com.baidu.tieba.im.j;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
final class a extends g {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SecretSettingActivity secretSettingActivity, int i) {
        super(0);
        this.a = secretSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        bVar = this.a.b;
        bVar.f();
        if (socketResponsedMessage2.g() == 104103) {
            if (!(socketResponsedMessage2 instanceof ResponseGetMaskInfoMessage)) {
                this.a.showToast(j.neterror);
                return;
            }
            ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage2;
            d<?> h = responseGetMaskInfoMessage.h();
            if (!(h instanceof c)) {
                this.a.showToast(j.neterror);
            } else if (((c) h).i() == 8) {
                if (responseGetMaskInfoMessage.e() != 0) {
                    if (responseGetMaskInfoMessage.e() <= 0) {
                        this.a.showToast(j.neterror);
                        return;
                    } else if (TextUtils.isEmpty(responseGetMaskInfoMessage.f())) {
                        return;
                    } else {
                        this.a.showToast(responseGetMaskInfoMessage.f());
                        return;
                    }
                }
                if (responseGetMaskInfoMessage.d() != 0) {
                    bVar6 = this.a.b;
                    bVar6.h().b();
                    return;
                }
                bVar5 = this.a.b;
                bVar5.h().a();
            }
        } else if (socketResponsedMessage2.g() == 104102) {
            if (!(socketResponsedMessage2 instanceof ResponseUpdateMaskInfoMessage)) {
                this.a.showToast(j.neterror);
                return;
            }
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage2;
            d<?> h2 = responseUpdateMaskInfoMessage.h();
            if (!(h2 instanceof com.baidu.tbadk.core.message.d)) {
                this.a.showToast(j.neterror);
            } else if (((com.baidu.tbadk.core.message.d) h2).i() == 8) {
                if (responseUpdateMaskInfoMessage.e() != 0) {
                    if (responseUpdateMaskInfoMessage.e() <= 0) {
                        this.a.showToast(j.neterror);
                        return;
                    } else if (TextUtils.isEmpty(responseUpdateMaskInfoMessage.f())) {
                        return;
                    } else {
                        this.a.showToast(responseUpdateMaskInfoMessage.f());
                        return;
                    }
                }
                bVar2 = this.a.b;
                Object tag = bVar2.h().getTag();
                if (tag == null || !(tag instanceof Boolean)) {
                    return;
                }
                if (((Boolean) tag).booleanValue()) {
                    bVar4 = this.a.b;
                    bVar4.h().b();
                    return;
                }
                bVar3 = this.a.b;
                bVar3.h().a();
            }
        }
    }
}
