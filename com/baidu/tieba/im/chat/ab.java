package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ GroupChatActivity aWL;
    private final /* synthetic */ GroupData val$groupData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aWL = groupChatActivity;
        this.val$groupData = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aWL.mListView.closeNotNotify();
            } else {
                this.aWL.mListView.showNotNotfiy();
            }
            if (this.aWL.mListModel != null && this.val$groupData != null) {
                String name = this.val$groupData.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aWL.mListView.refreshHeaderFooter(name, true);
                }
            }
        }
    }
}
