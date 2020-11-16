package com.baidu.tbadk.util;

import android.support.annotation.Keep;
import com.google.gson.Gson;
@Keep
/* loaded from: classes.dex */
public class AdExtParam {
    public String iadex;
    public int requestType;

    /* JADX INFO: Access modifiers changed from: private */
    public void appendCommonParams() {
        this.iadex = c.bCD();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam fxs;

        public static a bCw() {
            a aVar = new a();
            aVar.fxs = new AdExtParam();
            aVar.fxs.appendCommonParams();
            return aVar;
        }

        public a sq(int i) {
            this.fxs.requestType = i;
            return this;
        }

        public String bCx() {
            try {
                return new Gson().toJson(this.fxs);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
