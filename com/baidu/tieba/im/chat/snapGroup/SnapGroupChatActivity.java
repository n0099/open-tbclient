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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonGroupChatActiviy;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.TopicSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.SnapGroupMsglistModel;
import com.baidu.tieba.im.model.al;
import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.x;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class SnapGroupChatActivity extends CommonGroupChatActiviy implements AbsListView.OnScrollListener, al {
    public static boolean a;
    public static String b = "";
    private bf m;
    private RandChatRoomData n;
    private com.baidu.tieba.im.model.h o;
    private int p;
    private h q;
    private int s;
    private boolean t;
    private boolean u;
    private String w;
    private String x;
    private int r = 0;
    private final Handler v = new Handler();
    private final CustomMessageListener y = new a(this, 2001119);
    private final com.baidu.adp.framework.listener.d z = new b(this, 0);

    public static void a(Context context, RandChatRoomData randChatRoomData, String str, String str2, String str3, int i) {
        Intent intent = new Intent(context, SnapGroupChatActivity.class);
        if (randChatRoomData != null) {
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
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (Math.abs(i - this.r) == 1) {
            if (!w().S().a() && i > this.r) {
                w().S().b();
            } else if (w().S().a() && i < this.r) {
                w().S().c();
            }
        }
        if (i != this.r) {
            this.r = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.B()) {
            if (this.u) {
                finish();
                return;
            } else {
                w().T().show();
                return;
            }
        }
        if (view == w().X()) {
            if (this.u) {
                v();
            } else {
                w().U().show();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tieba.im.model.al
    public void a(int i) {
        w().V().setVisibility(4);
        if (this.q != null) {
            this.q.a();
        }
        this.q = new h(this, this.n.h() * 1000);
        this.q.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = getIntent().getIntExtra("gid", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        if (bundleExtra != null) {
            this.n = (RandChatRoomData) bundleExtra.getParcelable("rand_chat_room_data");
        }
        this.o = new com.baidu.tieba.im.model.h(this);
        this.o.setUniqueId(getUniqueId());
        this.o.registerListener(this.z);
        this.s = getIntent().getIntExtra("restart_time", 0);
        this.w = getIntent().getStringExtra("topic_title");
        this.x = getIntent().getStringExtra("topic_content");
        if (this.n == null) {
            showToast("初始化失败，请重新尝试。");
            finish();
        }
        if (this.s >= 2) {
            w().X().setOnClickListener(new c(this));
        }
        this.q = new h(this, this.n.h() * 1000);
        this.q.b();
        this.m.b(this.p);
        this.v.postDelayed(new d(this), 300L);
        w().W().a(this.n.g() * 1000, 500L, TbConfig.USE_TIME_INTERVAL);
        w().W().setOnFinishlistener(new e(this));
        w().W().setFinalText(getString(x.snap_group_chat_remaining));
        w().W().a();
        this.e.a((al) this);
        com.baidu.tbadk.core.f.b(getApplicationContext(), "snap_chat_activity");
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        this.d = new SnapGroupChatView(this, this.e.j());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (((SnapGroupMsglistModel) this.e).c() != null) {
            this.d.a(this.e.i(), ((SnapGroupMsglistModel) this.e).c().getGroupId());
        }
        this.d.a(new f(this));
        this.d.m().setOnScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.a(getString(x.snap_group_chat_chatting), false);
        }
        this.t = false;
        a = false;
        b = String.valueOf(this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.t = true;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage b2 = this.e.b(i2);
                if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getUserName() != null) {
                    String userName = b2.getUserInfo().getUserName();
                    if (this.d != null) {
                        this.d.b(userName);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void v() {
        showLoadingDialog(getString(x.group_tab_enterchatroom_loading), new g(this));
        this.o.a(this.p, false);
        com.baidu.tbadk.core.f.a(getApplicationContext(), "snap_chat_change_room");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.p != 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("need_freeze_user", false);
            if (booleanExtra) {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + String.valueOf(System.currentTimeMillis() + 900000));
            } else {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + String.valueOf(0L));
            }
            this.m.a(this.p, booleanExtra, 1);
        }
        if (w() != null) {
            w().W().b();
            w().V().b();
        }
        this.q.a();
        a = false;
        b = "";
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == w().U() && i == -1) {
            v();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        this.m = new bf(this);
        this.m.a(this.n);
        this.m.a(this.z);
        this.m.a(this.y);
        try {
            this.e = new SnapGroupMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            if (bundle != null) {
                a(bundle);
            } else {
                k();
            }
            return l();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.b bVar) {
        UserData next;
        if (this.n != null && bVar != null) {
            Iterator<UserData> it = this.n.j().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (bVar.c == next.getUserIdLong()) {
                    if (w() != null) {
                        w().S().a(next);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0027 -> B:16:0x0028). Please submit an issue!!! */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            try {
                if (keyEvent.getAction() == 0 && this.d != null) {
                    s();
                    if (this.d.z()) {
                        this.d.A();
                        return true;
                    } else if (this.u) {
                        finish();
                        return true;
                    } else if (w() != null) {
                        w().T().show();
                        return true;
                    } else {
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
        ((SnapGroupChatView) this.d).S().setData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SnapGroupChatView w() {
        return (SnapGroupChatView) this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && this.d != null) {
            TopicSystemGroupChatMessage topicSystemGroupChatMessage = new TopicSystemGroupChatMessage();
            topicSystemGroupChatMessage.setGroupId(String.valueOf(this.p));
            topicSystemGroupChatMessage.mSystemMsg = str;
            topicSystemGroupChatMessage.mSystemContent = str2;
            topicSystemGroupChatMessage.setRecordId(-999L);
            topicSystemGroupChatMessage.setMsgId(0L);
            w.a().d(topicSystemGroupChatMessage);
            this.e.i().getChatMessages().add(topicSystemGroupChatMessage);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.d != null) {
            FakeSystemGroupChatMessage fakeSystemGroupChatMessage = new FakeSystemGroupChatMessage();
            fakeSystemGroupChatMessage.setGroupId(String.valueOf(this.p));
            fakeSystemGroupChatMessage.mSystemMsg = getString(x.snap_group_chat_rule);
            fakeSystemGroupChatMessage.setRecordId(-1000L);
            fakeSystemGroupChatMessage.setMsgId(-1L);
            w.a().d(fakeSystemGroupChatMessage);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        FakeSystemGroupChatMessage fakeSystemGroupChatMessage = new FakeSystemGroupChatMessage();
        fakeSystemGroupChatMessage.setGroupId(String.valueOf(this.p));
        fakeSystemGroupChatMessage.mSystemMsg = getString(x.snap_group_chat_times_up);
        fakeSystemGroupChatMessage.setRecordId(Long.MAX_VALUE);
        w.a().d(fakeSystemGroupChatMessage);
        this.d.a().notifyDataSetChanged();
        this.d.e().setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(bt btVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void b(Bundle bundle) {
        super.b(bundle);
        z();
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void a(Intent intent) {
        super.a(intent);
        z();
    }

    private void z() {
        if (this.e == null || !(this.e instanceof SnapGroupMsglistModel)) {
            b = "";
            return;
        }
        GroupData c = ((SnapGroupMsglistModel) this.e).c();
        if (c != null) {
            b = String.valueOf(c.getGroupId());
        } else {
            b = "";
        }
    }
}
