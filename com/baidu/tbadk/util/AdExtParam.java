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
        this.iadex = c.bDk();
    }

    /* loaded from: classes.dex */
    public static class a {
        private AdExtParam fyd;

        public static a bDd() {
            a aVar = new a();
            aVar.fyd = new AdExtParam();
            aVar.fyd.appendCommonParams();
            return aVar;
        }

        public a rS(int i) {
            this.fyd.requestType = i;
            return this;
        }

        public String bDe() {
            try {
                return new Gson().toJson(this.fyd);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
