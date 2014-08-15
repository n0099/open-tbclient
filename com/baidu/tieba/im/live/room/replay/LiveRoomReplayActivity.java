package com.baidu.tieba.im.live.room.replay;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ao;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class LiveRoomReplayActivity extends BaseActivity {
    private View a;
    private NavigationBar b;
    private View c;
    private LiveRoomReplayPlayer d;
    private BdListView e = null;
    private com.baidu.tieba.im.live.room.intro.d f = null;
    private h g = null;
    private String h = null;
    private String i = null;
    private int j = -1;
    private final Handler k = new a(this);
    private final CustomMessageListener l = new b(this, 2001160);
    private final com.baidu.adp.framework.listener.d m = new c(this, 0);
    private final CustomMessageListener n = new d(this, 2001161);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ao.class, LiveRoomReplayActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 0;
        super.onCreate(bundle);
        com.baidu.tieba.im.live.d.b().c();
        registerListener(this.l);
        registerListener(this.n);
        String str = "";
        if (bundle != null) {
            this.h = bundle.getString(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            this.i = bundle.getString(com.baidu.tbadk.core.frameworkData.a.REPLAY_URL);
            i = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
            i2 = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID);
            str = bundle.getString(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME);
        } else if (getIntent() != null) {
            this.h = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            this.i = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.REPLAY_URL);
            i = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0);
            i2 = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID, 0);
            str = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME);
        } else {
            i = 0;
        }
        if (this.i == null) {
            finish();
            return;
        }
        this.f = new com.baidu.tieba.im.live.room.intro.d(i, i2, str);
        registerListener(107004, this.m);
        this.f.a(this);
        a();
        c();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.live.d.b().k();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            finish();
        } else if (view == this.d.getPauseOrPlayView()) {
            if (this.j == 19) {
                com.baidu.tieba.im.live.d.b().l();
            } else if (this.j == 20) {
                com.baidu.tieba.im.live.d.b().m();
            } else if (this.j == 17) {
                com.baidu.tieba.im.live.d.b().a(this.i, this.d.getNextStartPosition());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f.a(bundle, com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
        this.f.b(bundle, com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID);
    }

    private void a() {
        setContentView(v.live_room_replay_activity);
        this.a = findViewById(u.parent);
        this.b = (NavigationBar) findViewById(u.view_navigation_bar);
        this.c = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setOnClickListener(this);
        if (this.h == null) {
            this.b.a("");
        } else {
            this.b.a(this.h);
        }
        this.d = (LiveRoomReplayPlayer) findViewById(u.view_player);
        this.d.getPauseOrPlayView().setOnClickListener(this);
        this.e = (BdListView) findViewById(u.layout_other_live_list);
        this.g = new h(this);
        this.e.setAdapter((ListAdapter) this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(str, 10, new e(this), getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.c(i);
        getLayoutMode().a(false);
        getLayoutMode().a(this.a);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(false);
        getLayoutMode().a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        switch (com.baidu.tieba.im.live.d.b().r()) {
            case -1:
                showToast(x.live_error_system_not_support);
                finish();
                return;
            case 0:
                com.baidu.tieba.im.live.d.b().a(this.i, 0);
                return;
            case 1:
            case 2:
                com.baidu.tieba.im.live.d.b().a(null, LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, null, this.i, false);
                return;
            case 3:
                com.baidu.tieba.im.live.d.b().a(null, LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY, null, this.i, false);
                return;
            default:
                return;
        }
    }

    private void c() {
        BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
        if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            showToast(x.neterror);
        } else if (statusInfo != BdNetUtil.NetworkStateInfo.WIFI) {
            com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(x.live_chat_room_nonwifi_prompts_play).setPositiveButton(x.live_chat_room_nonwifi_prompts_play_yes, new f(this)).setNegativeButton(x.live_chat_room_nonwifi_prompts_play_no, new g(this)).create(), this);
        } else {
            this.k.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        this.d.getHeadView().a(str, 10, false);
        if (!StringUtils.isNull(str2)) {
            this.d.getNameView().setText(String.valueOf(getString(x.live_chat_room_host_name_prefix)) + str2);
        }
        this.d.getLikeView().setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveCardData> list) {
        this.g.a(list);
        this.g.notifyDataSetChanged();
    }
}
