package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.at;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private static final Map<ShareDialogConfig.From, Integer> eXD = new HashMap();
    private List<Integer> cnC;
    private int eXE;
    private int eXF;
    private int eXG;
    private String mText;

    static {
        eXD.put(ShareDialogConfig.From.Recommend, 1);
        eXD.put(ShareDialogConfig.From.Concern, 2);
        eXD.put(ShareDialogConfig.From.PB, 3);
        eXD.put(ShareDialogConfig.From.FRS, 4);
        eXD.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eXD.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eXD.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eXD.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eXD.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eXE = jSONObject.optInt("begin_time");
            this.eXF = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.eXG = jSONObject.optInt("icon_exp");
            CA(jSONObject.optString("page_list"));
        }
    }

    private void CA(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cnC == null) {
                        this.cnC = new ArrayList();
                    }
                    this.cnC.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cnC == null || (num = eXD.get(from)) == null || !this.cnC.contains(num)) ? false : true;
    }

    public boolean bsq() {
        return System.currentTimeMillis() / 1000 >= ((long) this.eXE) && System.currentTimeMillis() / 1000 <= ((long) this.eXF);
    }

    public String getText() {
        return this.mText;
    }

    public int bsr() {
        return this.eXG;
    }
}
