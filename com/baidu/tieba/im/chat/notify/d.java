package com.baidu.tieba.im.chat.notify;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.core.d implements com.baidu.tbadk.imageManager.d {
    private ShutDownValidateTipView j;
    private DialogInterface.OnClickListener l;
    private LinearLayout m;
    private com.baidu.tbadk.core.view.k n;
    private com.baidu.tbadk.core.view.b o;
    private int p;
    private NoNetworkView q;
    private RelativeLayout t;
    private com.baidu.tieba.im.model.p d = null;
    private FragmentActivity e = null;
    private ImMessageCenterShowItemData f = null;
    private BdListView g = null;
    private u h = null;
    private com.baidu.tbadk.core.view.q i = null;
    private String k = null;
    AlertDialog b = null;
    private boolean r = true;
    private final com.baidu.tieba.im.a<Void> s = new e(this);
    CustomMessageTask c = new CustomMessageTask(2005014, new j(this));
    private final View.OnClickListener u = new k(this);
    private final AdapterView.OnItemClickListener v = new l(this);
    private final AdapterView.OnItemLongClickListener w = new p(this);
    private final com.baidu.adp.widget.ListView.d x = new q(this);
    private final com.baidu.adp.framework.listener.b y = new r(this, 0);
    private final CustomMessageListener z = new s(this, 0);
    private final CustomMessageListener A = new t(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(2001140, this.z);
        MessageManager.getInstance().registerListener(2001129, this.z);
        MessageManager.getInstance().registerListener(2001130, this.z);
        MessageManager.getInstance().registerListener(2001132, this.z);
        MessageManager.getInstance().registerListener(2001136, this.z);
        MessageManager.getInstance().registerListener(2001137, this.z);
        MessageManager.getInstance().registerListener(2001134, this.z);
        MessageManager.getInstance().registerListener(2001133, this.z);
        MessageManager.getInstance().registerListener(2001135, this.z);
        MessageManager.getInstance().registerListener(2001167, this.z);
        MessageManager.getInstance().registerListener(2001141, this.z);
        MessageManager.getInstance().registerListener(2001143, this.z);
        MessageManager.getInstance().registerListener(2001142, this.z);
        MessageManager.getInstance().registerListener(103104, this.y);
        this.c.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.c);
        a(2001178, this.A);
        h();
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            i();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.p = -1;
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
    public void g() {
        com.baidu.tieba.im.pushNotify.q.a().c();
        i();
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
                if (this.g != null) {
                    this.g.setVisibility(0);
                }
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (this.k == null) {
                    this.k = TbadkApplication.getCurrentAccount();
                } else if (!this.k.equals(TbadkApplication.getCurrentAccount())) {
                    this.k = TbadkApplication.getCurrentAccount();
                    com.baidu.tieba.im.pushNotify.a.i().g();
                    this.d.d();
                }
                i();
            } else {
                if (this.o == null) {
                    this.o = new com.baidu.tbadk.core.view.b(this.e, this.e.getString(y.login_msg_tab), this.e.getString(y.login_msg_form), 3);
                    this.m.addView(this.o.b());
                    this.o.b(TbadkApplication.m252getInst().getSkinType());
                } else {
                    ((ViewGroup) this.o.b().getParent()).removeAllViews();
                    this.m.addView(this.o.b());
                    this.o.b(TbadkApplication.m252getInst().getSkinType());
                }
                if (this.h.getCount() > 0) {
                    c(false);
                }
                this.g.setVisibility(8);
                this.m.setVisibility(0);
            }
            c(TbadkApplication.m252getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.im.i.a(new f(this), null);
        MessageManager.getInstance().unRegisterListener(this.z);
        MessageManager.getInstance().unRegisterListener(this.y);
        MessageManager.getInstance().unRegisterTask(2005014);
        super.onDestroy();
    }

    private void h() {
        this.d = new com.baidu.tieba.im.model.p();
        d(com.baidu.tbadk.core.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
    }

    private void a(View view) {
        this.t = (RelativeLayout) view.findViewById(com.baidu.tieba.v.chat_list);
        this.n = new com.baidu.tbadk.core.view.k(view, com.baidu.tieba.u.individual_center_news, com.baidu.tieba.u.individual_center_news_1, com.baidu.tieba.v.no_data_container, com.baidu.tieba.v.no_data_image, com.baidu.tieba.v.no_data_image_text);
        this.j = (ShutDownValidateTipView) view.findViewById(com.baidu.tieba.v.view_no_validate);
        this.j.setVisibility(8);
        this.j.setShutDownClickListener(new g(this));
        this.m = (LinearLayout) view.findViewById(com.baidu.tieba.v.bodyNotLogin);
        this.g = (BdListView) view.findViewById(com.baidu.tieba.v.chat_list_content);
        this.g.setDividerHeight(0);
        this.i = new com.baidu.tbadk.core.view.q(this.e);
        this.i.a(this.x);
        this.g.setPullRefresh(this.i);
        this.h = new u(this.e);
        this.h.a(this);
        this.g.setAdapter((ListAdapter) this.h);
        this.h.a(this.u);
        this.g.setOnItemClickListener(this.v);
        this.g.setOnItemLongClickListener(this.w);
        this.g.e();
        this.q = (NoNetworkView) this.t.findViewById(com.baidu.tieba.v.view_no_network);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        if (isAdded() && this.p != i) {
            this.p = i;
            if (this.n != null) {
                this.n.a(i);
            }
            if (this.j != null) {
                this.j.a(i);
            }
            if (this.i != null) {
                this.i.a(i);
            }
            if (this.o != null) {
                this.o.b(i);
            }
            if (this.h != null) {
                this.h.notifyDataSetChanged();
            }
            if (this.e != null && (this.e instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.e).c().a(i == 1);
                ((BaseFragmentActivity) this.e).c().a((View) this.t);
            }
            if (this.q != null) {
                this.q.a(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.n.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.n.b();
        if (this.o != null) {
            this.o.d();
        }
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bc(this.e, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0)));
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
        this.l = new h(this, imMessageCenterShowItemData);
        String string = this.e.getString(y.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.e);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, this.l);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (f() && this.j.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
        } else if (this.j.getVisibility() != 8) {
            this.j.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && this.g != null && (imageView = (ImageView) this.g.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public void c(boolean z) {
        if (z) {
            this.n.b(0);
        } else {
            this.n.b(8);
        }
        if (!isAdded()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.d != null) {
            if (com.baidu.tieba.im.b.e.a.get()) {
                this.d.a(this.s);
                return;
            }
            this.d.d();
            this.h.a(this.d.c());
        }
    }

    public boolean f() {
        return this.r;
    }

    public void d(boolean z) {
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        i();
    }
}
