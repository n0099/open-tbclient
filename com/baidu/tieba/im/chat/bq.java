package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(TalkableActivity talkableActivity) {
        this.bpt = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iL()) {
            if (this.bpt.mListView != null) {
                this.bpt.mListView.displayNoNetwork();
            }
        } else if (this.bpt.mListView != null) {
            this.bpt.mListView.hideNoNetwork();
        }
        switch (this.bpt.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bpt.preTime;
                if (j > -1) {
                    this.bpt.preTime = -1L;
                }
                this.bpt.mListView.closeProgress();
                this.bpt.mListView.refreshGo2New(this.bpt.mListModel.getData());
                return;
            case 2:
                this.bpt.mListView.refreshPrepage(this.bpt.mListModel.getData());
                return;
            case 3:
                this.bpt.mListView.refreshCheckNew(this.bpt.mListModel.getData());
                return;
            case 4:
                this.bpt.mListView.refreshGo2New(this.bpt.mListModel.getData());
                return;
            case 5:
                this.bpt.mListView.refreshNormal(this.bpt.mListModel.getData());
                return;
            case 6:
                this.bpt.mListView.refreshNormal(this.bpt.mListModel.getData());
                return;
            case 7:
                this.bpt.mListView.refreshNormal(this.bpt.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bpt.mListView.setDraft(str);
                    this.bpt.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bpt.isNeedSaveDraft = false;
                this.bpt.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bpt.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bpt.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bpt.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bpt.isNeedSaveDraft = false;
                this.bpt.finish();
                return;
            case 12:
                this.bpt.mListView.refreshGo2New(this.bpt.mListModel.getData());
                return;
            case 13:
                this.bpt.mListView.refreshNormal(this.bpt.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bpt.mListView.refreshNormal(this.bpt.mListModel.getData());
    }
}
