package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity caU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.caU = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.fq()) {
            if (this.caU.caG != null) {
                this.caU.caG.displayNoNetwork();
            }
        } else if (this.caU.caG != null) {
            this.caU.caG.hideNoNetwork();
        }
        switch (this.caU.caH.getLoadDataMode()) {
            case 1:
                j = this.caU.caO;
                if (j > -1) {
                    this.caU.caO = -1L;
                }
                this.caU.caG.closeProgress();
                this.caU.caG.refreshGo2New(this.caU.caH.getData());
                return;
            case 2:
                this.caU.caG.refreshPrepage(this.caU.caH.getData());
                return;
            case 3:
                this.caU.caG.refreshCheckNew(this.caU.caH.getData());
                return;
            case 4:
                this.caU.caG.refreshGo2New(this.caU.caH.getData());
                return;
            case 5:
                this.caU.caG.refreshNormal(this.caU.caH.getData());
                return;
            case 6:
                this.caU.caG.refreshNormal(this.caU.caH.getData());
                return;
            case 7:
                this.caU.caG.refreshNormal(this.caU.caH.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.caU.caG.setDraft(str);
                    this.caU.caH.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.caU.caQ = false;
                this.caU.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.caU.caG.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m11getInst().login(this.caU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.caU.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.caU.caQ = false;
                this.caU.finish();
                return;
            case 12:
                this.caU.caG.refreshGo2New(this.caU.caH.getData());
                return;
            case 13:
                this.caU.caG.refreshNormal(this.caU.caH.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.caU.caG.refreshNormal(this.caU.caH.getData());
    }
}
