package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cQY = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.hk()) {
            if (this.cQY.cQK != null) {
                this.cQY.cQK.displayNoNetwork();
            }
        } else if (this.cQY.cQK != null) {
            this.cQY.cQK.hideNoNetwork();
        }
        switch (this.cQY.cQL.getLoadDataMode()) {
            case 1:
                j = this.cQY.cQS;
                if (j > -1) {
                    this.cQY.cQS = -1L;
                }
                this.cQY.cQK.closeProgress();
                this.cQY.cQK.refreshGo2New(this.cQY.cQL.getData());
                return;
            case 2:
                this.cQY.cQK.refreshPrepage(this.cQY.cQL.getData());
                return;
            case 3:
                this.cQY.cQK.refreshCheckNew(this.cQY.cQL.getData());
                return;
            case 4:
                this.cQY.cQK.refreshGo2New(this.cQY.cQL.getData());
                return;
            case 5:
                this.cQY.cQK.refreshNormal(this.cQY.cQL.getData());
                return;
            case 6:
                this.cQY.cQK.refreshNormal(this.cQY.cQL.getData());
                return;
            case 7:
                this.cQY.cQK.refreshNormal(this.cQY.cQL.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cQY.cQK.setDraft(str);
                    this.cQY.cQL.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cQY.cQU = false;
                this.cQY.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cQY.cQK.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cQY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cQY.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cQY.cQU = false;
                this.cQY.finish();
                return;
            case 12:
                this.cQY.cQK.refreshGo2New(this.cQY.cQL.getData());
                return;
            case 13:
                this.cQY.cQK.refreshNormal(this.cQY.cQL.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cQY.cQK.refreshNormal(this.cQY.cQL.getData());
    }
}
