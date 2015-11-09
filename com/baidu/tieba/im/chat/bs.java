package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bti = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iN()) {
            if (this.bti.mListView != null) {
                this.bti.mListView.displayNoNetwork();
            }
        } else if (this.bti.mListView != null) {
            this.bti.mListView.hideNoNetwork();
        }
        switch (this.bti.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bti.preTime;
                if (j > -1) {
                    this.bti.preTime = -1L;
                }
                this.bti.mListView.closeProgress();
                this.bti.mListView.refreshGo2New(this.bti.mListModel.getData());
                return;
            case 2:
                this.bti.mListView.refreshPrepage(this.bti.mListModel.getData());
                return;
            case 3:
                this.bti.mListView.refreshCheckNew(this.bti.mListModel.getData());
                return;
            case 4:
                this.bti.mListView.refreshGo2New(this.bti.mListModel.getData());
                return;
            case 5:
                this.bti.mListView.refreshNormal(this.bti.mListModel.getData());
                return;
            case 6:
                this.bti.mListView.refreshNormal(this.bti.mListModel.getData());
                return;
            case 7:
                this.bti.mListView.refreshNormal(this.bti.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bti.mListView.setDraft(str);
                    this.bti.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bti.isNeedSaveDraft = false;
                this.bti.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bti.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bti.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bti.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bti.isNeedSaveDraft = false;
                this.bti.finish();
                return;
            case 12:
                this.bti.mListView.refreshGo2New(this.bti.mListModel.getData());
                return;
            case 13:
                this.bti.mListView.refreshNormal(this.bti.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bti.mListView.refreshNormal(this.bti.mListModel.getData());
    }
}
