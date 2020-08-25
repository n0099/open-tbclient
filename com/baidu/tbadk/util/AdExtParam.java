package com.baidu.tbadk.util;

import android.support.annotation.Keep;
import com.google.gson.Gson;
@Keep
/* loaded from: classes2.dex */
public class AdExtParam {
    public String iadex;
    public int requestType;

    /* JADX INFO: Access modifiers changed from: private */
    public void appendCommonParams() {
        this.iadex = c.bvd();
    }

    /* loaded from: classes2.dex */
    public static class a {
        private AdExtParam eUG;

        public static a buW() {
            a aVar = new a();
            aVar.eUG = new AdExtParam();
            aVar.eUG.appendCommonParams();
            return aVar;
        }

        public a qI(int i) {
            this.eUG.requestType = i;
            return this;
        }

        public String buX() {
            try {
                return new Gson().toJson(this.eUG);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
