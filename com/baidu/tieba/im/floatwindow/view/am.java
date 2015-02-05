package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FloatingPersonalChatView floatingPersonalChatView) {
        this.baq = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean Oh;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        Oh = this.baq.Oh();
        if (!Oh) {
            apVar = this.baq.bao;
            list = this.baq.mUserDataList;
            i = this.baq.currentIndex;
            if (apVar.gE(((UserData) list.get(i)).getUserId())) {
                this.baq.SendMore1Event();
                return;
            }
            floatingPersonalChatActivity = this.baq.bac;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.z.add_friend_cannot_send);
        }
    }
}
