package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class dd extends BaseActivity implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.u, com.baidu.adp.widget.ListView.w, com.baidu.tbadk.core.voice.z, com.baidu.tbadk.widget.richText.j {
    private dk a;
    protected VoiceManager h;
    protected boolean j;
    protected Handler c = new Handler();
    protected h d = null;
    protected MsglistModel e = null;
    protected LocalPicModel f = null;
    protected com.baidu.adp.base.g g = null;
    protected cx i = null;
    protected com.baidu.tbadk.img.b<ChatMessage> k = null;
    private long b = -1;
    protected com.baidu.adp.base.g l = new de(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        this.g = new df(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BdLog.i("----onCreate start-----");
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.b = System.currentTimeMillis();
        }
        this.k = new dg(this);
        c();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                String stringExtra = intent.getStringExtra("file_name");
                String str = TbConfig.LOCAL_PIC_DIR;
                if (stringExtra == null) {
                    stringExtra = TbConfig.IMAGE_RESIZED_FILE;
                    str = null;
                }
                if (this.f != null) {
                    this.f.cancelLoadData();
                    this.f = null;
                }
                this.f = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.f.setLoadDataCallBack(this.g);
                this.f.getData();
                this.d.z();
                return;
            }
            int a = com.baidu.tbadk.h.a(this);
            String string = getString(com.baidu.tieba.u.send_msg);
            String string2 = getString(com.baidu.tieba.u.cancel);
            if (i == 12002) {
                if (intent != null && intent.getData() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 12002, 12009, intent.getData(), null, null, null, a, string, string2, "")));
                }
            } else if (i == 12001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 12001, 12010, null, null, null, null, a, string, string2, "")));
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.bb.a(this);
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.bb.b(this);
            }
        }
    }

    public void b(View view, int i, int i2, long j) {
        ChatMessage a = this.e.a(i2);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (a != null && a.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
            this.j = a.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
        }
        if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9) {
            this.d.a(i2, a(i, this.j));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] a(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(getString(com.baidu.tieba.u.operate_copy));
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_img_save));
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
            case 5:
                arrayList.add(TbadkApplication.m252getInst().isHeadsetModeOn() ? getString(com.baidu.tieba.u.group_close_receiver) : getString(com.baidu.tieba.u.group_open_receiver));
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.b = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.b = System.currentTimeMillis();
        }
        c();
        t();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.h != null) {
            this.h.b((Activity) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.d(this);
        }
        if (this.e != null) {
            v();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.z
    public VoiceManager d() {
        return this.h;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        if (this.d == null || this.d.m() == null) {
            return null;
        }
        View findViewWithTag = this.d.m().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tbadk.core.voice.x)) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.x) findViewWithTag;
    }

    private void c() {
        this.h = new VoiceManager();
        this.h.a((Activity) this);
        boolean isHeadsetModeOn = TbadkApplication.m252getInst().isHeadsetModeOn();
        BdLog.d("isUseHeadSet:" + isHeadsetModeOn);
        this.h.c(!isHeadsetModeOn);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView a() {
        if (this.d == null) {
            return null;
        }
        return this.d.m();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int e() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> f() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> g() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> h() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> i() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> j() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        com.baidu.tbadk.core.util.bi.a().a(context, new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void c(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void e(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.d != null) {
                s();
            }
            if (this.d != null && this.d.y()) {
                this.d.z();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s() {
        return this.e.c(this.d.N());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h != null) {
            this.h.c(this);
            boolean isHeadsetModeOn = TbadkApplication.m252getInst().isHeadsetModeOn();
            BdLog.d("isUseHeadSet:" + isHeadsetModeOn);
            this.h.c(!isHeadsetModeOn);
        }
    }

    private void k() {
        if (this.h != null) {
            this.h.g();
        }
    }

    public boolean t() {
        if (com.baidu.tbadk.core.util.x.a()) {
            return true;
        }
        showToast(com.baidu.tieba.u.voice_error_sdcard);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        String k = this.d.k();
        if (TextUtils.isEmpty(k)) {
            BdLog.e("content == null");
            return;
        }
        this.d.l();
        this.c.postDelayed(new dh(this, k), 100L);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        k();
        if (view == this.d.A()) {
            s();
            finish();
        } else if (view == this.d.D()) {
            if (t()) {
                com.baidu.tbadk.core.util.bb.a(this);
            }
        } else if (view == this.d.E()) {
            if (t()) {
                com.baidu.tbadk.core.util.bb.b(this);
            }
        } else if (view == this.d.B()) {
            u();
        } else if (view == this.d.I()) {
            this.d.b(this.e.h());
            this.d.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.h != null) {
            this.h.e(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.d.G()) {
            if (motionEvent.getAction() == 0) {
                if (this.h == null || !this.h.i()) {
                    return true;
                }
                this.h.a(this.d, -1);
                this.d.t();
                this.d.b(true);
                this.d.o();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.h.a((Context) this, 5.0f) * (-1)) {
                    if (this.h != null) {
                        this.h.d();
                    }
                    this.d.t();
                } else {
                    if (this.h != null) {
                        this.h.f();
                    }
                    this.d.p();
                }
                this.d.b(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.h.a((Context) this, 5.0f) * (-1)) {
                    this.d.s();
                    this.d.p();
                    return true;
                }
                this.d.t();
                this.d.o();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        this.e.a(dVar);
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void b() {
        l();
    }

    @Override // com.baidu.adp.widget.ListView.u
    public void f_() {
        this.d.u();
    }

    private void l() {
        this.e.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.g(this);
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.f != null) {
            this.f.cancelLoadData();
            this.f = null;
        }
        if (this.e != null) {
            this.e.a();
        }
        if (this.d != null) {
            this.d.O();
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    public void v() {
        if (this.a == null) {
            this.a = new dk(this, null);
        }
        this.e.a(this.a);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.d.H()) {
            ListView listView = ((AlertDialog) dialogInterface).getListView();
            int intValue = ((Integer) listView.getTag()).intValue();
            View childAt = listView.getChildAt(i);
            if (childAt != null && (childAt instanceof TextView)) {
                String charSequence = ((TextView) childAt).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    a(intValue, charSequence);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str) {
        ChatMessage a = this.e.a(i);
        if (str.equals(getString(com.baidu.tieba.u.operate_copy))) {
            if (a != null && a.getCacheData() != null) {
                com.baidu.adp.lib.util.a.a(a.getContent());
                showToast(com.baidu.tieba.u.op_result_copied);
            }
        } else if (str.equals(getString(com.baidu.tieba.u.msg_at))) {
            if (a != null && a.getUserInfo() != null && a.getUserInfo().getUserName() != null) {
                this.d.b(a.getUserInfo().getUserName());
            }
        } else if (str.equals(getString(com.baidu.tieba.u.msg_delete))) {
            this.e.c(i);
            showToast(com.baidu.tieba.u.op_result_deleted);
        } else if (str.equals(getString(com.baidu.tieba.u.msg_img_save))) {
            String a2 = com.baidu.tieba.im.f.r.a(a.getContent(), true);
            if (a2 != null) {
                this.i = new cx(a2, this);
                this.i.a();
                showToast(com.baidu.tieba.u.op_result_saved);
            }
        } else if (str.equals(getString(com.baidu.tieba.u.group_open_receiver)) || str.equals(getString(com.baidu.tieba.u.group_close_receiver))) {
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
                TbadkApplication.m252getInst().setHeadsetModeOn(false);
                this.h.c(true);
                this.d.J();
                return;
            }
            TbadkApplication.m252getInst().setHeadsetModeOn(true);
            this.h.c(false);
            this.d.K();
        }
    }

    public void a(View view, int i, int i2, long j) {
        ChatMessage a;
        String content;
        ChatMessage a2;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(com.baidu.tieba.u.operation));
                builder.setPositiveButton(getString(com.baidu.tieba.u.msg_resend), new di(this, i2));
                builder.setNegativeButton(getString(com.baidu.tieba.u.delete), new dj(this, i2));
                builder.create().show();
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 5:
                if (!t() || (a2 = this.e.a(i2)) == null || !com.baidu.tieba.im.f.r.c(a2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(this, TbadkApplication.getCurrentAccount(), TbadkApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage a3 = this.e.a(i2);
                if (a3 != null && com.baidu.tieba.im.f.r.e(a3) && (a = this.e.a(i2)) != null && (content = a.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.f.b.a(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.f.b.a(optJSONObject.optString("groupId"), 0L), 2);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.e.a(i, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.e.b(i);
    }
}
