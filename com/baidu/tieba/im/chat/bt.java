package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity dbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.dbD = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.gm()) {
            if (this.dbD.dbp != null) {
                this.dbD.dbp.displayNoNetwork();
            }
        } else if (this.dbD.dbp != null) {
            this.dbD.dbp.hideNoNetwork();
        }
        switch (this.dbD.dbq.getLoadDataMode()) {
            case 1:
                j = this.dbD.dbx;
                if (j > -1) {
                    this.dbD.dbx = -1L;
                }
                this.dbD.dbp.closeProgress();
                this.dbD.dbp.refreshGo2New(this.dbD.dbq.getData());
                return;
            case 2:
                this.dbD.dbp.refreshPrepage(this.dbD.dbq.getData());
                return;
            case 3:
                this.dbD.dbp.refreshCheckNew(this.dbD.dbq.getData());
                return;
            case 4:
                this.dbD.dbp.refreshGo2New(this.dbD.dbq.getData());
                return;
            case 5:
                this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
                return;
            case 6:
                this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
                return;
            case 7:
                this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.dbD.dbp.setDraft(str);
                    this.dbD.dbq.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.dbD.dbz = false;
                this.dbD.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.dbD.dbp.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.dbD.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.dbD.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.dbD.dbz = false;
                this.dbD.finish();
                return;
            case 12:
                this.dbD.dbp.refreshGo2New(this.dbD.dbq.getData());
                return;
            case 13:
                this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
                break;
            case 14:
                break;
            case 15:
                this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
                return;
            default:
                return;
        }
        this.dbD.dbp.refreshNormal(this.dbD.dbq.getData());
    }
}
