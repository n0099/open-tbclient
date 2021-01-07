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
/* loaded from: classes11.dex */
public class b {
    public static String PROFILE_LOG_ACTION = "com.baidu.open.profile.log";
    private Handler hCA;
    private int hCB;
    private JSONArray hCz;
    private long mLastTime;
    private String hCw = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hCx = new StringBuffer();
    private SimpleDateFormat bbo = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hCy = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hCA = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.hCB++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hCz == null) {
            this.hCz = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hCy.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.bbo.format(this.hCy));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hCB % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.chB().chC());
                jSONObject.put("cpu", a.chB().aez());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hCz.put(jSONObject);
        if (this.hCB >= 75) {
            this.hCB = 0;
            try {
                this.hCx.setLength(0);
                this.hCx.append(this.hCw).append("?extra=").append(this.hCz.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hCx.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hCA.sendMessage(obtain);
                this.hCz = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hCx.append("&_client_type=2");
        this.hCx.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hCx.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hCx.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hCx.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hCx.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hCx.append("&_sdk_version=4.2.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hCx.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hCx.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hCx.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hCx.append("&from=" + from);
        }
        this.hCx.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hCx.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hCx.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hCx.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hCx.append("&model=" + Build.MODEL);
        this.hCx.append("&brand=" + Build.BRAND);
        this.hCx.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
