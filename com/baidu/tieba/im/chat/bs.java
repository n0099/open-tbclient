package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.cNV = talkableActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.i.gk()) {
            if (this.cNV.cNH != null) {
                this.cNV.cNH.displayNoNetwork();
            }
        } else if (this.cNV.cNH != null) {
            this.cNV.cNH.hideNoNetwork();
        }
        switch (this.cNV.cNI.getLoadDataMode()) {
            case 1:
                j = this.cNV.cNP;
                if (j > -1) {
                    this.cNV.cNP = -1L;
                }
                this.cNV.cNH.closeProgress();
                this.cNV.cNH.refreshGo2New(this.cNV.cNI.getData());
                return;
            case 2:
                this.cNV.cNH.refreshPrepage(this.cNV.cNI.getData());
                return;
            case 3:
                this.cNV.cNH.refreshCheckNew(this.cNV.cNI.getData());
                return;
            case 4:
                this.cNV.cNH.refreshGo2New(this.cNV.cNI.getData());
                return;
            case 5:
                this.cNV.cNH.refreshNormal(this.cNV.cNI.getData());
                return;
            case 6:
                this.cNV.cNH.refreshNormal(this.cNV.cNI.getData());
                return;
            case 7:
                this.cNV.cNH.refreshNormal(this.cNV.cNI.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.cNV.cNH.setDraft(str);
                    this.cNV.cNI.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.cNV.cNR = false;
                this.cNV.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.cNV.cNH.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                TbadkCoreApplication.m9getInst().login(this.cNV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.cNV.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                this.cNV.cNR = false;
                this.cNV.finish();
                return;
            case 12:
                this.cNV.cNH.refreshGo2New(this.cNV.cNI.getData());
                return;
            case 13:
                this.cNV.cNH.refreshNormal(this.cNV.cNI.getData());
                break;
            case 14:
                break;
            default:
                return;
        }
        this.cNV.cNH.refreshNormal(this.cNV.cNI.getData());
    }
}
