package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ar;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private static final Map<ShareDialogConfig.From, Integer> ekj = new HashMap();
    private List<Integer> bKT;
    private int ekk;
    private int ekl;
    private int ekm;
    private String mText;

    static {
        ekj.put(ShareDialogConfig.From.Recommend, 1);
        ekj.put(ShareDialogConfig.From.Concern, 2);
        ekj.put(ShareDialogConfig.From.PB, 3);
        ekj.put(ShareDialogConfig.From.FRS, 4);
        ekj.put(ShareDialogConfig.From.PersonPolymeric, 5);
        ekj.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        ekj.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        ekj.put(ShareDialogConfig.From.HomeVideoTab, 8);
        ekj.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ekk = jSONObject.optInt("begin_time");
            this.ekl = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.ekm = jSONObject.optInt("icon_exp");
            xD(jSONObject.optString("page_list"));
        }
    }

    private void xD(String str) {
        String[] split;
        if (!ar.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bKT == null) {
                        this.bKT = new ArrayList();
                    }
                    this.bKT.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bKT == null || (num = ekj.get(from)) == null || !this.bKT.contains(num)) ? false : true;
    }

    public boolean bam() {
        return System.currentTimeMillis() / 1000 >= ((long) this.ekk) && System.currentTimeMillis() / 1000 <= ((long) this.ekl);
    }

    public String getText() {
        return this.mText;
    }

    public int ban() {
        return this.ekm;
    }
}
