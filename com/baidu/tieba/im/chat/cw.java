package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(TalkableActivity talkableActivity) {
        this.aTe = talkableActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.ff()) {
            if (this.aTe.mListView != null) {
                this.aTe.mListView.displayNoNetwork();
            }
        } else if (this.aTe.mListView != null) {
            this.aTe.mListView.hideNoNetwork();
        }
        switch (this.aTe.mListModel.getLoadDataMode()) {
            case 1:
                j = this.aTe.preTime;
                if (j > -1) {
                    this.aTe.preTime = -1L;
                }
                this.aTe.mListView.closeProgress();
                this.aTe.mListView.refreshGo2New(this.aTe.mListModel.getData());
                return;
            case 2:
                this.aTe.mListView.refreshPrepage(this.aTe.mListModel.getData());
                return;
            case 3:
                this.aTe.mListView.refreshCheckNew(this.aTe.mListModel.getData());
                return;
            case 4:
                this.aTe.mListView.refreshGo2New(this.aTe.mListModel.getData());
                return;
            case 5:
                this.aTe.mListView.refreshNormal(this.aTe.mListModel.getData());
                return;
            case 6:
                this.aTe.mListView.refreshNormal(this.aTe.mListModel.getData());
                return;
            case 7:
                this.aTe.mListView.refreshNormal(this.aTe.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aTe.mListView.setDraft(str);
                    this.aTe.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aTe.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aTe.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                this.aTe.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.aTe.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.aTe.finish();
                return;
            case 12:
                this.aTe.mListView.refreshGo2New(this.aTe.mListModel.getData());
                return;
            case 13:
                this.aTe.mListView.refreshNormal(this.aTe.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.aTe.mListView.refreshNormal(this.aTe.mListModel.getData());
    }
}
