package com.baidu.tieba.chatmessage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity arG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.arG = chatMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fragment fragment;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        FragmentTransaction fragmentTransaction2;
        Object data;
        if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof Fragment)) {
            fragment = null;
        } else {
            fragment = (Fragment) data;
        }
        if (fragment != null) {
            this.arG.mFragmentManager = this.arG.getSupportFragmentManager();
            ChatMessageActivity chatMessageActivity = this.arG;
            fragmentManager = this.arG.mFragmentManager;
            chatMessageActivity.arF = fragmentManager.beginTransaction();
            fragmentTransaction = this.arG.arF;
            fragmentTransaction.add(w.content, fragment);
            fragmentTransaction2 = this.arG.arF;
            fragmentTransaction2.commitAllowingStateLoss();
        }
    }
}
