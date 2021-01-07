package com.baidu.tbadk.util;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class AdExtParam {
    public static final String KEY_AD_CONTEXT_LIST = "ad_context_list";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IADEX = "iadex";
    public static final String KEY_REQUEST_TYPE = "requestType";
    public static final String KEY_SHOUBAI_CUID = "shoubai_cuid";
    public static final String KEY_THREAD_COUNT = "pre_ad_thread_count";

    /* loaded from: classes.dex */
    public static class a {
        private HashMap fOL;

        private a() {
        }

        public static a bIt() {
            a aVar = new a();
            aVar.fOL = new HashMap();
            aVar.fOL.put(AdExtParam.KEY_IADEX, c.bIA());
            return aVar;
        }

        public a tc(int i) {
            this.fOL.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
            return this;
        }

        public a td(int i) {
            this.fOL.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
            return this;
        }

        public a EA(String str) {
            this.fOL.put(AdExtParam.KEY_SHOUBAI_CUID, str);
            return this;
        }

        public a EB(String str) {
            this.fOL.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public a EC(String str) {
            this.fOL.put("forum_name", str);
            return this;
        }

        public String bIu() {
            try {
                return new Gson().toJson(this.fOL);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
