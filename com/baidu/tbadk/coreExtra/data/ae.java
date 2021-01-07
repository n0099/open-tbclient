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
    private static final Map<ShareDialogConfig.From, Integer> ftL = new HashMap();
    private List<Integer> cDD;
    private int ftM;
    private int ftN;
    private int ftO;
    private String mText;

    static {
        ftL.put(ShareDialogConfig.From.Recommend, 1);
        ftL.put(ShareDialogConfig.From.Concern, 2);
        ftL.put(ShareDialogConfig.From.PB, 3);
        ftL.put(ShareDialogConfig.From.FRS, 4);
        ftL.put(ShareDialogConfig.From.PersonPolymeric, 5);
        ftL.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        ftL.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        ftL.put(ShareDialogConfig.From.HomeVideoTab, 8);
        ftL.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ftM = jSONObject.optInt("begin_time");
            this.ftN = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.ftO = jSONObject.optInt("icon_exp");
            CS(jSONObject.optString("page_list"));
        }
    }

    private void CS(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(",")) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cDD == null) {
                        this.cDD = new ArrayList();
                    }
                    this.cDD.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cDD == null || (num = ftL.get(from)) == null || !this.cDD.contains(num)) ? false : true;
    }

    public boolean bAb() {
        return System.currentTimeMillis() / 1000 >= ((long) this.ftM) && System.currentTimeMillis() / 1000 <= ((long) this.ftN);
    }

    public String getText() {
        return this.mText;
    }

    public int bAc() {
        return this.ftO;
    }
}
