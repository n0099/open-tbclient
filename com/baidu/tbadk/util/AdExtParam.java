package com.baidu.tbadk.util;

import android.support.annotation.Keep;
import com.google.gson.Gson;
@Keep
/* loaded from: classes.dex */
public class AdExtParam {
    public String iadex;

    /* JADX INFO: Access modifiers changed from: private */
    public void appendCommonParams() {
        this.iadex = c.bmq();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam eKb;

        public static a bmj() {
            a aVar = new a();
            aVar.eKb = new AdExtParam();
            aVar.eKb.appendCommonParams();
            return aVar;
        }

        public String bmk() {
            try {
                return new Gson().toJson(this.eKb);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
