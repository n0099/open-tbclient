package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.at;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private static final Map<ShareDialogConfig.From, Integer> eAV = new HashMap();
    private List<Integer> bQP;
    private int eAW;
    private int eAX;
    private int eAY;
    private String mText;

    static {
        eAV.put(ShareDialogConfig.From.Recommend, 1);
        eAV.put(ShareDialogConfig.From.Concern, 2);
        eAV.put(ShareDialogConfig.From.PB, 3);
        eAV.put(ShareDialogConfig.From.FRS, 4);
        eAV.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eAV.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eAV.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eAV.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eAV.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAW = jSONObject.optInt("begin_time");
            this.eAX = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.eAY = jSONObject.optInt("icon_exp");
            AZ(jSONObject.optString("page_list"));
        }
    }

    private void AZ(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bQP == null) {
                        this.bQP = new ArrayList();
                    }
                    this.bQP.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bQP == null || (num = eAV.get(from)) == null || !this.bQP.contains(num)) ? false : true;
    }

    public boolean bmT() {
        return System.currentTimeMillis() / 1000 >= ((long) this.eAW) && System.currentTimeMillis() / 1000 <= ((long) this.eAX);
    }

    public String getText() {
        return this.mText;
    }

    public int bmU() {
        return this.eAY;
    }
}
