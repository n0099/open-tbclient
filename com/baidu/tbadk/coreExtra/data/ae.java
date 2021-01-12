package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private static final Map<ShareDialogConfig.From, Integer> foZ = new HashMap();
    private List<Integer> cyR;
    private int fpa;
    private int fpb;
    private int fpc;
    private String mText;

    static {
        foZ.put(ShareDialogConfig.From.Recommend, 1);
        foZ.put(ShareDialogConfig.From.Concern, 2);
        foZ.put(ShareDialogConfig.From.PB, 3);
        foZ.put(ShareDialogConfig.From.FRS, 4);
        foZ.put(ShareDialogConfig.From.PersonPolymeric, 5);
        foZ.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        foZ.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        foZ.put(ShareDialogConfig.From.HomeVideoTab, 8);
        foZ.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fpa = jSONObject.optInt("begin_time");
            this.fpb = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.fpc = jSONObject.optInt("icon_exp");
            BH(jSONObject.optString("page_list"));
        }
    }

    private void BH(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cyR == null) {
                        this.cyR = new ArrayList();
                    }
                    this.cyR.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cyR == null || (num = foZ.get(from)) == null || !this.cyR.contains(num)) ? false : true;
    }

    public boolean bwh() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fpa) && System.currentTimeMillis() / 1000 <= ((long) this.fpb);
    }

    public String getText() {
        return this.mText;
    }

    public int bwi() {
        return this.fpc;
    }
}
