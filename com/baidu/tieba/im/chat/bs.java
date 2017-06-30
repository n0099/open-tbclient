package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cYu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cYu = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.hj()) {
            if (this.cYu.cYg != null) {
                this.cYu.cYg.displayNoNetwork();
            }
        } else if (this.cYu.cYg != null) {
            this.cYu.cYg.hideNoNetwork();
        }
        switch (this.cYu.cYh.getLoadDataMode()) {
            case 1:
                j = this.cYu.cYo;
                if (j > -1) {
                    this.cYu.cYo = -1L;
                }
                this.cYu.cYg.closeProgress();
                this.cYu.cYg.refreshGo2New(this.cYu.cYh.getData());
                return;
            case 2:
                this.cYu.cYg.refreshPrepage(this.cYu.cYh.getData());
                return;
            case 3:
                this.cYu.cYg.refreshCheckNew(this.cYu.cYh.getData());
                return;
            case 4:
                this.cYu.cYg.refreshGo2New(this.cYu.cYh.getData());
                return;
            case 5:
                this.cYu.cYg.refreshNormal(this.cYu.cYh.getData());
                return;
            case 6:
                this.cYu.cYg.refreshNormal(this.cYu.cYh.getData());
                return;
            case 7:
                this.cYu.cYg.refreshNormal(this.cYu.cYh.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cYu.cYg.setDraft(str);
                    this.cYu.cYh.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cYu.cYq = false;
                this.cYu.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cYu.cYg.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cYu.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cYu.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cYu.cYq = false;
                this.cYu.finish();
                return;
            case 12:
                this.cYu.cYg.refreshGo2New(this.cYu.cYh.getData());
                return;
            case 13:
                this.cYu.cYg.refreshNormal(this.cYu.cYh.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cYu.cYg.refreshNormal(this.cYu.cYh.getData());
    }
}
