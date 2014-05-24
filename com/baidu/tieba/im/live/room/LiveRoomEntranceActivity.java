package com.baidu.tieba.im.live.room;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LiveRoomEntranceActivity extends BaseActivity {
    private az a;
    private ay b;
    private AnimationSet c;
    private final Handler d = new av(this);
    private final Runnable e = new aw(this);
    private com.baidu.adp.framework.listener.b f = new ax(this, MessageTypes.CMD_ADD_LIVE_GROUP);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.af.class, LiveRoomEntranceActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new az(this);
        this.b = new ay(this);
        this.b.a(getIntent(), bundle);
        registerListener(this.f);
        this.c = (AnimationSet) AnimationUtils.loadAnimation(this, com.baidu.tieba.p.live_room_entrance_spot_anim);
        this.a.e().setAnimation(this.c);
        this.d.post(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.d()) {
            if (this.a.c().getText() != null) {
                showProgressBar();
                this.b.a(this.a.c().getText().toString());
                this.b.b();
            }
        } else if (view == this.a.b()) {
            this.a.a();
            finish();
        }
    }
}
