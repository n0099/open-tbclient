package com.baidu.tieba.ala.liveroom.i;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.GUIDTool;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static String PROFILE_LOG_ACTION = "com.baidu.open.profile.log";
    private JSONArray hqB;
    private Handler hqC;
    private int hqD;
    private long mLastTime;
    private String hqy = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hqz = new StringBuffer();
    private SimpleDateFormat aZH = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hqA = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hqC = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL((String) message.obj).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void report(long j, long j2) {
        this.hqD++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hqB == null) {
            this.hqB = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hqA.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aZH.format(this.hqA));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hqD % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.ceJ().ceK());
                jSONObject.put("cpu", a.ceJ().acF());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hqB.put(jSONObject);
        if (this.hqD >= 75) {
            this.hqD = 0;
            try {
                this.hqz.setLength(0);
                this.hqz.append(this.hqy).append("?extra=").append(this.hqB.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hqz.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hqC.sendMessage(obtain);
                this.hqB = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hqz.append("&_client_type=2");
        this.hqz.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hqz.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hqz.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hqz.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hqz.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hqz.append("&_sdk_version=4.1.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hqz.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hqz.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hqz.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hqz.append("&from=" + from);
        }
        this.hqz.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hqz.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hqz.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hqz.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hqz.append("&model=" + Build.MODEL);
        this.hqz.append("&brand=" + Build.BRAND);
        this.hqz.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
