package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(l lVar, int i) {
        super(i);
        this.a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        q qVar;
        q qVar2;
        boolean z;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (!updateAttentionMessage.isSucc()) {
                personalTalkSettingActivity = this.a.g;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.a.g;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.c = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.a.g;
            if (personalTalkSettingActivity3 != null) {
                z = this.a.c;
                if (z) {
                    personalTalkSettingActivity5 = this.a.g;
                    personalTalkSettingActivity5.showToast(x.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.a.g;
                    personalTalkSettingActivity4.showToast(x.remove_succ);
                }
            }
            qVar = this.a.h;
            if (qVar != null) {
                qVar2 = this.a.h;
                qVar2.a();
            }
        }
    }
}
