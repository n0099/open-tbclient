package com.baidu.tieba.chat;

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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.home.r;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.aa;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.ShutDownValidateTipView;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.j implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.im.messageCenter.g {
    private ShutDownValidateTipView m;
    private DialogInterface.OnClickListener o;
    private LinearLayout p;
    private aj q;
    private r r;
    private int s;
    private ag c = null;
    private Activity d = null;
    private int e = 1;
    private Handler f = null;
    private Runnable g = null;
    private ImMessageCenterShowItemData h = null;
    private int i = 3;
    private BdListView j = null;
    private n k = null;
    private ct l = null;
    private String n = null;
    AlertDialog b = null;
    private boolean t = true;
    private final com.baidu.tieba.im.a<Void> u = new b(this);
    private final View.OnClickListener v = new d(this);
    private final AdapterView.OnItemClickListener w = new e(this);
    private final AdapterView.OnItemLongClickListener x = new g(this);
    private final com.baidu.adp.widget.ListView.b y = new h(this);
    private final AbsListView.OnScrollListener z = new i(this);
    private final com.baidu.tieba.im.messageCenter.g A = new j(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(-140, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-129, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-130, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-136, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-137, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-133, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-135, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-143, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-142, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.A);
        e();
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            g();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = -1;
        this.d = getActivity();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        cb.a(this.d, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i >= 1) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.k.a(true);
            } else if (this.i == 2) {
                this.k.b(true);
            }
            com.baidu.tieba.im.c.j.a().c();
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.k.a(true);
            } else if (this.i == 2) {
                this.k.b(true);
            }
            g();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
    }

    public void a() {
        if (this.d == null) {
            this.d = getActivity();
        }
        if (this.d != null) {
            if (TiebaApplication.B()) {
                if (this.j != null) {
                    this.j.setVisibility(0);
                }
                if (this.p != null) {
                    this.p.setVisibility(8);
                }
                if (this.n == null) {
                    this.n = TiebaApplication.A();
                } else if (!this.n.equals(TiebaApplication.A())) {
                    this.n = TiebaApplication.A();
                    com.baidu.tieba.im.c.a.f().d();
                    this.c.b();
                    com.baidu.adp.lib.util.f.e(" change account");
                }
                if (getParentFragment() != null && !getParentFragment().isHidden()) {
                    b(this.e, 3);
                    this.g.run();
                }
            } else {
                if (this.r == null) {
                    this.r = new r(this.d, this.d.getString(R.string.login_msg_tab), this.d.getString(R.string.login_msg_form), 3);
                    this.p.addView(this.r.e());
                    this.r.b(TiebaApplication.g().al());
                } else {
                    ((ViewGroup) this.r.e().getParent()).removeAllViews();
                    this.p.addView(this.r.e());
                    this.r.b(TiebaApplication.g().al());
                }
                if (this.k.getCount() > 0) {
                    b(false);
                }
                this.j.setVisibility(8);
                this.p.setVisibility(0);
            }
            c(TiebaApplication.g().al());
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.k != null && this.k.a() != null) {
            this.k.a().d();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(this.A);
        super.onDestroy();
    }

    private void e() {
        this.c = new ag();
        c(com.baidu.tieba.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
        c();
    }

    private void a(View view) {
        this.q = new aj(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.m = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.m.setVisibility(8);
        this.m.setShutDownClickListener(new k(this));
        this.p = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.j = (BdListView) view.findViewById(R.id.chat_list_content);
        this.l = new ct(this.d);
        this.l.a(this.y);
        this.j.setPullRefresh(this.l);
        this.k = new n(this.d);
        this.k.a(this);
        this.j.setAdapter((ListAdapter) this.k);
        this.k.a(this.v);
        this.j.setOnItemClickListener(this.w);
        this.j.setOnScrollListener(this.z);
        this.j.setOnItemLongClickListener(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this.d);
        this.k.a().a();
        boolean z = h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG;
        this.k.a().a(z);
        int firstVisiblePosition = this.j.getFirstVisiblePosition();
        int lastVisiblePosition = this.j.getLastVisiblePosition();
        this.k.a().a();
        int i2 = firstVisiblePosition;
        int i3 = 0;
        while (i2 < this.k.getCount()) {
            if (z || i2 <= lastVisiblePosition) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) this.k.getItem(i2);
                if (!(this.k.getItem(i2) instanceof ImMessageCenterShowItemData) || i3 >= 13 || (friendPortrait = ((ImMessageCenterShowItemData) this.k.getItem(i2)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i3;
                } else {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            com.baidu.adp.lib.util.f.e("group head url:" + friendPortrait);
                            this.k.a().b(friendPortrait, this);
                        } else {
                            this.k.a().c(friendPortrait, this);
                        }
                    } else {
                        this.k.a().c(friendPortrait, this);
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

    @Override // com.baidu.tieba.j
    public void c(int i) {
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
                this.r.b(i);
            }
            if (i == 1) {
                if (this.q != null && this.q.c()) {
                    this.j.setDivider(this.d.getResources().getDrawable(17170445));
                } else {
                    this.j.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.night_divider)));
                }
                this.j.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.onedip));
            } else {
                if (this.q != null && this.q.c()) {
                    this.j.setDivider(this.d.getResources().getDrawable(17170445));
                } else {
                    this.j.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.day_divider)));
                }
                this.j.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.onedip));
            }
            if (this.k != null) {
                this.k.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.q.a();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
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
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        try {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(this.d, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0)));
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
        this.o = new l(this, imMessageCenterShowItemData);
        String string = this.d.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.o);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (d() && this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
        } else if (this.m.getVisibility() != 8) {
            this.m.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
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

    public void b(boolean z) {
        com.baidu.adp.lib.util.f.e("is show no data:" + z);
        if (z) {
            this.q.b(0);
        } else {
            this.q.b(8);
        }
        if (isAdded()) {
            if (this.s == 1) {
                if (this.q.c()) {
                    this.j.setDivider(this.d.getResources().getDrawable(17170445));
                } else {
                    this.j.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.night_divider)));
                }
                this.j.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.onedip));
                return;
            }
            if (this.q != null && this.q.c()) {
                this.j.setDivider(this.d.getResources().getDrawable(17170445));
            } else {
                this.j.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.day_divider)));
            }
            this.j.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.onedip));
        }
    }

    public void c() {
        this.f = new Handler();
        this.g = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.c != null) {
            this.c.a(this.u);
        }
    }

    public boolean d() {
        return this.t;
    }

    public void c(boolean z) {
        this.t = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        g();
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        GroupNewsPojo a;
        if (sVar == null || !(sVar instanceof aa) || (a = ((aa) sVar).a()) == null || !a.getGid().equals(SnapGroupChatActivity.m)) {
            g();
        }
    }
}
