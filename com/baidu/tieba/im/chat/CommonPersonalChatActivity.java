package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonPersonalChatActivity extends MsglistActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        super.c();
    }

    protected void a(UserData userData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean k() {
        if (this.e instanceof CommonPersonalMsglistModel) {
            UserData c = ((CommonPersonalMsglistModel) this.e).c();
            if (c == null) {
                com.baidu.adp.lib.util.f.b("error:user or forum is null");
                return false;
            } else if (c.getUserIdLong() == 0) {
                com.baidu.adp.lib.util.f.b("error:uid invalid," + c.getUserId());
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Bundle bundle) {
        this.e.a(bundle.getBoolean("is_accept_notify", true));
        UserData userData = (UserData) bundle.getSerializable("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        ((CommonPersonalMsglistModel) this.e).a(userData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.e == null) {
            com.baidu.adp.lib.util.f.b("mListModel is null");
            return;
        }
        this.e.a(booleanExtra);
        UserData userData = (UserData) intent.getSerializableExtra("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        ((CommonPersonalMsglistModel) this.e).a(userData);
    }

    @Override // com.baidu.tieba.im.chat.dn, com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (dialogInterface == this.d.C()) {
            int intValue = ((Integer) ((AlertDialog) dialogInterface).getListView().getTag()).intValue();
            com.baidu.tieba.im.message.a.a a = this.e.a(intValue);
            if (a != null) {
                com.baidu.adp.lib.util.f.e("----------recordId" + a.u() + "msgID" + a.w());
            }
            if (i > 0) {
                i++;
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
            if (i >= 0) {
                i++;
            }
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
                        this.i = new de(a3, this);
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
            if (i > 0) {
                i++;
            }
            switch (i) {
                case 0:
                    if (TbadkApplication.j().V()) {
                        TbadkApplication.j().d(false);
                        this.h.b(true);
                        this.d.H();
                        return;
                    }
                    TbadkApplication.j().d(true);
                    this.h.b(false);
                    this.d.I();
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
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.dn, com.baidu.adp.lib.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, int i, int i2, long j) {
        com.baidu.tieba.im.message.a.a a;
        String v;
        JSONObject jSONObject;
        JSONArray jSONArray;
        super.a(view, i, i2, j);
        switch (i) {
            case 7:
                if (s() && this.e != null && (a = this.e.a(i2)) != null) {
                    if (!a.D()) {
                        a.b(true);
                        dg.a((Context) this, (GifView) view, a, this.d.O(), false);
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
                                sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.h(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
            default:
                return;
        }
    }
}
