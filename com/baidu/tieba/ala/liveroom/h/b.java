package com.baidu.tieba.ala.liveroom.h;

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
    private JSONArray hCd;
    private Handler hCe;
    private int hCf;
    private long mLastTime;
    private String hCa = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hCb = new StringBuffer();
    private SimpleDateFormat aZG = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hCc = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hCe = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.h.b.1
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
        this.hCf++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hCd == null) {
            this.hCd = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hCc.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aZG.format(this.hCc));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hCf % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.ceE().ceF());
                jSONObject.put("cpu", a.ceE().acu());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hCd.put(jSONObject);
        if (this.hCf >= 75) {
            this.hCf = 0;
            try {
                this.hCb.setLength(0);
                this.hCb.append(this.hCa).append("?extra=").append(this.hCd.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hCb.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hCe.sendMessage(obtain);
                this.hCd = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hCb.append("&_client_type=2");
        this.hCb.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hCb.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hCb.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hCb.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hCb.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hCb.append("&_sdk_version=4.3.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hCb.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hCb.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hCb.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hCb.append("&from=" + from);
        }
        this.hCb.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hCb.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hCb.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hCb.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hCb.append("&model=" + Build.MODEL);
        this.hCb.append("&brand=" + Build.BRAND);
        this.hCb.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
