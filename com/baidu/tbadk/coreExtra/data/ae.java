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
    private static final Map<ShareDialogConfig.From, Integer> frt = new HashMap();
    private List<Integer> cBn;
    private int fru;
    private int frv;
    private int frw;
    private String mText;

    static {
        frt.put(ShareDialogConfig.From.Recommend, 1);
        frt.put(ShareDialogConfig.From.Concern, 2);
        frt.put(ShareDialogConfig.From.PB, 3);
        frt.put(ShareDialogConfig.From.FRS, 4);
        frt.put(ShareDialogConfig.From.PersonPolymeric, 5);
        frt.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        frt.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        frt.put(ShareDialogConfig.From.HomeVideoTab, 8);
        frt.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fru = jSONObject.optInt("begin_time");
            this.frv = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.frw = jSONObject.optInt("icon_exp");
            BY(jSONObject.optString("page_list"));
        }
    }

    private void BY(String str) {
        String[] split;
        if (!au.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cBn == null) {
                        this.cBn = new ArrayList();
                    }
                    this.cBn.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cBn == null || (num = frt.get(from)) == null || !this.cBn.contains(num)) ? false : true;
    }

    public boolean bwz() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fru) && System.currentTimeMillis() / 1000 <= ((long) this.frv);
    }

    public String getText() {
        return this.mText;
    }

    public int bwA() {
        return this.frw;
    }
}
