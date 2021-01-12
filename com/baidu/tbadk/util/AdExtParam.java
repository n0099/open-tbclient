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
        private HashMap fKe;

        private a() {
        }

        public static a bEB() {
            a aVar = new a();
            aVar.fKe = new HashMap();
            aVar.fKe.put(AdExtParam.KEY_IADEX, c.bEI());
            return aVar;
        }

        public a rw(int i) {
            this.fKe.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
            return this;
        }

        public a rx(int i) {
            this.fKe.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
            return this;
        }

        public a Dp(String str) {
            this.fKe.put(AdExtParam.KEY_SHOUBAI_CUID, str);
            return this;
        }

        public a Dq(String str) {
            this.fKe.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public a Dr(String str) {
            this.fKe.put("forum_name", str);
            return this;
        }

        public String bEC() {
            try {
                return new Gson().toJson(this.fKe);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
