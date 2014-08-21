package com.baidu.tieba.im.chat;

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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity extends BaseActivity implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, com.baidu.adp.widget.ListView.x, com.baidu.adp.widget.ListView.z, com.baidu.tbadk.core.voice.aa, com.baidu.tbadk.widget.richText.j {
    private static String b = "tbgametype";
    protected VoiceManager h;
    protected boolean j;
    protected Handler c = new Handler();
    protected g d = null;
    protected MsglistModel e = null;
    protected LocalPicModel f = null;
    protected com.baidu.adp.base.h g = null;
    protected df i = null;
    protected com.baidu.tbadk.img.b<ChatMessage> k = null;
    private long a = -1;
    protected com.baidu.adp.base.h l = new di(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        this.g = new dj(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.a = System.currentTimeMillis();
        }
        this.k = new dk(this);
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
                this.d.A();
                return;
            }
            int a = com.baidu.tbadk.k.a(this);
            String string = getString(com.baidu.tieba.x.send_msg);
            String string2 = getString(com.baidu.tieba.x.cancel);
            if (i == 12002) {
                if (intent != null && intent.getData() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cg(this, 12002, 12009, intent.getData(), null, null, null, a, string, string2, "")));
                }
            } else if (i == 12001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cg(this, 12001, 12010, null, null, null, null, a, string, string2, "")));
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.ax.a(this);
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.ax.b(this);
            }
        }
    }

    public void b(View view, int i, int i2, long j) {
        ChatMessage b2 = this.e.b(i2);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (b2 != null && b2.getLocalData() != null && b2.getLocalData().getStatus().shortValue() != 1) {
            if (b2.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.j = b2.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10) {
                this.d.a(i2, a(i, this.j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] a(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(getString(com.baidu.tieba.x.operate_copy));
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_img_save));
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
            case 5:
                arrayList.add(TbadkApplication.m252getInst().isHeadsetModeOn() ? getString(com.baidu.tieba.x.group_close_receiver) : getString(com.baidu.tieba.x.group_open_receiver));
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.a = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.a = System.currentTimeMillis();
        }
        c();
        t();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.h != null) {
            this.h.onStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.onPause(this);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        return this.h;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        if (this.d == null || this.d.m() == null) {
            return null;
        }
        View findViewWithTag = this.d.m().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tbadk.core.voice.y)) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.y) findViewWithTag;
    }

    private void c() {
        this.h = new VoiceManager();
        this.h.onCreate(this);
        this.h.setSpeakerphoneOn(!TbadkApplication.m252getInst().isHeadsetModeOn());
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
        com.baidu.tbadk.core.util.bg.a().a(context, new String[]{str});
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
            if (this.d != null && this.d.z()) {
                this.d.A();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s() {
        return this.e.c(this.d.O());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h != null) {
            this.h.onResume(this);
            this.h.setSpeakerphoneOn(!TbadkApplication.m252getInst().isHeadsetModeOn());
        }
    }

    private void k() {
        if (this.h != null) {
            this.h.stopPlay();
        }
    }

    public boolean t() {
        if (com.baidu.tbadk.core.util.s.a()) {
            return true;
        }
        showToast(com.baidu.tieba.x.voice_error_sdcard);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        String k = this.d.k();
        if (!TextUtils.isEmpty(k)) {
            this.d.l();
            this.c.postDelayed(new dl(this, k), 100L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.d != null) {
            k();
            if (view == this.d.B()) {
                s();
                this.d.f();
                finish();
            } else if (view == this.d.E()) {
                if (t()) {
                    com.baidu.tbadk.core.util.ax.a(this);
                }
            } else if (view == this.d.F()) {
                if (t()) {
                    com.baidu.tbadk.core.util.ax.b(this);
                }
            } else if (view == this.d.C()) {
                u();
            } else if (view == this.d.J()) {
                this.d.b(this.e.i());
                this.d.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.h != null) {
            this.h.onSaveInstanceState(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.d.H()) {
            if (motionEvent.getAction() == 0) {
                if (this.h == null || !this.h.isAllowRecord()) {
                    return true;
                }
                this.h.startRecord(this.d, -1);
                this.d.u();
                this.d.b(true);
                this.d.p();
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.j.a((Context) this, 5.0f) * (-1)) {
                    if (this.h != null) {
                        this.h.cancelRecord();
                    }
                    this.d.u();
                } else {
                    if (this.h != null) {
                        this.h.stopRecord();
                    }
                    this.d.q();
                }
                this.d.b(false);
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.j.a((Context) this, 5.0f) * (-1)) {
                    this.d.t();
                    this.d.q();
                    return true;
                }
                this.d.u();
                this.d.p();
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

    @Override // com.baidu.adp.widget.ListView.z
    public void b() {
        l();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        this.d.v();
    }

    private void l() {
        this.e.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
        if (this.h != null) {
            this.h.onDestory(this);
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.f != null) {
            this.f.cancelLoadData();
            this.f = null;
        }
        if (this.d != null) {
            this.d.P();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.d.I()) {
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
        ChatMessage b2 = this.e.b(i);
        if (str.equals(getString(com.baidu.tieba.x.operate_copy))) {
            if (b2 != null && b2.getCacheData() != null) {
                com.baidu.adp.lib.util.a.a(b2.getContent());
                showToast(com.baidu.tieba.x.op_result_copied);
            }
        } else if (str.equals(getString(com.baidu.tieba.x.msg_at))) {
            if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getUserName() != null) {
                this.d.b(b2.getUserInfo().getUserName());
            }
        } else if (str.equals(getString(com.baidu.tieba.x.msg_delete))) {
            this.e.d(i);
            showToast(com.baidu.tieba.x.op_result_deleted);
        } else if (str.equals(getString(com.baidu.tieba.x.msg_img_save))) {
            String a = com.baidu.tieba.im.d.j.a(b2.getContent(), true);
            if (a != null) {
                this.i = new df(a, this);
                this.i.a();
            }
        } else if (str.equals(getString(com.baidu.tieba.x.group_open_receiver)) || str.equals(getString(com.baidu.tieba.x.group_close_receiver))) {
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
                TbadkApplication.m252getInst().setHeadsetModeOn(false);
                this.h.setSpeakerphoneOn(true);
                this.d.K();
                return;
            }
            TbadkApplication.m252getInst().setHeadsetModeOn(true);
            this.h.setSpeakerphoneOn(false);
            this.d.L();
        }
    }

    public void a(View view, int i, int i2, long j) {
        ChatMessage b2;
        String content;
        ChatMessage b3;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(com.baidu.tieba.x.operation));
                builder.setPositiveButton(getString(com.baidu.tieba.x.msg_resend), new dm(this, i2));
                builder.setNegativeButton(getString(com.baidu.tieba.x.delete), new dn(this, i2));
                builder.create().show();
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            case 9:
            default:
                return;
            case 5:
                if (!t() || (b3 = this.e.b(i2)) == null || !com.baidu.tieba.im.d.j.d(b3)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bh(this, TbadkApplication.getCurrentAccount(), TbadkApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage b4 = this.e.b(i2);
                if (b4 != null && com.baidu.tieba.im.d.j.f(b4) && (b2 = this.e.b(i2)) != null && (content = b2.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.e.c.a(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.e.c.a(optJSONObject.optString("groupId"), 0L), 2);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            case 10:
                ChatMessage b5 = this.e.b(i2);
                if (b5 != null && b5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
                    aVar.a(b5.getContent(), getClass().getName());
                    if (aVar.a() == 1 && aVar.b() != null) {
                        if (!TextUtils.isEmpty(((ShareFromPBMsgData) aVar.b()).getThreadId()) || !TextUtils.isEmpty(((ShareFromPBMsgData) aVar.b()).getPostId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this).a(((ShareFromPBMsgData) aVar.b()).getThreadId(), ((ShareFromPBMsgData) aVar.b()).getPostId(), null)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 11:
                if (UtilHelper.getNetStatusInfo(this) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                    showToast(com.baidu.tieba.x.rand_chat_waiting_net_error);
                    return;
                }
                ChatMessage b6 = this.e.b(i2);
                if (b6 != null && b6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.a(b6.getContent(), getClass().getName());
                    if (aVar2.a() == 1 && aVar2.b() != null) {
                        String b7 = com.baidu.tbadk.game.a.b(((ShareFromGameCenterMsgData) aVar2.b()).getShareSourceUrl());
                        if (!TextUtils.isEmpty(b7) && b7.equalsIgnoreCase("default")) {
                            b7 = "";
                        }
                        String shareUrl = ((ShareFromGameCenterMsgData) aVar2.b()).getShareUrl();
                        if (!TextUtils.isEmpty(shareUrl)) {
                            TiebaStatic.eventStat(this, "game_ck_link", "click", 1, b7);
                            if (shareUrl.equalsIgnoreCase("default")) {
                                sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(this)));
                                return;
                            } else if (com.baidu.tbadk.game.a.a(shareUrl) == 2) {
                                if (a(shareUrl)) {
                                    sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.x(this, "", shareUrl, b7, true)));
                                    return;
                                } else {
                                    TbWebViewActivity.startActivity(this, shareUrl);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            case 12:
                ChatMessage b8 = this.e.b(i2);
                if (b8 != null && b8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.a(b8.getContent(), getClass().getName());
                    if (aVar3.a() == 1 && aVar3.b() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar3.b()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(this)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String b9 = com.baidu.tbadk.game.a.b(shareSourceUrl);
                        sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.w(this, b9)));
                        TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, b9);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                ChatMessage b10 = this.e.b(i2);
                if (b10 != null && b10.getContent() != null) {
                    try {
                        String optString = new JSONArray(b10.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString) && optString.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(this)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, optString);
                        } else {
                            String b11 = com.baidu.tbadk.game.a.b(optString);
                            sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.w(this, b11)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, b11);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }

    public boolean a(String str) {
        Map<String, String> a;
        if (!TextUtils.isEmpty(str) && (a = com.baidu.tbadk.core.util.bg.a(com.baidu.tbadk.core.util.bg.b(str))) != null) {
            String str2 = a.get(b);
            return !TextUtils.isEmpty(str2) && str2.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.e.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.e.c(i);
    }
}
