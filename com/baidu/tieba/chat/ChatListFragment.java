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
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.at;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
import com.baidu.tieba.view.ShutDownValidateTipView;
import com.baidu.tieba.view.cm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ChatListFragment extends BaseFragment implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.im.c.l {
    private ShutDownValidateTipView aa;
    private DialogInterface.OnClickListener ac;
    private LinearLayout ad;
    private at ae;
    private com.baidu.tieba.home.o af;
    private int ag;
    private com.baidu.tieba.model.i b = null;
    private Activity c = null;
    private int d = 1;
    private Handler e = null;
    private Runnable f = null;
    private RecentChatFriendData g = null;
    private int h = 3;
    private BdListView i = null;
    private a Y = null;
    private cm Z = null;
    private String ab = null;
    AlertDialog a = null;
    private boolean ah = true;
    private com.baidu.tieba.im.a<Void> ai = new d(this);
    private View.OnClickListener aj = new g(this);
    private AdapterView.OnItemClickListener ak = new h(this);
    private AdapterView.OnItemLongClickListener al = new j(this);
    private com.baidu.adp.widget.ListView.b am = new m(this);
    private AbsListView.OnScrollListener an = new n(this);
    private com.baidu.tieba.im.messageCenter.g ao = new e(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int f(ChatListFragment chatListFragment) {
        int i = chatListFragment.d;
        chatListFragment.d = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int g(ChatListFragment chatListFragment) {
        int i = chatListFragment.d;
        chatListFragment.d = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        com.baidu.tieba.im.c.m.a().a("apply_join_group", this);
        com.baidu.tieba.im.c.m.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("group_intro_change", this);
        com.baidu.tieba.im.c.m.a().a("group_level_up", this);
        com.baidu.tieba.im.c.m.a().a("group_name_change", this);
        com.baidu.tieba.im.c.m.a().a("group_notice_change", this);
        com.baidu.tieba.im.c.m.a().a("group_event_info", this);
        com.baidu.tieba.im.c.m.a().a("dismiss_group", this);
        com.baidu.tieba.im.c.m.a().a("hide_group_warn", this);
        com.baidu.tieba.im.c.m.a().a("hide_group", this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.ao);
        I();
    }

    @Override // android.support.v4.app.Fragment
    public void d(boolean z) {
        super.d(z);
        if (z) {
            K();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ag = -1;
        this.c = i();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        by.a(this.c, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i >= 1) {
            this.d = i;
            this.h = i2;
            if (this.h == 1) {
                this.Y.a(true);
            } else if (this.h == 2) {
                this.Y.b(true);
            }
            com.baidu.tieba.im.c.m.a().c();
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.d = i;
            this.h = i2;
            if (this.h == 1) {
                this.Y.a(true);
            } else if (this.h == 2) {
                this.Y.b(true);
            }
            K();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        a();
    }

    public void a() {
        if (this.c == null) {
            this.c = i();
        }
        if (this.c != null) {
            if (TiebaApplication.B()) {
                if (this.i != null) {
                    this.i.setVisibility(0);
                }
                if (this.ad != null) {
                    this.ad.setVisibility(8);
                }
                if (this.ab == null) {
                    this.ab = TiebaApplication.A();
                } else if (!this.ab.equals(TiebaApplication.A())) {
                    this.ab = TiebaApplication.A();
                    com.baidu.tieba.im.c.a.h().f();
                    this.b.b();
                    com.baidu.adp.lib.g.e.d(" change account");
                }
                if (m() != null && !m().p()) {
                    b(this.d, 3);
                    this.f.run();
                    return;
                }
                return;
            }
            if (this.af == null) {
                this.af = new com.baidu.tieba.home.o(this.c, this.c.getString(R.string.login_msg_tab), this.c.getString(R.string.login_msg_form), 3);
                this.ad.addView(this.af.e());
                this.af.b(TiebaApplication.h().al());
            } else {
                ((ViewGroup) this.af.e().getParent()).removeAllViews();
                this.ad.addView(this.af.e());
                this.af.b(TiebaApplication.h().al());
            }
            this.Y.a(this.b.b(TiebaApplication.A()));
            if (this.Y.getCount() > 0) {
                e(false);
            }
            this.i.setVisibility(8);
            this.ad.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.Y != null && this.Y.b() != null) {
            this.Y.b().d();
            this.Y.a();
        }
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        com.baidu.tieba.im.c.m.a().a(this);
        super.t();
    }

    private void I() {
        this.b = new com.baidu.tieba.model.i();
        f(com.baidu.tieba.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
        G();
    }

    private void a(View view) {
        this.ae = new at(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.aa = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.aa.setVisibility(8);
        this.aa.setShutDownClickListener(new f(this));
        this.ad = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.i = (BdListView) view.findViewById(R.id.chat_list_content);
        this.Z = new cm(this.c);
        this.Z.a(this.am);
        this.i.setPullRefresh(this.Z);
        this.Y = new a(this.c);
        this.Y.a(this);
        this.i.setAdapter((ListAdapter) this.Y);
        this.Y.a(this.aj);
        this.i.setOnItemClickListener(this.ak);
        this.i.setOnScrollListener(this.an);
        this.i.setOnItemLongClickListener(this.al);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.c);
        this.Y.b().a();
        boolean z = g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG;
        this.Y.b().a(z);
        int firstVisiblePosition = this.i.getFirstVisiblePosition();
        int lastVisiblePosition = this.i.getLastVisiblePosition();
        this.Y.b().a();
        int i2 = firstVisiblePosition;
        int i3 = 0;
        while (i2 < this.Y.getCount()) {
            if (z || i2 <= lastVisiblePosition) {
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) this.Y.getItem(i2);
                if (!(this.Y.getItem(i2) instanceof RecentChatFriendData) || i3 >= 13 || (friendPortrait = ((RecentChatFriendData) this.Y.getItem(i2)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i3;
                } else {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            com.baidu.adp.lib.g.e.d("group head url:" + friendPortrait);
                            this.Y.b().b(friendPortrait, this);
                        } else {
                            this.Y.b().c(friendPortrait, this);
                        }
                    } else {
                        this.Y.b().c(friendPortrait, this);
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

    @Override // com.baidu.tieba.BaseFragment
    public void d(int i) {
        if (this.ag != i) {
            this.ag = i;
            if (n()) {
                if (this.ae != null) {
                    this.ae.a(i);
                }
                if (this.aa != null) {
                    this.aa.a(i);
                }
                if (this.Z != null) {
                    this.Z.a(i);
                }
                if (this.af != null) {
                    this.af.b(i);
                }
                if (i == 1) {
                    if (this.ae.c()) {
                        this.i.setDivider(this.c.getResources().getDrawable(17170445));
                    } else {
                        this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.night_divider)));
                    }
                    this.i.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
                    return;
                }
                if (this.ae != null && this.ae.c()) {
                    this.i.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.day_divider)));
                }
                this.i.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        this.ae.a();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.ae.b();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        try {
                            PersonalChatActivity.a(this.c, Long.parseLong(stringExtra), stringExtra2, stringExtra3, 0, null);
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
    public void a(RecentChatFriendData recentChatFriendData) {
        this.ac = new k(this, recentChatFriendData);
        String string = this.c.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.ac);
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (H() && this.aa.getVisibility() != 0) {
                this.aa.setVisibility(0);
            }
        } else if (this.aa.getVisibility() != 8) {
            this.aa.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null && this.i != null) {
            com.baidu.adp.lib.g.e.d("imageUrl:" + str);
            ImageView imageView = (ImageView) this.i.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.g.e.d("view found:  imageUrl:" + str);
                dVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.g.e.d("view not found:  imageUrl:" + str);
        }
    }

    public void e(boolean z) {
        com.baidu.adp.lib.g.e.d("is show no data:" + z);
        if (z) {
            this.ae.b(0);
        } else {
            this.ae.b(8);
        }
        if (n()) {
            if (this.ag == 1) {
                if (this.ae.c()) {
                    this.i.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.night_divider)));
                }
                this.i.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
                return;
            }
            if (this.ae != null && this.ae.c()) {
                this.i.setDivider(this.c.getResources().getDrawable(17170445));
            } else {
                this.i.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.day_divider)));
            }
            this.i.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
        }
    }

    public void G() {
        this.e = new Handler();
        this.f = new o(this);
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo == null || !groupNewsPojo.getGid().equals(SnapGroupChatActivity.m)) {
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.b != null) {
            this.b.a(this.ai);
        }
    }

    public boolean H() {
        return this.ah;
    }

    public void f(boolean z) {
        this.ah = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        K();
    }
}
