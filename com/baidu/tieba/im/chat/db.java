package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends com.baidu.adp.base.e {
    final /* synthetic */ TalkableActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(TalkableActivity talkableActivity) {
        this.a = talkableActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        long j;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            if (this.a.d != null) {
                this.a.d.w();
            }
        } else if (this.a.d != null) {
            this.a.d.x();
        }
        switch (this.a.e.getLoadDataMode()) {
            case 1:
                BdLog.d("MODE_TYPE_GET_MSGS");
                j = this.a.b;
                if (j > -1) {
                    this.a.b = -1L;
                }
                this.a.d.v();
                this.a.d.b(this.a.e.h());
                return;
            case 2:
                BdLog.d("MODE_TYPE_PRE");
                this.a.d.c(this.a.e.h());
                return;
            case 3:
                BdLog.d("MODE_TYPE_PUSH");
                this.a.d.d(this.a.e.h());
                return;
            case 4:
                BdLog.d("MODE_TYPE_SENDING");
                this.a.d.b(this.a.e.h());
                return;
            case 5:
                BdLog.d("MODE_TYPE_SEND");
                this.a.d.a(this.a.e.h());
                return;
            case 6:
                BdLog.d("MODE_TYPE_RESEND");
                this.a.d.a(this.a.e.h());
                return;
            case 7:
                BdLog.d("MODE_TYPE_DELETE_MSG");
                this.a.d.a(this.a.e.h());
                return;
            case 8:
                BdLog.d("MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.a.d.c(str);
                    this.a.e.b(str);
                    return;
                }
                return;
            case 9:
                BdLog.d("MODE_TYPE_QUIT_GROUP");
                this.a.finish();
                return;
            case 10:
                BdLog.d("MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    this.a.d.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                BdLog.d("MODE_TYPE_UNLOGIN");
                LoginActivity.a(this.a, TbadkApplication.getCurrentAccountName());
                this.a.finish();
                return;
            case 12:
                BdLog.d("MODE_TYPE_CLEAR_HISTORY");
                this.a.d.b(this.a.e.h());
                return;
            case 13:
                BdLog.d("MODE_TYPE_CHAT_ROOM_RULE");
                this.a.d.a(this.a.e.h());
                return;
            default:
                return;
        }
    }
}
