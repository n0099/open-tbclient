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
public abstract class MsglistActivity extends cz implements com.baidu.tieba.im.messageCenter.g {
    protected abstract void a(Intent intent);

    protected abstract void a(Bundle bundle);

    protected abstract boolean k();

    protected abstract void l();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (!b(bundle)) {
                finish();
            } else {
                l();
                m();
                if (s()) {
                    t();
                    j();
                    cs.a = com.baidu.tieba.util.i.b();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.im.chat.cz, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            com.baidu.adp.lib.util.f.d("----onNewIntent start-----");
            setIntent(intent);
            if (!b((Bundle) null)) {
                finish();
            } else {
                l();
                m();
                if (s()) {
                    t();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.d != null) {
            this.d.g(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.cz, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("chat_mode", this.e.k());
        bundle.putBoolean("is_accept_notify", this.e.d());
        if (this.e.k() == 0 || this.e.k() == 2) {
            bundle.putSerializable("group", this.e.a());
        } else {
            bundle.putSerializable("user", this.e.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.g(TiebaApplication.g().al());
            q();
        }
    }

    private void q() {
        if (TiebaApplication.g().ai()) {
            this.d.J();
        } else {
            this.d.I();
        }
        if (this.e.k() == 0 || this.e.k() == 2) {
            if (this.e.a() != null) {
                String name = this.e.a().getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name, true);
                }
            }
            com.baidu.tieba.im.j.a(new cd(this), new ce(this));
            return;
        }
        com.baidu.tieba.im.j.a(new cf(this), new cg(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Bundle bundle) {
        try {
            this.e = new MsglistModel(this);
            this.e.setLoadDataCallBack(this.k);
            if (bundle != null) {
                c(bundle);
            } else {
                r();
            }
            return k();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }

    private void r() {
        Intent intent = getIntent();
        this.i = intent.getIntExtra("chat_mode", 0);
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.e == null) {
            com.baidu.adp.lib.util.f.b("mListModel is null");
            return;
        }
        this.e.a(booleanExtra);
        this.e.d(this.i);
        a(intent);
    }

    private void c(Bundle bundle) {
        this.i = bundle.getInt("chat_mode");
        this.e.a(bundle.getBoolean("is_accept_notify", true));
        this.e.d(this.i);
        a(bundle);
    }

    private boolean s() {
        if (this.e.k() == 1) {
            this.e.g();
        }
        return this.e.f();
    }

    private boolean t() {
        return this.e.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.cz, com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.f.e("----ondestroy---");
        super.onDestroy();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        com.baidu.tieba.im.messageCenter.e.a().a(103110, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-109, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-130, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-138, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-136, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-137, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
    }

    private void u() {
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    private void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.e != null && this.e.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.e.a().getGroupId()))) {
                    showToast(R.string.group_is_kicked, false);
                    finish();
                    com.baidu.adp.lib.util.f.e("newSystemMessageNotify suc and closeBottom");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.e != null && this.e.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.e.a().getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.d.a(string2, true);
                        this.e.a().setName(string2);
                        com.baidu.adp.lib.util.f.e("newSystemMessageNotify suc and change name");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.e != null && this.e.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.e.a().getGroupId()))) {
                    showToast(R.string.group_is_dismiss, false);
                    finish();
                    com.baidu.adp.lib.util.f.e("dismiss suc");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
                            this.d.f();
                            if (!cmd.equals("apply_join_success")) {
                                if (cmd.equals("kick_out")) {
                                    a(a);
                                    return;
                                } else if (cmd.equals("group_name_change")) {
                                    b(a);
                                    return;
                                } else if (cmd.equals("dismiss_group")) {
                                    c(a);
                                    return;
                                } else {
                                    return;
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
                    this.d.f();
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
