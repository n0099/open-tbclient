package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ UserData aQa;
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aRt = officialBarChatActivity;
        this.aQa = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(ax.KE().av(TbadkApplication.getCurrentAccount(), String.valueOf(this.aQa.getUserId())));
    }
}
