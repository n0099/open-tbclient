package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cIT = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.fq()) {
            if (this.cIT.cIF != null) {
                this.cIT.cIF.displayNoNetwork();
            }
        } else if (this.cIT.cIF != null) {
            this.cIT.cIF.hideNoNetwork();
        }
        switch (this.cIT.cIG.getLoadDataMode()) {
            case 1:
                j = this.cIT.cIN;
                if (j > -1) {
                    this.cIT.cIN = -1L;
                }
                this.cIT.cIF.closeProgress();
                this.cIT.cIF.refreshGo2New(this.cIT.cIG.getData());
                return;
            case 2:
                this.cIT.cIF.refreshPrepage(this.cIT.cIG.getData());
                return;
            case 3:
                this.cIT.cIF.refreshCheckNew(this.cIT.cIG.getData());
                return;
            case 4:
                this.cIT.cIF.refreshGo2New(this.cIT.cIG.getData());
                return;
            case 5:
                this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
                return;
            case 6:
                this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
                return;
            case 7:
                this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cIT.cIF.setDraft(str);
                    this.cIT.cIG.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cIT.cIP = false;
                this.cIT.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cIT.cIF.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m10getInst().login(this.cIT.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cIT.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cIT.cIP = false;
                this.cIT.finish();
                return;
            case 12:
                this.cIT.cIF.refreshGo2New(this.cIT.cIG.getData());
                return;
            case 13:
                this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
                break;
            case 14:
                break;
            case 15:
                this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
                return;
            default:
                return;
        }
        this.cIT.cIF.refreshNormal(this.cIT.cIG.getData());
    }
}
