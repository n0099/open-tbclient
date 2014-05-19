package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
/* loaded from: classes.dex */
public class LiveRoomSettingActivity extends BaseActivity {
    private bi e;
    private bh f;
    private String g;
    private String h;
    private final String c = "key_url";
    private final String d = "key_pid";
    private com.baidu.adp.framework.listener.b i = new bd(this, 0);
    private com.baidu.adp.framework.listener.b j = new be(this, 0);
    DialogInterface.OnClickListener a = new bf(this);
    DialogInterface.OnClickListener b = new bg(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ai.class, LiveRoomSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a();
        a(bundle);
        f();
    }

    private void a() {
        this.e = new bi(this);
        this.e.a(this.b);
        this.e.b(this.a);
        this.e.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.e.a(i);
    }

    private void a(Bundle bundle) {
        this.f = new bh();
        if (bundle == null) {
            if (getIntent() != null) {
                a(getIntent());
                return;
            }
            return;
        }
        b(bundle);
    }

    private void b(Bundle bundle) {
        this.f.a(bundle.getInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0));
        this.g = bundle.getString("key_url");
        this.h = bundle.getString("key_pid");
        this.f.a(this.h);
    }

    private void a(Intent intent) {
        this.f.a(intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0));
        this.g = intent.getStringExtra("key_url");
        this.h = intent.getStringExtra("key_pid");
        this.f.a(this.h);
    }

    private void b() {
        registerListener(MessageTypes.CMD_UPDATE_LIVE_GROUP, this.i);
        registerListener(MessageTypes.CMD_GET_LIVE_GROUP_INFO, this.j);
    }

    private void c() {
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.f.a());
        bundle.putString("key_url", this.g);
        bundle.putString("key_pid", this.h);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.e.a()) {
            e();
            this.e.p();
            this.e.q();
        } else if (view == this.e.c() || view == this.e.b()) {
            if (this.e.g() != null) {
                this.e.g().show();
            }
        } else if (view == this.e.d()) {
            if (!d()) {
                finish();
            }
        } else if (view == this.e.h()) {
            com.baidu.tbadk.core.atomData.d dVar = new com.baidu.tbadk.core.atomData.d(this, String.valueOf(this.f.a()));
            dVar.setIntentAction(IntentAction.ActivityForResult);
            dVar.setRequestCode(23002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, dVar));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == this.e.g()) {
            switch (i) {
                case 0:
                    com.baidu.tbadk.core.util.bb.a(this);
                    return;
                case 1:
                    com.baidu.tbadk.core.util.bb.c(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 1);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.b);
                    if (photoUrlData != null) {
                        com.baidu.tbadk.core.util.aw.a().b(photoUrlData.getSmallurl(), com.baidu.tbadk.core.util.x.c(TbConfig.GROUP_HEAD_FILE), true, false, true);
                        this.f.a(photoUrlData.getPicId());
                        this.f.a(true);
                        this.e.a(photoUrlData.getSmallurl());
                        this.g = photoUrlData.getSmallurl();
                        this.h = photoUrlData.getPicId();
                        return;
                    }
                    return;
                case 23002:
                    if (intent != null) {
                        this.e.b(intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.TOTAL, 0));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.bb.a(this);
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.bb.b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        if (this.e != null) {
            this.e.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            showToast(com.baidu.tieba.u.neterror);
        } else {
            showToast(str);
        }
    }

    private boolean d() {
        if (this.e.o() && (this.f.b() || this.e.i())) {
            this.e.k();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.e.j()) {
            showToast(com.baidu.tieba.u.group_step_name_error);
            return;
        }
        this.e.l();
        this.f.b(this.e.e());
        this.f.c(this.e.f());
        this.f.c();
        TiebaStatic.eventStat(getBaseContext(), "edit_live_brief", "click");
    }

    private void f() {
        this.e.l();
        this.f.d();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !d()) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.e.r() != null && this.e.s() != null) {
            int[] iArr = new int[2];
            this.e.r().getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            this.e.s().getLocationInWindow(iArr2);
            if (!new Rect(iArr[0], iArr[1], iArr2[0] + this.e.s().getWidth(), iArr2[1] + this.e.s().getHeight()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.e.p();
            }
        } else {
            this.e.p();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
