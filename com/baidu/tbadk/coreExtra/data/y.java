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
public class y {
    private static final Map<ShareDialogConfig.From, Integer> eby = new HashMap();
    private List<Integer> bGf;
    private int ebA;
    private int ebB;
    private int ebz;
    private String mText;

    static {
        eby.put(ShareDialogConfig.From.Recommend, 1);
        eby.put(ShareDialogConfig.From.Concern, 2);
        eby.put(ShareDialogConfig.From.PB, 3);
        eby.put(ShareDialogConfig.From.FRS, 4);
        eby.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eby.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eby.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eby.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eby.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ebz = jSONObject.optInt("begin_time");
            this.ebA = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.ebB = jSONObject.optInt("icon_exp");
            xk(jSONObject.optString("page_list"));
        }
    }

    private void xk(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bGf == null) {
                        this.bGf = new ArrayList();
                    }
                    this.bGf.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bGf == null || (num = eby.get(from)) == null || !this.bGf.contains(num)) ? false : true;
    }

    public boolean aYh() {
        return System.currentTimeMillis() / 1000 >= ((long) this.ebz) && System.currentTimeMillis() / 1000 <= ((long) this.ebA);
    }

    public String getText() {
        return this.mText;
    }

    public int aYi() {
        return this.ebB;
    }
}
