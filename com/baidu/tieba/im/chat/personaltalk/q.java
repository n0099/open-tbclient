package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ o aTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i) {
        super(i);
        this.aTZ = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        t tVar;
        t tVar2;
        boolean z;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (!updateAttentionMessage.isSucc()) {
                personalTalkSettingActivity = this.aTZ.aTX;
                if (personalTalkSettingActivity != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    personalTalkSettingActivity2 = this.aTZ.aTX;
                    personalTalkSettingActivity2.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aTZ.QP = updateAttentionMessage.isAttention();
            personalTalkSettingActivity3 = this.aTZ.aTX;
            if (personalTalkSettingActivity3 != null) {
                z = this.aTZ.QP;
                if (z) {
                    personalTalkSettingActivity5 = this.aTZ.aTX;
                    personalTalkSettingActivity5.showToast(z.add_succ);
                } else {
                    personalTalkSettingActivity4 = this.aTZ.aTX;
                    personalTalkSettingActivity4.showToast(z.remove_succ);
                }
            }
            tVar = this.aTZ.aTY;
            if (tVar != null) {
                tVar2 = this.aTZ.aTY;
                tVar2.qw();
            }
        }
    }
}
