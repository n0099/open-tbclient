package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.bPX = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            if (this.bPX.bPJ != null) {
                this.bPX.bPJ.displayNoNetwork();
            }
        } else if (this.bPX.bPJ != null) {
            this.bPX.bPJ.hideNoNetwork();
        }
        switch (this.bPX.bPK.getLoadDataMode()) {
            case 1:
                j = this.bPX.bPR;
                if (j > -1) {
                    this.bPX.bPR = -1L;
                }
                this.bPX.bPJ.closeProgress();
                this.bPX.bPJ.refreshGo2New(this.bPX.bPK.getData());
                return;
            case 2:
                this.bPX.bPJ.refreshPrepage(this.bPX.bPK.getData());
                return;
            case 3:
                this.bPX.bPJ.refreshCheckNew(this.bPX.bPK.getData());
                return;
            case 4:
                this.bPX.bPJ.refreshGo2New(this.bPX.bPK.getData());
                return;
            case 5:
                this.bPX.bPJ.refreshNormal(this.bPX.bPK.getData());
                return;
            case 6:
                this.bPX.bPJ.refreshNormal(this.bPX.bPK.getData());
                return;
            case 7:
                this.bPX.bPJ.refreshNormal(this.bPX.bPK.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.bPX.bPJ.setDraft(str);
                    this.bPX.bPK.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.bPX.bPT = false;
                this.bPX.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.bPX.bPJ.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m411getInst().login(this.bPX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.bPX.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.bPX.bPT = false;
                this.bPX.finish();
                return;
            case 12:
                this.bPX.bPJ.refreshGo2New(this.bPX.bPK.getData());
                return;
            case 13:
                this.bPX.bPJ.refreshNormal(this.bPX.bPK.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.bPX.bPJ.refreshNormal(this.bPX.bPK.getData());
    }
}
