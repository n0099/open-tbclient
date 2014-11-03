package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bc implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupChatActivity aOr;
    private final /* synthetic */ GroupData aOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aOr = groupChatActivity;
        this.aOs = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aOr.aQd.closeNotNotify();
            } else {
                this.aOr.aQd.showNotNotfiy();
            }
            if (this.aOr.aQe != null && this.aOs != null) {
                String name = this.aOs.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aOr.aQd.refreshHeaderFooter(name, true);
                }
            }
        }
    }
}
