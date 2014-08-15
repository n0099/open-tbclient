package com.baidu.tieba.im.chat.officialBar;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity implements com.baidu.tieba.im.view.r {
    public static boolean a;
    public static String b = "";
    private OfficialBarMsglistView m;
    private OfficialBarMsglistModel n;
    private boolean o;
    private final com.baidu.adp.framework.listener.d p = new t(this, 303006);
    private final com.baidu.adp.framework.listener.d q = new u(this, 208003);
    private final CustomMessageListener r = new v(this, 2001181);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.m.d(true);
        this.n.f(this.n.m());
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        try {
            this.e = new OfficialBarMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            this.n = (OfficialBarMsglistModel) this.e;
            if (bundle != null) {
                b(bundle);
            } else {
                l();
            }
            if (k()) {
                this.o = true;
                registerListener(this.p);
                registerListener(this.q);
                registerListener(this.r);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        UserData c;
        this.d = new OfficialBarMsglistView(this, this.e.j());
        this.m = (OfficialBarMsglistView) this.d;
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.chat.w.a;
        if ((this.e instanceof OfficialBarMsglistModel) && (c = ((OfficialBarMsglistModel) this.e).c()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(c.getUserName())) {
                str = c.getUserName();
            }
            this.d.a(String.valueOf(str) + getString(com.baidu.tieba.x.bar), false);
            this.d.a(this.e.i(), i);
            this.d.a(new w(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.e.a(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f(b, 4)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (a(this.m.o()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.n S = this.m.S();
            if (S.isShown() && !a(S).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    ao aoVar = this.m.T()[i];
                    if (aoVar.a) {
                        this.m.S().a();
                        aoVar.a = false;
                        this.m.a(i, aoVar.a);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr == null || iArr.length != 2) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.e.a(new x(this, userData), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        UserData c;
        super.c();
        if ((this.e instanceof CommonPersonalMsglistModel) && (c = ((CommonPersonalMsglistModel) this.e).c()) != null) {
            com.baidu.tieba.im.e.a(new y(this, c), new z(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.l> c;
        com.baidu.tieba.im.data.l lVar;
        UserData c2;
        super.onClick(view);
        if (view == this.d.G()) {
            if ((this.e instanceof OfficialBarMsglistModel) && (c2 = ((OfficialBarMsglistModel) this.e).c()) != null) {
                OfficialBarInfoActivity.a(this, (int) c2.getUserIdLong(), c2.getUserName());
            }
        } else if (view == this.m.U()) {
            this.o = !this.o;
            this.m.e(this.o);
        } else if (view == this.m.T()[0].b || view == this.m.T()[1].b || view == this.m.T()[2].b) {
            com.baidu.tbadk.core.f.a(this, "service_bt_ck");
            int a2 = this.m.a(view);
            for (int i = 0; i < 3; i++) {
                ao aoVar = this.m.T()[i];
                if (aoVar.a && i != a2) {
                    this.m.S().b();
                    aoVar.a = false;
                    this.m.a(i, aoVar.a);
                }
            }
            com.baidu.tieba.im.data.m f = this.n.f();
            if (f != null && (c = f.c()) != null && a2 < c.size() && (lVar = c.get(a2)) != null) {
                if (lVar.c() == 0) {
                    ao aoVar2 = this.m.T()[a2];
                    com.baidu.tieba.im.view.n S = this.m.S();
                    if (aoVar2.a) {
                        S.a();
                    } else {
                        S.a(3, a2, lVar.e());
                        S.a(view);
                    }
                    aoVar2.a = aoVar2.a ? false : true;
                    this.m.a(a2, aoVar2.a);
                    return;
                }
                a(lVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage b2;
        String a2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage b3 = this.e.b(i2);
                if (b3 != null && b3.getUserInfo() != null) {
                    UserData userInfo = b3.getUserInfo();
                    OfficialBarInfoActivity.a(this, (int) userInfo.getUserIdLong(), userInfo.getUserName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (t() && (b2 = this.e.b(i2)) != null && com.baidu.tieba.im.d.j.b(b2) && (a2 = com.baidu.tieba.im.d.j.a(b2.getContent(), true)) != null && (this.e instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.e).c() != null) {
                    OfficialMsgImageActivity.a(this, a2, ((CommonPersonalMsglistModel) this.e).c().getUserIdLong(), String.valueOf(b2.getMsgId()));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.l lVar) {
        if (lVar.c() == 2) {
            this.m.d(true);
            this.n.a(lVar.a(), TbadkApplication.getCurrentAccount(), this.n.m());
        } else if (lVar.c() == 1) {
            UtilHelper.commenDealUrl(this, lVar.d(), lVar.b());
        }
    }

    @Override // com.baidu.tieba.im.view.r
    public void a(int i, com.baidu.tieba.im.data.l lVar) {
        if (lVar != null) {
            a(lVar);
            this.m.S().a();
            ao aoVar = this.m.T()[i];
            aoVar.a = false;
            this.m.a(i, aoVar.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void a(Intent intent) {
        super.a(intent);
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b = "";
    }

    private void v() {
        if (this.e == null || !(this.e instanceof OfficialBarMsglistModel)) {
            b = "";
            return;
        }
        UserData c = ((OfficialBarMsglistModel) this.e).c();
        if (c != null) {
            b = String.valueOf(c.getUserId());
        } else {
            b = "";
        }
    }
}
