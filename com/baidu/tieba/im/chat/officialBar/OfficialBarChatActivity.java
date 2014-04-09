package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001006, new u());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean b(Bundle bundle) {
        try {
            this.e = new OfficialBarMsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                a(bundle);
            } else {
                l();
            }
            return k();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final void o() {
        UserData c;
        this.d = new OfficialBarMsglistView(this, this.e.h());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.chat.x.a;
        if ((this.e instanceof OfficialBarMsglistModel) && (c = ((OfficialBarMsglistModel) this.e).c()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(c.getUserName())) {
                str = c.getUserName();
            }
            this.d.a(String.valueOf(str) + getString(com.baidu.tieba.im.j.bar));
            this.d.a(this.e.g(), i);
            this.d.a(new x(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean p() {
        this.e.f_();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dj, com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().e();
            ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(b);
            if (a != null) {
                a.setUnread_count(0);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected final void a(UserData userData) {
        com.baidu.tieba.im.r.a(new y(this, userData), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public final void c() {
        UserData c;
        super.c();
        if ((this.e instanceof CommonPersonalMsglistModel) && (c = ((CommonPersonalMsglistModel) this.e).c()) != null) {
            com.baidu.tieba.im.r.a(new z(this, c), new aa(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.dj, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData c;
        super.onClick(view);
        if (view == this.d.A() && (this.e instanceof OfficialBarMsglistModel) && (c = ((OfficialBarMsglistModel) this.e).c()) != null) {
            OfficialBarInfoActivity.a(this, (int) c.getUserIdLong(), c.getUserName());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.dj, com.baidu.adp.lib.b.b
    public final void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 9:
                if (this.d instanceof OfficialBarMsglistView) {
                    ((OfficialBarMsglistView) this.d).h(i2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.dj, com.baidu.adp.lib.b.a
    public final void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.a.a a;
        String a2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                com.baidu.tieba.im.message.a.a a3 = this.e.a(i2);
                if (a3 != null && a3.r() != null) {
                    UserData r = a3.r();
                    OfficialBarInfoActivity.a(this, (int) r.getUserIdLong(), r.getUserName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (s() && (a = this.e.a(i2)) != null && com.baidu.tieba.im.f.q.a(a) && (a2 = com.baidu.tieba.im.f.q.a(a.v(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    OfficialMsgImageActivity.a(this, a2, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong());
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.dj, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if ((this.d instanceof OfficialBarMsglistView) && dialogInterface == ((OfficialBarMsglistView) this.d).R()) {
            this.e.c(((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue());
        }
    }
}
