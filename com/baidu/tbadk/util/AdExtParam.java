package com.baidu.tbadk.util;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class AdExtParam {
    public static final String KEY_AD_CONTEXT_LIST = "ad_context_list";
    public static final String KEY_FLOOR_INFO = "floor_info";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IADEX = "iadex";
    public static final String KEY_REQUEST_TYPE = "requestType";
    public static final String KEY_SHOUBAI_CUID = "shoubai_cuid";
    public static final String KEY_THREAD_COUNT = "pre_ad_thread_count";

    /* loaded from: classes.dex */
    public static class a {
        private HashMap fNP;

        private a() {
        }

        public static a bEY() {
            a aVar = new a();
            aVar.fNP = new HashMap();
            aVar.fNP.put(AdExtParam.KEY_IADEX, d.bFf());
            return aVar;
        }

        public a rD(int i) {
            this.fNP.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
            return this;
        }

        public a rE(int i) {
            this.fNP.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
            return this;
        }

        public a DL(String str) {
            this.fNP.put(AdExtParam.KEY_SHOUBAI_CUID, str);
            return this;
        }

        public a DM(String str) {
            this.fNP.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public a DN(String str) {
            this.fNP.put("forum_name", str);
            return this;
        }

        public a DO(String str) {
            this.fNP.put(AdExtParam.KEY_FLOOR_INFO, str);
            return this;
        }

        public String bEZ() {
            try {
                return new Gson().toJson(this.fNP);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
