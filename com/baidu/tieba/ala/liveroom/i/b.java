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
    private JSONArray gye;
    private Handler gyf;
    private int gyg;
    private long mLastTime;
    private String gyb = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer gyc = new StringBuffer();
    private SimpleDateFormat aQc = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date gyd = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.gyf = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.gyg++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.gye == null) {
            this.gye = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.gyd.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aQc.format(this.gyd));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.gyg % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bRf().bRi());
                jSONObject.put(c.i, a.bRf().bRg());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.gye.put(jSONObject);
        if (this.gyg >= 75) {
            this.gyg = 0;
            try {
                this.gyc.setLength(0);
                this.gyc.append(this.gyb).append("?extra=").append(this.gye.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.gyc.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.gyf.sendMessage(obtain);
                this.gye = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.gyc.append("&_client_type=2");
        this.gyc.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.gyc.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.gyc.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.gyc.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.gyc.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.gyc.append("&_sdk_version=3.8.5");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.gyc.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.gyc.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.gyc.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.gyc.append("&from=" + from);
        }
        this.gyc.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.gyc.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.gyc.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.gyc.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.gyc.append("&model=" + Build.MODEL);
        this.gyc.append("&brand=" + Build.BRAND);
        this.gyc.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
