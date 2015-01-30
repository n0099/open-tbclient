package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FloatingPersonalChatView floatingPersonalChatView) {
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
                this.bas.SendMore1Event();
                return;
            }
            floatingPersonalChatActivity = this.bas.bad;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.z.add_friend_cannot_send);
        }
    }
}
