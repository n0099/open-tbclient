package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cUy = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.gm()) {
            if (this.cUy.cUk != null) {
                this.cUy.cUk.displayNoNetwork();
            }
        } else if (this.cUy.cUk != null) {
            this.cUy.cUk.hideNoNetwork();
        }
        switch (this.cUy.cUl.getLoadDataMode()) {
            case 1:
                j = this.cUy.cUs;
                if (j > -1) {
                    this.cUy.cUs = -1L;
                }
                this.cUy.cUk.closeProgress();
                this.cUy.cUk.refreshGo2New(this.cUy.cUl.getData());
                return;
            case 2:
                this.cUy.cUk.refreshPrepage(this.cUy.cUl.getData());
                return;
            case 3:
                this.cUy.cUk.refreshCheckNew(this.cUy.cUl.getData());
                return;
            case 4:
                this.cUy.cUk.refreshGo2New(this.cUy.cUl.getData());
                return;
            case 5:
                this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
                return;
            case 6:
                this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
                return;
            case 7:
                this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cUy.cUk.setDraft(str);
                    this.cUy.cUl.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cUy.cUu = false;
                this.cUy.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cUy.cUk.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cUy.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cUy.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cUy.cUu = false;
                this.cUy.finish();
                return;
            case 12:
                this.cUy.cUk.refreshGo2New(this.cUy.cUl.getData());
                return;
            case 13:
                this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
                break;
            case 14:
                break;
            case 15:
                this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
                return;
            default:
                return;
        }
        this.cUy.cUk.refreshNormal(this.cUy.cUl.getData());
    }
}
