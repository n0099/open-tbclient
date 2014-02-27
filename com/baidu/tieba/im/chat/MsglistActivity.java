package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.MsglistModel;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class MsglistActivity extends cy implements com.baidu.tieba.im.messageCenter.g {
    protected abstract void a(Intent intent);

    protected abstract void a(Bundle bundle);

    protected abstract boolean k();

    protected abstract void l();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (!b(bundle)) {
                finish();
            } else {
                l();
                m();
                if (o()) {
                    this.e.i();
                    j();
                    cr.a = com.baidu.tieba.util.i.b();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.im.chat.cy, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            com.baidu.adp.lib.util.e.d("----onNewIntent start-----");
            setIntent(intent);
            if (!b((Bundle) null)) {
                finish();
            } else {
                l();
                m();
                if (o()) {
                    this.e.i();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.d != null) {
            this.d.L();
        }
    }

    @Override // com.baidu.tieba.im.chat.cy, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("chat_mode", this.e.j());
        bundle.putBoolean("is_accept_notify", this.e.d());
        if (this.e.j() == 0 || this.e.j() == 2) {
            bundle.putSerializable("group", this.e.a());
        } else {
            bundle.putSerializable("user", this.e.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            a aVar = this.d;
            TiebaApplication.g().ae();
            aVar.L();
            if (TiebaApplication.g().ab()) {
                this.d.G();
            } else {
                this.d.F();
            }
            if (this.e.j() == 0 || this.e.j() == 2) {
                if (this.e.a() != null) {
                    String name = this.e.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        this.d.a(name);
                    }
                }
                com.baidu.tieba.im.i.a(new cc(this), new cd(this));
                return;
            }
            com.baidu.tieba.im.i.a(new ce(this), new cf(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Bundle bundle) {
        try {
            this.e = new MsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                this.i = bundle.getInt("chat_mode");
                this.e.a(bundle.getBoolean("is_accept_notify", true));
                this.e.d(this.i);
                a(bundle);
            } else {
                Intent intent = getIntent();
                this.i = intent.getIntExtra("chat_mode", 0);
                boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
                if (this.e == null) {
                    com.baidu.adp.lib.util.e.b("mListModel is null");
                } else {
                    this.e.a(booleanExtra);
                    this.e.d(this.i);
                    a(intent);
                }
            }
            return k();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
            return false;
        }
    }

    private boolean o() {
        if (this.e.j() == 1) {
            this.e.g();
        }
        return this.e.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cy, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.e.e("----ondestroy---");
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        com.baidu.tieba.im.messageCenter.d.a().a(103110, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103101, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103112, this);
        com.baidu.tieba.im.messageCenter.d.a().a(103104, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-109, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-130, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-138, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-136, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-137, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-141, this);
    }

    public void a(com.baidu.tieba.im.message.s sVar) {
        GroupNewsPojo a;
        if (sVar != null) {
            switch (sVar.w()) {
                case -141:
                case -138:
                case -137:
                case -136:
                case -134:
                case -132:
                case -130:
                    if ((sVar instanceof com.baidu.tieba.im.message.aa) && (a = ((com.baidu.tieba.im.message.aa) sVar).a()) != null) {
                        String cmd = a.getCmd();
                        if (!TextUtils.isEmpty(cmd)) {
                            this.d.e();
                            if (!cmd.equals("apply_join_success")) {
                                if (cmd.equals("kick_out")) {
                                    if (a == null || this.e == null || this.e.a() == null) {
                                        return;
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject(a.getContent());
                                        String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                                        if (!jSONObject.getString("eventId").equals("003") || !string.equals(String.valueOf(this.e.a().getGroupId()))) {
                                            return;
                                        }
                                        showToast(R.string.group_is_kicked, false);
                                        finish();
                                        com.baidu.adp.lib.util.e.e("newSystemMessageNotify suc and closeBottom");
                                        return;
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                } else if (cmd.equals("group_name_change")) {
                                    if (a == null || this.e == null || this.e.a() == null) {
                                        return;
                                    }
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(a.getContent());
                                        JSONObject jSONObject3 = jSONObject2.getJSONObject("eventParam");
                                        String string2 = jSONObject3.getString("groupId");
                                        if (jSONObject2.getString("eventId").equals("101") && string2.equals(String.valueOf(this.e.a().getGroupId()))) {
                                            String string3 = jSONObject3.getString("groupName");
                                            if (!TextUtils.isEmpty(string3)) {
                                                this.d.a(string3);
                                                this.e.a().setName(string3);
                                                com.baidu.adp.lib.util.e.e("newSystemMessageNotify suc and change name");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                } else if (!cmd.equals("dismiss_group") || a == null || this.e == null || this.e.a() == null) {
                                    return;
                                } else {
                                    try {
                                        JSONObject jSONObject4 = new JSONObject(a.getContent());
                                        String string4 = jSONObject4.getJSONObject("eventParam").getString("groupId");
                                        if (!jSONObject4.getString("eventId").equals("107") || !string4.equals(String.valueOf(this.e.a().getGroupId()))) {
                                            return;
                                        }
                                        showToast(R.string.group_is_dismiss, false);
                                        finish();
                                        com.baidu.adp.lib.util.e.e("dismiss suc");
                                        return;
                                    } catch (JSONException e3) {
                                        e3.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case -109:
                case 103101:
                case 103110:
                case 103112:
                    this.d.e();
                    return;
                case 103104:
                    if (sVar instanceof com.baidu.tieba.im.message.bv) {
                        com.baidu.tieba.im.message.bv bvVar = (com.baidu.tieba.im.message.bv) sVar;
                        if (!bvVar.l() && this.e.a().getGroupId() == bvVar.a()) {
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
