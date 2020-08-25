package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.at;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ad {
    private static final Map<ShareDialogConfig.From, Integer> eAR = new HashMap();
    private List<Integer> bQL;
    private int eAS;
    private int eAT;
    private int eAU;
    private String mText;

    static {
        eAR.put(ShareDialogConfig.From.Recommend, 1);
        eAR.put(ShareDialogConfig.From.Concern, 2);
        eAR.put(ShareDialogConfig.From.PB, 3);
        eAR.put(ShareDialogConfig.From.FRS, 4);
        eAR.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eAR.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eAR.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eAR.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eAR.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAS = jSONObject.optInt("begin_time");
            this.eAT = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.eAU = jSONObject.optInt("icon_exp");
            AY(jSONObject.optString("page_list"));
        }
    }

    private void AY(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bQL == null) {
                        this.bQL = new ArrayList();
                    }
                    this.bQL.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bQL == null || (num = eAR.get(from)) == null || !this.bQL.contains(num)) ? false : true;
    }

    public boolean bmT() {
        return System.currentTimeMillis() / 1000 >= ((long) this.eAS) && System.currentTimeMillis() / 1000 <= ((long) this.eAT);
    }

    public String getText() {
        return this.mText;
    }

    public int bmU() {
        return this.eAU;
    }
}
