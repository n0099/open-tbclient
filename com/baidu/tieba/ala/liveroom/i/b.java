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
    private JSONArray hgY;
    private Handler hgZ;
    private int hha;
    private long mLastTime;
    private String hgV = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer hgW = new StringBuffer();
    private SimpleDateFormat aWr = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date hgX = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.hgZ = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.hha++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.hgY == null) {
            this.hgY = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.hgX.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aWr.format(this.hgX));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.hha % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.caO().caR());
                jSONObject.put(c.i, a.caO().caP());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.hgY.put(jSONObject);
        if (this.hha >= 75) {
            this.hha = 0;
            try {
                this.hgW.setLength(0);
                this.hgW.append(this.hgV).append("?extra=").append(this.hgY.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.hgW.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.hgZ.sendMessage(obtain);
                this.hgY = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.hgW.append("&_client_type=2");
        this.hgW.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hgW.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hgW.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hgW.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hgW.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hgW.append("&_sdk_version=4.0.8");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hgW.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hgW.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hgW.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hgW.append("&from=" + from);
        }
        this.hgW.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hgW.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hgW.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hgW.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hgW.append("&model=" + Build.MODEL);
        this.hgW.append("&brand=" + Build.BRAND);
        this.hgW.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
