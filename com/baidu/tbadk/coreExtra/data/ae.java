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
    private static final Map<ShareDialogConfig.From, Integer> ePh = new HashMap();
    private List<Integer> cfd;
    private int ePi;
    private int ePj;
    private int ePk;
    private String mText;

    static {
        ePh.put(ShareDialogConfig.From.Recommend, 1);
        ePh.put(ShareDialogConfig.From.Concern, 2);
        ePh.put(ShareDialogConfig.From.PB, 3);
        ePh.put(ShareDialogConfig.From.FRS, 4);
        ePh.put(ShareDialogConfig.From.PersonPolymeric, 5);
        ePh.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        ePh.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        ePh.put(ShareDialogConfig.From.HomeVideoTab, 8);
        ePh.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ePi = jSONObject.optInt("begin_time");
            this.ePj = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.ePk = jSONObject.optInt("icon_exp");
            Ch(jSONObject.optString("page_list"));
        }
    }

    private void Ch(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.cfd == null) {
                        this.cfd = new ArrayList();
                    }
                    this.cfd.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.cfd == null || (num = ePh.get(from)) == null || !this.cfd.contains(num)) ? false : true;
    }

    public boolean bqx() {
        return System.currentTimeMillis() / 1000 >= ((long) this.ePi) && System.currentTimeMillis() / 1000 <= ((long) this.ePj);
    }

    public String getText() {
        return this.mText;
    }

    public int bqy() {
        return this.ePk;
    }
}
