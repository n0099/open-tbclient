package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cGe = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.fr()) {
            if (this.cGe.cFQ != null) {
                this.cGe.cFQ.displayNoNetwork();
            }
        } else if (this.cGe.cFQ != null) {
            this.cGe.cFQ.hideNoNetwork();
        }
        switch (this.cGe.cFR.getLoadDataMode()) {
            case 1:
                j = this.cGe.cFY;
                if (j > -1) {
                    this.cGe.cFY = -1L;
                }
                this.cGe.cFQ.closeProgress();
                this.cGe.cFQ.refreshGo2New(this.cGe.cFR.getData());
                return;
            case 2:
                this.cGe.cFQ.refreshPrepage(this.cGe.cFR.getData());
                return;
            case 3:
                this.cGe.cFQ.refreshCheckNew(this.cGe.cFR.getData());
                return;
            case 4:
                this.cGe.cFQ.refreshGo2New(this.cGe.cFR.getData());
                return;
            case 5:
                this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
                return;
            case 6:
                this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
                return;
            case 7:
                this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cGe.cFQ.setDraft(str);
                    this.cGe.cFR.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cGe.cGa = false;
                this.cGe.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cGe.cFQ.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cGe.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cGe.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cGe.cGa = false;
                this.cGe.finish();
                return;
            case 12:
                this.cGe.cFQ.refreshGo2New(this.cGe.cFR.getData());
                return;
            case 13:
                this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
                break;
            case 14:
                break;
            case 15:
                this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
                return;
            default:
                return;
        }
        this.cGe.cFQ.refreshNormal(this.cGe.cFR.getData());
    }
}
