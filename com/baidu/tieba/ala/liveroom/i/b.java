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
/* loaded from: classes10.dex */
public class b {
    public static String PROFILE_LOG_ACTION = "com.baidu.open.profile.log";
    private JSONArray hxT;
    private Handler hxU;
    private int hxV;
    private long mLastTime;
    private String hxQ = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hxR = new StringBuffer();
    private SimpleDateFormat aWA = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hxS = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hxU = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.hxV++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hxT == null) {
            this.hxT = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hxS.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aWA.format(this.hxS));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hxV % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.cdJ().cdK());
                jSONObject.put("cpu", a.cdJ().aaG());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hxT.put(jSONObject);
        if (this.hxV >= 75) {
            this.hxV = 0;
            try {
                this.hxR.setLength(0);
                this.hxR.append(this.hxQ).append("?extra=").append(this.hxT.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hxR.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hxU.sendMessage(obtain);
                this.hxT = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hxR.append("&_client_type=2");
        this.hxR.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hxR.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hxR.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hxR.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hxR.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hxR.append("&_sdk_version=4.2.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hxR.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hxR.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hxR.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hxR.append("&from=" + from);
        }
        this.hxR.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hxR.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hxR.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hxR.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hxR.append("&model=" + Build.MODEL);
        this.hxR.append("&brand=" + Build.BRAND);
        this.hxR.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
