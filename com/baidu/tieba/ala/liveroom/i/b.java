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
    private JSONArray gBp;
    private Handler gBq;
    private int gBr;
    private long mLastTime;
    private String gBm = "http://10.101.44.50:8899/live-profile/analy";
    private StringBuffer gBn = new StringBuffer();
    private SimpleDateFormat aSe = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
    private Date gBo = new Date();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public b() {
        this.mHandlerThread.start();
        this.gBq = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.ala.liveroom.i.b.1
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
        this.gBr++;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.gBp == null) {
            this.gBp = new JSONArray();
        }
        try {
            jSONObject.put("frame_interval", j2);
            jSONObject.put("frame_time", j);
            this.gBo.setTime(System.currentTimeMillis());
            jSONObject.put("time", this.aSe.format(this.gBo));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.gBr % 15 == 0) {
            this.mLastTime = currentTimeMillis;
            try {
                jSONObject.put("memory", a.bSB().bSE());
                jSONObject.put(c.i, a.bSB().bSC());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.gBp.put(jSONObject);
        if (this.gBr >= 75) {
            this.gBr = 0;
            try {
                this.gBn.setLength(0);
                this.gBn.append(this.gBm).append("?extra=").append(this.gBp.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
                addCommonParams();
                String stringBuffer = this.gBn.toString();
                Message obtain = Message.obtain();
                obtain.obj = stringBuffer;
                this.gBq.sendMessage(obtain);
                this.gBp = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void addCommonParams() {
        this.gBn.append("&_client_type=2");
        this.gBn.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.gBn.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.gBn.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.gBn.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.gBn.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.gBn.append("&_sdk_version=3.9.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.gBn.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.gBn.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.gBn.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.gBn.append("&from=" + from);
        }
        this.gBn.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.gBn.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.gBn.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.gBn.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.gBn.append("&model=" + Build.MODEL);
        this.gBn.append("&brand=" + Build.BRAND);
        this.gBn.append("&_os_version=" + Build.VERSION.RELEASE);
    }
}
