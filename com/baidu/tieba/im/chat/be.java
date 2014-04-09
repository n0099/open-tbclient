package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
final class be implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupChatActivity a;
    private final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.a = groupChatActivity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                this.a.d.K();
            } else {
                this.a.d.L();
            }
            if (this.a.e == null || this.b == null) {
                return;
            }
            String name = this.b.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            this.a.d.a(name);
        }
    }
}
