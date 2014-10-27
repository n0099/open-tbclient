package com.baidu.tieba.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity bif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectFriendActivity selectFriendActivity) {
        this.bif = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tbadk.coreExtra.relationship.b item = this.bif.bic.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String userPortrait = item.getUserPortrait();
            i2 = this.bif.bib;
            if (i2 == 0) {
                this.bif.a(com.baidu.tbadk.game.b.rS().rU(), userId, userName, userPortrait);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, userPortrait);
            this.bif.setResult(-1, intent);
            this.bif.finish();
        }
    }
}
