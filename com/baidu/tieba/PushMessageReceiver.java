package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.bh;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1003a = PushMessageReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArrayExtra;
        JSONObject optJSONObject;
        if (intent != null && context != null) {
            if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
                try {
                    String string = intent.getExtras().getString(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
                    if (string == null && (byteArrayExtra = intent.getByteArrayExtra("message")) != null) {
                        string = new String(byteArrayExtra, BdUtil.UTF8);
                    }
                    if (TextUtils.isEmpty(string)) {
                        com.baidu.adp.lib.h.d.a("receive message is empty");
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
                                        com.baidu.tieba.data.at atVar = new com.baidu.tieba.data.at();
                                        atVar.a(optString);
                                        if (TiebaApplication.A().equals(atVar.e()) && TiebaApplication.g().ad()) {
                                            com.baidu.tieba.mention.t.a().j();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 14:
                                    if (TiebaApplication.A() != null) {
                                        UtilHelper.a(context, new com.baidu.tieba.data.at(-1L, "vote", optString), 15);
                                        return;
                                    }
                                    return;
                                case 65535:
                                    com.baidu.tieba.data.at atVar2 = new com.baidu.tieba.data.at();
                                    atVar2.a(optString);
                                    if (TiebaApplication.g().s() && !TextUtils.isEmpty(atVar2.a())) {
                                        StatService.onEvent(TiebaApplication.g().getApplicationContext(), "push_noti:" + atVar2.a(), "msgID:" + atVar2.b());
                                    }
                                    bh.a(atVar2.b(), 1, atVar2.c());
                                    if (atVar2.b() != -1) {
                                        TiebaApplication.g().b(atVar2.b());
                                    }
                                    UtilHelper.a(TiebaApplication.g().getApplicationContext(), atVar2, 13);
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
                String str = new String(intent.getByteArrayExtra("content"));
                if (PushConstants.METHOD_BIND.equals(stringExtra) && intExtra == 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("response_params")) != null) {
                            String optString2 = optJSONObject.optString("channel_id");
                            String optString3 = optJSONObject.optString(PushConstants.EXTRA_USER_ID);
                            if (optString2 != null) {
                                TiebaApplication.g().w(optString2);
                            }
                            if (optString3 != null) {
                                TiebaApplication.g().x(optString3);
                            }
                            new ao().start();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
                bg.e(f1003a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra(PushConstants.EXTRA_EXTRA));
            }
        }
    }
}
