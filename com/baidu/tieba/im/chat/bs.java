package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bLV = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iQ()) {
            if (this.bLV.mListView != null) {
                this.bLV.mListView.displayNoNetwork();
            }
        } else if (this.bLV.mListView != null) {
            this.bLV.mListView.hideNoNetwork();
        }
        switch (this.bLV.mListModel.getLoadDataMode()) {
            case 1:
                j = this.bLV.preTime;
                if (j > -1) {
                    this.bLV.preTime = -1L;
                }
                this.bLV.mListView.closeProgress();
                this.bLV.mListView.refreshGo2New(this.bLV.mListModel.getData());
                return;
            case 2:
                this.bLV.mListView.refreshPrepage(this.bLV.mListModel.getData());
                return;
            case 3:
                this.bLV.mListView.refreshCheckNew(this.bLV.mListModel.getData());
                return;
            case 4:
                this.bLV.mListView.refreshGo2New(this.bLV.mListModel.getData());
                return;
            case 5:
                this.bLV.mListView.refreshNormal(this.bLV.mListModel.getData());
                return;
            case 6:
                this.bLV.mListView.refreshNormal(this.bLV.mListModel.getData());
                return;
            case 7:
                this.bLV.mListView.refreshNormal(this.bLV.mListModel.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bLV.mListView.setDraft(str);
                    this.bLV.mListModel.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bLV.isNeedSaveDraft = false;
                this.bLV.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bLV.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bLV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bLV.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bLV.isNeedSaveDraft = false;
                this.bLV.finish();
                return;
            case 12:
                this.bLV.mListView.refreshGo2New(this.bLV.mListModel.getData());
                return;
            case 13:
                this.bLV.mListView.refreshNormal(this.bLV.mListModel.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bLV.mListView.refreshNormal(this.bLV.mListModel.getData());
    }
}
