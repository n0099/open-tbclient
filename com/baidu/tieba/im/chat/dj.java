package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj extends com.baidu.adp.base.h {
    final /* synthetic */ TalkableActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(TalkableActivity talkableActivity) {
        this.a = talkableActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        long j;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            if (this.a.d != null) {
                this.a.d.x();
            }
        } else if (this.a.d != null) {
            this.a.d.y();
        }
        switch (this.a.e.getLoadDataMode()) {
            case 1:
                j = this.a.b;
                if (j > -1) {
                    this.a.b = -1L;
                }
                this.a.d.w();
                this.a.d.b(this.a.e.h());
                return;
            case 2:
                this.a.d.c(this.a.e.h());
                return;
            case 3:
                this.a.d.d(this.a.e.h());
                return;
            case 4:
                this.a.d.b(this.a.e.h());
                return;
            case 5:
                this.a.d.a(this.a.e.h());
                return;
            case 6:
                this.a.d.a(this.a.e.h());
                return;
            case 7:
                this.a.d.a(this.a.e.h());
                return;
            case 8:
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.a.d.c(str);
                    this.a.e.b(str);
                    return;
                }
                return;
            case 9:
                this.a.finish();
                return;
            case 10:
                if (obj != null && (obj instanceof String)) {
                    this.a.d.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                LoginActivity.a(this.a, TbadkApplication.getCurrentAccountName());
                this.a.finish();
                return;
            case 12:
                this.a.d.b(this.a.e.h());
                return;
            case 13:
                this.a.d.a(this.a.e.h());
                return;
            default:
                return;
        }
    }
}
