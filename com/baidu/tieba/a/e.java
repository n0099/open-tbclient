package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.recommend.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static final String amX = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/threadrecommend";
    private boolean amW;
    private int errorCode = -1;
    private ac mNetWork = null;

    public e(boolean z) {
        this.amW = z;
    }

    public String ab(String str, String str2) {
        this.mNetWork = new ac();
        this.mNetWork.setUrl(amX);
        this.mNetWork.mc().na().FU = false;
        if (this.amW) {
            this.mNetWork.k("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.mNetWork.k("date", str);
        }
        if (str2 != null) {
            this.mNetWork.k(o.ST_TYPE, str2);
        }
        String lA = this.mNetWork.lA();
        if (lA != null) {
            try {
                this.errorCode = new JSONObject(lA).optInt("error_code");
            } catch (JSONException e) {
            }
        }
        return lA;
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
    }

    public boolean jq() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nb().jq();
        }
        return false;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
