package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.util.DialogUtil;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateGroupActivityActivity extends BaseFragmentActivity implements View.OnClickListener {
    private e aYK;
    private d aYL;
    private boolean aYM = false;
    private com.baidu.adp.framework.listener.e ayS = new a(this, 103120);

    public static void j(Context context, int i) {
        if (context != null) {
            Intent intent = new Intent(context, CreateGroupActivityActivity.class);
            intent.putExtra("gid", i);
            intent.putExtra("isedit", false);
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, int i, GroupActivityData groupActivityData, int i2) {
        if (activity != null && i != 0 && groupActivityData != null) {
            Intent intent = new Intent(activity, CreateGroupActivityActivity.class);
            intent.putExtra("gid", i);
            intent.putExtra("isedit", true);
            intent.putExtra("aid", groupActivityData.getActivityId());
            intent.putExtra("name", groupActivityData.getgActivityTitle());
            intent.putExtra("time", groupActivityData.getgActivityTime());
            intent.putExtra("area", groupActivityData.getgActivityArea());
            intent.putExtra("content", groupActivityData.getgActivityContent());
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HN();
        this.aYL = new d(this);
        this.aYK = new e(this);
        if (this.aYL.Ob() != null) {
            if (bundle != null) {
                this.aYL.Ob().setGroupId(bundle.getInt("gid", 0));
                this.aYM = bundle.getBoolean("isedit", false);
                if (this.aYM) {
                    this.aYL.Ob().setActivityId(bundle.getInt("aid", 0));
                    this.aYL.Ob().setgActivityTitle(bundle.getString("name"));
                    this.aYL.Ob().setgActivityArea(bundle.getString("area"));
                    this.aYL.Ob().setgActivityContent(bundle.getString("content"));
                    this.aYL.Ob().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.aYL.Ob().setGroupId(getIntent().getIntExtra("gid", 0));
                this.aYM = getIntent().getBooleanExtra("isedit", false);
                if (this.aYM) {
                    this.aYL.Ob().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.aYL.Ob().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.aYL.Ob().setgActivityArea(getIntent().getStringExtra("area"));
                    this.aYL.Ob().setgActivityContent(getIntent().getStringExtra("content"));
                    this.aYL.Ob().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.aYK.a(this.aYL.Ob(), this.aYM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HN();
        if (this.aYL == null) {
            this.aYL = new d(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.aYL.Ob() != null) {
            this.aYL.Ob().setGroupId(intent.getIntExtra("gid", 0));
            this.aYM = getIntent().getBooleanExtra("isedit", false);
            if (this.aYM) {
                this.aYL.Ob().setActivityId(intent.getIntExtra("aid", 0));
                this.aYL.Ob().setgActivityTitle(getIntent().getStringExtra("name"));
                this.aYL.Ob().setgActivityArea(getIntent().getStringExtra("area"));
                this.aYL.Ob().setgActivityContent(getIntent().getStringExtra("content"));
                this.aYL.Ob().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.aYK == null) {
            this.aYK = new e(this);
        }
        this.aYK.a(this.aYL.Ob(), this.aYM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.aYL.Ob() != null) {
            i = this.aYL.Ob().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.aYK.getTitle());
        bundle.putString("content", this.aYK.getContent());
        bundle.putString("area", this.aYK.Og());
        bundle.putLong("time", this.aYK.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        if (this.aYK != null) {
            this.aYK.onChangeSkinType(i);
        }
    }

    private void HN() {
        registerListener(this.ayS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aYL.cancelMessage();
        this.aYK.destroy();
        MessageManager.getInstance().unRegisterListener(this.ayS);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aYK.Oe()) {
            Oa();
        } else if (view == this.aYK.Of() && this.aYL != null && this.aYL.Ob() != null) {
            long time = this.aYK.getTime();
            if ((!this.aYM || this.aYK.Oh()) && 1000 * time < System.currentTimeMillis()) {
                showToast(y.group_activity_time_val);
                return;
            }
            this.aYL.Ob().setgActivityArea(this.aYK.Og());
            this.aYL.Ob().setgActivityContent(this.aYK.getContent());
            this.aYL.Ob().setgActivityTime(time);
            this.aYL.Ob().setgActivityTitle(this.aYK.getTitle());
            showProgressBar();
            this.aYL.bK(this.aYM);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Oa();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void Oa() {
        DialogUtil.quitCreateGroupActivity(this, this.aYM, new b(this), new c(this));
    }
}
