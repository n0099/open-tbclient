package com.baidu.tieba.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ao {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.ao
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.aYV.mUserDataList;
        if (list != null) {
            list2 = this.aYV.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.aYV.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.im.floatwindow.b.MX().gA(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.aYV.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.aYV.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.aYV.mUserDataList;
                    if (list4.size() <= 0) {
                        this.aYV.NR();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.aYV;
                    list5 = this.aYV.mUserDataList;
                    floatingPersonalChatView.fM(list5.size() - 1);
                    this.aYV.fN(i);
                }
            }
        }
    }
}
