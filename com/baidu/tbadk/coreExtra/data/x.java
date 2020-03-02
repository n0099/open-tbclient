package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private static final Map<ShareDialogConfig.From, Integer> dmI = new HashMap();
    private List<Integer> aZJ;
    private int dmJ;
    private int dmK;
    private int dmL;
    private String mText;

    static {
        dmI.put(ShareDialogConfig.From.Recommend, 1);
        dmI.put(ShareDialogConfig.From.Concern, 2);
        dmI.put(ShareDialogConfig.From.PB, 3);
        dmI.put(ShareDialogConfig.From.FRS, 4);
        dmI.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dmI.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dmI.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dmI.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dmI.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmJ = jSONObject.optInt("begin_time");
            this.dmK = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dmL = jSONObject.optInt("icon_exp");
            um(jSONObject.optString("page_list"));
        }
    }

    private void um(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.aZJ == null) {
                        this.aZJ = new ArrayList();
                    }
                    this.aZJ.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.aZJ == null || (num = dmI.get(from)) == null || !this.aZJ.contains(num)) ? false : true;
    }

    public boolean aJA() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dmJ) && System.currentTimeMillis() / 1000 <= ((long) this.dmK);
    }

    public String getText() {
        return this.mText;
    }

    public int aJB() {
        return this.dmL;
    }
}
