package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private Hashtable<String, String> akI = new Hashtable<>();
    private Hashtable<String, String> akJ = new Hashtable<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("tdou_cashier_type");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("pay_cashier_type");
                BdLog.e("consumepath is:" + jSONObject.toString());
                a(this.akI, optJSONArray);
                a(this.akJ, optJSONArray2);
                BdLog.e("pay mPayCashierType:" + this.akI.toString());
                BdLog.e("pay mPayCashierType:" + this.akJ.toString());
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

    public boolean h(int i, String str) {
        if (str == null) {
            return true;
        }
        String str2 = null;
        if (i == 1) {
            str2 = this.akJ.get(str);
        } else if (i == 2) {
            str2 = this.akI.get(str);
        }
        if (StringUtils.isNull(str2)) {
            return true;
        }
        return str2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
    }
}
