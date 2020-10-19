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
    private JSONArray gPI;
    private Handler gPJ;
    private int gPK;
    private long mLastTime;
    private String gPF = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer gPG = new StringBuffer();
    private SimpleDateFormat aVp = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date gPH = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.gPJ = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.gPK++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.gPI == null) {
            this.gPI = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.gPH.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aVp.format(this.gPH));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.gPK % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bVU().bVX());
                jSONObject.put(c.i, a.bVU().bVV());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.gPI.put(jSONObject);
        if (this.gPK >= 75) {
            this.gPK = 0;
            try {
                this.gPG.setLength(0);
                this.gPG.append(this.gPF).append("?extra=").append(this.gPI.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.gPG.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.gPJ.sendMessage(obtain);
                this.gPI = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.gPG.append("&_client_type=2");
        this.gPG.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.gPG.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.gPG.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.gPG.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.gPG.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.gPG.append("&_sdk_version=4.0.3");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.gPG.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.gPG.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.gPG.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.gPG.append("&from=" + from);
        }
        this.gPG.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.gPG.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.gPG.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.gPG.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.gPG.append("&model=" + Build.MODEL);
        this.gPG.append("&brand=" + Build.BRAND);
        this.gPG.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
