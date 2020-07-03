package com.baidu.tieba.ala.liveroom.h;

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
/* loaded from: classes3.dex */
public class b {
    public static String PROFILE_LOG_ACTION = "com.baidu.open.profile.log";
    private JSONArray ggW;
    private Handler ggX;
    private int ggY;
    private long mLastTime;
    private String ggT = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer ggU = new StringBuffer();
    private SimpleDateFormat aJr = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date ggV = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.ggX = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.h.b.1
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
        this.ggY++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.ggW == null) {
            this.ggW = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.ggV.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aJr.format(this.ggV));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.ggY % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bEp().bEs());
                jSONObject.put(c.i, a.bEp().bEq());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.ggW.put(jSONObject);
        if (this.ggY >= 75) {
            this.ggY = 0;
            try {
                this.ggU.setLength(0);
                this.ggU.append(this.ggT).append("?extra=").append(this.ggW.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.ggU.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.ggX.sendMessage(obtain);
                this.ggW = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.ggU.append("&_client_type=2");
        this.ggU.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.ggU.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.ggU.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.ggU.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.ggU.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.ggU.append("&_sdk_version=3.8.1");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.ggU.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.ggU.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.ggU.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.ggU.append("&from=" + from);
        }
        this.ggU.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.ggU.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.ggU.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.ggU.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.ggU.append("&model=" + Build.MODEL);
        this.ggU.append("&brand=" + Build.BRAND);
        this.ggU.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
