package com.baidu.tieba.frs.sportspage.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.sharedPref.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener fPp = new CustomMessageListener(2921404) { // from class: com.baidu.tieba.frs.sportspage.notification.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) customResponsedMessage.getData());
                    String optString = jSONObject.optString("gameId");
                    String optString2 = jSONObject.optString("gameName");
                    String optString3 = jSONObject.optString("gameTime");
                    String optString4 = jSONObject.optString("gameType");
                    String string = b.ahQ().getString("key_match_id_list_" + optString4, "");
                    String str = "match_id_" + optString4 + "_" + optString;
                    String str2 = TextUtils.isEmpty(string) ? str : Constants.ACCEPT_TIME_SEPARATOR_SP + str;
                    if (TextUtils.isEmpty(string) || !string.contains(str)) {
                        b.ahQ().putString("key_match_id_list_" + optString4, string + str2);
                    }
                    Intent intent = new Intent(a.this.mContext.getPageActivity(), AlarmReceiver.class);
                    intent.putExtra("KEY_MATCH_NAME", optString2);
                    intent.putExtra("KEY_MATCH_TYPE", optString4);
                    intent.putExtra("KEY_MATCH_ID", optString);
                    PendingIntent broadcast = PendingIntent.getBroadcast(a.this.mContext.getPageActivity(), 0, intent, 0);
                    Calendar calendar = Calendar.getInstance();
                    long currentTimeMillis = System.currentTimeMillis();
                    calendar.setTimeInMillis(currentTimeMillis);
                    long c = (com.baidu.adp.lib.g.b.c(optString3, 0L) * 1000) - currentTimeMillis;
                    if (c > 0) {
                        calendar.add(14, (int) c);
                    }
                    ((AlarmManager) a.this.mContext.getPageActivity().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, calendar.getTimeInMillis(), broadcast);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mContext.registerListener(this.fPp);
    }
}
