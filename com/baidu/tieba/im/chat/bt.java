package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cVS = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.gm()) {
            if (this.cVS.cVE != null) {
                this.cVS.cVE.displayNoNetwork();
            }
        } else if (this.cVS.cVE != null) {
            this.cVS.cVE.hideNoNetwork();
        }
        switch (this.cVS.cVF.getLoadDataMode()) {
            case 1:
                j = this.cVS.cVM;
                if (j > -1) {
                    this.cVS.cVM = -1L;
                }
                this.cVS.cVE.closeProgress();
                this.cVS.cVE.refreshGo2New(this.cVS.cVF.getData());
                return;
            case 2:
                this.cVS.cVE.refreshPrepage(this.cVS.cVF.getData());
                return;
            case 3:
                this.cVS.cVE.refreshCheckNew(this.cVS.cVF.getData());
                return;
            case 4:
                this.cVS.cVE.refreshGo2New(this.cVS.cVF.getData());
                return;
            case 5:
                this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
                return;
            case 6:
                this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
                return;
            case 7:
                this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cVS.cVE.setDraft(str);
                    this.cVS.cVF.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cVS.cVO = false;
                this.cVS.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cVS.cVE.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cVS.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cVS.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cVS.cVO = false;
                this.cVS.finish();
                return;
            case 12:
                this.cVS.cVE.refreshGo2New(this.cVS.cVF.getData());
                return;
            case 13:
                this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
                break;
            case 14:
                break;
            case 15:
                this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
                return;
            default:
                return;
        }
        this.cVS.cVE.refreshNormal(this.cVS.cVF.getData());
    }
}
