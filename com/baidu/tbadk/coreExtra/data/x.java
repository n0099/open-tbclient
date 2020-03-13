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
    private static final Map<ShareDialogConfig.From, Integer> dmV = new HashMap();
    private List<Integer> aZK;
    private int dmW;
    private int dmX;
    private int dmY;
    private String mText;

    static {
        dmV.put(ShareDialogConfig.From.Recommend, 1);
        dmV.put(ShareDialogConfig.From.Concern, 2);
        dmV.put(ShareDialogConfig.From.PB, 3);
        dmV.put(ShareDialogConfig.From.FRS, 4);
        dmV.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dmV.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dmV.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dmV.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dmV.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmW = jSONObject.optInt("begin_time");
            this.dmX = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dmY = jSONObject.optInt("icon_exp");
            un(jSONObject.optString("page_list"));
        }
    }

    private void un(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.aZK == null) {
                        this.aZK = new ArrayList();
                    }
                    this.aZK.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.aZK == null || (num = dmV.get(from)) == null || !this.aZK.contains(num)) ? false : true;
    }

    public boolean aJB() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dmW) && System.currentTimeMillis() / 1000 <= ((long) this.dmX);
    }

    public String getText() {
        return this.mText;
    }

    public int aJC() {
        return this.dmY;
    }
}
