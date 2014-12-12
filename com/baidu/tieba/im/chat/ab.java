package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ GroupChatActivity aQj;
    private final /* synthetic */ GroupData val$groupData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aQj = groupChatActivity;
        this.val$groupData = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aQj.mListView.closeNotNotify();
            } else {
                this.aQj.mListView.showNotNotfiy();
            }
            if (this.aQj.mListModel != null && this.val$groupData != null) {
                String name = this.val$groupData.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aQj.mListView.refreshHeaderFooter(name, true);
                }
            }
        }
    }
}
