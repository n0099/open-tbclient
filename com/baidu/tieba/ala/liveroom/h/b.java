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
    private JSONArray hCr;
    private Handler hCs;
    private int hCt;
    private long mLastTime;
    private String hCo = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hCp = new StringBuffer();
    private SimpleDateFormat aZG = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hCq = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hCs = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.h.b.1
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
        this.hCt++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hCr == null) {
            this.hCr = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hCq.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aZG.format(this.hCq));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hCt % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.ceL().ceM());
                jSONObject.put("cpu", a.ceL().acu());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hCr.put(jSONObject);
        if (this.hCt >= 75) {
            this.hCt = 0;
            try {
                this.hCp.setLength(0);
                this.hCp.append(this.hCo).append("?extra=").append(this.hCr.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hCp.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hCs.sendMessage(obtain);
                this.hCr = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hCp.append("&_client_type=2");
        this.hCp.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hCp.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hCp.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hCp.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hCp.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hCp.append("&_sdk_version=4.3.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hCp.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hCp.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hCp.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hCp.append("&from=" + from);
        }
        this.hCp.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hCp.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hCp.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hCp.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hCp.append("&model=" + Build.MODEL);
        this.hCp.append("&brand=" + Build.BRAND);
        this.hCp.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
