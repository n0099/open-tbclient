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
        this.iadex = c.bAL();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam fsl;

        public static a bAE() {
            a aVar = new a();
            aVar.fsl = new AdExtParam();
            aVar.fsl.appendCommonParams();
            return aVar;
        }

        public a rI(int i) {
            this.fsl.requestType = i;
            return this;
        }

        public String bAF() {
            try {
                return new Gson().toJson(this.fsl);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
