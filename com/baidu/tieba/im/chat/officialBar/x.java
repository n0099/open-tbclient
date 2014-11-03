package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ UserData aPX;
    final /* synthetic */ OfficialBarChatActivity aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aRt = officialBarChatActivity;
        this.aPX = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        ax.KE().a(TbadkApplication.getCurrentAccount(), OfficialBarChatActivity.ZK, this.aPX);
        return null;
    }
}
