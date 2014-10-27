package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ UserData aPJ;
    final /* synthetic */ OfficialBarChatActivity aRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aRf = officialBarChatActivity;
        this.aPJ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        ax.KA().a(TbadkApplication.getCurrentAccount(), OfficialBarChatActivity.ZG, this.aPJ);
        return null;
    }
}
