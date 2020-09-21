package com.baidu.tieba.frs.sportspage.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.sharedPref.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class a {
    private TbPageContext ehG;
    private CustomMessageListener iyn = new CustomMessageListener(2921404) { // from class: com.baidu.tieba.frs.sportspage.notification.a.1
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
                    String string = b.bjf().getString("key_match_id_list_" + optString4, "");
                    String str = "match_id_" + optString4 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString;
                    String str2 = TextUtils.isEmpty(string) ? str : Constants.ACCEPT_TIME_SEPARATOR_SP + str;
                    if (TextUtils.isEmpty(string) || !string.contains(str)) {
                        b.bjf().putString("key_match_id_list_" + optString4, string + str2);
                    }
                    Intent intent = new Intent(a.this.ehG.getPageActivity(), AlarmReceiver.class);
                    intent.putExtra("KEY_MATCH_NAME", optString2);
                    intent.putExtra("KEY_MATCH_TYPE", optString4);
                    intent.putExtra("KEY_MATCH_ID", optString);
                    PendingIntent broadcast = PendingIntent.getBroadcast(a.this.ehG.getPageActivity(), 0, intent, 0);
                    Calendar calendar = Calendar.getInstance();
                    long currentTimeMillis = System.currentTimeMillis();
                    calendar.setTimeInMillis(currentTimeMillis);
                    long j = (com.baidu.adp.lib.f.b.toLong(optString3, 0L) * 1000) - currentTimeMillis;
                    if (j > 0) {
                        calendar.add(14, (int) j);
                    }
                    ((AlarmManager) a.this.ehG.getPageActivity().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, calendar.getTimeInMillis(), broadcast);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
        this.ehG.registerListener(this.iyn);
    }
}
