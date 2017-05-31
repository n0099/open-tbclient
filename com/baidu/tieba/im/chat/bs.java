package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cQy = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.hk()) {
            if (this.cQy.cQk != null) {
                this.cQy.cQk.displayNoNetwork();
            }
        } else if (this.cQy.cQk != null) {
            this.cQy.cQk.hideNoNetwork();
        }
        switch (this.cQy.cQl.getLoadDataMode()) {
            case 1:
                j = this.cQy.cQs;
                if (j > -1) {
                    this.cQy.cQs = -1L;
                }
                this.cQy.cQk.closeProgress();
                this.cQy.cQk.refreshGo2New(this.cQy.cQl.getData());
                return;
            case 2:
                this.cQy.cQk.refreshPrepage(this.cQy.cQl.getData());
                return;
            case 3:
                this.cQy.cQk.refreshCheckNew(this.cQy.cQl.getData());
                return;
            case 4:
                this.cQy.cQk.refreshGo2New(this.cQy.cQl.getData());
                return;
            case 5:
                this.cQy.cQk.refreshNormal(this.cQy.cQl.getData());
                return;
            case 6:
                this.cQy.cQk.refreshNormal(this.cQy.cQl.getData());
                return;
            case 7:
                this.cQy.cQk.refreshNormal(this.cQy.cQl.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cQy.cQk.setDraft(str);
                    this.cQy.cQl.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cQy.cQu = false;
                this.cQy.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cQy.cQk.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cQy.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cQy.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cQy.cQu = false;
                this.cQy.finish();
                return;
            case 12:
                this.cQy.cQk.refreshGo2New(this.cQy.cQl.getData());
                return;
            case 13:
                this.cQy.cQk.refreshNormal(this.cQy.cQl.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cQy.cQk.refreshNormal(this.cQy.cQl.getData());
    }
}
