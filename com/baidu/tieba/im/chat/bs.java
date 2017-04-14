package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cOH = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.hj()) {
            if (this.cOH.cOt != null) {
                this.cOH.cOt.displayNoNetwork();
            }
        } else if (this.cOH.cOt != null) {
            this.cOH.cOt.hideNoNetwork();
        }
        switch (this.cOH.cOu.getLoadDataMode()) {
            case 1:
                j = this.cOH.cOB;
                if (j > -1) {
                    this.cOH.cOB = -1L;
                }
                this.cOH.cOt.closeProgress();
                this.cOH.cOt.refreshGo2New(this.cOH.cOu.getData());
                return;
            case 2:
                this.cOH.cOt.refreshPrepage(this.cOH.cOu.getData());
                return;
            case 3:
                this.cOH.cOt.refreshCheckNew(this.cOH.cOu.getData());
                return;
            case 4:
                this.cOH.cOt.refreshGo2New(this.cOH.cOu.getData());
                return;
            case 5:
                this.cOH.cOt.refreshNormal(this.cOH.cOu.getData());
                return;
            case 6:
                this.cOH.cOt.refreshNormal(this.cOH.cOu.getData());
                return;
            case 7:
                this.cOH.cOt.refreshNormal(this.cOH.cOu.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cOH.cOt.setDraft(str);
                    this.cOH.cOu.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cOH.cOD = false;
                this.cOH.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cOH.cOt.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cOH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cOH.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cOH.cOD = false;
                this.cOH.finish();
                return;
            case 12:
                this.cOH.cOt.refreshGo2New(this.cOH.cOu.getData());
                return;
            case 13:
                this.cOH.cOt.refreshNormal(this.cOH.cOu.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cOH.cOt.refreshNormal(this.cOH.cOu.getData());
    }
}
