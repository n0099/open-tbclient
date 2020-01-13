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
public class w {
    private static final Map<ShareDialogConfig.From, Integer> diD = new HashMap();
    private List<Integer> aVw;
    private int diE;
    private int diF;
    private int diG;
    private String mText;

    static {
        diD.put(ShareDialogConfig.From.Recommend, 1);
        diD.put(ShareDialogConfig.From.Concern, 2);
        diD.put(ShareDialogConfig.From.PB, 3);
        diD.put(ShareDialogConfig.From.FRS, 4);
        diD.put(ShareDialogConfig.From.PersonPolymeric, 5);
        diD.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        diD.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        diD.put(ShareDialogConfig.From.HomeVideoTab, 8);
        diD.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        this.diE = jSONObject.optInt("begin_time");
        this.diF = jSONObject.optInt("end_time");
        this.mText = jSONObject.optString("text");
        this.diG = jSONObject.optInt("icon_exp");
        tV(jSONObject.optString("page_list"));
    }

    private void tV(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.aVw == null) {
                        this.aVw = new ArrayList();
                    }
                    this.aVw.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.aVw == null || (num = diD.get(from)) == null || !this.aVw.contains(num)) ? false : true;
    }

    public boolean aHg() {
        return System.currentTimeMillis() / 1000 >= ((long) this.diE) && System.currentTimeMillis() / 1000 <= ((long) this.diF);
    }

    public String getText() {
        return this.mText;
    }
}
