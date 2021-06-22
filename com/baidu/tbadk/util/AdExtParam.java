package com.baidu.tbadk.util;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import d.a.n0.z0.d;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public class AdExtParam {
    public static final String KEY_AD_CONTEXT_LIST = "ad_context_list";
    public static final String KEY_FLOOR_INFO = "floor_info";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_IADEX = "iadex";
    public static final String KEY_REQUEST_TYPE = "requestType";
    public static final String KEY_SHOUBAI_CUID = "shoubai_cuid";
    public static final String KEY_THREAD_COUNT = "pre_ad_thread_count";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public HashMap f13094a;

        public static a b() {
            a aVar = new a();
            HashMap hashMap = new HashMap();
            aVar.f13094a = hashMap;
            hashMap.put("iadex", d.e());
            return aVar;
        }

        public String a() {
            try {
                return new Gson().toJson(this.f13094a);
            } catch (Exception unused) {
                return "";
            }
        }

        public a c(String str) {
            this.f13094a.put(AdExtParam.KEY_AD_CONTEXT_LIST, str);
            return this;
        }

        public a d(String str) {
            this.f13094a.put("shoubai_cuid", str);
            return this;
        }

        public a e(String str) {
            this.f13094a.put(AdExtParam.KEY_FLOOR_INFO, str);
            return this;
        }

        public a f(String str) {
            this.f13094a.put("forum_name", str);
            return this;
        }

        public a g(int i2) {
            this.f13094a.put(AdExtParam.KEY_THREAD_COUNT, Integer.valueOf(i2));
            return this;
        }

        public a h(int i2) {
            this.f13094a.put(AdExtParam.KEY_REQUEST_TYPE, Integer.valueOf(i2));
            return this;
        }
    }
}
