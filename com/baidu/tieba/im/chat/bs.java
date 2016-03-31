package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cap = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.jf()) {
            if (this.cap.cab != null) {
                this.cap.cab.displayNoNetwork();
            }
        } else if (this.cap.cab != null) {
            this.cap.cab.hideNoNetwork();
        }
        switch (this.cap.cac.getLoadDataMode()) {
            case 1:
                j = this.cap.caj;
                if (j > -1) {
                    this.cap.caj = -1L;
                }
                this.cap.cab.closeProgress();
                this.cap.cab.refreshGo2New(this.cap.cac.getData());
                return;
            case 2:
                this.cap.cab.refreshPrepage(this.cap.cac.getData());
                return;
            case 3:
                this.cap.cab.refreshCheckNew(this.cap.cac.getData());
                return;
            case 4:
                this.cap.cab.refreshGo2New(this.cap.cac.getData());
                return;
            case 5:
                this.cap.cab.refreshNormal(this.cap.cac.getData());
                return;
            case 6:
                this.cap.cab.refreshNormal(this.cap.cac.getData());
                return;
            case 7:
                this.cap.cab.refreshNormal(this.cap.cac.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cap.cab.setDraft(str);
                    this.cap.cac.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cap.cal = false;
                this.cap.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cap.cab.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.cap.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cap.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cap.cal = false;
                this.cap.finish();
                return;
            case 12:
                this.cap.cab.refreshGo2New(this.cap.cac.getData());
                return;
            case 13:
                this.cap.cab.refreshNormal(this.cap.cac.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cap.cab.refreshNormal(this.cap.cac.getData());
    }
}
