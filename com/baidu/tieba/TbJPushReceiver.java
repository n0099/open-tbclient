package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbJPushReceiver extends BroadcastReceiver {
    private static final String TAG = "JIGUANG-Example";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (com.baidu.tieba.q.b.bBs().bBt()) {
                Bundle extras = intent.getExtras();
                if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                    extras.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                } else if (!JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                    if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
                        extras.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
                        System.out.println("test: 5432109876");
                    } else if (!JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()) && !JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction()) && JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                        intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (str.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getInt(str));
            } else if (str.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getBoolean(str));
            } else if (str.equals(JPushInterface.EXTRA_EXTRA)) {
                if (!TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                    try {
                        JSONObject jSONObject = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            sb.append("\nkey:" + str + ", value: [" + next + " - " + jSONObject.optString(next) + "]");
                        }
                    } catch (JSONException e) {
                    }
                }
            } else {
                sb.append("\nkey:" + str + ", value:" + bundle.get(str));
            }
        }
        return sb.toString();
    }
}
