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
    private static final Map<ShareDialogConfig.From, Integer> dmH = new HashMap();
    private List<Integer> aZI;
    private int dmI;
    private int dmJ;
    private int dmK;
    private String mText;

    static {
        dmH.put(ShareDialogConfig.From.Recommend, 1);
        dmH.put(ShareDialogConfig.From.Concern, 2);
        dmH.put(ShareDialogConfig.From.PB, 3);
        dmH.put(ShareDialogConfig.From.FRS, 4);
        dmH.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dmH.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dmH.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dmH.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dmH.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmI = jSONObject.optInt("begin_time");
            this.dmJ = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dmK = jSONObject.optInt("icon_exp");
            um(jSONObject.optString("page_list"));
        }
    }

    private void um(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.aZI == null) {
                        this.aZI = new ArrayList();
                    }
                    this.aZI.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.aZI == null || (num = dmH.get(from)) == null || !this.aZI.contains(num)) ? false : true;
    }

    public boolean aJy() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dmI) && System.currentTimeMillis() / 1000 <= ((long) this.dmJ);
    }

    public String getText() {
        return this.mText;
    }

    public int aJz() {
        return this.dmK;
    }
}
