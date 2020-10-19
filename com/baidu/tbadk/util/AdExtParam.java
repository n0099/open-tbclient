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
        this.iadex = c.byS();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam fjM;

        public static a byL() {
            a aVar = new a();
            aVar.fjM = new AdExtParam();
            aVar.fjM.appendCommonParams();
            return aVar;
        }

        public a rx(int i) {
            this.fjM.requestType = i;
            return this;
        }

        public String byM() {
            try {
                return new Gson().toJson(this.fjM);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
