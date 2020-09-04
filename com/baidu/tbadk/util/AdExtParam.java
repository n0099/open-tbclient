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
        this.iadex = c.bve();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam eUK;

        public static a buX() {
            a aVar = new a();
            aVar.eUK = new AdExtParam();
            aVar.eUK.appendCommonParams();
            return aVar;
        }

        public a qI(int i) {
            this.eUK.requestType = i;
            return this;
        }

        public String buY() {
            try {
                return new Gson().toJson(this.eUK);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
