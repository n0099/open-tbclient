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
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.dd;
import com.baidu.tieba.im.model.aj;
import com.baidu.tieba.im.model.ar;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SnapGroupChatActivity extends GroupChatActivity implements AbsListView.OnScrollListener, com.baidu.tieba.im.messageCenter.g, aj {
    public static boolean l = false;
    public static String m = "";
    private ar n;
    private RandChatRoomData o;
    private com.baidu.tieba.im.model.c p;
    private int q;
    private g r;
    private int t;
    private boolean u;
    private boolean v;
    private String x;
    private String y;
    private int s = 0;
    private Handler w = new Handler();
    private com.baidu.tieba.im.messageCenter.g z = new a(this);

    public static void a(Context context, RandChatRoomData randChatRoomData, String str, String str2, String str3, int i) {
        com.baidu.adp.lib.util.e.e("simon", "startActivity", "started");
        Intent intent = new Intent(context, SnapGroupChatActivity.class);
        if (randChatRoomData == null) {
            com.baidu.adp.lib.util.e.c("RandChatRoomData is null, skip launch SnapGroupChatActivity");
            return;
        }
        GroupData groupData = new GroupData();
        groupData.setGroupId(randChatRoomData.d());
        intent.putExtra(PushConstants.EXTRA_GID, randChatRoomData.d());
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
        if (Math.abs(i - this.s) == 1) {
            if (!((SnapGroupChatView) this.d).P().a() && i > this.s) {
                ((SnapGroupChatView) this.d).P().b();
            } else if (((SnapGroupChatView) this.d).P().a() && i < this.s) {
                ((SnapGroupChatView) this.d).P().c();
            }
        }
        if (i != this.s) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.cy, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getLocalClassName(), "onClick", e.getMessage());
        }
        if (view == this.d.t()) {
            if (this.v) {
                finish();
                return;
            } else {
                ((SnapGroupChatView) this.d).Q().show();
                return;
            }
        }
        if (view == ((SnapGroupChatView) this.d).U()) {
            if (this.v) {
                p();
            } else {
                ((SnapGroupChatView) this.d).R().show();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tieba.im.model.aj
    public final void o() {
        ((SnapGroupChatView) this.d).S().setVisibility(4);
        if (this.r != null) {
            this.r.b();
        }
        this.r = new g(this, this.o.h() * 1000);
        this.r.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = getIntent().getIntExtra(PushConstants.EXTRA_GID, 0);
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        if (bundleExtra != null) {
            this.o = (RandChatRoomData) bundleExtra.getParcelable("rand_chat_room_data");
        }
        this.p = new com.baidu.tieba.im.model.c();
        com.baidu.tieba.im.model.c cVar = this.p;
        com.baidu.tieba.im.model.c.a(this.z);
        this.t = getIntent().getIntExtra("restart_time", 0);
        this.x = getIntent().getStringExtra("topic_title");
        this.y = getIntent().getStringExtra("topic_content");
        com.baidu.adp.lib.util.e.e("simon", "onCreate", "restart time = " + this.t);
        if (this.o == null) {
            com.baidu.adp.lib.util.e.b("RandChatRoomData is null, finish activity");
            showToast("初始化失败，请重新尝试。");
            finish();
        } else {
            com.baidu.adp.lib.util.e.e("simon", "onCreate", this.o.toString());
        }
        if (this.t >= 2) {
            com.baidu.adp.lib.util.e.e("simon", "initView", "disableChangeGroupBtn");
            ((SnapGroupChatView) this.d).U().setOnClickListener(new b(this));
        }
        this.r = new g(this, this.o.h() * 1000);
        this.r.c();
        this.n.b(this.q);
        this.w.postDelayed(new c(this), 300L);
        ((SnapGroupChatView) this.d).T().a(this.o.g() * 1000, 500L, 60000L);
        ((SnapGroupChatView) this.d).T().setOnFinishlistener(new d(this));
        ((SnapGroupChatView) this.d).T().setFinalText(getString(R.string.snap_group_chat_remaining));
        ((SnapGroupChatView) this.d).T().a();
        this.e.a(this);
        ai.b(getApplicationContext(), "snap_chat_activity");
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected final void l() {
        com.baidu.adp.lib.util.e.e("simon", "initView", "initView");
        this.d = new SnapGroupChatView(this, this.e.d());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        if (this.e.a() != null) {
            this.d.a(this.e.c(), this.e.a().getGroupId());
        }
        this.d.a(new e(this));
        this.d.h().setOnScrollListener(this);
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.d.a(getString(R.string.snap_group_chat_chatting));
        this.u = false;
        a = false;
        l = true;
        m = String.valueOf(this.q);
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.u = true;
    }

    private void p() {
        showLoadingDialog(getString(R.string.group_tab_enterchatroom_loading), new f(this));
        this.p.a(this.q);
        com.baidu.tieba.im.util.d.a(String.valueOf(this.q));
        ai.a(getApplicationContext(), "snap_chat_change_room");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("need_freeze_user", false);
            com.baidu.adp.lib.util.e.e("simon", "onDestroy", "shouldFreeze = " + booleanExtra);
            if (booleanExtra) {
                com.baidu.tieba.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TiebaApplication.v()) + "_" + String.valueOf(System.currentTimeMillis() + 900000));
            } else {
                com.baidu.tieba.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TiebaApplication.v()) + "_" + String.valueOf(0L));
            }
            this.n.a(this.q, booleanExtra, 1);
        }
        ar arVar = this.n;
        ar.b(this.z);
        com.baidu.tieba.im.model.c cVar = this.p;
        com.baidu.tieba.im.messageCenter.d.a().a(this.z);
        ((SnapGroupChatView) this.d).T().b();
        ((SnapGroupChatView) this.d).S().b();
        this.r.b();
        com.baidu.tieba.im.util.d.a(String.valueOf(this.q));
        l = false;
        m = "";
    }

    @Override // com.baidu.tieba.im.chat.cy, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == ((SnapGroupChatView) this.d).R() && i == -1) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public final boolean b(Bundle bundle) {
        super.b(bundle);
        this.n = new ar(this);
        this.n.a(this.o);
        ar arVar = this.n;
        ar.a(this.z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SnapGroupChatActivity snapGroupChatActivity, com.baidu.tieba.im.data.b bVar) {
        UserData next;
        if (snapGroupChatActivity.o == null || bVar == null) {
            return;
        }
        com.baidu.adp.lib.util.e.e("eventData uid = " + bVar.c);
        Iterator<UserData> it = snapGroupChatActivity.o.j().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (bVar.c == next.getUserIdLong()) {
                ((SnapGroupChatView) snapGroupChatActivity.d).P().a(next);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            try {
                if (keyEvent.getAction() == 0 && this.d != null) {
                    n();
                    if (this.d.r()) {
                        this.d.s();
                        return true;
                    }
                    if (this.v) {
                        finish();
                    } else {
                        ((SnapGroupChatView) this.d).Q().show();
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
        dd ddVar = new dd();
        ddVar.b(String.valueOf(snapGroupChatActivity.q));
        ddVar.b = str;
        ddVar.c = str2;
        ddVar.c(-999L);
        ddVar.d(0L);
        q.b().a((com.baidu.tieba.im.message.b) ddVar);
        snapGroupChatActivity.d.a().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(SnapGroupChatActivity snapGroupChatActivity) {
        if (snapGroupChatActivity.d != null) {
            com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
            fVar.b(String.valueOf(snapGroupChatActivity.q));
            fVar.b = snapGroupChatActivity.getString(R.string.snap_group_chat_rule);
            fVar.c(-1000L);
            fVar.d(-1L);
            q.b().a((com.baidu.tieba.im.message.b) fVar);
            snapGroupChatActivity.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(SnapGroupChatActivity snapGroupChatActivity) {
        com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
        fVar.b(String.valueOf(snapGroupChatActivity.q));
        fVar.b = snapGroupChatActivity.getString(R.string.snap_group_chat_times_up);
        fVar.c(Long.MAX_VALUE);
        q.b().a((com.baidu.tieba.im.message.b) fVar);
        snapGroupChatActivity.d.a().notifyDataSetChanged();
        snapGroupChatActivity.d.d().setVisibility(8);
    }
}
