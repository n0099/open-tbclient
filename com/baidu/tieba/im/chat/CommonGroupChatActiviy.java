package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy extends MsglistActivity {
    private com.baidu.adp.framework.c.g l = new ba(this, 0);
    private com.baidu.adp.framework.c.a m = new bb(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.e == null) {
            com.baidu.adp.lib.util.f.b("mListModel is null");
            return;
        }
        this.e.a(booleanExtra);
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra("ObjTp");
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!com.baidu.tieba.im.model.bn.a().a(valueOf)) {
            new com.baidu.tieba.im.f.p("chat_pg", stringExtra, valueOf).start();
            com.baidu.tieba.im.model.bn.a().a(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.e).a(groupData);
        b = String.valueOf(((CommonGroupMsglistModel) this.e).b().getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Bundle bundle) {
        this.e.a(bundle.getBoolean("is_accept_notify", true));
        ((CommonGroupMsglistModel) this.e).a((GroupData) bundle.getSerializable("group"));
        b = String.valueOf(((CommonGroupMsglistModel) this.e).b().getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dj, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_accept_notify", this.e.h());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.e).b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean l() {
        GroupData b = ((CommonGroupMsglistModel) this.e).b();
        if (b == null) {
            com.baidu.adp.lib.util.f.b("error:group or forum is null");
            return false;
        } else if (b.getGroupId() == 0) {
            com.baidu.adp.lib.util.f.b("error:gid invalid," + b.getGroupId());
            return false;
        } else {
            return true;
        }
    }

    @Override // com.baidu.tieba.im.chat.dj, com.baidu.adp.lib.b.b
    public final void b(View view, int i, int i2, long j) {
        switch (i) {
            case 2:
                com.baidu.tieba.im.message.a.a a = this.e.a(i2);
                if (a != null && a.r() != null && a.r().getUserName() != null) {
                    this.d.b(a.r().getUserName());
                    break;
                }
                break;
            case 7:
                this.d.g(i2);
                break;
        }
        super.b(view, i, i2, j);
    }

    @Override // com.baidu.tieba.im.chat.dj, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == this.d.C()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a = this.e.a(intValue);
            if (a != null) {
                com.baidu.adp.lib.util.f.e("----------recordId" + a.u() + "msgID" + a.w());
            }
            switch (i) {
                case 0:
                    if (a != null && a.z() != null) {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                            clipboardManager.setText(a.v());
                            if (clipboardManager.getText() != null) {
                                com.baidu.adp.lib.util.f.a(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b(e.getMessage());
                            return;
                        }
                    }
                    return;
                case 1:
                    if (a != null && a.r() != null && a.r().getUserName() != null) {
                        this.d.b(a.r().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.D()) {
            int intValue2 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a2 = this.e.a(intValue2);
            switch (i) {
                case 0:
                    if (a2 != null && a2.r() != null && a2.r().getUserName() != null) {
                        this.d.b(a2.r().getUserName());
                        return;
                    }
                    return;
                case 1:
                    String a3 = com.baidu.tieba.im.f.q.a(a2.v(), true);
                    if (a3 != null) {
                        this.i = new da(a3, this);
                        this.i.a();
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue2);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.E()) {
            int intValue3 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a4 = this.e.a(intValue3);
            switch (i) {
                case 0:
                    if (TbadkApplication.j().V()) {
                        TbadkApplication.j().d(false);
                        this.h.b(true);
                        this.d.I();
                        return;
                    }
                    TbadkApplication.j().d(true);
                    this.h.b(false);
                    this.d.J();
                    return;
                case 1:
                    if (a4 != null && a4.r() != null && a4.r().getUserName() != null) {
                        this.d.b(a4.r().getUserName());
                        return;
                    }
                    return;
                case 2:
                    this.e.c(intValue3);
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.d.G()) {
            int intValue4 = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a5 = this.e.a(intValue4);
            switch (i) {
                case 0:
                    if (a5 != null && a5.r() != null && a5.r().getUserName() != null) {
                        this.d.b(a5.r().getUserName());
                        return;
                    }
                    return;
                case 1:
                    this.e.c(intValue4);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.dj, com.baidu.adp.lib.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.a.a a;
        String v;
        JSONObject jSONObject;
        JSONArray jSONArray;
        com.baidu.tieba.im.message.a.a a2;
        String a3;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                com.baidu.tieba.im.message.a.a a4 = this.e.a(i2);
                if (a4 != null && a4.r() != null) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this, a4.r().getUserId(), a4.r().getUserName())));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (s() && (a2 = this.e.a(i2)) != null && com.baidu.tieba.im.f.q.a(a2) && (a3 = com.baidu.tieba.im.f.q.a(a2.v(), true)) != null && (this.e instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.e).b() != null) {
                    GroupMsgImageActivity.a(this, a3, ((CommonGroupMsglistModel) this.e).b().getGroupId(), false);
                    return;
                }
                return;
            case 7:
                if (s() && this.e != null && (a = this.e.a(i2)) != null) {
                    if (!a.D()) {
                        a.b(true);
                        dc.a((Context) this, (GifView) view, a, this.d.P(), false);
                        return;
                    } else if (com.baidu.tieba.im.f.q.b(a) && (v = a.v()) != null) {
                        try {
                            jSONArray = new JSONArray(v);
                        } catch (Exception e) {
                            try {
                                jSONObject = new JSONObject(v);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                            if (jSONObject == null) {
                                sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.h(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                                return;
                            }
                            return;
                        }
                        jSONObject = null;
                        if (jSONObject == null) {
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void m() {
        super.m();
        registerListener(103110, this.l);
        registerListener(103101, this.l);
        registerListener(103112, this.l);
        registerListener(103104, this.l);
        registerListener(2001109, this.m);
        registerListener(2001130, this.m);
        registerListener(2001132, this.m);
        registerListener(2001138, this.m);
        registerListener(2001136, this.m);
        registerListener(2001134, this.m);
        registerListener(2001137, this.m);
        registerListener(2001141, this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public final void n() {
        super.n();
        com.baidu.adp.framework.c.a().b(this.l);
        com.baidu.adp.framework.c.a().b(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(CommonGroupChatActiviy commonGroupChatActiviy, GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo == null || commonGroupChatActiviy.e == null || !(commonGroupChatActiviy.e instanceof CommonGroupMsglistModel) || (b = ((CommonGroupMsglistModel) commonGroupChatActiviy.e).b()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject("eventParam").getString("groupId");
            if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(b.getGroupId()))) {
                commonGroupChatActiviy.showToast(com.baidu.tieba.im.j.group_is_kicked, false);
                commonGroupChatActiviy.finish();
                com.baidu.adp.lib.util.f.e("newSystemMessageNotify suc and closeBottom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(CommonGroupChatActiviy commonGroupChatActiviy, GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo == null || commonGroupChatActiviy.e == null || !(commonGroupChatActiviy.e instanceof CommonGroupMsglistModel) || (b = ((CommonGroupMsglistModel) commonGroupChatActiviy.e).b()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
            String string = jSONObject2.getString("groupId");
            if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(b.getGroupId()))) {
                String string2 = jSONObject2.getString("groupName");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                commonGroupChatActiviy.d.a(string2);
                b.setName(string2);
                com.baidu.adp.lib.util.f.e("newSystemMessageNotify suc and change name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(CommonGroupChatActiviy commonGroupChatActiviy, GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo == null || commonGroupChatActiviy.e == null || !(commonGroupChatActiviy.e instanceof CommonGroupMsglistModel) || (b = ((CommonGroupMsglistModel) commonGroupChatActiviy.e).b()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject("eventParam").getString("groupId");
            if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(b.getGroupId()))) {
                commonGroupChatActiviy.showToast(com.baidu.tieba.im.j.group_is_dismiss, false);
                commonGroupChatActiviy.finish();
                com.baidu.adp.lib.util.f.e("dismiss suc");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
