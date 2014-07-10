package com.baidu.tieba.im.live.livelist;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.LiveCardData;
/* loaded from: classes.dex */
class n implements DialogInterface.OnClickListener {
    final /* synthetic */ m a;
    private final /* synthetic */ int b;
    private final /* synthetic */ LiveCardData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, int i, LiveCardData liveCardData) {
        this.a = mVar;
        this.b = i;
        this.c = liveCardData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FrsLiveListActivity frsLiveListActivity;
        FrsLiveListActivity frsLiveListActivity2;
        FrsLiveListActivity frsLiveListActivity3;
        com.baidu.tieba.im.model.j jVar;
        FrsLiveListActivity frsLiveListActivity4;
        FrsLiveListActivity frsLiveListActivity5;
        FrsLiveListActivity frsLiveListActivity6;
        com.baidu.tieba.im.model.j jVar2;
        FrsLiveListActivity frsLiveListActivity7;
        com.baidu.tieba.im.model.j jVar3;
        FrsLiveListActivity frsLiveListActivity8;
        com.baidu.tieba.im.model.j jVar4;
        switch (i) {
            case 0:
                frsLiveListActivity4 = this.a.a;
                frsLiveListActivity5 = this.a.a;
                frsLiveListActivity4.showLoadingDialog(frsLiveListActivity5.getString(com.baidu.tieba.y.group_tab_enterchatroom_loading), null);
                switch (this.b) {
                    case 0:
                        frsLiveListActivity8 = this.a.a;
                        jVar4 = frsLiveListActivity8.c;
                        jVar4.a(String.valueOf(this.c.getForumId()), String.valueOf(this.c.getGroupId()), 1, 0);
                        return;
                    case 1:
                        frsLiveListActivity7 = this.a.a;
                        jVar3 = frsLiveListActivity7.c;
                        jVar3.a(String.valueOf(this.c.getForumId()), String.valueOf(this.c.getGroupId()), 0, 1);
                        return;
                    case 2:
                        frsLiveListActivity6 = this.a.a;
                        jVar2 = frsLiveListActivity6.c;
                        jVar2.a(String.valueOf(this.c.getForumId()), String.valueOf(this.c.getGroupId()), 0, 2);
                        return;
                    default:
                        return;
                }
            case 1:
                frsLiveListActivity = this.a.a;
                frsLiveListActivity2 = this.a.a;
                frsLiveListActivity.showLoadingDialog(frsLiveListActivity2.getString(com.baidu.tieba.y.group_tab_enterchatroom_loading), null);
                switch (this.b) {
                    case 0:
                        frsLiveListActivity3 = this.a.a;
                        jVar = frsLiveListActivity3.c;
                        jVar.a(String.valueOf(this.c.getForumId()), String.valueOf(this.c.getGroupId()), 2, 0);
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
