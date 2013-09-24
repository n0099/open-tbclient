package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f858a = PushMessageReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        JSONObject optJSONObject;
        String optString;
        if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getExtras().getString(PushConstants.EXTRA_PUSH_MESSAGE_STRING));
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("tp");
                    String optString2 = jSONObject.optString("msg");
                    if (!TextUtils.isEmpty(optString2)) {
                        switch (optInt) {
                            case 1:
                            case 4:
                            case 9:
                            case 13:
                                if (TiebaApplication.C() != null) {
                                    com.baidu.tieba.data.au auVar = new com.baidu.tieba.data.au();
                                    auVar.a(optString2);
                                    if (TiebaApplication.C().equals(auVar.e()) && TiebaApplication.g().ad()) {
                                        com.baidu.tieba.mention.s.a().g();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 14:
                                if (TiebaApplication.C() != null) {
                                    UtilHelper.a(context, new com.baidu.tieba.data.au(-1L, "vote", optString2), 15);
                                    return;
                                }
                                return;
                            case 65535:
                                com.baidu.tieba.data.au auVar2 = new com.baidu.tieba.data.au();
                                auVar2.a(optString2);
                                if (TiebaApplication.g().s() && !TextUtils.isEmpty(auVar2.a())) {
                                    StatService.onEvent(TiebaApplication.g().getApplicationContext(), "push_noti:" + auVar2.a(), "msgID:" + auVar2.b());
                                }
                                if (auVar2.b() != -1) {
                                    TiebaApplication.g().b(auVar2.b());
                                }
                                UtilHelper.a(TiebaApplication.g().getApplicationContext(), auVar2, 13);
                                return;
                            default:
                                return;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
            String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
            int intExtra = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, 0);
            String str = new String(intent.getByteArrayExtra("content"));
            if (PushConstants.METHOD_BIND.equals(stringExtra) && intExtra == 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("response_params")) != null && (optString = optJSONObject.optString("channel_id")) != null) {
                        TiebaApplication.g().s(optString);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
            com.baidu.tieba.util.av.e(f858a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra(PushConstants.EXTRA_EXTRA));
        }
    }
}
