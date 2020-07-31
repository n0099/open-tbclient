package com.baidu.tieba.ala.liveroom.i;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.fsg.face.base.b.c;
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
    private JSONArray glW;
    private Handler glX;
    private int glY;
    private long mLastTime;
    private String glT = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer glU = new StringBuffer();
    private SimpleDateFormat aKN = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date glV = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.glX = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.glY++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.glW == null) {
            this.glW = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.glV.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aKN.format(this.glV));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.glY % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bHA().bHD());
                jSONObject.put(c.i, a.bHA().bHB());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.glW.put(jSONObject);
        if (this.glY >= 75) {
            this.glY = 0;
            try {
                this.glU.setLength(0);
                this.glU.append(this.glT).append("?extra=").append(this.glW.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.glU.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.glX.sendMessage(obtain);
                this.glW = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.glU.append("&_client_type=2");
        this.glU.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.glU.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.glU.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.glU.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.glU.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.glU.append("&_sdk_version=3.8.2");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.glU.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.glU.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.glU.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.glU.append("&from=" + from);
        }
        this.glU.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.glU.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.glU.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.glU.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.glU.append("&model=" + Build.MODEL);
        this.glU.append("&brand=" + Build.BRAND);
        this.glU.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
