package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(TalkableActivity talkableActivity) {
        this.aRW = talkableActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.fg()) {
            if (this.aRW.mListView != null) {
                this.aRW.mListView.displayNoNetwork();
            }
        } else if (this.aRW.mListView != null) {
            this.aRW.mListView.hideNoNetwork();
        }
        switch (this.aRW.mListModel.getLoadDataMode()) {
            case 1:
                j = this.aRW.preTime;
                if (j > -1) {
                    this.aRW.preTime = -1L;
                }
                this.aRW.mListView.closeProgress();
                this.aRW.mListView.refreshGo2New(this.aRW.mListModel.getData());
                return;
            case 2:
                this.aRW.mListView.refreshPrepage(this.aRW.mListModel.getData());
                return;
            case 3:
                this.aRW.mListView.refreshCheckNew(this.aRW.mListModel.getData());
                return;
            case 4:
                this.aRW.mListView.refreshGo2New(this.aRW.mListModel.getData());
                return;
            case 5:
                this.aRW.mListView.refreshNormal(this.aRW.mListModel.getData());
                return;
            case 6:
                this.aRW.mListView.refreshNormal(this.aRW.mListModel.getData());
                return;
            case 7:
                this.aRW.mListView.refreshNormal(this.aRW.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aRW.mListView.setDraft(str);
                    this.aRW.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aRW.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aRW.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                this.aRW.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.aRW.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.aRW.finish();
                return;
            case 12:
                this.aRW.mListView.refreshGo2New(this.aRW.mListModel.getData());
                return;
            case 13:
                this.aRW.mListView.refreshNormal(this.aRW.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.aRW.mListView.refreshNormal(this.aRW.mListModel.getData());
    }
}
