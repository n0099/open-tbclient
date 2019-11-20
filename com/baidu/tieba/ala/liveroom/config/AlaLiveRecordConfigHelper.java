package com.baidu.tieba.ala.liveroom.config;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.ala.liveRecorder.video.DynamicBitRateConfig;
import com.baidu.live.l.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.tbadk.TbConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class AlaLiveRecordConfigHelper {
    private static AlaLiveRecordConfigHelper een;

    public VideoResolution hJ(boolean z) {
        return x(a.uB().ajF.Qn, z);
    }

    public VideoResolution x(int i, boolean z) {
        if (z) {
            return VideoResolution.RTC;
        }
        if (i == 1) {
            return VideoResolution.P720;
        }
        if (i == 2) {
            return VideoResolution.P576;
        }
        if (i == 3) {
            return VideoResolution.P540;
        }
        if (i == 4) {
            return VideoResolution.P360;
        }
        return VideoResolution.P540;
    }

    public static AlaLiveRecordConfigHelper aRu() {
        if (een == null) {
            synchronized (AlaLiveRecordConfigHelper.class) {
                if (een == null) {
                    een = new AlaLiveRecordConfigHelper();
                }
            }
        }
        return een;
    }

    public AlaLiveVideoConfig i(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = hJ(false);
        }
        if (videoResolution == null) {
            videoResolution = x(i, false);
        }
        if (i2 == 1 && !a.uB().ajF.Qo) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(tE(a.uB().ajF.Qq), tE(a.uB().ajF.Qr), a.uB().ajF.increaseThreshold, a.uB().ajF.decreaseThreshold, a.uB().ajF.increaseCount, a.uB().ajF.Qo, a.uB().ajF.Qp, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(1280);
            if (a.uB().ajF != null) {
                isLandscape.setSupportFaceStyle(a.uB().ajF.Qu);
            }
            return isLandscape;
        } else if (i2 == 2) {
            isLandscape.setPreviewWidth(videoResolution.getWidth());
            isLandscape.setPreviewHeight(videoResolution.getHeight());
            return isLandscape;
        } else {
            return null;
        }
    }

    private List<DynamicBitRateConfig.DynamicBitRateItem> tE(String str) {
        JSONArray jSONArray;
        int length;
        int i;
        Exception e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            int optInt = optJSONObject.optInt(IjkMediaMeta.IJKM_KEY_BITRATE);
            int optInt2 = optJSONObject.optInt("frame");
            Log.i("iveRecordConfigHelper", "@@ old bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ old     fps = " + optInt2);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IjkMediaMeta.IJKM_KEY_BITRATE, Integer.valueOf(optInt));
                hashMap.put("fps", Integer.valueOf(optInt2));
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey(IjkMediaMeta.IJKM_KEY_BITRATE)) {
                    optInt = ((Integer) process.get(IjkMediaMeta.IJKM_KEY_BITRATE)).intValue();
                }
                i = process.containsKey("fps") ? ((Integer) process.get("fps")).intValue() : optInt2;
                try {
                    Log.i("iveRecordConfigHelper", "@@ new bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ new     fps = " + i);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
                    arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
                }
            } catch (Exception e4) {
                i = optInt2;
                e = e4;
            }
            Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
            arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
        }
        return arrayList;
    }

    /* loaded from: classes6.dex */
    public enum VideoResolution {
        P720(1, 1280, 720),
        P576(2, 1024, 576),
        P540(3, TbConfig.HEAD_IMG_SIZE, 540),
        P360(4, 640, 360),
        RTC(0, CameraInterface.DEFAULT_PREVIEW_HEIGHT, SubsamplingScaleImageView.ORIENTATION_270);
        
        private int height;
        private int type;
        private int width;

        VideoResolution(int i, int i2, int i3) {
            this.type = i;
            this.width = i3;
            this.height = i2;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "L" + this.type + ":" + this.height + "*" + this.width;
        }
    }
}
