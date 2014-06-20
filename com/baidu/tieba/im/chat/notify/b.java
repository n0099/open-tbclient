package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.d implements com.baidu.tbadk.imageManager.d {
    private ShutDownValidateTipView n;
    private DialogInterface.OnClickListener p;
    private LinearLayout q;
    private com.baidu.tbadk.core.view.k r;
    private com.baidu.tbadk.core.view.b s;
    private int t;
    private com.baidu.tieba.im.model.r d = null;
    private Activity e = null;
    private int f = 1;
    private Handler g = null;
    private Runnable h = null;
    private ImMessageCenterShowItemData i = null;
    private int j = 3;
    private BdListView k = null;
    private s l = null;
    private com.baidu.tbadk.core.view.q m = null;
    private String o = null;
    AlertDialog b = null;
    private boolean u = true;
    private final com.baidu.tieba.im.a<Void> v = new c(this);
    CustomMessageTask c = new CustomMessageTask(2007014, new i(this));
    private final View.OnClickListener w = new j(this);
    private final AdapterView.OnItemClickListener x = new k(this);
    private final AdapterView.OnItemLongClickListener y = new n(this);
    private final com.baidu.adp.widget.ListView.d z = new o(this);
    private final AbsListView.OnScrollListener A = new p(this);
    private final com.baidu.adp.framework.listener.b B = new q(this, 0);
    private final CustomMessageListener C = new r(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_MSG_ARRIVED, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LIVE_NOTIFY_LOCAL, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.C);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.B);
        this.c.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.c);
        h();
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            j();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.t = -1;
        this.e = getActivity();
        View inflate = layoutInflater.inflate(w.chat_list_activity, viewGroup, false);
        a(inflate);
        TiebaStatic.eventStat(this.e, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i >= 1) {
            this.f = i;
            this.j = i2;
            if (this.j == 1) {
                this.l.a(true);
            } else if (this.j == 2) {
                this.l.b(true);
            }
            com.baidu.tieba.im.pushNotify.p.a().c();
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.f = i;
            this.j = i2;
            if (this.j == 1) {
                this.l.a(true);
            } else if (this.j == 2) {
                this.l.b(true);
            }
            j();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
    }

    public void a() {
        if (this.e == null) {
            this.e = getActivity();
        }
        if (this.e != null) {
            if (TbadkApplication.isLogin()) {
                if (this.k != null) {
                    this.k.setVisibility(0);
                }
                if (this.q != null) {
                    this.q.setVisibility(8);
                }
                if (this.o == null) {
                    this.o = TbadkApplication.getCurrentAccount();
                } else if (!this.o.equals(TbadkApplication.getCurrentAccount())) {
                    this.o = TbadkApplication.getCurrentAccount();
                    com.baidu.tieba.im.pushNotify.a.f().d();
                    this.d.c();
                    BdLog.d(" change account");
                }
                if (getParentFragment() != null && !getParentFragment().isHidden()) {
                    b(this.f, 3);
                    this.h.run();
                }
            } else {
                if (this.s == null) {
                    this.s = new com.baidu.tbadk.core.view.b(this.e, this.e.getString(y.login_msg_tab), this.e.getString(y.login_msg_form), 3);
                    this.q.addView(this.s.b());
                    this.s.b(TbadkApplication.m252getInst().getSkinType());
                } else {
                    ((ViewGroup) this.s.b().getParent()).removeAllViews();
                    this.q.addView(this.s.b());
                    this.s.b(TbadkApplication.m252getInst().getSkinType());
                }
                if (this.l.getCount() > 0) {
                    c(false);
                }
                this.k.setVisibility(8);
                this.q.setVisibility(0);
            }
            c(TbadkApplication.m252getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.im.i.a(new d(this), null);
        if (this.l != null && this.l.a() != null) {
            this.l.a().d();
        }
        if (this.g != null) {
            this.g.removeCallbacks(this.h);
        }
        MessageManager.getInstance().unRegisterListener(this.C);
        MessageManager.getInstance().unRegisterListener(this.B);
        MessageManager.getInstance().unRegisterTask(2007014);
        super.onDestroy();
    }

    private void h() {
        this.d = new com.baidu.tieba.im.model.r();
        d(com.baidu.tbadk.core.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
        f();
    }

    private void a(View view) {
        this.r = new com.baidu.tbadk.core.view.k(view, u.individual_center_news, u.individual_center_news_1, v.no_data_container, v.no_data_image, v.no_data_image_text);
        this.n = (ShutDownValidateTipView) view.findViewById(v.view_no_validate);
        this.n.setVisibility(8);
        this.n.setShutDownClickListener(new e(this));
        this.q = (LinearLayout) view.findViewById(v.bodyNotLogin);
        this.k = (BdListView) view.findViewById(v.chat_list_content);
        this.k.setDividerHeight(0);
        this.m = new com.baidu.tbadk.core.view.q(this.e);
        this.m.a(this.z);
        this.k.setPullRefresh(this.m);
        this.l = new s(this.e);
        this.l.a(this);
        this.k.setAdapter((ListAdapter) this.l);
        this.l.a(this.w);
        this.k.setOnItemClickListener(this.x);
        this.k.setOnScrollListener(this.A);
        this.k.setOnItemLongClickListener(this.y);
        this.k.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.e);
        this.l.a().a();
        boolean z = netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG;
        this.l.a().a(z);
        int firstVisiblePosition = this.k.getFirstVisiblePosition();
        int lastVisiblePosition = this.k.getLastVisiblePosition();
        this.l.a().a();
        int i2 = firstVisiblePosition;
        int i3 = 0;
        while (i2 < this.l.getCount()) {
            if (z || i2 <= lastVisiblePosition) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) this.l.getItem(i2);
                if (!(this.l.getItem(i2) instanceof ImMessageCenterShowItemData) || i3 >= 13 || (friendPortrait = ((ImMessageCenterShowItemData) this.l.getItem(i2)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i3;
                } else {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            BdLog.d("group head url:" + friendPortrait);
                            this.l.a().b(friendPortrait, this);
                        } else {
                            this.l.a().c(friendPortrait, this);
                        }
                    } else {
                        this.l.a().c(friendPortrait, this);
                    }
                    i = i3 + 1;
                }
                if (i < 30) {
                    i2++;
                    i3 = i;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        if (isAdded() && this.t != i) {
            this.t = i;
            if (this.r != null) {
                this.r.a(i);
            }
            if (this.n != null) {
                this.n.a(i);
            }
            if (this.m != null) {
                this.m.a(i);
            }
            if (this.s != null) {
                this.s.b(i);
            }
            if (this.l != null) {
                this.l.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.r.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.r.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                    String stringExtra2 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                    String stringExtra3 = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    if (stringExtra2 != null && stringExtra != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003005, new at(this.e, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0)));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.p = new f(this, imMessageCenterShowItemData);
        String string = this.e.getString(y.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.e);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, this.p);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (g() && this.n.getVisibility() != 0) {
                this.n.setVisibility(0);
            }
        } else if (this.n.getVisibility() != 8) {
            this.n.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && this.k != null) {
            BdLog.d("imageUrl:" + str);
            ImageView imageView = (ImageView) this.k.findViewWithTag(str);
            if (imageView != null) {
                BdLog.d("view found:  imageUrl:" + str);
                aVar.a(imageView);
                imageView.invalidate();
                return;
            }
            BdLog.d("view not found:  imageUrl:" + str);
        }
    }

    public void c(boolean z) {
        BdLog.d("is show no data:" + z);
        if (z) {
            this.r.b(0);
        } else {
            this.r.b(8);
        }
        if (!isAdded()) {
        }
    }

    public void f() {
        this.g = new Handler();
        this.h = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.d != null) {
            this.d.a(this.v);
        }
    }

    public boolean g() {
        return this.u;
    }

    public void d(boolean z) {
        this.u = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        j();
    }
}
