package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ GroupChatActivity aRo;
    private final /* synthetic */ GroupData val$groupData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GroupChatActivity groupChatActivity, GroupData groupData) {
        this.aRo = groupChatActivity;
        this.val$groupData = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.aRo.mListView.closeNotNotify();
            } else {
                this.aRo.mListView.showNotNotfiy();
            }
            if (this.aRo.mListModel != null && this.val$groupData != null) {
                String name = this.val$groupData.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.aRo.mListView.refreshHeaderFooter(name, true);
                }
            }
        }
    }
}
