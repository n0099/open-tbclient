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
        this.iadex = c.bwi();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam eXA;

        public static a bwb() {
            a aVar = new a();
            aVar.eXA = new AdExtParam();
            aVar.eXA.appendCommonParams();
            return aVar;
        }

        public a qZ(int i) {
            this.eXA.requestType = i;
            return this;
        }

        public String bwc() {
            try {
                return new Gson().toJson(this.eXA);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
