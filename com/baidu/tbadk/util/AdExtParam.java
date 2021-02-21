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
        private HashMap fMp;

        private a() {
        }

        public static a bEU() {
            a aVar = new a();
            aVar.fMp = new HashMap();
            aVar.fMp.put(AdExtParam.KEY_IADEX, d.bFb());
            return aVar;
        }

        public a rB(int i) {
            this.fMp.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i));
            return this;
        }

        public a rC(int i) {
            this.fMp.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i));
            return this;
        }

        public a DE(String str) {
            this.fMp.put(AdExtParam.KEY_SHOUBAI_CUID, str);
            return this;
        }

        public a DF(String str) {
            this.fMp.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public a DG(String str) {
            this.fMp.put("forum_name", str);
            return this;
        }

        public a DH(String str) {
            this.fMp.put(AdExtParam.KEY_FLOOR_INFO, str);
            return this;
        }

        public String bEV() {
            try {
                return new Gson().toJson(this.fMp);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
