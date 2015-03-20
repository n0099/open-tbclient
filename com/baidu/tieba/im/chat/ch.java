package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aYd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(TalkableActivity talkableActivity) {
        this.aYd = talkableActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.k.iH()) {
            if (this.aYd.mListView != null) {
                this.aYd.mListView.displayNoNetwork();
            }
        } else if (this.aYd.mListView != null) {
            this.aYd.mListView.hideNoNetwork();
        }
        switch (this.aYd.mListModel.getLoadDataMode()) {
            case 1:
                j = this.aYd.preTime;
                if (j > -1) {
                    this.aYd.preTime = -1L;
                }
                this.aYd.mListView.closeProgress();
                this.aYd.mListView.refreshGo2New(this.aYd.mListModel.getData());
                return;
            case 2:
                this.aYd.mListView.refreshPrepage(this.aYd.mListModel.getData());
                return;
            case 3:
                this.aYd.mListView.refreshCheckNew(this.aYd.mListModel.getData());
                return;
            case 4:
                this.aYd.mListView.refreshGo2New(this.aYd.mListModel.getData());
                return;
            case 5:
                this.aYd.mListView.refreshNormal(this.aYd.mListModel.getData());
                return;
            case 6:
                this.aYd.mListView.refreshNormal(this.aYd.mListModel.getData());
                return;
            case 7:
                this.aYd.mListView.refreshNormal(this.aYd.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aYd.mListView.setDraft(str);
                    this.aYd.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aYd.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aYd.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                this.aYd.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.aYd.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.aYd.finish();
                return;
            case 12:
                this.aYd.mListView.refreshGo2New(this.aYd.mListModel.getData());
                return;
            case 13:
                this.aYd.mListView.refreshNormal(this.aYd.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.aYd.mListView.refreshNormal(this.aYd.mListModel.getData());
    }
}
