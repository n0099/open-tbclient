package com.baidu.tieba.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ao {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.bas = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.ao
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.bas.mUserDataList;
        if (list != null) {
            list2 = this.bas.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.bas.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.im.floatwindow.b.Nt().gF(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.bas.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.bas.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.bas.mUserDataList;
                    if (list4.size() <= 0) {
                        this.bas.On();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.bas;
                    list5 = this.bas.mUserDataList;
                    floatingPersonalChatView.fR(list5.size() - 1);
                    this.bas.fS(i);
                }
            }
        }
    }
}
