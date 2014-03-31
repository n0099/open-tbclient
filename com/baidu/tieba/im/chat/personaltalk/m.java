package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends com.baidu.adp.framework.c.a {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i) {
        super(0);
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        p pVar;
        p pVar2;
        boolean z;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage2;
            if (updateAttentionMessage.b()) {
                this.a.d = updateAttentionMessage.c();
                personalTalkSettingActivity3 = this.a.h;
                if (personalTalkSettingActivity3 != null) {
                    z = this.a.d;
                    if (z) {
                        personalTalkSettingActivity5 = this.a.h;
                        personalTalkSettingActivity5.showToast(com.baidu.tieba.im.j.add_succ);
                    } else {
                        personalTalkSettingActivity4 = this.a.h;
                        personalTalkSettingActivity4.showToast(com.baidu.tieba.im.j.remove_succ);
                    }
                }
                pVar = this.a.i;
                if (pVar != null) {
                    pVar2 = this.a.i;
                    pVar2.a();
                    return;
                }
                return;
            }
            personalTalkSettingActivity = this.a.h;
            if (personalTalkSettingActivity == null || TextUtils.isEmpty(updateAttentionMessage.f())) {
                return;
            }
            personalTalkSettingActivity2 = this.a.h;
            personalTalkSettingActivity2.showToast(updateAttentionMessage.f());
        }
    }
}
