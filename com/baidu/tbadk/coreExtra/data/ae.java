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
    private static final Map<ShareDialogConfig.From, Integer> eDa = new HashMap();
    private List<Integer> bSP;
    private int eDb;
    private int eDc;
    private int eDd;
    private String mText;

    static {
        eDa.put(ShareDialogConfig.From.Recommend, 1);
        eDa.put(ShareDialogConfig.From.Concern, 2);
        eDa.put(ShareDialogConfig.From.PB, 3);
        eDa.put(ShareDialogConfig.From.FRS, 4);
        eDa.put(ShareDialogConfig.From.PersonPolymeric, 5);
        eDa.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        eDa.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        eDa.put(ShareDialogConfig.From.HomeVideoTab, 8);
        eDa.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eDb = jSONObject.optInt("begin_time");
            this.eDc = jSONObject.optInt("end_time");
            this.mText = jSONObject.optString("text");
            this.eDd = jSONObject.optInt("icon_exp");
            Bv(jSONObject.optString("page_list"));
        }
    }

    private void Bv(String str) {
        String[] split;
        if (!at.isEmpty(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
            for (String str2 : split) {
                int i = com.baidu.adp.lib.f.b.toInt(str2, -1);
                if (i != -1) {
                    if (this.bSP == null) {
                        this.bSP = new ArrayList();
                    }
                    this.bSP.add(Integer.valueOf(i));
                }
            }
        }
    }

    public boolean a(ShareDialogConfig.From from) {
        Integer num;
        return (this.bSP == null || (num = eDa.get(from)) == null || !this.bSP.contains(num)) ? false : true;
    }

    public boolean bnN() {
        return System.currentTimeMillis() / 1000 >= ((long) this.eDb) && System.currentTimeMillis() / 1000 <= ((long) this.eDc);
    }

    public String getText() {
        return this.mText;
    }

    public int bnO() {
        return this.eDd;
    }
}
