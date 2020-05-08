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
    private static final Map<ShareDialogConfig.From, Integer> dNh = new HashMap();
    private List<Integer> byC;
    private int dNi;
    private int dNj;
    private int dNk;
    private String mText;

    static {
        dNh.put(ShareDialogConfig.From.Recommend, 1);
        dNh.put(ShareDialogConfig.From.Concern, 2);
        dNh.put(ShareDialogConfig.From.PB, 3);
        dNh.put(ShareDialogConfig.From.FRS, 4);
        dNh.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dNh.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dNh.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dNh.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dNh.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dNi = jSONObject.optInt("begin_time");
            this.dNj = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dNk = jSONObject.optInt("icon_exp");
            vE(jSONObject.optString("page_list"));
        }
    }

    private void vE(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.byC == null) {
                        this.byC = new ArrayList();
                    }
                    this.byC.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.byC == null || (num = dNh.get(from)) == null || !this.byC.contains(num)) ? false : true;
    }

    public boolean aRZ() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dNi) && System.currentTimeMillis() / 1000 <= ((long) this.dNj);
    }

    public String getText() {
        return this.mText;
    }

    public int aSa() {
        return this.dNk;
    }
}
