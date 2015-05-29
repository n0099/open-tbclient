package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity bba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(TalkableActivity talkableActivity) {
        this.bba = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.k.iX()) {
            if (this.bba.mListView != null) {
                this.bba.mListView.displayNoNetwork();
            }
        } else if (this.bba.mListView != null) {
            this.bba.mListView.hideNoNetwork();
        }
        switch (this.bba.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bba.preTime;
                if (j > -1) {
                    this.bba.preTime = -1L;
                }
                this.bba.mListView.closeProgress();
                this.bba.mListView.refreshGo2New(this.bba.mListModel.getData());
                return;
            case 2:
                this.bba.mListView.refreshPrepage(this.bba.mListModel.getData());
                return;
            case 3:
                this.bba.mListView.refreshCheckNew(this.bba.mListModel.getData());
                return;
            case 4:
                this.bba.mListView.refreshGo2New(this.bba.mListModel.getData());
                return;
            case 5:
                this.bba.mListView.refreshNormal(this.bba.mListModel.getData());
                return;
            case 6:
                this.bba.mListView.refreshNormal(this.bba.mListModel.getData());
                return;
            case 7:
                this.bba.mListView.refreshNormal(this.bba.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bba.mListView.setDraft(str);
                    this.bba.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bba.isNeedSaveDraft = false;
                this.bba.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bba.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bba.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.bba.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bba.isNeedSaveDraft = false;
                this.bba.finish();
                return;
            case 12:
                this.bba.mListView.refreshGo2New(this.bba.mListModel.getData());
                return;
            case 13:
                this.bba.mListView.refreshNormal(this.bba.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bba.mListView.refreshNormal(this.bba.mListModel.getData());
    }
}
