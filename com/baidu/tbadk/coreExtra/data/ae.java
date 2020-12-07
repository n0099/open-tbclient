package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private static final Map<ShareDialogConfig.From, Integer> fka = new HashMap();
    private List<Integer> cyK;
    private int fkb;
    private int fkc;
    private int fkd;
    private String mText;

    static {
        fka.put(ShareDialogConfig.From.Recommend, 1);
        fka.put(ShareDialogConfig.From.Concern, 2);
        fka.put(ShareDialogConfig.From.PB, 3);
        fka.put(ShareDialogConfig.From.FRS, 4);
        fka.put(ShareDialogConfig.From.PersonPolymeric, 5);
        fka.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        fka.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        fka.put(ShareDialogConfig.From.HomeVideoTab, 8);
        fka.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fkb = jSONObject.optInt("begin_time");
            this.fkc = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.fkd = jSONObject.optInt("icon_exp");
            CV(jSONObject.optString("page_list"));
        }
    }

    private void CV(String str) {
        String[] split;
        if (!au.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cyK == null) {
                        this.cyK = new ArrayList();
                    }
                    this.cyK.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cyK == null || (num = fka.get(from)) == null || !this.cyK.contains(num)) ? false : true;
    }

    public boolean bxG() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fkb) && System.currentTimeMillis() / 1000 <= ((long) this.fkc);
    }

    public String getText() {
        return this.mText;
    }

    public int bxH() {
        return this.fkd;
    }
}
