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
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ap;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ShutDownValidateTipView;
import com.baidu.tieba.view.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ChatListFragment extends BaseFragment implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.im.c.l {
    private ShutDownValidateTipView ab;
    private DialogInterface.OnClickListener ad;
    private LinearLayout ae;
    private ap af;
    private com.baidu.tieba.home.n ag;
    private int ah;
    private com.baidu.tieba.model.i b = null;
    private Activity c = null;
    private int d = 1;
    private Handler e = null;
    private Runnable f = null;
    private RecentChatFriendData g = null;
    private int h = 3;
    private RelativeLayout i = null;
    private BdListView Y = null;
    private a Z = null;
    private bq aa = null;
    private String ac = null;
    AlertDialog a = null;
    private boolean ai = true;
    private com.baidu.tieba.im.a<Void> aj = new d(this);
    private View.OnClickListener ak = new g(this);
    private AdapterView.OnItemClickListener al = new h(this);
    private AdapterView.OnItemLongClickListener am = new j(this);
    private com.baidu.adp.widget.ListView.b an = new m(this);
    private AbsListView.OnScrollListener ao = new n(this);
    private com.baidu.tieba.im.messageCenter.g ap = new e(this);

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
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.ap);
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
        this.ah = -1;
        this.c = i();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.c, "enter_chatlist", "chatlistclick", 1);
        }
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
                this.Z.a(true);
            } else if (this.h == 2) {
                this.Z.b(true);
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
                this.Z.a(true);
            } else if (this.h == 2) {
                this.Z.b(true);
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
            if (TiebaApplication.C()) {
                if (this.Y != null) {
                    this.Y.setVisibility(0);
                }
                if (this.ae != null) {
                    this.ae.setVisibility(8);
                }
                if (this.ac == null) {
                    this.ac = TiebaApplication.B();
                } else if (!this.ac.equals(TiebaApplication.B())) {
                    this.ac = TiebaApplication.B();
                    com.baidu.tieba.im.c.a.h().f();
                    this.b.b();
                    com.baidu.adp.lib.h.e.d(" change account");
                }
                if (m() != null && !m().p()) {
                    b(this.d, 3);
                    this.f.run();
                    return;
                }
                return;
            }
            if (this.ag == null) {
                this.ag = new com.baidu.tieba.home.n(this.c, this.c.getString(R.string.login_msg_tab), this.c.getString(R.string.login_msg_form), 3);
                this.ae.addView(this.ag.e());
                this.ag.b(TiebaApplication.h().an());
            } else {
                ((ViewGroup) this.ag.e().getParent()).removeAllViews();
                this.ae.addView(this.ag.e());
                this.ag.b(TiebaApplication.h().an());
            }
            this.Z.a(this.b.b(TiebaApplication.B()));
            if (this.Z.getCount() > 0) {
                e(false);
            }
            this.Y.setVisibility(8);
            this.ae.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.Z != null && this.Z.b() != null) {
            this.Z.b().b();
            this.Z.a();
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
        this.i = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.af = new ap(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.ab = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.ab.setVisibility(8);
        this.ab.setShutDownClickListener(new f(this));
        this.ae = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.Y = (BdListView) view.findViewById(R.id.chat_list_content);
        this.aa = new bq(this.c);
        this.aa.a(this.an);
        this.Y.setPullRefresh(this.aa);
        this.Z = new a(this.c);
        this.Z.a(this);
        this.Y.setAdapter((ListAdapter) this.Z);
        this.Z.a(this.ak);
        this.Y.setOnItemClickListener(this.al);
        this.Y.setOnScrollListener(this.ao);
        this.Y.setOnItemLongClickListener(this.am);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.c);
        this.Z.b().a();
        boolean z = g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG;
        this.Z.b().a(z);
        int firstVisiblePosition = this.Y.getFirstVisiblePosition();
        int lastVisiblePosition = this.Y.getLastVisiblePosition();
        this.Z.b().a();
        int i2 = firstVisiblePosition;
        int i3 = 0;
        while (i2 < this.Z.getCount()) {
            if (z || i2 <= lastVisiblePosition) {
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) this.Z.getItem(i2);
                if (!(this.Z.getItem(i2) instanceof RecentChatFriendData) || i3 >= 13 || (friendPortrait = ((RecentChatFriendData) this.Z.getItem(i2)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i3;
                } else {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            com.baidu.adp.lib.h.e.d("group head url:" + friendPortrait);
                            this.Z.b().a(friendPortrait, this);
                        } else {
                            this.Z.b().b(friendPortrait, this);
                        }
                    } else {
                        this.Z.b().b(friendPortrait, this);
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
    public void c(int i) {
        if (this.ah != i) {
            this.ah = i;
            if (n()) {
                if (this.af != null) {
                    this.af.a(i);
                }
                if (this.ab != null) {
                    this.ab.a(i);
                }
                if (this.aa != null) {
                    this.aa.a(i);
                }
                if (this.ag != null) {
                    this.ag.b(i);
                }
                if (i == 1) {
                    if (this.af.c()) {
                        this.Y.setDivider(this.c.getResources().getDrawable(17170445));
                    } else {
                        this.Y.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.night_divider)));
                    }
                    this.Y.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
                    return;
                }
                if (this.af != null && this.af.c()) {
                    this.Y.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.Y.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.day_divider)));
                }
                this.Y.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        this.af.a();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.af.b();
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
        this.ad = new k(this, recentChatFriendData);
        String string = this.c.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.ad);
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (H() && this.ab.getVisibility() != 0) {
                this.ab.setVisibility(0);
            }
        } else if (this.ab.getVisibility() != 8) {
            this.ab.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.Y != null) {
            com.baidu.adp.lib.h.e.d("imageUrl:" + str);
            ImageView imageView = (ImageView) this.Y.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.h.e.d("view found:  imageUrl:" + str);
                eVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.h.e.d("view not found:  imageUrl:" + str);
        }
    }

    public void e(boolean z) {
        com.baidu.adp.lib.h.e.d("is show no data:" + z);
        if (z) {
            this.af.b(0);
        } else {
            this.af.b(8);
        }
        if (n()) {
            if (this.ah == 1) {
                if (this.af.c()) {
                    this.Y.setDivider(this.c.getResources().getDrawable(17170445));
                } else {
                    this.Y.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.night_divider)));
                }
                this.Y.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
                return;
            }
            if (this.af != null && this.af.c()) {
                this.Y.setDivider(this.c.getResources().getDrawable(17170445));
            } else {
                this.Y.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.day_divider)));
            }
            this.Y.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
        }
    }

    public void G() {
        this.e = new Handler();
        this.f = new o(this);
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.b != null) {
            this.b.a(this.aj);
        }
    }

    public boolean H() {
        return this.ai;
    }

    public void f(boolean z) {
        this.ai = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        K();
    }
}
