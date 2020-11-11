package com.baidu.tieba.ala.guardclub;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.bf;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.guardclub.i {
    private static volatile b gFe = null;
    private long currLiveId;

    public static b bSX() {
        if (gFe == null) {
            synchronized (b.class) {
                if (gFe == null) {
                    gFe = new b();
                }
            }
        }
        return gFe;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    @Override // com.baidu.live.guardclub.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, final long j, long j2, String str, String str2) {
        bf KH;
        JSONArray jSONArray;
        int i;
        Map<String, Object> process;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && (KH = com.baidu.live.guardclub.g.KF().KH()) != null) {
            this.currLiveId = j;
            int i2 = KH.aOX;
            int i3 = KH.aOY;
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.AZ().getString("guardclub_im_entry_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (i2 == 0 || i3 != 0) {
                    if ((i2 < 0 || i3 >= 0) && jSONArray != null) {
                        int i4 = 0;
                        HashSet hashSet = new HashSet();
                        for (i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("date");
                                hashSet.add(optString);
                                if (TextUtils.equals(optString, b)) {
                                    i4++;
                                }
                                if (i2 >= 0 && i4 >= i2) {
                                    return;
                                }
                            }
                        }
                        if (i3 >= 0) {
                            if (hashSet.size() <= i3) {
                                if (hashSet.size() == i3 && i4 == 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    this.currLiveId = j;
                    int i5 = KH.aOZ;
                    boolean z = false;
                    HashMap hashMap = new HashMap();
                    hashMap.put("test_guardClub_im_entry", false);
                    process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                    if (process.containsKey("test_guardClub_im_entry")) {
                        z = ((Boolean) process.get("test_guardClub_im_entry")).booleanValue();
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(au(j), j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (j == b.this.currLiveId) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913113));
                            }
                        }

                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onInterrupt() {
                        }
                    }, (!z ? 5 : i5) * 1000, true);
                }
                return;
            }
            jSONArray = null;
            if (i2 == 0) {
            }
            if (i2 < 0) {
            }
            int i42 = 0;
            HashSet hashSet2 = new HashSet();
            while (i < jSONArray.length()) {
            }
            if (i3 >= 0) {
            }
            this.currLiveId = j;
            int i52 = KH.aOZ;
            boolean z2 = false;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("test_guardClub_im_entry", false);
            process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap2);
            if (process.containsKey("test_guardClub_im_entry")) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(au(j), j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z22) {
                    if (j == b.this.currLiveId) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913113));
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, (!z2 ? 5 : i52) * 1000, true);
        }
    }

    @Override // com.baidu.live.guardclub.i
    public void KK() {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        try {
            bf KH = com.baidu.live.guardclub.g.KF().KH();
            if (KH != null) {
                i = KH.aOX;
                i2 = KH.aOY;
            } else {
                i = 0;
            }
            if (i >= 0 || i2 >= 0) {
                String b = com.baidu.live.utils.k.b(new Date());
                String string = com.baidu.live.d.AZ().getString("guardclub_im_entry_show_trace", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONArray = new JSONArray(string);
                } else {
                    jSONArray = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("date", b);
                jSONArray.put(jSONObject);
                com.baidu.live.d.AZ().putString("guardclub_im_entry_show_trace", jSONArray.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.live.guardclub.i
    public String au(long j) {
        return "guardClub_im_" + j;
    }
}
