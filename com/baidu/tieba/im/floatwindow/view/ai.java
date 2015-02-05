package com.baidu.tieba.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ao {
    final /* synthetic */ FloatingPersonalChatView baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FloatingPersonalChatView floatingPersonalChatView) {
        this.baq = floatingPersonalChatView;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.ao
    public void delete(int i) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        list = this.baq.mUserDataList;
        if (list != null) {
            list2 = this.baq.mUserDataList;
            if (!list2.isEmpty()) {
                list3 = this.baq.mUserDataList;
                UserData userData = (UserData) list3.remove(i);
                if (userData != null) {
                    com.baidu.tieba.im.floatwindow.b.No().gC(userData.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.baq.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(userData.getUserId(), next.getFriendId())) {
                            this.baq.mList.remove(next);
                            break;
                        }
                    }
                    list4 = this.baq.mUserDataList;
                    if (list4.size() <= 0) {
                        this.baq.Oi();
                        return;
                    }
                    FloatingPersonalChatView floatingPersonalChatView = this.baq;
                    list5 = this.baq.mUserDataList;
                    floatingPersonalChatView.fR(list5.size() - 1);
                    this.baq.fS(i);
                }
            }
        }
    }
}
