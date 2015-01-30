package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FloatingPersonalChatView floatingPersonalChatView) {
        this.bas = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean Om;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        Om = this.bas.Om();
        if (!Om) {
            apVar = this.bas.bap;
            list = this.bas.mUserDataList;
            i = this.bas.currentIndex;
            if (apVar.gH(((UserData) list.get(i)).getUserId())) {
                this.bas.sendSoftkeyEvent();
                return;
            }
            floatingPersonalChatActivity = this.bas.bad;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.z.add_friend_cannot_send);
        }
    }
}
