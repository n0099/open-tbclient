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
    private static final Map<ShareDialogConfig.From, Integer> fdt = new HashMap();
    private List<Integer> ctA;
    private int fdu;
    private int fdv;
    private int fdw;
    private String mText;

    static {
        fdt.put(ShareDialogConfig.From.Recommend, 1);
        fdt.put(ShareDialogConfig.From.Concern, 2);
        fdt.put(ShareDialogConfig.From.PB, 3);
        fdt.put(ShareDialogConfig.From.FRS, 4);
        fdt.put(ShareDialogConfig.From.PersonPolymeric, 5);
        fdt.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        fdt.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        fdt.put(ShareDialogConfig.From.HomeVideoTab, 8);
        fdt.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fdu = jSONObject.optInt("begin_time");
            this.fdv = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.fdw = jSONObject.optInt("icon_exp");
            CO(jSONObject.optString("page_list"));
        }
    }

    private void CO(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.ctA == null) {
                        this.ctA = new ArrayList();
                    }
                    this.ctA.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.ctA == null || (num = fdt.get(from)) == null || !this.ctA.contains(num)) ? false : true;
    }

    public boolean buQ() {
        return System.currentTimeMillis() / 1000 >= ((long) this.fdu) && System.currentTimeMillis() / 1000 <= ((long) this.fdv);
    }

    public String getText() {
        return this.mText;
    }

    public int buR() {
        return this.fdw;
    }
}
