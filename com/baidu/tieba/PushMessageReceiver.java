package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
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
                        com.baidu.adp.lib.g.e.a("receive message is empty");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("tp");
                        String optString = jSONObject.optString("msg");
                        if (!TextUtils.isEmpty(optString)) {
                            switch (optInt) {
                                case 1:
                                case 4:
                                case 9:
                                case 13:
                                    if (TiebaApplication.A() != null) {
                                        com.baidu.tieba.data.av avVar = new com.baidu.tieba.data.av();
                                        avVar.a(optString);
                                        if (TiebaApplication.A().equals(avVar.e()) && TiebaApplication.h().aa()) {
                                            com.baidu.tieba.mention.s.a().k();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 14:
                                    if (TiebaApplication.A() != null) {
                                        UtilHelper.a(context, new com.baidu.tieba.data.av(-1L, "vote", optString), 15);
                                        return;
                                    }
                                    return;
                                case 65535:
                                    com.baidu.tieba.data.av avVar2 = new com.baidu.tieba.data.av();
                                    avVar2.a(optString);
                                    if (TiebaApplication.h().s() && !TextUtils.isEmpty(avVar2.a())) {
                                        by.a(TiebaApplication.h().getApplicationContext(), "push_noti:" + avVar2.a(), "msgID:" + avVar2.b());
                                    }
                                    if (!TextUtils.isEmpty(avVar2.c()) && !TextUtils.isEmpty(avVar2.a())) {
                                        by.a(avVar2.b(), 1, avVar2.c(), avVar2.a());
                                    }
                                    if (avVar2.b() != -1) {
                                        TiebaApplication.h().b(avVar2.b());
                                    }
                                    UtilHelper.a(TiebaApplication.h().getApplicationContext(), avVar2, 13);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
                String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
                int intExtra = intent.getIntExtra("error_msg", 0);
                String str = new String(intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT));
                if (PushConstants.METHOD_BIND.equals(stringExtra) && intExtra == 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("response_params")) != null) {
                            String optString2 = optJSONObject.optString("channel_id");
                            String optString3 = optJSONObject.optString(PushConstants.EXTRA_USER_ID);
                            if (optString2 != null) {
                                TiebaApplication.h().v(optString2);
                            }
                            if (optString3 != null) {
                                TiebaApplication.h().w(optString3);
                            }
                            new av().start();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
                com.baidu.adp.lib.g.e.e(a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra(PushConstants.EXTRA_EXTRA));
            }
        }
    }
}
