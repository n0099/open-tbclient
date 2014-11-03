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
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarChatActivity extends CommonPersonalChatActivity implements com.baidu.tieba.im.view.o {
    public static String ZK = "";
    public static boolean aOq;
    private OfficialBarMsglistView aRm;
    private OfficialBarMsglistModel aRn;
    private boolean aRo;
    private final com.baidu.adp.framework.listener.e aRp = new t(this, 303006);
    private final com.baidu.adp.framework.listener.e aRq = new u(this, 208003);
    private final CustomMessageListener aRr = new v(this, 2001181);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aRm.cJ(true);
        this.aRn.sendGetMenuLocalMessage(this.aRn.getForumId());
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean h(Bundle bundle) {
        try {
            this.aQe = new OfficialBarMsglistModel(this);
            this.aQe.setLoadDataCallBack(this.aQo);
            this.aRn = (OfficialBarMsglistModel) this.aQe;
            if (bundle != null) {
                f(bundle);
            } else {
                Jv();
            }
            if (Jw()) {
                this.aRo = true;
                registerListener(this.aRp);
                registerListener(this.aRq);
                registerListener(this.aRr);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void nu() {
        UserData user;
        this.aQd = new OfficialBarMsglistView(this, this.aQe.getIsAcceptNotify());
        this.aRm = (OfficialBarMsglistView) this.aQd;
        this.aQd.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.chat.w.aNT;
        if ((this.aQe instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.aQe).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            this.aQd.refreshHeaderFooter(String.valueOf(str) + getString(com.baidu.tieba.y.bar), false);
            this.aQd.bindDataAndRefresh(this.aQe.getData(), i);
            this.aQd.setRecordCallback(new w(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aQe.loadFirst(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aOq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aOq = true;
        if (!TextUtils.isEmpty(ZK)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oD().oJ();
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZK, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (K(this.aRm.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.k Kz = this.aRm.Kz();
            if (Kz.isShown() && !K(Kz).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    ao aoVar = this.aRm.KA()[i];
                    if (aoVar.aSc) {
                        this.aRm.Kz().RW();
                        aoVar.aSc = false;
                        this.aRm.q(i, aoVar.aSc);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private Rect K(View view) {
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
    public void Ju() {
        UserData user;
        super.Ju();
        if ((this.aQe instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.aQe).getUser()) != null) {
            com.baidu.tieba.im.e.a(new y(this, user), new z(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.f> Mw;
        com.baidu.tieba.im.data.f fVar;
        UserData user;
        super.onClick(view);
        if (view == this.aQd.getBtnGroupInfo()) {
            if ((this.aQe instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.aQe).getUser()) != null) {
                OfficialBarInfoActivity.startActivity(this, (int) user.getUserIdLong(), user.getUserName());
            }
        } else if (view == this.aRm.KB()) {
            this.aRo = !this.aRo;
            this.aRm.cK(this.aRo);
        } else if (view == this.aRm.KA()[0].aSd || view == this.aRm.KA()[1].aSd || view == this.aRm.KA()[2].aSd) {
            com.baidu.tbadk.core.j.l(this, "service_bt_ck");
            int L = this.aRm.L(view);
            for (int i = 0; i < 3; i++) {
                ao aoVar = this.aRm.KA()[i];
                if (aoVar.aSc && i != L) {
                    this.aRm.Kz().RX();
                    aoVar.aSc = false;
                    this.aRm.q(i, aoVar.aSc);
                }
            }
            com.baidu.tieba.im.data.g officialBarMenuDatas = this.aRn.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (Mw = officialBarMenuDatas.Mw()) != null && L < Mw.size() && (fVar = Mw.get(L)) != null) {
                if (fVar.Ms() == 0) {
                    ao aoVar2 = this.aRm.KA()[L];
                    com.baidu.tieba.im.view.k Kz = this.aRm.Kz();
                    if (aoVar2.aSc) {
                        Kz.RW();
                    } else {
                        Kz.a(3, L, fVar.Mt());
                        Kz.N(view);
                    }
                    aoVar2.aSc = aoVar2.aSc ? false : true;
                    this.aRm.q(L, aoVar2.aSc);
                    return;
                }
                a(fVar);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String v;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.aQe.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    UserData userInfo = msg2.getUserInfo();
                    OfficialBarInfoActivity.startActivity(this, (int) userInfo.getUserIdLong(), userInfo.getUserName());
                    return;
                }
                return;
            case 3:
            default:
                return;
            case 4:
                if (Kj() && (msg = this.aQe.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (v = com.baidu.tieba.im.util.i.v(msg.getContent(), true)) != null && (this.aQe instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.aQe).getUser() != null) {
                    OfficialMsgImageActivity.a(this, v, ((CommonPersonalMsglistModel) this.aQe).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.f fVar) {
        if (fVar.Ms() == 2) {
            this.aRm.cJ(true);
            this.aRn.sendClickMenuMessage(fVar.getId(), TbadkApplication.getCurrentAccount(), this.aRn.getForumId());
        } else if (fVar.Ms() == 1) {
            UtilHelper.commenDealUrl(this, fVar.getContent(), fVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.o
    public void a(int i, com.baidu.tieba.im.data.f fVar) {
        if (fVar != null) {
            a(fVar);
            this.aRm.Kz().RW();
            ao aoVar = this.aRm.KA()[i];
            aoVar.aSc = false;
            this.aRm.q(i, aoVar.aSc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void g(Bundle bundle) {
        super.g(bundle);
        JA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void i(Intent intent) {
        super.i(intent);
        JA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZK = "";
    }

    private void JA() {
        if (this.aQe == null || !(this.aQe instanceof OfficialBarMsglistModel)) {
            ZK = "";
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.aQe).getUser();
        if (user != null) {
            ZK = String.valueOf(user.getUserId());
        } else {
            ZK = "";
        }
    }
}
