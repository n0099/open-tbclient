package com.baidu.tieba.ala.alaar.makeup.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a implements b {
    public boolean parse(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return dD(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
