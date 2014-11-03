package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends com.baidu.adp.base.h {
    final /* synthetic */ TalkableActivity aQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(TalkableActivity talkableActivity) {
        this.aQq = talkableActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        long j;
        if (!com.baidu.adp.lib.util.j.fh()) {
            if (this.aQq.aQd != null) {
                this.aQq.aQd.displayNoNetwork();
            }
        } else if (this.aQq.aQd != null) {
            this.aQq.aQd.hideNoNetwork();
        }
        switch (this.aQq.aQe.getLoadDataMode()) {
            case 1:
                j = this.aQq.aQl;
                if (j > -1) {
                    this.aQq.aQl = -1L;
                }
                this.aQq.aQd.closeProgress();
                this.aQq.aQd.refreshGo2New(this.aQq.aQe.getData());
                return;
            case 2:
                this.aQq.aQd.refreshPrepage(this.aQq.aQe.getData());
                return;
            case 3:
                this.aQq.aQd.refreshCheckNew(this.aQq.aQe.getData());
                return;
            case 4:
                this.aQq.aQd.refreshGo2New(this.aQq.aQe.getData());
                return;
            case 5:
                this.aQq.aQd.refreshNormal(this.aQq.aQe.getData());
                return;
            case 6:
                this.aQq.aQd.refreshNormal(this.aQq.aQe.getData());
                return;
            case 7:
                this.aQq.aQd.refreshNormal(this.aQq.aQe.getData());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.aQq.aQd.setDraft(str);
                    this.aQq.aQe.setDraft(str);
                    return;
                }
                return;
            case 9:
                this.aQq.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.aQq.aQd.refreshHeaderFooter((String) obj, true);
                    return;
                }
                return;
            case 11:
                LoginActivity.o(this.aQq, TbadkApplication.getCurrentAccountName());
                this.aQq.finish();
                return;
            case 12:
                this.aQq.aQd.refreshGo2New(this.aQq.aQe.getData());
                return;
            case 13:
                this.aQq.aQd.refreshNormal(this.aQq.aQe.getData());
                return;
            default:
                return;
        }
    }
}
