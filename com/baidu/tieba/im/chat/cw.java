package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(TalkableActivity talkableActivity) {
        this.aTf = talkableActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.ff()) {
            if (this.aTf.mListView != null) {
                this.aTf.mListView.displayNoNetwork();
            }
        } else if (this.aTf.mListView != null) {
            this.aTf.mListView.hideNoNetwork();
        }
        switch (this.aTf.mListModel.getLoadDataMode()) {
            case 1:
                j = this.aTf.preTime;
                if (j > -1) {
                    this.aTf.preTime = -1L;
                }
                this.aTf.mListView.closeProgress();
                this.aTf.mListView.refreshGo2New(this.aTf.mListModel.getData());
                return;
            case 2:
                this.aTf.mListView.refreshPrepage(this.aTf.mListModel.getData());
                return;
            case 3:
                this.aTf.mListView.refreshCheckNew(this.aTf.mListModel.getData());
                return;
            case 4:
                this.aTf.mListView.refreshGo2New(this.aTf.mListModel.getData());
                return;
            case 5:
                this.aTf.mListView.refreshNormal(this.aTf.mListModel.getData());
                return;
            case 6:
                this.aTf.mListView.refreshNormal(this.aTf.mListModel.getData());
                return;
            case 7:
                this.aTf.mListView.refreshNormal(this.aTf.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aTf.mListView.setDraft(str);
                    this.aTf.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aTf.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aTf.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                this.aTf.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.aTf.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.aTf.finish();
                return;
            case 12:
                this.aTf.mListView.refreshGo2New(this.aTf.mListModel.getData());
                return;
            case 13:
                this.aTf.mListView.refreshNormal(this.aTf.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.aTf.mListView.refreshNormal(this.aTf.mListModel.getData());
    }
}
