package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(TalkableActivity talkableActivity) {
        this.bbb = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.k.iX()) {
            if (this.bbb.mListView != null) {
                this.bbb.mListView.displayNoNetwork();
            }
        } else if (this.bbb.mListView != null) {
            this.bbb.mListView.hideNoNetwork();
        }
        switch (this.bbb.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bbb.preTime;
                if (j > -1) {
                    this.bbb.preTime = -1L;
                }
                this.bbb.mListView.closeProgress();
                this.bbb.mListView.refreshGo2New(this.bbb.mListModel.getData());
                return;
            case 2:
                this.bbb.mListView.refreshPrepage(this.bbb.mListModel.getData());
                return;
            case 3:
                this.bbb.mListView.refreshCheckNew(this.bbb.mListModel.getData());
                return;
            case 4:
                this.bbb.mListView.refreshGo2New(this.bbb.mListModel.getData());
                return;
            case 5:
                this.bbb.mListView.refreshNormal(this.bbb.mListModel.getData());
                return;
            case 6:
                this.bbb.mListView.refreshNormal(this.bbb.mListModel.getData());
                return;
            case 7:
                this.bbb.mListView.refreshNormal(this.bbb.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bbb.mListView.setDraft(str);
                    this.bbb.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bbb.isNeedSaveDraft = false;
                this.bbb.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bbb.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bbb.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.bbb.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bbb.isNeedSaveDraft = false;
                this.bbb.finish();
                return;
            case 12:
                this.bbb.mListView.refreshGo2New(this.bbb.mListModel.getData());
                return;
            case 13:
                this.bbb.mListView.refreshNormal(this.bbb.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bbb.mListView.refreshNormal(this.bbb.mListModel.getData());
    }
}
