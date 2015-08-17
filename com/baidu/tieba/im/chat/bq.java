package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(TalkableActivity talkableActivity) {
        this.boV = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iO()) {
            if (this.boV.mListView != null) {
                this.boV.mListView.displayNoNetwork();
            }
        } else if (this.boV.mListView != null) {
            this.boV.mListView.hideNoNetwork();
        }
        switch (this.boV.mListModel.getLoadDataMode()) {
            case 1:
                j = this.boV.preTime;
                if (j > -1) {
                    this.boV.preTime = -1L;
                }
                this.boV.mListView.closeProgress();
                this.boV.mListView.refreshGo2New(this.boV.mListModel.getData());
                return;
            case 2:
                this.boV.mListView.refreshPrepage(this.boV.mListModel.getData());
                return;
            case 3:
                this.boV.mListView.refreshCheckNew(this.boV.mListModel.getData());
                return;
            case 4:
                this.boV.mListView.refreshGo2New(this.boV.mListModel.getData());
                return;
            case 5:
                this.boV.mListView.refreshNormal(this.boV.mListModel.getData());
                return;
            case 6:
                this.boV.mListView.refreshNormal(this.boV.mListModel.getData());
                return;
            case 7:
                this.boV.mListView.refreshNormal(this.boV.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.boV.mListView.setDraft(str);
                    this.boV.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.boV.isNeedSaveDraft = false;
                this.boV.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.boV.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.boV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.boV.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.boV.isNeedSaveDraft = false;
                this.boV.finish();
                return;
            case 12:
                this.boV.mListView.refreshGo2New(this.boV.mListModel.getData());
                return;
            case 13:
                this.boV.mListView.refreshNormal(this.boV.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.boV.mListView.refreshNormal(this.boV.mListModel.getData());
    }
}
