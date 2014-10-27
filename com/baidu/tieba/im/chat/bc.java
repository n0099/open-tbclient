package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class bc implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupChatActivity aOd;
    private final /* synthetic */ GroupData aOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aOd = groupChatActivity;
        this.aOe = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aOd.aPP.closeNotNotify();
            } else {
                this.aOd.aPP.showNotNotfiy();
            }
            if (this.aOd.aPQ != null && this.aOe != null) {
                String name = this.aOe.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aOd.aPP.refreshHeaderFooter(name, true);
                }
            }
        }
    }
}
