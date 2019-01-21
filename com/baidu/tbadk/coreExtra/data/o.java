package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private Hashtable<String, String> aOG = new Hashtable<>();
    private Hashtable<String, String> aOH = new Hashtable<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("tdou_cashier_type");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("pay_cashier_type");
                BdLog.e("consumepath is:" + jSONObject.toString());
                a(this.aOG, optJSONArray);
                a(this.aOH, optJSONArray2);
                BdLog.e("pay mPayCashierType:" + this.aOG.toString());
                BdLog.e("pay mPayCashierType:" + this.aOH.toString());
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

    public boolean l(int i, String str) {
        if (str == null) {
            return true;
        }
        String str2 = null;
        if (i == 1) {
            str2 = this.aOH.get(str);
        } else if (i == 2) {
            str2 = this.aOG.get(str);
        }
        if (StringUtils.isNull(str2)) {
            return true;
        }
        return str2.equals("3");
    }
}
