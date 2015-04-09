package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aYt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(TalkableActivity talkableActivity) {
        this.aYt = talkableActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.k.iH()) {
            if (this.aYt.mListView != null) {
                this.aYt.mListView.displayNoNetwork();
            }
        } else if (this.aYt.mListView != null) {
            this.aYt.mListView.hideNoNetwork();
        }
        switch (this.aYt.mListModel.getLoadDataMode()) {
            case 1:
                j = this.aYt.preTime;
                if (j > -1) {
                    this.aYt.preTime = -1L;
                }
                this.aYt.mListView.closeProgress();
                this.aYt.mListView.refreshGo2New(this.aYt.mListModel.getData());
                return;
            case 2:
                this.aYt.mListView.refreshPrepage(this.aYt.mListModel.getData());
                return;
            case 3:
                this.aYt.mListView.refreshCheckNew(this.aYt.mListModel.getData());
                return;
            case 4:
                this.aYt.mListView.refreshGo2New(this.aYt.mListModel.getData());
                return;
            case 5:
                this.aYt.mListView.refreshNormal(this.aYt.mListModel.getData());
                return;
            case 6:
                this.aYt.mListView.refreshNormal(this.aYt.mListModel.getData());
                return;
            case 7:
                this.aYt.mListView.refreshNormal(this.aYt.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aYt.mListView.setDraft(str);
                    this.aYt.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aYt.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aYt.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                this.aYt.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.aYt.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.aYt.finish();
                return;
            case 12:
                this.aYt.mListView.refreshGo2New(this.aYt.mListModel.getData());
                return;
            case 13:
                this.aYt.mListView.refreshNormal(this.aYt.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.aYt.mListView.refreshNormal(this.aYt.mListModel.getData());
    }
}
