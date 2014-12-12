package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean NQ;
        ap apVar;
        List list;
        int i;
        FloatingPersonalChatActivity floatingPersonalChatActivity;
        NQ = this.aYV.NQ();
        if (!NQ) {
            apVar = this.aYV.aYT;
            list = this.aYV.mUserDataList;
            i = this.aYV.currentIndex;
            if (apVar.gC(((UserData) list.get(i)).getUserId())) {
                this.aYV.SendMore1Event();
                return;
            }
            floatingPersonalChatActivity = this.aYV.aYH;
            floatingPersonalChatActivity.showToast(com.baidu.tieba.z.add_friend_cannot_send);
        }
    }
}
