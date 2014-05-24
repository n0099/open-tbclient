package com.baidu.tieba.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ SecretSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SecretSettingActivity secretSettingActivity, int i) {
        super(i);
        this.a = secretSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        bVar = this.a.b;
        bVar.d();
        if (socketResponsedMessage.getCmd() == 104103) {
            if (!(socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                this.a.showToast(y.neterror);
                return;
            }
            ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseGetMaskInfoMessage.getOrginalMessage();
            if (!(orginalMessage instanceof RequestGetMaskInfoMessage)) {
                this.a.showToast(y.neterror);
            } else if (((RequestGetMaskInfoMessage) orginalMessage).getMaskType() == 8) {
                if (responseGetMaskInfoMessage.getError() != 0) {
                    if (responseGetMaskInfoMessage.getError() > 0) {
                        if (!TextUtils.isEmpty(responseGetMaskInfoMessage.getErrorString())) {
                            this.a.showToast(responseGetMaskInfoMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(y.neterror);
                    return;
                }
                if (responseGetMaskInfoMessage.getIsMask() != 0) {
                    bVar6 = this.a.b;
                    bVar6.f().b();
                    return;
                }
                bVar5 = this.a.b;
                bVar5.f().a();
            }
        } else if (socketResponsedMessage.getCmd() == 104102) {
            if (!(socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage)) {
                this.a.showToast(y.neterror);
                return;
            }
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage2 = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (!(orginalMessage2 instanceof RequestUpdateMaskInfoMessage)) {
                this.a.showToast(y.neterror);
            } else if (((RequestUpdateMaskInfoMessage) orginalMessage2).getMaskType() == 8) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    bVar2 = this.a.b;
                    Object tag = bVar2.f().getTag();
                    if (tag != null && (tag instanceof Boolean)) {
                        if (((Boolean) tag).booleanValue()) {
                            bVar4 = this.a.b;
                            bVar4.f().b();
                            return;
                        }
                        bVar3 = this.a.b;
                        bVar3.f().a();
                    }
                } else if (responseUpdateMaskInfoMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseUpdateMaskInfoMessage.getErrorString())) {
                        this.a.showToast(responseUpdateMaskInfoMessage.getErrorString());
                    }
                } else {
                    this.a.showToast(y.neterror);
                }
            }
        }
    }
}
