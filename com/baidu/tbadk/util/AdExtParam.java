package com.baidu.tbadk.util;

import android.support.annotation.Keep;
import com.google.gson.Gson;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class AdExtParam {
    public static final String KEY_AD_CONTEXT_LIST = "ad_context_list";
    public static final String KEY_IADEX = "iadex";
    public static final String KEY_REQUEST_TYPE = "requestType";
    public static final String KEY_SHOUBAI_CUID = "shoubai_cuid";
    public static final String KEY_THREAD_COUNT = "pre_ad_thread_count";

    /* loaded from: classes.dex */
    public static class a {
        private HashMap fFh;

        private a() {
        }

        public static a bFX() {
            a aVar = new a();
            aVar.fFh = new HashMap();
            aVar.fFh.put(AdExtParam.KEY_IADEX, c.bGe());
            return aVar;
        }

        public a sR(int i) {
            this.fFh.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
            return this;
        }

        public a sS(int i) {
            this.fFh.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
            return this;
        }

        public a EE(String str) {
            this.fFh.put(AdExtParam.KEY_SHOUBAI_CUID, str);
            return this;
        }

        public a EF(String str) {
            this.fFh.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public String bFY() {
            try {
                return new Gson().toJson(this.fFh);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
