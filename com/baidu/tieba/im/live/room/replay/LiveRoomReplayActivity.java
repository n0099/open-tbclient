package com.baidu.tieba.im.live.room.replay;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ah;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class LiveRoomReplayActivity extends BaseActivity {
    private com.baidu.tbadk.core.util.b a;
    private View b;
    private NavigationBar c;
    private View d;
    private LiveRoomReplayPlayer e;
    private BdListView f = null;
    private com.baidu.tieba.im.live.room.intro.d g = null;
    private i h = null;
    private String i = null;
    private String j = null;
    private int k = -1;
    private final Handler l = new a(this);
    private final CustomMessageListener m = new b(this, MessageTypes.CMD_PLAY_PROGRESS_CHANGED);
    private final com.baidu.adp.framework.listener.b n = new c(this, 0);
    private final CustomMessageListener o = new d(this, MessageTypes.CMD_LIVE_STATUS_CHANGE);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ah.class, LiveRoomReplayActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 0;
        super.onCreate(bundle);
        com.baidu.tieba.im.live.b.b().c();
        MessageManager.getInstance().registerListener(this.m);
        MessageManager.getInstance().registerListener(this.o);
        String str = "";
        if (bundle != null) {
            this.i = bundle.getString(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            this.j = bundle.getString(com.baidu.tbadk.core.frameworkData.a.REPLAY_URL);
            i = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
            i2 = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID);
            str = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME);
        } else if (getIntent() != null) {
            this.i = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            this.j = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.REPLAY_URL);
            i = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0);
            i2 = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID, 0);
            str = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME);
        } else {
            i = 0;
        }
        if (this.j == null) {
            finish();
            return;
        }
        this.g = new com.baidu.tieba.im.live.room.intro.d(i, i2, str);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_QUERY_LIVE_ROOM_INTRO, this.n);
        this.g.a(this);
        a();
        c();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.live.b.b().k();
        MessageManager.getInstance().unRegisterListener(this.n);
        MessageManager.getInstance().unRegisterListener(this.m);
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d) {
            finish();
        } else if (view == this.e.getPauseOrPlayView()) {
            BdLog.d("PP clicked when playing is " + this.k);
            if (this.k == 19) {
                com.baidu.tieba.im.live.b.b().l();
            } else if (this.k == 20) {
                com.baidu.tieba.im.live.b.b().m();
            } else if (this.k == 17) {
                com.baidu.tieba.im.live.b.b().a(this.j, this.e.getNextStartPosition());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.a(bundle, com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
        this.g.b(bundle, com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID);
    }

    private void a() {
        setContentView(w.live_room_replay_activity);
        this.b = findViewById(v.parent);
        this.c = (NavigationBar) findViewById(v.view_navigation_bar);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setOnClickListener(this);
        if (this.i == null) {
            this.c.a("");
        } else {
            this.c.a(this.i);
        }
        this.e = (LiveRoomReplayPlayer) findViewById(v.view_player);
        this.e.getPauseOrPlayView().setOnClickListener(this);
        this.f = (BdListView) findViewById(v.layout_other_live_list);
        this.h = new i(this);
        this.f.setAdapter((ListAdapter) this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) && this.a == null) {
            this.a = new com.baidu.tbadk.core.util.b(this);
            this.a.b(str, new e(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        getLayoutMode().a(false);
        getLayoutMode().a(this.b);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(false);
        getLayoutMode().a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        switch (com.baidu.tieba.im.live.b.b().r()) {
            case -1:
                showToast(y.live_error_system_not_support);
                finish();
                return;
            case 0:
                com.baidu.tieba.im.live.b.b().a(this.j, 0);
                return;
            case 1:
            case 2:
                com.baidu.tieba.im.live.b.b().a(null, LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, null, this.j, false);
                return;
            case 3:
                com.baidu.tieba.im.live.b.b().a(null, LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, null, this.j, false);
                return;
            default:
                return;
        }
    }

    private void c() {
        BdNetUtil.NetworkStateInfo a = BdNetUtil.a();
        if (a == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            showToast(y.neterror);
        } else if (a != BdNetUtil.NetworkStateInfo.WIFI) {
            new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(y.live_chat_room_nonwifi_prompts_play).setPositiveButton(y.live_chat_room_nonwifi_prompts_play_yes, new f(this)).setNegativeButton(y.live_chat_room_nonwifi_prompts_play_no, new g(this)).create().show();
        } else {
            this.l.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        if (this.a == null) {
            this.a = new com.baidu.tbadk.core.util.b(this);
        }
        com.baidu.adp.widget.a.a c = this.a.c(str);
        if (c != null) {
            c.a(this.e.getHeadView());
        } else {
            this.e.getHeadView().setTag(str);
            this.a.c(str, new h(this));
        }
        if (!StringUtils.isNull(str2)) {
            this.e.getNameView().setText(String.valueOf(getString(y.live_chat_room_host_name_prefix)) + str2);
        }
        this.e.getLikeView().setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveCardData> list) {
        this.h.a(list);
        this.h.notifyDataSetChanged();
    }
}
