package com.baidu.tieba.ala.guardclub;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.guardclub.i {
    private static volatile b eDY = null;
    private long currLiveId;

    public static b bfc() {
        if (eDY == null) {
            synchronized (b.class) {
                if (eDY == null) {
                    eDY = new b();
                }
            }
        }
        return eDY;
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
        ah vJ;
        JSONArray jSONArray;
        int i;
        Map<String, Object> process;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && (vJ = com.baidu.live.guardclub.g.vH().vJ()) != null) {
            this.currLiveId = j;
            int i2 = vJ.acn;
            int i3 = vJ.aco;
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.pr().getString("guardclub_im_entry_show_trace", "");
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
                    int i5 = vJ.acp;
                    boolean z = false;
                    HashMap hashMap = new HashMap();
                    hashMap.put("test_guardClub_im_entry", false);
                    process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                    if (process.containsKey("test_guardClub_im_entry")) {
                        z = ((Boolean) process.get("test_guardClub_im_entry")).booleanValue();
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(E(j), j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (j == b.this.currLiveId) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOST_GET_WALLET_UA));
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
            int i52 = vJ.acp;
            boolean z2 = false;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("test_guardClub_im_entry", false);
            process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap2);
            if (process.containsKey("test_guardClub_im_entry")) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(E(j), j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z22) {
                    if (j == b.this.currLiveId) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOST_GET_WALLET_UA));
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, (!z2 ? 5 : i52) * 1000, true);
        }
    }

    @Override // com.baidu.live.guardclub.i
    public void vM() {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        try {
            ah vJ = com.baidu.live.guardclub.g.vH().vJ();
            if (vJ != null) {
                i = vJ.acn;
                i2 = vJ.aco;
            } else {
                i = 0;
            }
            if (i >= 0 || i2 >= 0) {
                String b = com.baidu.live.utils.j.b(new Date());
                String string = com.baidu.live.c.pr().getString("guardclub_im_entry_show_trace", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONArray = new JSONArray(string);
                } else {
                    jSONArray = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("date", b);
                jSONArray.put(jSONObject);
                com.baidu.live.c.pr().putString("guardclub_im_entry_show_trace", jSONArray.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.live.guardclub.i
    public String E(long j) {
        return "guardClub_im_" + j;
    }
}
