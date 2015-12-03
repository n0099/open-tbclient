package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bIo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bIo = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iP()) {
            if (this.bIo.mListView != null) {
                this.bIo.mListView.displayNoNetwork();
            }
        } else if (this.bIo.mListView != null) {
            this.bIo.mListView.hideNoNetwork();
        }
        switch (this.bIo.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bIo.preTime;
                if (j > -1) {
                    this.bIo.preTime = -1L;
                }
                this.bIo.mListView.closeProgress();
                this.bIo.mListView.refreshGo2New(this.bIo.mListModel.getData());
                return;
            case 2:
                this.bIo.mListView.refreshPrepage(this.bIo.mListModel.getData());
                return;
            case 3:
                this.bIo.mListView.refreshCheckNew(this.bIo.mListModel.getData());
                return;
            case 4:
                this.bIo.mListView.refreshGo2New(this.bIo.mListModel.getData());
                return;
            case 5:
                this.bIo.mListView.refreshNormal(this.bIo.mListModel.getData());
                return;
            case 6:
                this.bIo.mListView.refreshNormal(this.bIo.mListModel.getData());
                return;
            case 7:
                this.bIo.mListView.refreshNormal(this.bIo.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bIo.mListView.setDraft(str);
                    this.bIo.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bIo.isNeedSaveDraft = false;
                this.bIo.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bIo.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bIo.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bIo.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bIo.isNeedSaveDraft = false;
                this.bIo.finish();
                return;
            case 12:
                this.bIo.mListView.refreshGo2New(this.bIo.mListModel.getData());
                return;
            case 13:
                this.bIo.mListView.refreshNormal(this.bIo.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bIo.mListView.refreshNormal(this.bIo.mListModel.getData());
    }
}
