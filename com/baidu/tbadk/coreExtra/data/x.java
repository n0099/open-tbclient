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
public class x {
    private static final Map<ShareDialogConfig.From, Integer> dni = new HashMap();
    private List<Integer> aZX;
    private int dnj;
    private int dnk;
    private int dnl;
    private String mText;

    static {
        dni.put(ShareDialogConfig.From.Recommend, 1);
        dni.put(ShareDialogConfig.From.Concern, 2);
        dni.put(ShareDialogConfig.From.PB, 3);
        dni.put(ShareDialogConfig.From.FRS, 4);
        dni.put(ShareDialogConfig.From.PersonPolymeric, 5);
        dni.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        dni.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        dni.put(ShareDialogConfig.From.HomeVideoTab, 8);
        dni.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dnj = jSONObject.optInt("begin_time");
            this.dnk = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.dnl = jSONObject.optInt("icon_exp");
            un(jSONObject.optString("page_list"));
        }
    }

    private void un(String str) {
        String[] split;
        if (!aq.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.aZX == null) {
                        this.aZX = new ArrayList();
                    }
                    this.aZX.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.aZX == null || (num = dni.get(from)) == null || !this.aZX.contains(num)) ? false : true;
    }

    public boolean aJF() {
        return System.currentTimeMillis() / 1000 >= ((long) this.dnj) && System.currentTimeMillis() / 1000 <= ((long) this.dnk);
    }

    public String getText() {
        return this.mText;
    }

    public int aJG() {
        return this.dnl;
    }
}
