package com.baidu.tieba.im.chat.snapGroup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonGroupChatActiviy;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.bo;
import com.baidu.tieba.im.model.SnapGroupMsglistModel;
import com.baidu.tieba.im.model.aw;
import com.baidu.tieba.im.model.bu;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SnapGroupChatActivity extends CommonGroupChatActiviy implements AbsListView.OnScrollListener, aw {
    private bu l;
    private RandChatRoomData m;
    private com.baidu.tieba.im.model.j n;
    private int o;
    private h p;
    private int r;
    private boolean s;
    private boolean t;
    private String v;
    private String w;
    private int q = 0;
    private final Handler u = new Handler();
    private final com.baidu.adp.framework.c.a x = new a(this, 2001119);
    private final com.baidu.adp.framework.c.g y = new b(this, 0);

    public static void a(Context context, RandChatRoomData randChatRoomData, String str, String str2, String str3, int i) {
        com.baidu.adp.lib.util.f.e("simon", "startActivity", "started");
        Intent intent = new Intent(context, SnapGroupChatActivity.class);
        if (randChatRoomData == null) {
            com.baidu.adp.lib.util.f.c("RandChatRoomData is null, skip launch SnapGroupChatActivity");
            return;
        }
        GroupData groupData = new GroupData();
        groupData.setGroupId(randChatRoomData.d());
        intent.putExtra("gid", randChatRoomData.d());
        Bundle bundle = new Bundle();
        bundle.putParcelable("rand_chat_room_data", randChatRoomData);
        intent.putExtra("bundle", bundle);
        intent.putExtra("group", groupData);
        intent.putExtra("chat_mode", 2);
        intent.putExtra("introduction", str3);
        intent.putExtra("restart_time", i);
        intent.putExtra("topic_title", str);
        intent.putExtra("topic_content", str2);
        context.startActivity(intent);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (Math.abs(i - this.q) == 1) {
            if (!((SnapGroupChatView) this.d).R().a() && i > this.q) {
                ((SnapGroupChatView) this.d).R().b();
            } else if (((SnapGroupChatView) this.d).R().a() && i < this.q) {
                ((SnapGroupChatView) this.d).R().c();
            }
        }
        if (i != this.q) {
            this.q = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.dn, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getLocalClassName(), "onClick", e.getMessage());
        }
        if (view == this.d.w()) {
            if (this.t) {
                finish();
                return;
            } else {
                ((SnapGroupChatView) this.d).S().show();
                return;
            }
        }
        if (view == ((SnapGroupChatView) this.d).W()) {
            if (this.t) {
                u();
            } else {
                ((SnapGroupChatView) this.d).T().show();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tieba.im.model.aw
    public final void t() {
        ((SnapGroupChatView) this.d).U().setVisibility(4);
        if (this.p != null) {
            this.p.a();
        }
        this.p = new h(this, this.m.h() * 1000);
        this.p.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = getIntent().getIntExtra("gid", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        if (bundleExtra != null) {
            this.m = (RandChatRoomData) bundleExtra.getParcelable("rand_chat_room_data");
        }
        this.n = new com.baidu.tieba.im.model.j();
        this.n.setUniqueId(getUniqueId());
        this.n.registerListener(this.y);
        this.r = getIntent().getIntExtra("restart_time", 0);
        this.v = getIntent().getStringExtra("topic_title");
        this.w = getIntent().getStringExtra("topic_content");
        com.baidu.adp.lib.util.f.e("simon", "onCreate", "restart time = " + this.r);
        if (this.m == null) {
            com.baidu.adp.lib.util.f.b("RandChatRoomData is null, finish activity");
            showToast("初始化失败，请重新尝试。");
            finish();
        } else {
            com.baidu.adp.lib.util.f.e("simon", "onCreate", this.m.toString());
        }
        if (this.r >= 2) {
            com.baidu.adp.lib.util.f.e("simon", "initView", "disableChangeGroupBtn");
            ((SnapGroupChatView) this.d).W().setOnClickListener(new c(this));
        }
        this.p = new h(this, this.m.h() * 1000);
        this.p.b();
        this.l.b(this.o);
        this.u.postDelayed(new d(this), 300L);
        ((SnapGroupChatView) this.d).V().a(this.m.g() * 1000, 500L, 60000L);
        ((SnapGroupChatView) this.d).V().setOnFinishlistener(new e(this));
        ((SnapGroupChatView) this.d).V().setFinalText(getString(com.baidu.tieba.im.j.snap_group_chat_remaining));
        ((SnapGroupChatView) this.d).V().a();
        this.e.a(this);
        com.baidu.tbadk.core.g.b(getApplicationContext(), "snap_chat_activity");
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final void o() {
        com.baidu.adp.lib.util.f.e("simon", "initView", "initView");
        this.d = new SnapGroupChatView(this, this.e.h());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        if (((SnapGroupMsglistModel) this.e).b() != null) {
            this.d.a(this.e.g(), ((SnapGroupMsglistModel) this.e).b().getGroupId());
        }
        this.d.a(new f(this));
        this.d.j().setOnScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.a(getString(com.baidu.tieba.im.j.snap_group_chat_chatting));
        this.s = false;
        a = false;
        b = String.valueOf(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.s = true;
    }

    private void u() {
        showLoadingDialog(getString(com.baidu.tieba.im.j.group_tab_enterchatroom_loading), new g(this));
        this.n.a(this.o);
        com.baidu.tieba.im.f.h.a(String.valueOf(this.o));
        com.baidu.tbadk.core.g.a(getApplicationContext(), "snap_chat_change_room");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("need_freeze_user", false);
            com.baidu.adp.lib.util.f.e("simon", "onDestroy", "shouldFreeze = " + booleanExtra);
            if (booleanExtra) {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.E()) + "_" + String.valueOf(System.currentTimeMillis() + 900000));
            } else {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.E()) + "_" + String.valueOf(0L));
            }
            this.l.a(this.o, booleanExtra, 1);
        }
        ((SnapGroupChatView) this.d).V().b();
        ((SnapGroupChatView) this.d).U().b();
        this.p.a();
        com.baidu.tieba.im.f.h.a(String.valueOf(this.o));
        a = false;
        b = "";
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.dn, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == ((SnapGroupChatView) this.d).T() && i == -1) {
            u();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean b(Bundle bundle) {
        this.l = new bu(this);
        this.l.a(this.m);
        this.l.a(this.y);
        this.l.a(this.x);
        try {
            this.e = new SnapGroupMsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                a(bundle);
            } else {
                k();
            }
            return l();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SnapGroupChatActivity snapGroupChatActivity, com.baidu.tieba.im.data.b bVar) {
        UserData next;
        if (snapGroupChatActivity.m == null || bVar == null) {
            return;
        }
        com.baidu.adp.lib.util.f.e("eventData uid = " + bVar.c);
        Iterator<UserData> it = snapGroupChatActivity.m.j().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (bVar.c == next.getUserIdLong()) {
                ((SnapGroupChatView) snapGroupChatActivity.d).R().a(next);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.dn, com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            try {
                if (keyEvent.getAction() == 0 && this.d != null) {
                    r();
                    if (this.d.u()) {
                        this.d.v();
                        return true;
                    }
                    if (this.t) {
                        finish();
                    } else {
                        ((SnapGroupChatView) this.d).S().show();
                    }
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SnapGroupChatView d(SnapGroupChatActivity snapGroupChatActivity) {
        return (SnapGroupChatView) snapGroupChatActivity.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SnapGroupChatActivity snapGroupChatActivity, String str, String str2) {
        if (TextUtils.isEmpty(str) || snapGroupChatActivity.d == null) {
            return;
        }
        bo boVar = new bo();
        boVar.a(String.valueOf(snapGroupChatActivity.o));
        boVar.a = str;
        boVar.b = str2;
        boVar.e(-999L);
        boVar.f(0L);
        x.b().a(boVar);
        snapGroupChatActivity.d.d().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(SnapGroupChatActivity snapGroupChatActivity) {
        if (snapGroupChatActivity.d != null) {
            com.baidu.tieba.im.message.b bVar = new com.baidu.tieba.im.message.b();
            bVar.a(String.valueOf(snapGroupChatActivity.o));
            bVar.a = snapGroupChatActivity.getString(com.baidu.tieba.im.j.snap_group_chat_rule);
            bVar.e(-1000L);
            bVar.f(-1L);
            x.b().a(bVar);
            snapGroupChatActivity.d.d().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(SnapGroupChatActivity snapGroupChatActivity) {
        com.baidu.tieba.im.message.b bVar = new com.baidu.tieba.im.message.b();
        bVar.a(String.valueOf(snapGroupChatActivity.o));
        bVar.a = snapGroupChatActivity.getString(com.baidu.tieba.im.j.snap_group_chat_times_up);
        bVar.e(Long.MAX_VALUE);
        x.b().a(bVar);
        snapGroupChatActivity.d.d().notifyDataSetChanged();
        snapGroupChatActivity.d.f().setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected final boolean p() {
        return true;
    }
}
