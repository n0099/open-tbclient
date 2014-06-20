package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import com.baidu.tieba.im.model.bj;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003006, new u());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        try {
            this.e = new OfficialBarMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            if (bundle != null) {
                b(bundle);
            } else {
                l();
            }
            return k();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        UserData c;
        this.d = new OfficialBarMsglistView(this, this.e.i());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.chat.w.a;
        if ((this.e instanceof OfficialBarMsglistModel) && (c = ((OfficialBarMsglistModel) this.e).c()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(c.getUserName())) {
                str = c.getUserName();
            }
            this.d.a(String.valueOf(str) + getString(com.baidu.tieba.y.bar), false);
            this.d.a(this.e.h(), i);
            this.d.a(new x(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean p() {
        this.e.g_();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
            bj.a(b);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.i.a(new y(this, userData), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        UserData c;
        super.c();
        if ((this.e instanceof CommonPersonalMsglistModel) && (c = ((CommonPersonalMsglistModel) this.e).c()) != null) {
            com.baidu.tieba.im.i.a(new z(this, c), new aa(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData c;
        super.onClick(view);
        if (view == this.d.F() && (this.e instanceof OfficialBarMsglistModel) && (c = ((OfficialBarMsglistModel) this.e).c()) != null) {
            OfficialBarInfoActivity.a(this, (int) c.getUserIdLong(), c.getUserName());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage a;
        String a2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage a3 = this.e.a(i2);
                if (a3 != null && a3.getUserInfo() != null) {
                    UserData userInfo = a3.getUserInfo();
                    OfficialBarInfoActivity.a(this, (int) userInfo.getUserIdLong(), userInfo.getUserName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (t() && (a = this.e.a(i2)) != null && com.baidu.tieba.im.e.r.a(a) && (a2 = com.baidu.tieba.im.e.r.a(a.getContent(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    OfficialMsgImageActivity.a(this, a2, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong());
                    return;
                }
                return;
        }
    }
}
