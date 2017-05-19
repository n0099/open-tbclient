package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cLa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cLa = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.hk()) {
            if (this.cLa.cKM != null) {
                this.cLa.cKM.displayNoNetwork();
            }
        } else if (this.cLa.cKM != null) {
            this.cLa.cKM.hideNoNetwork();
        }
        switch (this.cLa.cKN.getLoadDataMode()) {
            case 1:
                j = this.cLa.cKU;
                if (j > -1) {
                    this.cLa.cKU = -1L;
                }
                this.cLa.cKM.closeProgress();
                this.cLa.cKM.refreshGo2New(this.cLa.cKN.getData());
                return;
            case 2:
                this.cLa.cKM.refreshPrepage(this.cLa.cKN.getData());
                return;
            case 3:
                this.cLa.cKM.refreshCheckNew(this.cLa.cKN.getData());
                return;
            case 4:
                this.cLa.cKM.refreshGo2New(this.cLa.cKN.getData());
                return;
            case 5:
                this.cLa.cKM.refreshNormal(this.cLa.cKN.getData());
                return;
            case 6:
                this.cLa.cKM.refreshNormal(this.cLa.cKN.getData());
                return;
            case 7:
                this.cLa.cKM.refreshNormal(this.cLa.cKN.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cLa.cKM.setDraft(str);
                    this.cLa.cKN.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cLa.cKW = false;
                this.cLa.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cLa.cKM.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cLa.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cLa.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cLa.cKW = false;
                this.cLa.finish();
                return;
            case 12:
                this.cLa.cKM.refreshGo2New(this.cLa.cKN.getData());
                return;
            case 13:
                this.cLa.cKM.refreshNormal(this.cLa.cKN.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cLa.cKM.refreshNormal(this.cLa.cKN.getData());
    }
}
