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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.CommonGroupChatActiviy;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.TopicSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.SnapGroupMsglistModel;
import com.baidu.tieba.im.model.bc;
import com.baidu.tieba.im.model.cb;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class SnapGroupChatActivity extends CommonGroupChatActiviy implements AbsListView.OnScrollListener, bc {
    private cb m;
    private RandChatRoomData n;
    private com.baidu.tieba.im.model.j o;
    private int p;
    private h q;
    private int s;
    private boolean t;
    private boolean u;
    private String w;
    private String x;
    private int r = 0;
    private final Handler v = new Handler();
    private final CustomMessageListener y = new a(this, MessageTypes.CMD_CHAT_ROOM_EVENT);
    private final com.baidu.adp.framework.listener.b z = new b(this, 0);

    public static void a(Context context, RandChatRoomData randChatRoomData, String str, String str2, String str3, int i) {
        BdLog.d("simon", "startActivity", "started");
        Intent intent = new Intent(context, SnapGroupChatActivity.class);
        if (randChatRoomData == null) {
            BdLog.w("RandChatRoomData is null, skip launch SnapGroupChatActivity");
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
        if (Math.abs(i - this.r) == 1) {
            if (!x().R().a() && i > this.r) {
                x().R().b();
            } else if (x().R().a() && i < this.r) {
                x().R().c();
            }
        }
        if (i != this.r) {
            this.r = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        try {
        } catch (Exception e) {
            BdLog.e(getLocalClassName(), "onClick", e.getMessage());
        }
        if (view == this.d.A()) {
            if (this.u) {
                finish();
                return;
            } else {
                x().S().show();
                return;
            }
        }
        if (view == x().W()) {
            if (this.u) {
                w();
            } else {
                x().T().show();
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.tieba.im.model.bc
    public void a(int i) {
        x().U().setVisibility(4);
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
        this.o = new com.baidu.tieba.im.model.j();
        this.o.setUniqueId(getUniqueId());
        this.o.registerListener(this.z);
        this.s = getIntent().getIntExtra("restart_time", 0);
        this.w = getIntent().getStringExtra("topic_title");
        this.x = getIntent().getStringExtra("topic_content");
        BdLog.d("simon", "onCreate", "restart time = " + this.s);
        if (this.n == null) {
            BdLog.e("RandChatRoomData is null, finish activity");
            showToast("初始化失败，请重新尝试。");
            finish();
        } else {
            BdLog.d("simon", "onCreate", this.n.toString());
        }
        if (this.s >= 2) {
            BdLog.d("simon", "initView", "disableChangeGroupBtn");
            x().W().setOnClickListener(new c(this));
        }
        this.q = new h(this, this.n.h() * 1000);
        this.q.b();
        this.m.b(this.p);
        this.v.postDelayed(new d(this), 300L);
        x().V().a(this.n.g() * 1000, 500L, TbConfig.USE_TIME_INTERVAL);
        x().V().setOnFinishlistener(new e(this));
        x().V().setFinalText(getString(y.snap_group_chat_remaining));
        x().V().a();
        this.e.a(this);
        com.baidu.tbadk.core.f.b(getApplicationContext(), "snap_chat_activity");
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        BdLog.d("simon", "initView", "initView");
        this.d = new SnapGroupChatView(this, this.e.i());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (((SnapGroupMsglistModel) this.e).b() != null) {
            this.d.a(this.e.h(), ((SnapGroupMsglistModel) this.e).b().getGroupId());
        }
        this.d.a(new f(this));
        this.d.m().setOnScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.a(getString(y.snap_group_chat_chatting), false);
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
                ChatMessage a = this.e.a(i2);
                if (a != null && a.getUserInfo() != null && a.getUserInfo().getUserName() != null) {
                    this.d.b(a.getUserInfo().getUserName());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void w() {
        showLoadingDialog(getString(y.group_tab_enterchatroom_loading), new g(this));
        this.o.a(this.p);
        com.baidu.tieba.im.e.i.a(String.valueOf(this.p));
        com.baidu.tbadk.core.f.a(getApplicationContext(), "snap_chat_change_room");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.p != 0) {
            boolean booleanExtra = getIntent().getBooleanExtra("need_freeze_user", false);
            BdLog.d("simon", "onDestroy", "shouldFreeze = " + booleanExtra);
            if (booleanExtra) {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + String.valueOf(System.currentTimeMillis() + 900000));
            } else {
                com.baidu.tbadk.core.sharedPref.b.a().b("chat_room_cool_down", String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + String.valueOf(0L));
            }
            this.m.a(this.p, booleanExtra, 1);
        }
        x().V().b();
        x().U().b();
        this.q.a();
        com.baidu.tieba.im.e.i.a(String.valueOf(this.p));
        a = false;
        b = "";
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == x().T() && i == -1) {
            w();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        this.m = new cb(this);
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
            BdLog.e(e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.b bVar) {
        UserData next;
        if (this.n != null && bVar != null) {
            BdLog.d("eventData uid = " + bVar.c);
            Iterator<UserData> it = this.n.j().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (bVar.c == next.getUserIdLong()) {
                    x().R().a(next);
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
                    if (this.d.y()) {
                        this.d.z();
                        return true;
                    } else if (this.u) {
                        finish();
                        return true;
                    } else {
                        x().S().show();
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
    public SnapGroupChatView x() {
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
            w.b().a(topicSystemGroupChatMessage);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.d != null) {
            FakeSystemGroupChatMessage fakeSystemGroupChatMessage = new FakeSystemGroupChatMessage();
            fakeSystemGroupChatMessage.setGroupId(String.valueOf(this.p));
            fakeSystemGroupChatMessage.mSystemMsg = getString(y.snap_group_chat_rule);
            fakeSystemGroupChatMessage.setRecordId(-1000L);
            fakeSystemGroupChatMessage.setMsgId(-1L);
            w.b().a(fakeSystemGroupChatMessage);
            this.d.a().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        FakeSystemGroupChatMessage fakeSystemGroupChatMessage = new FakeSystemGroupChatMessage();
        fakeSystemGroupChatMessage.setGroupId(String.valueOf(this.p));
        fakeSystemGroupChatMessage.mSystemMsg = getString(y.snap_group_chat_times_up);
        fakeSystemGroupChatMessage.setRecordId(Long.MAX_VALUE);
        w.b().a(fakeSystemGroupChatMessage);
        this.d.a().notifyDataSetChanged();
        this.d.e().setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean p() {
        return true;
    }
}
