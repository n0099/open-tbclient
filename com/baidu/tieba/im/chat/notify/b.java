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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.d implements com.baidu.tbadk.imageManager.d {
    private ShutDownValidateTipView m;
    private DialogInterface.OnClickListener o;
    private LinearLayout p;
    private com.baidu.tbadk.core.view.k q;
    private com.baidu.tbadk.core.view.b r;
    private int s;
    private com.baidu.tieba.im.model.p c = null;
    private Activity d = null;
    private int e = 1;
    private Handler f = null;
    private Runnable g = null;
    private ImMessageCenterShowItemData h = null;
    private int i = 3;
    private BdListView j = null;
    private q k = null;
    private com.baidu.tbadk.core.view.q l = null;
    private String n = null;
    AlertDialog b = null;
    private boolean t = true;
    private final com.baidu.tieba.im.a<Void> u = new c(this);
    private final View.OnClickListener v = new g(this);
    private final AdapterView.OnItemClickListener w = new h(this);
    private final AdapterView.OnItemLongClickListener x = new k(this);
    private final com.baidu.adp.widget.ListView.d y = new l(this);
    private final AbsListView.OnScrollListener z = new m(this);
    private final com.baidu.adp.framework.c.g A = new n(this, 0);
    private final com.baidu.adp.framework.c.a B = new o(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.framework.c.a().a(2001140, this.B);
        com.baidu.adp.framework.c.a().a(2001129, this.B);
        com.baidu.adp.framework.c.a().a(2001130, this.B);
        com.baidu.adp.framework.c.a().a(2001132, this.B);
        com.baidu.adp.framework.c.a().a(2001136, this.B);
        com.baidu.adp.framework.c.a().a(2001137, this.B);
        com.baidu.adp.framework.c.a().a(2001134, this.B);
        com.baidu.adp.framework.c.a().a(2001133, this.B);
        com.baidu.adp.framework.c.a().a(2001135, this.B);
        com.baidu.adp.framework.c.a().a(2001141, this.B);
        com.baidu.adp.framework.c.a().a(2001143, this.B);
        com.baidu.adp.framework.c.a().a(2001142, this.B);
        com.baidu.adp.framework.c.a().a(103104, this.A);
        this.c = new com.baidu.tieba.im.model.p();
        this.t = com.baidu.tbadk.core.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true;
        this.f = new Handler();
        this.g = new f(this);
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = -1;
        this.d = getActivity();
        View inflate = layoutInflater.inflate(com.baidu.tieba.im.i.chat_list_activity, viewGroup, false);
        this.q = new com.baidu.tbadk.core.view.k(inflate, com.baidu.tieba.im.g.individual_center_news, com.baidu.tieba.im.g.individual_center_news_1, com.baidu.tieba.im.h.no_data_container, com.baidu.tieba.im.h.no_data_image, com.baidu.tieba.im.h.no_data_image_text);
        this.m = (ShutDownValidateTipView) inflate.findViewById(com.baidu.tieba.im.h.view_no_validate);
        this.m.setVisibility(8);
        this.m.setShutDownClickListener(new p(this));
        this.p = (LinearLayout) inflate.findViewById(com.baidu.tieba.im.h.bodyNotLogin);
        this.j = (BdListView) inflate.findViewById(com.baidu.tieba.im.h.chat_list_content);
        this.j.setDividerHeight(0);
        this.l = new com.baidu.tbadk.core.view.q(this.d);
        this.l.a(this.y);
        this.j.setPullRefresh(this.l);
        this.k = new q(this.d);
        this.k.a(this);
        this.j.setAdapter((ListAdapter) this.k);
        q qVar = this.k;
        View.OnClickListener onClickListener = this.v;
        q.a();
        this.j.setOnItemClickListener(this.w);
        this.j.setOnScrollListener(this.z);
        this.j.setOnItemLongClickListener(this.x);
        TiebaStatic.a(this.d, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, int i, int i2) {
        bVar.e = 1;
        bVar.i = 3;
        if (bVar.i == 1) {
            bVar.k.a(true);
        } else if (bVar.i == 2) {
            bVar.k.b(true);
        }
        com.baidu.tieba.im.pushNotify.o.a();
        com.baidu.tieba.im.pushNotify.o.c();
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i > 0) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.k.a(true);
            } else if (this.i == 2) {
                this.k.b(true);
            }
            b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
    }

    public final void a() {
        if (this.d == null) {
            this.d = getActivity();
        }
        if (this.d != null) {
            if (TbadkApplication.F()) {
                if (this.j != null) {
                    this.j.setVisibility(0);
                }
                if (this.p != null) {
                    this.p.setVisibility(8);
                }
                if (this.n == null) {
                    this.n = TbadkApplication.E();
                } else if (!this.n.equals(TbadkApplication.E())) {
                    this.n = TbadkApplication.E();
                    com.baidu.tieba.im.pushNotify.a.d().b();
                    this.c.c();
                    com.baidu.adp.lib.util.f.e(" change account");
                }
                if (getParentFragment() != null && !getParentFragment().isHidden()) {
                    a(this.e, 3);
                    this.g.run();
                }
            } else {
                if (this.r == null) {
                    this.r = new com.baidu.tbadk.core.view.b(this.d, this.d.getString(com.baidu.tieba.im.j.login_msg_tab), this.d.getString(com.baidu.tieba.im.j.login_msg_form), 3);
                    this.p.addView(this.r.a());
                    this.r.a(TbadkApplication.j().l());
                } else {
                    ((ViewGroup) this.r.a().getParent()).removeAllViews();
                    this.p.addView(this.r.a());
                    this.r.a(TbadkApplication.j().l());
                }
                if (this.k.getCount() > 0) {
                    c(false);
                }
                this.j.setVisibility(8);
                this.p.setVisibility(0);
            }
            c(TbadkApplication.j().l());
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.k != null && this.k.b() != null) {
            this.k.b().c();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        com.baidu.adp.framework.c.a().b(this.B);
        com.baidu.adp.framework.c.a().b(this.A);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(b bVar) {
        String friendPortrait;
        int i = 0;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(bVar.d);
        bVar.k.b().a();
        boolean z = d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG;
        bVar.k.b();
        int firstVisiblePosition = bVar.j.getFirstVisiblePosition();
        int lastVisiblePosition = bVar.j.getLastVisiblePosition();
        bVar.k.b().a();
        while (true) {
            int i2 = i;
            int i3 = firstVisiblePosition;
            if (i3 >= bVar.k.getCount()) {
                return;
            }
            if (!z && i3 > lastVisiblePosition) {
                return;
            }
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) bVar.k.getItem(i3);
            if (!(bVar.k.getItem(i3) instanceof ImMessageCenterShowItemData) || i2 >= 13 || (friendPortrait = ((ImMessageCenterShowItemData) bVar.k.getItem(i3)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                i = i2;
            } else {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    bVar.k.b().c(friendPortrait, bVar);
                } else if (ownerName.equals(String.valueOf(1))) {
                    com.baidu.adp.lib.util.f.e("group head url:" + friendPortrait);
                    bVar.k.b().b(friendPortrait, bVar);
                } else {
                    bVar.k.b().c(friendPortrait, bVar);
                }
                i = i2 + 1;
            }
            if (i >= 30) {
                return;
            }
            firstVisiblePosition = i3 + 1;
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        if (isAdded() && this.s != i) {
            this.s = i;
            if (this.q != null) {
                this.q.a(i);
            }
            if (this.m != null) {
                this.m.a(i);
            }
            if (this.l != null) {
                this.l.a(i);
            }
            if (this.r != null) {
                this.r.a(i);
            }
            if (this.k != null) {
                this.k.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.q.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.q.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra("user_id");
                    String stringExtra2 = intent.getStringExtra("user_name");
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        try {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new ah(this.d, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0)));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        bVar.o = new d(bVar, imMessageCenterShowItemData);
        String string = bVar.d.getString(com.baidu.tieba.im.j.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(bVar.d);
        builder.setTitle(com.baidu.tieba.im.j.operation);
        builder.setItems(new String[]{string}, bVar.o);
        bVar.b = builder.create();
        bVar.b.setCanceledOnTouchOutside(true);
    }

    public final void a(boolean z) {
        if (z) {
            if (this.t && this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
        } else if (this.m.getVisibility() != 8) {
            this.m.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && this.j != null) {
            com.baidu.adp.lib.util.f.e("imageUrl:" + str);
            ImageView imageView = (ImageView) this.j.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.util.f.e("view found:  imageUrl:" + str);
                bVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.util.f.e("view not found:  imageUrl:" + str);
        }
    }

    public final void c(boolean z) {
        com.baidu.adp.lib.util.f.e("is show no data:" + z);
        if (z) {
            this.q.b(0);
        } else {
            this.q.b(8);
        }
        if (!isAdded()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            this.c.a(this.u);
        }
    }

    public final void d(boolean z) {
        this.t = z;
    }
}
