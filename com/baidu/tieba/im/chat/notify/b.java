package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
    private ShutDownValidateTipView l;
    private DialogInterface.OnClickListener n;
    private LinearLayout o;
    private com.baidu.tbadk.core.view.k p;
    private com.baidu.tbadk.core.view.b q;
    private int r;
    private com.baidu.tieba.im.model.p b = null;
    private Activity c = null;
    private int d = 1;
    private Handler e = null;
    private Runnable f = null;
    private ImMessageCenterShowItemData g = null;
    private int h = 3;
    private BdListView i = null;
    private p j = null;
    private com.baidu.tbadk.core.view.q k = null;
    private String m = null;
    AlertDialog a = null;
    private boolean s = true;
    private final com.baidu.tieba.im.a<Void> t = new c(this);
    private final View.OnClickListener u = new g(this);
    private final AdapterView.OnItemClickListener v = new h(this);
    private final AdapterView.OnItemLongClickListener w = new j(this);
    private final com.baidu.adp.widget.ListView.d x = new k(this);
    private final AbsListView.OnScrollListener y = new l(this);
    private final com.baidu.adp.framework.c.g z = new m(this, 0);
    private final com.baidu.adp.framework.c.a A = new n(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.framework.c.a().a(2001140, this.A);
        com.baidu.adp.framework.c.a().a(2001129, this.A);
        com.baidu.adp.framework.c.a().a(2001130, this.A);
        com.baidu.adp.framework.c.a().a(2001132, this.A);
        com.baidu.adp.framework.c.a().a(2001136, this.A);
        com.baidu.adp.framework.c.a().a(2001137, this.A);
        com.baidu.adp.framework.c.a().a(2001134, this.A);
        com.baidu.adp.framework.c.a().a(2001133, this.A);
        com.baidu.adp.framework.c.a().a(2001135, this.A);
        com.baidu.adp.framework.c.a().a(2001141, this.A);
        com.baidu.adp.framework.c.a().a(2001143, this.A);
        com.baidu.adp.framework.c.a().a(2001142, this.A);
        com.baidu.adp.framework.c.a().a(103104, this.z);
        this.b = new com.baidu.tieba.im.model.p();
        this.s = com.baidu.tbadk.core.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true;
        this.e = new Handler();
        this.f = new f(this);
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
        this.r = -1;
        this.c = getActivity();
        View inflate = layoutInflater.inflate(com.baidu.tieba.im.i.chat_list_activity, viewGroup, false);
        this.p = new com.baidu.tbadk.core.view.k(inflate, com.baidu.tieba.im.g.individual_center_news, com.baidu.tieba.im.g.individual_center_news_1, com.baidu.tieba.im.h.no_data_container, com.baidu.tieba.im.h.no_data_image, com.baidu.tieba.im.h.no_data_image_text);
        this.l = (ShutDownValidateTipView) inflate.findViewById(com.baidu.tieba.im.h.view_no_validate);
        this.l.setVisibility(8);
        this.l.setShutDownClickListener(new o(this));
        this.o = (LinearLayout) inflate.findViewById(com.baidu.tieba.im.h.bodyNotLogin);
        this.i = (BdListView) inflate.findViewById(com.baidu.tieba.im.h.chat_list_content);
        this.k = new com.baidu.tbadk.core.view.q(this.c);
        this.k.a(this.x);
        this.i.setPullRefresh(this.k);
        this.j = new p(this.c);
        this.j.a(this);
        this.i.setAdapter((ListAdapter) this.j);
        p pVar = this.j;
        View.OnClickListener onClickListener = this.u;
        p.a();
        this.i.setOnItemClickListener(this.v);
        this.i.setOnScrollListener(this.y);
        this.i.setOnItemLongClickListener(this.w);
        TiebaStatic.a(this.c, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, int i, int i2) {
        bVar.d = 1;
        bVar.h = 3;
        if (bVar.h == 1) {
            bVar.j.a(true);
        } else if (bVar.h == 2) {
            bVar.j.b(true);
        }
        com.baidu.tieba.im.pushNotify.o.a();
        com.baidu.tieba.im.pushNotify.o.c();
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i > 0) {
            this.d = i;
            this.h = i2;
            if (this.h == 1) {
                this.j.a(true);
            } else if (this.h == 2) {
                this.j.b(true);
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
        if (this.c == null) {
            this.c = getActivity();
        }
        if (this.c != null) {
            if (TbadkApplication.F()) {
                if (this.i != null) {
                    this.i.setVisibility(0);
                }
                if (this.o != null) {
                    this.o.setVisibility(8);
                }
                if (this.m == null) {
                    this.m = TbadkApplication.E();
                } else if (!this.m.equals(TbadkApplication.E())) {
                    this.m = TbadkApplication.E();
                    com.baidu.tieba.im.pushNotify.a.d().b();
                    this.b.b();
                    com.baidu.adp.lib.util.f.e(" change account");
                }
                if (getParentFragment() != null && !getParentFragment().isHidden()) {
                    a(this.d, 3);
                    this.f.run();
                }
            } else {
                if (this.q == null) {
                    this.q = new com.baidu.tbadk.core.view.b(this.c, this.c.getString(com.baidu.tieba.im.j.login_msg_tab), this.c.getString(com.baidu.tieba.im.j.login_msg_form), 3);
                    this.o.addView(this.q.a());
                    this.q.a(TbadkApplication.j().l());
                } else {
                    ((ViewGroup) this.q.a().getParent()).removeAllViews();
                    this.o.addView(this.q.a());
                    this.q.a(TbadkApplication.j().l());
                }
                if (this.j.getCount() > 0) {
                    b(false);
                }
                this.i.setVisibility(8);
                this.o.setVisibility(0);
            }
            onChangeSkinType(TbadkApplication.j().l());
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.j != null && this.j.b() != null) {
            this.j.b().c();
        }
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        com.baidu.adp.framework.c.a().b(this.A);
        com.baidu.adp.framework.c.a().b(this.z);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(b bVar) {
        String friendPortrait;
        int i = 0;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(bVar.c);
        bVar.j.b().a();
        boolean z = d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG;
        bVar.j.b();
        int firstVisiblePosition = bVar.i.getFirstVisiblePosition();
        int lastVisiblePosition = bVar.i.getLastVisiblePosition();
        bVar.j.b().a();
        while (true) {
            int i2 = i;
            int i3 = firstVisiblePosition;
            if (i3 >= bVar.j.getCount()) {
                return;
            }
            if (!z && i3 > lastVisiblePosition) {
                return;
            }
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) bVar.j.getItem(i3);
            if (!(bVar.j.getItem(i3) instanceof ImMessageCenterShowItemData) || i2 >= 13 || (friendPortrait = ((ImMessageCenterShowItemData) bVar.j.getItem(i3)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                i = i2;
            } else {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    bVar.j.b().c(friendPortrait, bVar);
                } else if (ownerName.equals(String.valueOf(1))) {
                    com.baidu.adp.lib.util.f.e("group head url:" + friendPortrait);
                    bVar.j.b().b(friendPortrait, bVar);
                } else {
                    bVar.j.b().c(friendPortrait, bVar);
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
    public void onChangeSkinType(int i) {
        if (isAdded() && this.r != i) {
            this.r = i;
            if (this.p != null) {
                this.p.a(i);
            }
            if (this.l != null) {
                this.l.a(i);
            }
            if (this.k != null) {
                this.k.a(i);
            }
            if (this.q != null) {
                this.q.a(i);
            }
            if (i == 1) {
                if (this.p != null && this.p.c()) {
                    this.i.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.im.e.night_divider)));
                }
                this.i.setDividerHeight(getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
            } else {
                if (this.p != null && this.p.c()) {
                    this.i.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.im.e.day_divider)));
                }
                this.i.setDividerHeight(getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
            }
            if (this.j != null) {
                this.j.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.p.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.p.b();
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
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new ah(this.c, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0)));
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
        bVar.n = new d(bVar, imMessageCenterShowItemData);
        String string = bVar.c.getString(com.baidu.tieba.im.j.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(bVar.c);
        builder.setTitle(com.baidu.tieba.im.j.operation);
        builder.setItems(new String[]{string}, bVar.n);
        bVar.a = builder.create();
        bVar.a.setCanceledOnTouchOutside(true);
    }

    public final void a(boolean z) {
        if (z) {
            if (this.s && this.l.getVisibility() != 0) {
                this.l.setVisibility(0);
            }
        } else if (this.l.getVisibility() != 8) {
            this.l.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && this.i != null) {
            com.baidu.adp.lib.util.f.e("imageUrl:" + str);
            ImageView imageView = (ImageView) this.i.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.util.f.e("view found:  imageUrl:" + str);
                bVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.util.f.e("view not found:  imageUrl:" + str);
        }
    }

    public final void b(boolean z) {
        com.baidu.adp.lib.util.f.e("is show no data:" + z);
        if (z) {
            this.p.b(0);
        } else {
            this.p.b(8);
        }
        if (isAdded()) {
            if (this.r == 1) {
                if (this.p.c()) {
                    this.i.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.im.e.night_divider)));
                }
                this.i.setDividerHeight(getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
                return;
            }
            if (this.p != null && this.p.c()) {
                this.i.setDivider(this.c.getResources().getDrawable(17170445));
            } else {
                this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.im.e.day_divider)));
            }
            this.i.setDividerHeight(getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            this.b.a(this.t);
        }
    }

    public final void c(boolean z) {
        this.s = z;
    }
}
