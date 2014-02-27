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
import com.baidu.tieba.view.cs;
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
    private cs l = null;
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
        com.baidu.tieba.im.messageCenter.d.a().a(-140, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-129, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-130, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-136, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-137, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-133, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-135, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-141, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-143, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-142, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103104, this.A);
        this.c = new ag();
        this.t = com.baidu.tieba.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true;
        this.f = new Handler();
        this.g = new c(this);
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            b();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = -1;
        this.d = getActivity();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        this.q = new aj(inflate, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.m = (ShutDownValidateTipView) inflate.findViewById(R.id.view_no_validate);
        this.m.setVisibility(8);
        this.m.setShutDownClickListener(new k(this));
        this.p = (LinearLayout) inflate.findViewById(R.id.bodyNotLogin);
        this.j = (BdListView) inflate.findViewById(R.id.chat_list_content);
        this.l = new cs(this.d);
        this.l.a(this.y);
        this.j.setPullRefresh(this.l);
        this.k = new n(this.d);
        this.k.a(this);
        this.j.setAdapter((ListAdapter) this.k);
        n nVar = this.k;
        View.OnClickListener onClickListener = this.v;
        n.a();
        this.j.setOnItemClickListener(this.w);
        this.j.setOnScrollListener(this.z);
        this.j.setOnItemLongClickListener(this.x);
        cb.a(this.d, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, int i, int i2) {
        aVar.e = 1;
        aVar.i = 3;
        if (aVar.i == 1) {
            aVar.k.a(true);
        } else if (aVar.i == 2) {
            aVar.k.b(true);
        }
        com.baidu.tieba.im.c.j.a();
        com.baidu.tieba.im.c.j.c();
        aVar.b();
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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
    }

    public final void a() {
        if (this.d == null) {
            this.d = getActivity();
        }
        if (this.d != null) {
            if (TiebaApplication.w()) {
                if (this.j != null) {
                    this.j.setVisibility(0);
                }
                if (this.p != null) {
                    this.p.setVisibility(8);
                }
                if (this.n == null) {
                    this.n = TiebaApplication.v();
                } else if (!this.n.equals(TiebaApplication.v())) {
                    this.n = TiebaApplication.v();
                    com.baidu.tieba.im.c.a.d().b();
                    this.c.b();
                    com.baidu.adp.lib.util.e.e(" change account");
                }
                if (getParentFragment() != null && !getParentFragment().isHidden()) {
                    a(this.e, 3);
                    this.g.run();
                }
            } else {
                if (this.r == null) {
                    this.r = new r(this.d, this.d.getString(R.string.login_msg_tab), this.d.getString(R.string.login_msg_form), 3);
                    this.p.addView(this.r.a());
                    this.r.a(TiebaApplication.g().ae());
                } else {
                    ((ViewGroup) this.r.a().getParent()).removeAllViews();
                    this.p.addView(this.r.a());
                    this.r.a(TiebaApplication.g().ae());
                }
                if (this.k.getCount() > 0) {
                    b(false);
                }
                this.j.setVisibility(8);
                this.p.setVisibility(0);
            }
            c(TiebaApplication.g().ae());
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.k != null && this.k.b() != null) {
            this.k.b().c();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        com.baidu.tieba.im.messageCenter.d.a().a(this.A);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(a aVar) {
        String friendPortrait;
        int i = 0;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(aVar.d);
        aVar.k.b().a();
        boolean z = h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG;
        aVar.k.b();
        int firstVisiblePosition = aVar.j.getFirstVisiblePosition();
        int lastVisiblePosition = aVar.j.getLastVisiblePosition();
        aVar.k.b().a();
        while (true) {
            int i2 = i;
            int i3 = firstVisiblePosition;
            if (i3 >= aVar.k.getCount()) {
                return;
            }
            if (!z && i3 > lastVisiblePosition) {
                return;
            }
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) aVar.k.getItem(i3);
            if (!(aVar.k.getItem(i3) instanceof ImMessageCenterShowItemData) || i2 >= 13 || (friendPortrait = ((ImMessageCenterShowItemData) aVar.k.getItem(i3)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                i = i2;
            } else {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    aVar.k.b().c(friendPortrait, aVar);
                } else if (ownerName.equals(String.valueOf(1))) {
                    com.baidu.adp.lib.util.e.e("group head url:" + friendPortrait);
                    aVar.k.b().b(friendPortrait, aVar);
                } else {
                    aVar.k.b().c(friendPortrait, aVar);
                }
                i = i2 + 1;
            }
            if (i >= 30) {
                return;
            }
            firstVisiblePosition = i3 + 1;
        }
    }

    @Override // com.baidu.tieba.j
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.o = new l(aVar, imMessageCenterShowItemData);
        String string = aVar.d.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(aVar.d);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, aVar.o);
        aVar.b = builder.create();
        aVar.b.setCanceledOnTouchOutside(true);
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
            com.baidu.adp.lib.util.e.e("imageUrl:" + str);
            ImageView imageView = (ImageView) this.j.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.util.e.e("view found:  imageUrl:" + str);
                bVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.util.e.e("view not found:  imageUrl:" + str);
        }
    }

    public final void b(boolean z) {
        com.baidu.adp.lib.util.e.e("is show no data:" + z);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            this.c.a(this.u);
        }
    }

    public final void c(boolean z) {
        this.t = z;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        GroupNewsPojo a;
        if (sVar == null || !(sVar instanceof aa) || (a = ((aa) sVar).a()) == null || !a.getGid().equals(SnapGroupChatActivity.m)) {
            b();
        }
    }
}
