package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {
    public static final String a = PushMessageReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArrayExtra;
        JSONObject optJSONObject;
        if (intent != null && context != null) {
            if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
                try {
                    String string = intent.getExtras().getString(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
                    if (string == null && (byteArrayExtra = intent.getByteArrayExtra(PushConstants.EXTRA_PUSH_MESSAGE)) != null) {
                        string = new String(byteArrayExtra, "utf-8");
                    }
                    if (TextUtils.isEmpty(string)) {
                        com.baidu.adp.lib.util.e.b("receive message is empty");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("tp");
                    String optString = jSONObject.optString("msg");
                    if (!TextUtils.isEmpty(optString)) {
                        switch (optInt) {
                            case 1:
                            case 4:
                            case 9:
                            case 13:
                                if (TiebaApplication.v() != null) {
                                    com.baidu.tieba.data.at atVar = new com.baidu.tieba.data.at();
                                    atVar.a(optString);
                                    if (TiebaApplication.v().equals(atVar.e()) && TiebaApplication.g().T()) {
                                        com.baidu.tieba.mention.v.a().i();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 14:
                                if (TiebaApplication.v() != null) {
                                    UtilHelper.a(context, new com.baidu.tieba.data.at(-1L, "vote", optString), 15);
                                    return;
                                }
                                return;
                            case 65535:
                                com.baidu.tieba.data.at atVar2 = new com.baidu.tieba.data.at();
                                atVar2.a(optString);
                                if (TiebaApplication.g().n() && !TextUtils.isEmpty(atVar2.a())) {
                                    cb.a(TiebaApplication.g().b().getApplicationContext(), "push_noti:" + atVar2.a(), "msgID:" + atVar2.b());
                                }
                                if (!TextUtils.isEmpty(atVar2.c()) && !TextUtils.isEmpty(atVar2.a())) {
                                    cb.a(atVar2.b(), 1, atVar2.c(), atVar2.a());
                                }
                                if (atVar2.b() != -1) {
                                    TiebaApplication.g().b(atVar2.b());
                                }
                                UtilHelper.a(TiebaApplication.g().b().getApplicationContext(), atVar2, 13);
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
                try {
                    String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
                    int intExtra = intent.getIntExtra("error_msg", 0);
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT);
                    if (byteArrayExtra2 != null && byteArrayExtra2.length != 0) {
                        String str = new String(byteArrayExtra2);
                        if (PushConstants.METHOD_BIND.equals(stringExtra) && intExtra == 0 && (optJSONObject = new JSONObject(str).optJSONObject("response_params")) != null) {
                            String optString2 = optJSONObject.optString("channel_id");
                            String optString3 = optJSONObject.optString(PushConstants.EXTRA_USER_ID);
                            if (optString2 != null) {
                                TiebaApplication.g().v(optString2);
                            }
                            if (optString3 != null) {
                                TiebaApplication.g().w(optString3);
                            }
                            new ak((byte) 0).start();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
                com.baidu.adp.lib.util.e.e(a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra(PushConstants.EXTRA_EXTRA));
            }
        }
    }
}
