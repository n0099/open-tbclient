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
    private JSONArray hhr;
    private Handler hhs;
    private int hht;
    private long mLastTime;
    private String hho = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hhp = new StringBuffer();
    private SimpleDateFormat aYc = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hhq = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hhs = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.hht++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hhr == null) {
            this.hhr = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hhq.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aYc.format(this.hhq));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hht % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.cbv().cby());
                jSONObject.put(c.i, a.cbv().cbw());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hhr.put(jSONObject);
        if (this.hht >= 75) {
            this.hht = 0;
            try {
                this.hhp.setLength(0);
                this.hhp.append(this.hho).append("?extra=").append(this.hhr.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hhp.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hhs.sendMessage(obtain);
                this.hhr = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hhp.append("&_client_type=2");
        this.hhp.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hhp.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hhp.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hhp.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hhp.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hhp.append("&_sdk_version=4.0.8");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hhp.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hhp.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hhp.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hhp.append("&from=" + from);
        }
        this.hhp.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hhp.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hhp.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hhp.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hhp.append("&model=" + Build.MODEL);
        this.hhp.append("&brand=" + Build.BRAND);
        this.hhp.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
