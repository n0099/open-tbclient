package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bsE = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iM()) {
            if (this.bsE.mListView != null) {
                this.bsE.mListView.displayNoNetwork();
            }
        } else if (this.bsE.mListView != null) {
            this.bsE.mListView.hideNoNetwork();
        }
        switch (this.bsE.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bsE.preTime;
                if (j > -1) {
                    this.bsE.preTime = -1L;
                }
                this.bsE.mListView.closeProgress();
                this.bsE.mListView.refreshGo2New(this.bsE.mListModel.getData());
                return;
            case 2:
                this.bsE.mListView.refreshPrepage(this.bsE.mListModel.getData());
                return;
            case 3:
                this.bsE.mListView.refreshCheckNew(this.bsE.mListModel.getData());
                return;
            case 4:
                this.bsE.mListView.refreshGo2New(this.bsE.mListModel.getData());
                return;
            case 5:
                this.bsE.mListView.refreshNormal(this.bsE.mListModel.getData());
                return;
            case 6:
                this.bsE.mListView.refreshNormal(this.bsE.mListModel.getData());
                return;
            case 7:
                this.bsE.mListView.refreshNormal(this.bsE.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bsE.mListView.setDraft(str);
                    this.bsE.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bsE.isNeedSaveDraft = false;
                this.bsE.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bsE.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bsE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bsE.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bsE.isNeedSaveDraft = false;
                this.bsE.finish();
                return;
            case 12:
                this.bsE.mListView.refreshGo2New(this.bsE.mListModel.getData());
                return;
            case 13:
                this.bsE.mListView.refreshNormal(this.bsE.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bsE.mListView.refreshNormal(this.bsE.mListModel.getData());
    }
}
