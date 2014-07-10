package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bd implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupChatActivity a;
    private final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.a = groupChatActivity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.a.d.M();
            } else {
                this.a.d.N();
            }
            if (this.a.e != null && this.b != null) {
                String name = this.b.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.a.d.a(name, true);
                }
            }
        }
    }
}
