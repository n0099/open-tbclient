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
    public static String ZG = "";
    public static boolean aOc;
    private OfficialBarMsglistView aQY;
    private OfficialBarMsglistModel aQZ;
    private boolean aRa;
    private final com.baidu.adp.framework.listener.e aRb = new t(this, 303006);
    private final com.baidu.adp.framework.listener.e aRc = new u(this, 208003);
    private final CustomMessageListener aRd = new v(this, 2001181);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aQY.cJ(true);
        this.aQZ.sendGetMenuLocalMessage(this.aQZ.getForumId());
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean h(Bundle bundle) {
        try {
            this.aPQ = new OfficialBarMsglistModel(this);
            this.aPQ.setLoadDataCallBack(this.aQa);
            this.aQZ = (OfficialBarMsglistModel) this.aPQ;
            if (bundle != null) {
                f(bundle);
            } else {
                Jr();
            }
            if (Js()) {
                this.aRa = true;
                registerListener(this.aRb);
                registerListener(this.aRc);
                registerListener(this.aRd);
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
        this.aPP = new OfficialBarMsglistView(this, this.aPQ.getIsAcceptNotify());
        this.aQY = (OfficialBarMsglistView) this.aPP;
        this.aPP.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        int i = com.baidu.tieba.im.chat.w.aNF;
        if ((this.aPQ instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.aPQ).getUser()) != null) {
            String str = "";
            if (!TextUtils.isEmpty(user.getUserName())) {
                str = user.getUserName();
            }
            this.aPP.refreshHeaderFooter(String.valueOf(str) + getString(com.baidu.tieba.y.bar), false);
            this.aPP.bindDataAndRefresh(this.aPQ.getData(), i);
            this.aPP.setRecordCallback(new w(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        this.aPQ.loadFirst(btVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aOc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aOc = true;
        if (!TextUtils.isEmpty(ZG)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oB().oH();
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(ZG, 4)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (K(this.aQY.getListMain()).contains(rawX, rawY)) {
            com.baidu.tieba.im.view.k Kv = this.aQY.Kv();
            if (Kv.isShown() && !K(Kv).contains(rawX, rawY)) {
                for (int i = 0; i < 3; i++) {
                    ao aoVar = this.aQY.Kw()[i];
                    if (aoVar.aRO) {
                        this.aQY.Kv().RT();
                        aoVar.aRO = false;
                        this.aQY.q(i, aoVar.aRO);
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
    public void Jq() {
        UserData user;
        super.Jq();
        if ((this.aPQ instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.aPQ).getUser()) != null) {
            com.baidu.tieba.im.e.a(new y(this, user), new z(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        List<com.baidu.tieba.im.data.f> Ms;
        com.baidu.tieba.im.data.f fVar;
        UserData user;
        super.onClick(view);
        if (view == this.aPP.getBtnGroupInfo()) {
            if ((this.aPQ instanceof OfficialBarMsglistModel) && (user = ((OfficialBarMsglistModel) this.aPQ).getUser()) != null) {
                OfficialBarInfoActivity.startActivity(this, (int) user.getUserIdLong(), user.getUserName());
            }
        } else if (view == this.aQY.Kx()) {
            this.aRa = !this.aRa;
            this.aQY.cK(this.aRa);
        } else if (view == this.aQY.Kw()[0].aRP || view == this.aQY.Kw()[1].aRP || view == this.aQY.Kw()[2].aRP) {
            com.baidu.tbadk.core.i.l(this, "service_bt_ck");
            int L = this.aQY.L(view);
            for (int i = 0; i < 3; i++) {
                ao aoVar = this.aQY.Kw()[i];
                if (aoVar.aRO && i != L) {
                    this.aQY.Kv().RU();
                    aoVar.aRO = false;
                    this.aQY.q(i, aoVar.aRO);
                }
            }
            com.baidu.tieba.im.data.g officialBarMenuDatas = this.aQZ.getOfficialBarMenuDatas();
            if (officialBarMenuDatas != null && (Ms = officialBarMenuDatas.Ms()) != null && L < Ms.size() && (fVar = Ms.get(L)) != null) {
                if (fVar.Mo() == 0) {
                    ao aoVar2 = this.aQY.Kw()[L];
                    com.baidu.tieba.im.view.k Kv = this.aQY.Kv();
                    if (aoVar2.aRO) {
                        Kv.RT();
                    } else {
                        Kv.a(3, L, fVar.Mp());
                        Kv.N(view);
                    }
                    aoVar2.aRO = aoVar2.aRO ? false : true;
                    this.aQY.q(L, aoVar2.aRO);
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
                ChatMessage msg2 = this.aPQ.getMsg(i2);
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
                if (Kf() && (msg = this.aPQ.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (v = com.baidu.tieba.im.util.i.v(msg.getContent(), true)) != null && (this.aPQ instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.aPQ).getUser() != null) {
                    OfficialMsgImageActivity.a(this, v, ((CommonPersonalMsglistModel) this.aPQ).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()));
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.im.data.f fVar) {
        if (fVar.Mo() == 2) {
            this.aQY.cJ(true);
            this.aQZ.sendClickMenuMessage(fVar.getId(), TbadkApplication.getCurrentAccount(), this.aQZ.getForumId());
        } else if (fVar.Mo() == 1) {
            UtilHelper.commenDealUrl(this, fVar.getContent(), fVar.getName());
        }
    }

    @Override // com.baidu.tieba.im.view.o
    public void a(int i, com.baidu.tieba.im.data.f fVar) {
        if (fVar != null) {
            a(fVar);
            this.aQY.Kv().RT();
            ao aoVar = this.aQY.Kw()[i];
            aoVar.aRO = false;
            this.aQY.q(i, aoVar.aRO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void g(Bundle bundle) {
        super.g(bundle);
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void i(Intent intent) {
        super.i(intent);
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZG = "";
    }

    private void Jw() {
        if (this.aPQ == null || !(this.aPQ instanceof OfficialBarMsglistModel)) {
            ZG = "";
            return;
        }
        UserData user = ((OfficialBarMsglistModel) this.aPQ).getUser();
        if (user != null) {
            ZG = String.valueOf(user.getUserId());
        } else {
            ZG = "";
        }
    }
}
