package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends com.baidu.adp.base.h {
    final /* synthetic */ TalkableActivity aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(TalkableActivity talkableActivity) {
        this.aQc = talkableActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.j.fh()) {
            if (this.aQc.aPP != null) {
                this.aQc.aPP.displayNoNetwork();
            }
        } else if (this.aQc.aPP != null) {
            this.aQc.aPP.hideNoNetwork();
        }
        switch (this.aQc.aPQ.getLoadDataMode()) {
            case 1:
                j = this.aQc.aPX;
                if (j > -1) {
                    this.aQc.aPX = -1L;
                }
                this.aQc.aPP.closeProgress();
                this.aQc.aPP.refreshGo2New(this.aQc.aPQ.getData());
                return;
            case 2:
                this.aQc.aPP.refreshPrepage(this.aQc.aPQ.getData());
                return;
            case 3:
                this.aQc.aPP.refreshCheckNew(this.aQc.aPQ.getData());
                return;
            case 4:
                this.aQc.aPP.refreshGo2New(this.aQc.aPQ.getData());
                return;
            case 5:
                this.aQc.aPP.refreshNormal(this.aQc.aPQ.getData());
                return;
            case 6:
                this.aQc.aPP.refreshNormal(this.aQc.aPQ.getData());
                return;
            case 7:
                this.aQc.aPP.refreshNormal(this.aQc.aPQ.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aQc.aPP.setDraft(str);
                    this.aQc.aPQ.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aQc.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aQc.aPP.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                LoginActivity.o(this.aQc, TbadkApplication.getCurrentAccountName());
                this.aQc.finish();
                return;
            case 12:
                this.aQc.aPP.refreshGo2New(this.aQc.aPQ.getData());
                return;
            case 13:
                this.aQc.aPP.refreshNormal(this.aQc.aPQ.getData());
                return;
            default:
                return;
        }
    }
}
