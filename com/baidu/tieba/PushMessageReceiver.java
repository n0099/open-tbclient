package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f825a = PushMessageReceiver.class.getSimpleName();

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
                    switch (optInt) {
                        case 14:
                            if (TiebaApplication.E() != null) {
                                com.baidu.tieba.util.am.a(context, new com.baidu.tieba.data.ay(-1L, "vote", optString2), 15);
                                return;
                            }
                            return;
                        default:
                            return;
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
                        TiebaApplication.f().s(optString);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
            com.baidu.tieba.util.aj.e(f825a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra(PushConstants.EXTRA_EXTRA));
        }
    }
}
