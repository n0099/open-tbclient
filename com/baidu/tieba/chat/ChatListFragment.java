package com.baidu.tieba.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
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
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ShutDownValidateTipView;
import com.baidu.tieba.view.bi;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ChatListFragment extends BaseFragment implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.im.pushNotify.m {
    private ShutDownValidateTipView ac;
    private DialogInterface.OnClickListener ae;
    private com.baidu.tieba.view.q af;
    private LinearLayout ag;
    private com.baidu.tieba.aj ah;
    private com.baidu.tieba.home.s ai;
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
    private bi ab = null;
    private String ad = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1117a = null;
    private boolean aj = true;
    private com.baidu.tieba.im.a<Void> ak = new p(this);
    com.baidu.adp.a.g b = new r(this);
    private View.OnClickListener al = new t(this);
    private AdapterView.OnItemClickListener am = new u(this);
    private AdapterView.OnItemLongClickListener an = new w(this);
    private com.baidu.adp.widget.ListView.b ao = new z(this);
    private AbsListView.OnScrollListener ap = new aa(this);

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
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_group", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_msg_arrived", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_intro_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_level_up", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_notice_change", this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = i();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        H();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.d, "enter_chatlist", "chatlistclick", 1);
        }
        return inflate;
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
            com.baidu.tieba.im.pushNotify.n.a().c();
            J();
            if (this.c.a(TiebaApplication.A(), String.valueOf(this.e))) {
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
            J();
            if (this.c.a(TiebaApplication.A(), String.valueOf(this.e))) {
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (TiebaApplication.B()) {
            this.Z.setVisibility(0);
            this.ag.setVisibility(8);
            if (this.ad == null) {
                this.ad = TiebaApplication.A();
            } else if (!this.ad.equals(TiebaApplication.A())) {
                this.ad = TiebaApplication.A();
                com.baidu.tieba.im.pushNotify.a.g().e();
                this.c.b();
                com.baidu.adp.lib.h.d.d(" change account");
            }
            b(this.e, 3);
            this.g.run();
            try {
                if (this.af != null) {
                    this.Z.removeFooterView(this.af);
                    this.af = null;
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        if (this.ai == null) {
            this.ai = new com.baidu.tieba.home.s(this.d, this.d.getString(R.string.login_msg_tab), this.d.getString(R.string.login_msg_form), 3);
            this.ag.addView(this.ai.e());
            this.ai.b(TiebaApplication.g().ap());
        } else {
            ((ViewGroup) this.ai.e().getParent()).removeAllViews();
            this.ag.addView(this.ai.e());
            this.ai.b(TiebaApplication.g().ap());
        }
        this.aa.a(this.c.d(TiebaApplication.A()));
        if (this.aa.getCount() > 0) {
            e(false);
        }
        this.Z.setVisibility(8);
        this.ag.setVisibility(0);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.aa.b() != null) {
            this.aa.b().b();
            this.aa.a();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        com.baidu.tieba.im.pushNotify.n.a().a(this);
        super.t();
    }

    private void H() {
        this.c = new com.baidu.tieba.model.f();
        this.c.setLoadDataCallBack(this.b);
        f(com.baidu.tieba.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
        a();
    }

    private void a(View view) {
        this.Y = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.ah = new com.baidu.tieba.aj(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.ac = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.ac.setVisibility(8);
        this.ac.setShutDownClickListener(new s(this));
        this.ag = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.Z = (BdListView) view.findViewById(R.id.chat_list_content);
        this.ab = new bi(this.d);
        this.ab.a(this.ao);
        this.Z.setPullRefresh(this.ab);
        this.aa = new m(this.d);
        this.aa.a(this);
        this.Z.setAdapter((ListAdapter) this.aa);
        this.aa.a(this.al);
        this.Z.setOnItemClickListener(this.am);
        this.Z.setOnScrollListener(this.ap);
        this.Z.setOnItemLongClickListener(this.an);
        new com.baidu.tieba.view.q(this.d).setHeightDip(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        int i;
        String friendPortrait;
        UtilHelper.NetworkStateInfo i2 = UtilHelper.i(this.d);
        this.aa.b().a();
        boolean z = i2 == UtilHelper.NetworkStateInfo.WIFI || i2 == UtilHelper.NetworkStateInfo.ThreeG;
        this.aa.b().a(z);
        int firstVisiblePosition = this.Z.getFirstVisiblePosition();
        int lastVisiblePosition = this.Z.getLastVisiblePosition();
        this.aa.b().a();
        int i3 = firstVisiblePosition;
        int i4 = 0;
        while (i3 < this.aa.getCount()) {
            if (z || i3 <= lastVisiblePosition) {
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) this.aa.getItem(i3);
                if (!(this.aa.getItem(i3) instanceof RecentChatFriendData) || i4 >= 13 || (friendPortrait = ((RecentChatFriendData) this.aa.getItem(i3)).getFriendPortrait()) == null || friendPortrait.equals("")) {
                    i = i4;
                } else {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (!TextUtils.isEmpty(ownerName)) {
                        if (ownerName.equals(String.valueOf(1))) {
                            com.baidu.adp.lib.h.d.d("group head url:" + friendPortrait);
                            this.aa.b().a(friendPortrait, this);
                        } else {
                            this.aa.b().b(friendPortrait, this);
                        }
                    } else {
                        this.aa.b().b(friendPortrait, this);
                    }
                    i = i4 + 1;
                }
                if (i < 30) {
                    i3++;
                    i4 = i;
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
            this.Y.setBackgroundColor(-14538444);
            if (this.ah.c()) {
                this.Z.setDivider(this.d.getResources().getDrawable(17170445));
            } else {
                this.Z.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.night_divider)));
            }
            this.Z.setDividerHeight(UtilHelper.a((Context) this.d, 1.0f));
            return;
        }
        this.Y.setBackgroundColor(-197380);
        if (this.ah.c()) {
            this.Z.setDivider(this.d.getResources().getDrawable(17170445));
        } else {
            this.Z.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.day_divider)));
        }
        this.Z.setDividerHeight(UtilHelper.a((Context) this.d, 1.0f));
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
        this.ae = new x(this, recentChatFriendData);
        String string = this.d.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.ae);
        this.f1117a = builder.create();
        this.f1117a.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (G() && this.ac.getVisibility() != 0) {
                this.ac.setVisibility(0);
            }
        } else if (this.ac.getVisibility() != 8) {
            this.ac.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.Z != null) {
            com.baidu.adp.lib.h.d.d("imageUrl:" + str);
            ImageView imageView = (ImageView) this.Z.findViewWithTag(str);
            if (imageView != null) {
                com.baidu.adp.lib.h.d.d("view found:  imageUrl:" + str);
                eVar.a(imageView);
                imageView.invalidate();
                return;
            }
            com.baidu.adp.lib.h.d.d("view not found:  imageUrl:" + str);
        }
    }

    public void e(boolean z) {
        com.baidu.adp.lib.h.d.d("is show no data:" + z);
        if (z) {
            this.ah.b(0);
        } else {
            this.ah.b(8);
        }
    }

    public void a() {
        this.f = new Handler();
        this.g = new q(this);
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.c != null) {
            this.c.a(this.ak);
        }
    }

    public boolean G() {
        return this.aj;
    }

    public void f(boolean z) {
        this.aj = z;
    }
}
