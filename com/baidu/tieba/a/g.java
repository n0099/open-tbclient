package com.baidu.tieba.a;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.k {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/tag_thread";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/all_thread";

    public String a(String str, String str2, String str3) {
        a("pn", str3);
        a("rn", String.valueOf(20));
        this.f1170a.e(true);
        if (str.equals("get_all_interest")) {
            a(d);
        } else {
            a("tag_id", str);
            a("tag_name", str2);
            a(c);
        }
        return b();
    }
}
