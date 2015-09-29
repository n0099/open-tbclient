package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bst = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iM()) {
            if (this.bst.mListView != null) {
                this.bst.mListView.displayNoNetwork();
            }
        } else if (this.bst.mListView != null) {
            this.bst.mListView.hideNoNetwork();
        }
        switch (this.bst.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bst.preTime;
                if (j > -1) {
                    this.bst.preTime = -1L;
                }
                this.bst.mListView.closeProgress();
                this.bst.mListView.refreshGo2New(this.bst.mListModel.getData());
                return;
            case 2:
                this.bst.mListView.refreshPrepage(this.bst.mListModel.getData());
                return;
            case 3:
                this.bst.mListView.refreshCheckNew(this.bst.mListModel.getData());
                return;
            case 4:
                this.bst.mListView.refreshGo2New(this.bst.mListModel.getData());
                return;
            case 5:
                this.bst.mListView.refreshNormal(this.bst.mListModel.getData());
                return;
            case 6:
                this.bst.mListView.refreshNormal(this.bst.mListModel.getData());
                return;
            case 7:
                this.bst.mListView.refreshNormal(this.bst.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bst.mListView.setDraft(str);
                    this.bst.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bst.isNeedSaveDraft = false;
                this.bst.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bst.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bst.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bst.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bst.isNeedSaveDraft = false;
                this.bst.finish();
                return;
            case 12:
                this.bst.mListView.refreshGo2New(this.bst.mListModel.getData());
                return;
            case 13:
                this.bst.mListView.refreshNormal(this.bst.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bst.mListView.refreshNormal(this.bst.mListModel.getData());
    }
}
