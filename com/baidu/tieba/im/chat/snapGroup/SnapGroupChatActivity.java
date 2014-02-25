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
import java.util.List;
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
        com.baidu.adp.lib.util.f.e("simon", "startActivity", "started");
        Intent intent = new Intent(context, SnapGroupChatActivity.class);
        if (randChatRoomData == null) {
            com.baidu.adp.lib.util.f.c("RandChatRoomData is null, skip launch SnapGroupChatActivity");
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
            if (!r().R().a() && i > this.s) {
                r().R().b();
            } else if (r().R().a() && i < this.s) {
                r().R().c();
            }
        }
        if (i != this.s) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.cz, com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getLocalClassName(), "onClick", e.getMessage());
        }
        if (view == this.d.v()) {
            if (this.v) {
                finish();
                return;
            } else {
                r().S().show();
                return;
            }
        }
        if (view == r().W()) {
            if (this.v) {
                q();
            } else {
                r().T().show();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tieba.im.model.aj
    public void a(int i) {
        r().U().setVisibility(4);
        if (this.r != null) {
            this.r.b();
        }
        this.r = new g(this, this.o.h() * 1000);
        this.r.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = getIntent().getIntExtra(PushConstants.EXTRA_GID, 0);
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        if (bundleExtra != null) {
            this.o = (RandChatRoomData) bundleExtra.getParcelable("rand_chat_room_data");
        }
        this.p = new com.baidu.tieba.im.model.c();
        this.p.a(this.z);
        this.t = getIntent().getIntExtra("restart_time", 0);
        this.x = getIntent().getStringExtra("topic_title");
        this.y = getIntent().getStringExtra("topic_content");
        com.baidu.adp.lib.util.f.e("simon", "onCreate", "restart time = " + this.t);
        if (this.o == null) {
            com.baidu.adp.lib.util.f.b("RandChatRoomData is null, finish activity");
            showToast("初始化失败，请重新尝试。");
            finish();
        } else {
            com.baidu.adp.lib.util.f.e("simon", "onCreate", this.o.toString());
        }
        if (this.t >= 2) {
            com.baidu.adp.lib.util.f.e("simon", "initView", "disableChangeGroupBtn");
            r().W().setOnClickListener(new b(this));
        }
        this.r = new g(this, this.o.h() * 1000);
        this.r.c();
        this.n.b(this.q);
        this.w.postDelayed(new c(this), 300L);
        r().V().a(this.o.g() * 1000, 500L, 60000L);
        r().V().setOnFinishlistener(new d(this));
        r().V().setFinalText(getString(R.string.snap_group_chat_remaining));
        r().V().a();
        this.e.a(this);
        ai.b(getApplicationContext(), "snap_chat_activity");
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void l() {
        com.baidu.adp.lib.util.f.e("simon", "initView", "initView");
        this.d = new SnapGroupChatView(this, this.e.d());
        this.d.a((InputMethodManager) getSystemService("input_method"));
        if (this.e.a() != null) {
            this.d.a(this.e.c(), this.e.a().getGroupId());
        }
        this.d.a(new e(this));
        this.d.i().setOnScrollListener(this);
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.d.a(getString(R.string.snap_group_chat_chatting), false);
        this.u = false;
        a = false;
        l = true;
        m = String.valueOf(this.q);
    }

    @Override // com.baidu.tieba.im.chat.GroupChatActivity, com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.u = true;
    }

    private void q() {
        showLoadingDialog(getString(R.string.group_tab_enterchatroom_loading), new f(this));
        this.p.a(this.q);
        com.baidu.tieba.im.util.d.a(String.valueOf(this.q));
        ai.a(getApplicationContext(), "snap_chat_change_room");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("need_freeze_user", false);
            com.baidu.adp.lib.util.f.e("simon", "onDestroy", "shouldFreeze = " + booleanExtra);
            if (booleanExtra) {
                com.baidu.tieba.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TiebaApplication.A()) + "_" + String.valueOf(System.currentTimeMillis() + 900000));
            } else {
                com.baidu.tieba.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TiebaApplication.A()) + "_" + String.valueOf(0L));
            }
            this.n.a(this.q, booleanExtra, 1);
        }
        this.n.b(this.z);
        this.p.b(this.z);
        r().V().b();
        r().U().b();
        this.r.b();
        com.baidu.tieba.im.util.d.a(String.valueOf(this.q));
        l = false;
        m = "";
    }

    @Override // com.baidu.tieba.im.chat.cz, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == r().T() && i == -1) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean b(Bundle bundle) {
        super.b(bundle);
        this.n = new ar(this);
        this.n.a(this.o);
        this.n.a(this.z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.b bVar) {
        UserData next;
        if (this.o != null && bVar != null) {
            com.baidu.adp.lib.util.f.e("eventData uid = " + bVar.c);
            Iterator<UserData> it = this.o.j().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (bVar.c == next.getUserIdLong()) {
                    r().R().a(next);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0027 -> B:16:0x0028). Please submit an issue!!! */
    @Override // com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            try {
                if (keyEvent.getAction() == 0 && this.d != null) {
                    n();
                    if (this.d.t()) {
                        this.d.u();
                        return true;
                    } else if (this.v) {
                        finish();
                        return true;
                    } else {
                        r().S().show();
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<UserData> list) {
        ((SnapGroupChatView) this.d).R().setData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SnapGroupChatView r() {
        return (SnapGroupChatView) this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && this.d != null) {
            dd ddVar = new dd();
            ddVar.b(String.valueOf(this.q));
            ddVar.b = str;
            ddVar.c = str2;
            ddVar.c(-999L);
            ddVar.d(0L);
            q.b().a((com.baidu.tieba.im.message.b) ddVar);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.d != null) {
            com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
            fVar.b(String.valueOf(this.q));
            fVar.b = getString(R.string.snap_group_chat_rule);
            fVar.c(-1000L);
            fVar.d(-1L);
            q.b().a((com.baidu.tieba.im.message.b) fVar);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
        fVar.b(String.valueOf(this.q));
        fVar.b = getString(R.string.snap_group_chat_times_up);
        fVar.c(Long.MAX_VALUE);
        q.b().a((com.baidu.tieba.im.message.b) fVar);
        this.d.a().notifyDataSetChanged();
        this.d.e().setVisibility(8);
    }
}
