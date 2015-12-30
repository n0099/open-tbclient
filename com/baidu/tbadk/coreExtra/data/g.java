package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private Hashtable<String, String> ajc = new Hashtable<>();
    private Hashtable<String, String> ajd = new Hashtable<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("tdou_cashier_type");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("pay_cashier_type");
                BdLog.e("consumepath is:" + jSONObject.toString());
                a(this.ajc, optJSONArray);
                a(this.ajd, optJSONArray2);
                BdLog.e("pay mPayCashierType:" + this.ajc.toString());
                BdLog.e("pay mPayCashierType:" + this.ajd.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Hashtable hashtable, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashtable.put(next, optJSONObject.get(next));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean q(int i, String str) {
        if (str == null) {
            return true;
        }
        String str2 = null;
        if (i == 1) {
            str2 = this.ajd.get(str);
        } else if (i == 2) {
            str2 = this.ajc.get(str);
        }
        if (StringUtils.isNull(str2)) {
            return true;
        }
        return str2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
    }
}
