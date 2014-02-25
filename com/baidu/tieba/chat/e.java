package com.baidu.tieba.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.account.ax;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.tieba.mention.v;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar;
        n nVar2;
        Activity activity;
        Activity activity2;
        com.baidu.tieba.im.a<Void> aVar;
        Activity activity3;
        com.baidu.tieba.im.a<Void> aVar2;
        Activity activity4;
        Activity activity5;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i >= 0) {
            nVar = this.a.k;
            long itemId = nVar.getItemId(i);
            if (itemId == -1) {
                i4 = this.a.e;
                if (i4 > 1) {
                    a aVar3 = this.a;
                    i5 = aVar3.e;
                    aVar3.e = i5 - 1;
                    a aVar4 = this.a;
                    i6 = this.a.e;
                    aVar4.b(i6, 2);
                }
            } else if (itemId != -2) {
                nVar2 = this.a.k;
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) nVar2.getItem(i);
                activity = this.a.d;
                cb.a(activity, "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (imMessageCenterShowItemData != null) {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(imMessageCenterShowItemData);
                        return;
                    } else if (ownerName.equals(SocialConstants.TRUE)) {
                        com.baidu.tieba.im.c.a f = com.baidu.tieba.im.c.a.f();
                        aVar2 = this.a.u;
                        f.b(false, aVar2);
                        activity4 = this.a.d;
                        cb.a(activity4, "chat_list_to_group", "click", 1, new Object[0]);
                        activity5 = this.a.d;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tieba.a.b(activity5, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                        a(imMessageCenterShowItemData);
                        if (v.a().u() != null) {
                            v.a().u().d(0);
                        }
                        com.baidu.tieba.im.c.a f2 = com.baidu.tieba.im.c.a.f();
                        aVar = this.a.u;
                        f2.b(false, aVar);
                        activity3 = this.a.d;
                        ValidateActivity.a(activity3);
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                        a(imMessageCenterShowItemData);
                        if (v.a().u() != null) {
                            v.a().u().b(0);
                        }
                        activity2 = this.a.d;
                        UpdatesActivity.a(activity2);
                        return;
                    } else {
                        b(imMessageCenterShowItemData);
                        return;
                    }
                }
                com.baidu.adp.lib.util.f.e(a.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                a aVar5 = this.a;
                i2 = aVar5.e;
                aVar5.e = i2 + 1;
                a aVar6 = this.a;
                i3 = this.a.e;
                aVar6.b(i3, 1);
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        com.baidu.tieba.im.j.a(new f(this, imMessageCenterShowItemData), null);
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Activity activity;
        Activity activity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            v.a().e(v.a().p() - imMessageCenterShowItemData.getUnReadCount());
            v.a().j();
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            activity = this.a.d;
            ai.a(activity, "tab_msg_personal_chat_click");
            new ax("pchat", SocialConstants.TRUE).start();
            activity2 = this.a.d;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(activity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
