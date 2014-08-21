package com.baidu.tieba.im.live.room;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class LiveRoomEntranceActivity extends BaseActivity {
    private bb a;
    private ba b;
    private AnimationSet c;
    private final Handler d = new ax(this);
    private final Runnable e = new ay(this);
    private com.baidu.adp.framework.listener.d f = new az(this, 107101);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.an.class, LiveRoomEntranceActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new bb(this);
        this.b = new ba(this);
        this.b.a(getIntent(), bundle);
        registerListener(this.f);
        this.c = (AnimationSet) AnimationUtils.loadAnimation(this, com.baidu.tieba.o.live_room_entrance_spot_anim);
        this.a.e().setAnimation(this.c);
        this.d.post(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.f();
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
