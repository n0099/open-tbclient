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
/* loaded from: classes7.dex */
public class b {
    public static String PROFILE_LOG_ACTION = "com.baidu.open.profile.log";
    private JSONArray gya;
    private Handler gyb;
    private int gyc;
    private long mLastTime;
    private String gxX = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer gxY = new StringBuffer();
    private SimpleDateFormat aQa = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date gxZ = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.gyb = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.gyc++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.gya == null) {
            this.gya = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.gxZ.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aQa.format(this.gxZ));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.gyc % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bRe().bRh());
                jSONObject.put(c.i, a.bRe().bRf());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.gya.put(jSONObject);
        if (this.gyc >= 75) {
            this.gyc = 0;
            try {
                this.gxY.setLength(0);
                this.gxY.append(this.gxX).append("?extra=").append(this.gya.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.gxY.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.gyb.sendMessage(obtain);
                this.gya = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.gxY.append("&_client_type=2");
        this.gxY.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.gxY.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.gxY.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.gxY.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.gxY.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.gxY.append("&_sdk_version=3.8.5");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.gxY.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.gxY.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.gxY.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.gxY.append("&from=" + from);
        }
        this.gxY.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.gxY.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.gxY.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.gxY.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.gxY.append("&model=" + Build.MODEL);
        this.gxY.append("&brand=" + Build.BRAND);
        this.gxY.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
