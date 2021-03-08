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
    private static final Map<ShareDialogConfig.From, Integer> fsS = new HashMap();
    private List<Integer> cCN;
    private int fsT;
    private int fsU;
    private int fsV;
    private String mText;

    static {
        fsS.put(ShareDialogConfig.From.Recommend, 1);
        fsS.put(ShareDialogConfig.From.Concern, 2);
        fsS.put(ShareDialogConfig.From.PB, 3);
        fsS.put(ShareDialogConfig.From.FRS, 4);
        fsS.put(ShareDialogConfig.From.PersonPolymeric, 5);
        fsS.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        fsS.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        fsS.put(ShareDialogConfig.From.HomeVideoTab, 8);
        fsS.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsT = jSONObject.optInt("begin_time");
            this.fsU = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.fsV = jSONObject.optInt("icon_exp");
            Cf(jSONObject.optString("page_list"));
        }
    }

    private void Cf(String str) {
        String[] split;
        if (!au.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cCN == null) {
                        this.cCN = new ArrayList();
                    }
                    this.cCN.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cCN == null || (num = fsS.get(from)) == null || !this.cCN.contains(num)) ? false : true;
    }

    public boolean bwC() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fsT) && System.currentTimeMillis() / 1000 <= ((long) this.fsU);
    }

    public String getText() {
        return this.mText;
    }

    public int bwD() {
        return this.fsV;
    }
}
