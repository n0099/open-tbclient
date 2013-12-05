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
import com.baidu.tieba.aq;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ShutDownValidateTipView;
import com.baidu.tieba.view.bk;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ChatListFragment extends BaseFragment implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.im.pushNotify.k {
    private ShutDownValidateTipView ac;
    private DialogInterface.OnClickListener ae;
    private com.baidu.tieba.view.r af;
    private LinearLayout ag;
    private aq ah;
    private com.baidu.tieba.home.n ai;
    private int aj;
    private com.baidu.tieba.model.f c = null;
    private Activity d = null;
    private int e = 1;
    private Handler f = null;
    private Runnable g = null;
    private RecentChatFriendData h = null;
    private int i = 3;
    private RelativeLayout Y = null;
    private BdListView Z = null;
    private m aa = null;
    private bk ab = null;
    private String ad = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1169a = null;
    private boolean ak = true;
    private boolean al = false;
    private boolean am = false;
    private com.baidu.tieba.im.a<Void> an = new p(this);
    com.baidu.adp.a.g b = new s(this);
    private View.OnClickListener ao = new u(this);
    private AdapterView.OnItemClickListener ap = new v(this);
    private AdapterView.OnItemLongClickListener aq = new x(this);
    private com.baidu.adp.widget.ListView.b ar = new aa(this);
    private AbsListView.OnScrollListener as = new ab(this);
    private com.baidu.tieba.im.messageCenter.g at = new r(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int h(ChatListFragment chatListFragment) {
        int i = chatListFragment.e;
        chatListFragment.e = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(ChatListFragment chatListFragment) {
        int i = chatListFragment.e;
        chatListFragment.e = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        com.baidu.tieba.im.pushNotify.l.a().a("apply_join_group", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.pushNotify.l.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.l.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_intro_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_level_up", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_name_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_notice_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("dismiss_group", this);
        com.baidu.tieba.im.pushNotify.l.a().a("hide_group_warn", this);
        com.baidu.tieba.im.pushNotify.l.a().a("hide_group", this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.at);
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
        this.aj = -1;
        this.d = i();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        if (bundle != null) {
            this.al = bundle.getBoolean("is_have_footer");
        }
        this.am = false;
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.d, "enter_chatlist", "chatlistclick", 1);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            bundle.putBoolean("is_have_footer", this.al);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i >= 1) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.aa.a(true);
            } else if (this.i == 2) {
                this.aa.b(true);
            }
            com.baidu.tieba.im.pushNotify.l.a().c();
            K();
            if (this.c.a(TiebaApplication.B(), String.valueOf(this.e))) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.aa.a(true);
            } else if (this.i == 2) {
                this.aa.b(true);
            }
            K();
            if (this.c.a(TiebaApplication.B(), String.valueOf(this.e))) {
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        a();
    }

    public void a() {
        if (TiebaApplication.C()) {
            if (this.Z != null) {
                this.Z.setVisibility(0);
            }
            if (this.ag != null) {
                this.ag.setVisibility(8);
            }
            if (this.ad == null) {
                this.ad = TiebaApplication.B();
            } else if (!this.ad.equals(TiebaApplication.B())) {
                this.ad = TiebaApplication.B();
                com.baidu.tieba.im.pushNotify.a.h().f();
                this.c.b();
                com.baidu.adp.lib.h.e.d(" change account");
            }
            if (m() != null && !m().p()) {
                b(this.e, 3);
                this.g.run();
            }
            if (this.al && !this.am) {
                if (this.af == null) {
                    this.af = new com.baidu.tieba.view.r(this.d);
                }
                this.af.setHeightDip(30);
                this.Z.addFooterView(this.af);
                this.am = true;
                return;
            }
            this.am = false;
            this.al = false;
            try {
                if (this.af != null) {
                    this.Z.removeFooterView(this.af);
                    this.af = null;
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (this.ai == null) {
            this.ai = new com.baidu.tieba.home.n(this.d, this.d.getString(R.string.login_msg_tab), this.d.getString(R.string.login_msg_form), 3);
            this.ag.addView(this.ai.e());
            this.ai.b(TiebaApplication.h().an());
        } else {
            ((ViewGroup) this.ai.e().getParent()).removeAllViews();
            this.ag.addView(this.ai.e());
            this.ai.b(TiebaApplication.h().an());
        }
        this.aa.a(this.c.d(TiebaApplication.B()));
        if (this.aa.getCount() > 0) {
            e(false);
        }
        this.Z.setVisibility(8);
        this.ag.setVisibility(0);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.aa != null && this.aa.b() != null) {
            this.aa.b().b();
            this.aa.a();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        com.baidu.tieba.im.pushNotify.l.a().a(this);
        super.t();
    }

    private void I() {
        this.c = new com.baidu.tieba.model.f();
        this.c.setLoadDataCallBack(this.b);
        f(com.baidu.tieba.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
        G();
    }

    private void a(View view) {
        this.Y = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.ah = new aq(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.ac = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.ac.setVisibility(8);
        this.ac.setShutDownClickListener(new t(this));
        this.ag = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.Z = (BdListView) view.findViewById(R.id.chat_list_content);
        this.ab = new bk(this.d);
        this.ab.a(this.ar);
        this.Z.setPullRefresh(this.ab);
        this.aa = new m(this.d);
        this.aa.a(this);
        this.Z.setAdapter((ListAdapter) this.aa);
        this.aa.a(this.ao);
        this.Z.setOnItemClickListener(this.ap);
        this.Z.setOnScrollListener(this.as);
        this.Z.setOnItemLongClickListener(this.aq);
        new com.baidu.tieba.view.r(this.d).setHeightDip(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.d);
        this.aa.b().a();
        boolean z = g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG;
        this.aa.b().a(z);
        int firstVisiblePosition = this.Z.getFirstVisiblePosition();
        int lastVisiblePosition = this.Z.getLastVisiblePosition();
        this.aa.b().a();
        int i2 = firstVisiblePosition;
        int i3 = 0;
        while (i2 < this.aa.getCount()) {
            if (z || i2 <= lastVisiblePosition) {
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) this.aa.getItem(i2);
                if (!(this.aa.getItem(i2) instanceof RecentChatFriendData) || i3 >= 13 || (friendPortrait = ((RecentChatFriendData) this.aa.getItem(i2)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i3;
                } else {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            com.baidu.adp.lib.h.e.d("group head url:" + friendPortrait);
                            this.aa.b().a(friendPortrait, this);
                        } else {
                            this.aa.b().b(friendPortrait, this);
                        }
                    } else {
                        this.aa.b().b(friendPortrait, this);
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
        if (this.aj != i) {
            this.aj = i;
            if (n()) {
                if (this.ah != null) {
                    this.ah.a(i);
                }
                if (this.ac != null) {
                    this.ac.a(i);
                }
                if (this.ab != null) {
                    this.ab.a(i);
                }
                if (this.ai != null) {
                    this.ai.b(i);
                }
                if (i == 1) {
                    if (this.ah.c()) {
                        this.Z.setDivider(this.d.getResources().getDrawable(17170445));
                    } else {
                        this.Z.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.night_divider)));
                    }
                    this.Z.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
                    return;
                }
                if (this.ah != null && this.ah.c()) {
                    this.Z.setDivider(this.d.getResources().getDrawable(17170445));
                } else {
                    this.Z.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.day_divider)));
                }
                this.Z.setDividerHeight(j().getDimensionPixelSize(R.dimen.onedip));
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        this.ah.a();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.ah.b();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra(LocaleUtil.INDONESIAN);
                    String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        ChatActivity.a(this.d, stringExtra, stringExtra2, stringExtra3, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentChatFriendData recentChatFriendData) {
        this.ae = new y(this, recentChatFriendData);
        String string = this.d.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.ae);
        this.f1169a = builder.create();
        this.f1169a.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (H() && this.ac.getVisibility() != 0) {
                this.ac.setVisibility(0);
            }
        } else if (this.ac.getVisibility() != 8) {
            this.ac.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.Z != null) {
            com.baidu.adp.lib.h.e.d("imageUrl:" + str);
            ImageView imageView = (ImageView) this.Z.findViewWithTag(str);
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
            this.ah.b(0);
        } else {
            this.ah.b(8);
        }
    }

    public void G() {
        this.f = new Handler();
        this.g = new q(this);
    }

    @Override // com.baidu.tieba.im.pushNotify.k
    public void a(GroupNewsPojo groupNewsPojo) {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.c != null) {
            this.c.a(this.an);
        }
    }

    public boolean H() {
        return this.ak;
    }

    public void f(boolean z) {
        this.ak = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        K();
    }
}
