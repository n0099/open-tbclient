package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cGN = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.gm()) {
            if (this.cGN.cGz != null) {
                this.cGN.cGz.displayNoNetwork();
            }
        } else if (this.cGN.cGz != null) {
            this.cGN.cGz.hideNoNetwork();
        }
        switch (this.cGN.cGA.getLoadDataMode()) {
            case 1:
                j = this.cGN.cGH;
                if (j > -1) {
                    this.cGN.cGH = -1L;
                }
                this.cGN.cGz.closeProgress();
                this.cGN.cGz.refreshGo2New(this.cGN.cGA.getData());
                return;
            case 2:
                this.cGN.cGz.refreshPrepage(this.cGN.cGA.getData());
                return;
            case 3:
                this.cGN.cGz.refreshCheckNew(this.cGN.cGA.getData());
                return;
            case 4:
                this.cGN.cGz.refreshGo2New(this.cGN.cGA.getData());
                return;
            case 5:
                this.cGN.cGz.refreshNormal(this.cGN.cGA.getData());
                return;
            case 6:
                this.cGN.cGz.refreshNormal(this.cGN.cGA.getData());
                return;
            case 7:
                this.cGN.cGz.refreshNormal(this.cGN.cGA.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cGN.cGz.setDraft(str);
                    this.cGN.cGA.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cGN.cGJ = false;
                this.cGN.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cGN.cGz.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cGN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cGN.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cGN.cGJ = false;
                this.cGN.finish();
                return;
            case 12:
                this.cGN.cGz.refreshGo2New(this.cGN.cGA.getData());
                return;
            case 13:
                this.cGN.cGz.refreshNormal(this.cGN.cGA.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cGN.cGz.refreshNormal(this.cGN.cGA.getData());
    }
}
