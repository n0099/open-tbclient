package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cQk = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.he()) {
            if (this.cQk.cPW != null) {
                this.cQk.cPW.displayNoNetwork();
            }
        } else if (this.cQk.cPW != null) {
            this.cQk.cPW.hideNoNetwork();
        }
        switch (this.cQk.cPX.getLoadDataMode()) {
            case 1:
                j = this.cQk.cQe;
                if (j > -1) {
                    this.cQk.cQe = -1L;
                }
                this.cQk.cPW.closeProgress();
                this.cQk.cPW.refreshGo2New(this.cQk.cPX.getData());
                return;
            case 2:
                this.cQk.cPW.refreshPrepage(this.cQk.cPX.getData());
                return;
            case 3:
                this.cQk.cPW.refreshCheckNew(this.cQk.cPX.getData());
                return;
            case 4:
                this.cQk.cPW.refreshGo2New(this.cQk.cPX.getData());
                return;
            case 5:
                this.cQk.cPW.refreshNormal(this.cQk.cPX.getData());
                return;
            case 6:
                this.cQk.cPW.refreshNormal(this.cQk.cPX.getData());
                return;
            case 7:
                this.cQk.cPW.refreshNormal(this.cQk.cPX.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cQk.cPW.setDraft(str);
                    this.cQk.cPX.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cQk.cQg = false;
                this.cQk.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cQk.cPW.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cQk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cQk.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cQk.cQg = false;
                this.cQk.finish();
                return;
            case 12:
                this.cQk.cPW.refreshGo2New(this.cQk.cPX.getData());
                return;
            case 13:
                this.cQk.cPW.refreshNormal(this.cQk.cPX.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cQk.cPW.refreshNormal(this.cQk.cPX.getData());
    }
}
