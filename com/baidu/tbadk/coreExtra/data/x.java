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
    private static final Map<ShareDialogConfig.From, Integer> dNd = new HashMap();
    private List<Integer> byx;
    private int dNe;
    private int dNf;
    private int dNg;
    private String mText;

    static {
        dNd.put(ShareDialogConfig.From.Recommend, 1);
        dNd.put(ShareDialogConfig.From.Concern, 2);
        dNd.put(ShareDialogConfig.From.PB, 3);
        dNd.put(ShareDialogConfig.From.FRS, 4);
        dNd.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dNd.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dNd.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dNd.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dNd.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dNe = jSONObject.optInt("begin_time");
            this.dNf = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dNg = jSONObject.optInt("icon_exp");
            vB(jSONObject.optString("page_list"));
        }
    }

    private void vB(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.byx == null) {
                        this.byx = new ArrayList();
                    }
                    this.byx.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.byx == null || (num = dNd.get(from)) == null || !this.byx.contains(num)) ? false : true;
    }

    public boolean aSc() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dNe) && System.currentTimeMillis() / 1000 <= ((long) this.dNf);
    }

    public String getText() {
        return this.mText;
    }

    public int aSd() {
        return this.dNg;
    }
}
