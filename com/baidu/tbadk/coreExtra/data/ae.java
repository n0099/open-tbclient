package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.au;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private static final Map<ShareDialogConfig.From, Integer> fcB = new HashMap();
    private List<Integer> crO;
    private int fcC;
    private int fcD;
    private int fcE;
    private String mText;

    static {
        fcB.put(ShareDialogConfig.From.Recommend, 1);
        fcB.put(ShareDialogConfig.From.Concern, 2);
        fcB.put(ShareDialogConfig.From.PB, 3);
        fcB.put(ShareDialogConfig.From.FRS, 4);
        fcB.put(ShareDialogConfig.From.PersonPolymeric, 5);
        fcB.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        fcB.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        fcB.put(ShareDialogConfig.From.HomeVideoTab, 8);
        fcB.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fcC = jSONObject.optInt("begin_time");
            this.fcD = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.fcE = jSONObject.optInt("icon_exp");
            Cn(jSONObject.optString("page_list"));
        }
    }

    private void Cn(String str) {
        String[] split;
        if (!au.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.crO == null) {
                        this.crO = new ArrayList();
                    }
                    this.crO.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.crO == null || (num = fcB.get(from)) == null || !this.crO.contains(num)) ? false : true;
    }

    public boolean bug() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fcC) && System.currentTimeMillis() / 1000 <= ((long) this.fcD);
    }

    public String getText() {
        return this.mText;
    }

    public int buh() {
        return this.fcE;
    }
}
