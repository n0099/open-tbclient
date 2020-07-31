package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.as;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private static final Map<ShareDialogConfig.From, Integer> eqx = new HashMap();
    private List<Integer> bLp;
    private int eqA;
    private int eqy;
    private int eqz;
    private String mText;

    static {
        eqx.put(ShareDialogConfig.From.Recommend, 1);
        eqx.put(ShareDialogConfig.From.Concern, 2);
        eqx.put(ShareDialogConfig.From.PB, 3);
        eqx.put(ShareDialogConfig.From.FRS, 4);
        eqx.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eqx.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eqx.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eqx.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eqx.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eqy = jSONObject.optInt("begin_time");
            this.eqz = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.eqA = jSONObject.optInt("icon_exp");
            yI(jSONObject.optString("page_list"));
        }
    }

    private void yI(String str) {
        String[] split;
        if (!as.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bLp == null) {
                        this.bLp = new ArrayList();
                    }
                    this.bLp.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bLp == null || (num = eqx.get(from)) == null || !this.bLp.contains(num)) ? false : true;
    }

    public boolean bej() {
        return System.currentTimeMillis() / 1000 >= ((long) this.eqy) && System.currentTimeMillis() / 1000 <= ((long) this.eqz);
    }

    public String getText() {
        return this.mText;
    }

    public int bek() {
        return this.eqA;
    }
}
